package com.java.namle.weatherAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.namle.weatherAPI.modelEntity.Role;

public interface RoleRepository  extends JpaRepository<Role, Integer>{

}
