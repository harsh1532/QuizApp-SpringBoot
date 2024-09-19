package com.example.QuizAppSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.QuizAppSpringBoot.model.Question;
import com.example.QuizAppSpringBoot.model.QuestionWrapper;
import com.example.QuizAppSpringBoot.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.QuizAppSpringBoot.service.QuizService;

@RestController
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title ){
		//System.out.println(category);
		//System.out.println(numQ);
		
		return quizService.createQuiz(category, numQ, title);
	}
	@GetMapping("quiz/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){


		return quizService.getQuizQuestions(id);
	}

	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id, responses);
	}

}
