package com.example.QuizAppSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizAppSpringBoot.model.Question;
import com.example.QuizAppSpringBoot.service.QuestionService;

@RestController
//@RequestMapping("/question")
public class QuestionController {
	
	
	@Autowired
	QuestionService questionservice;
	
	@GetMapping("/")
	public String index() {
		return "Hello";
	}
	
	@GetMapping("/allquestions")
	public ResponseEntity<List<Question>> getQuestions() {
		System.out.println("Home Page Requested....");
		return questionservice.getAllQuestions();
	}
	@GetMapping("/allquestions/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category ){
		return questionservice.getQuestionByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		
		return questionservice.addQuestion(question);
	}
	
}  
