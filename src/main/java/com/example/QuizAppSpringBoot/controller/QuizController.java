package com.example.QuizAppSpringBoot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizAppSpringBoot.service.QuizService;

@RestController
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title ){
		System.out.println(category);
		System.out.println(numQ);
		
		return quizService.createQuiz(category, numQ, title);
	}
	
	//public ResponseEntity<String> 

}
