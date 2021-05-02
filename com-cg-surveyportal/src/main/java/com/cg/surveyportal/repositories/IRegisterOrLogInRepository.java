package com.cg.surveyportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.surveyportal.entities.RegisterOrLogIn;

public interface IRegisterOrLogInRepository extends JpaRepository<RegisterOrLogIn, String> {

}
