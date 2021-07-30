package com.mbb.ib.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbb.ib.constant.ErrorConstant;
import com.mbb.ib.constant.TxnHistoryConstant;
import com.mbb.ib.model.AuthRequest;
import com.mbb.ib.model.AuthResponse;
import com.mbb.ib.service.UserService;
import com.mbb.ib.util.JwtUtil;

@RestController
@RequestMapping(TxnHistoryConstant.apiPath_2)
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping(value = TxnHistoryConstant.apiPath_3, method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest data) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(),
					DigestUtils.sha256Hex(data.getPassword())));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(ErrorConstant.badCredentials);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(data.getUsername());

		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthResponse(jwt));
	}
}
