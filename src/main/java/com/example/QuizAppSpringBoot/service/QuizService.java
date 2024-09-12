package com.example.QuizAppSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.QuizAppSpringBoot.DAO.QuestionDAO;
import com.example.QuizAppSpringBoot.DAO.QuizDAO;
import com.example.QuizAppSpringBoot.model.Question;

@Service
public class QuizService {
	
	@Autowired
	QuizDAO quizDAO;
	
	@Autowired
	QuestionDAO questiondao;
	
	public ResponseEntity<String> createQuiz(String category,Integer numQ, String title)
	{
		System.out.println("Quiz called...1");
		List<Question> questions= questiondao.findByCategory(category);
		System.out.println("Quiz called...2");
		System.out.println(questions);

		//System.out.println("Quesion ids are : "+ questionsIDs);
		
		for (int i = 0; i < questions.size(); i++) {
			System.out.println("Fdf");
			System.out.println(questions.get(i).getId());
		}
		
		//List<Question> questions= questionDAO.findRandomQuestionsByCategory(category,numQ);
		//List<Question> questions= questionDAO.findQuestionByLevel("Python");
		
		//Problem: above code return null
		//System.out.println(questions.toString());
		//Quiz quiz = new Quiz();
		//quiz.setTitle(title);
		//quiz.setQuestions(questions);
		
		//quizDAO.save(quiz);
		
		//System.out.println(quiz.toString());
		return new ResponseEntity<>("Quiz created",HttpStatus.CREATED);
		
	}
}


