package com.mbb.ib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbb.ib.entity.Users;

@Repository
public interface IUserRepository extends CrudRepository<Users, Integer> {

	public Users findByUsername(String username);

}
