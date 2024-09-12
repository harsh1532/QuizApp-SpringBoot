package com.example.QuizAppSpringBoot.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QuizAppSpringBoot.model.Quiz;

//@Repository
public interface QuizDAO  extends JpaRepository<Quiz, Integer>{

}
