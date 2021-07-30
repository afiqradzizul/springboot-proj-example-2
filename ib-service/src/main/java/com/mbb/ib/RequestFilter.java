package com.mbb.ib;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mbb.ib.constant.CommonConstant;
import com.mbb.ib.constant.TxnHistoryConstant;
import com.mbb.ib.service.UserService;
import com.mbb.ib.util.JwtUtil;

@Component
public class RequestFilter extends OncePerRequestFilter {

	@Autowired
	private UserService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader(TxnHistoryConstant.authorization);

		String username = null;
		String token = null;

		if (authorizationHeader != null && authorizationHeader.startsWith(TxnHistoryConstant.bearer)) {
			token = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(token);
			request.setAttribute(CommonConstant.username, username);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if (jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(upat);
			}
		}
		filterChain.doFilter(request, response);
	}
}
