package com.example.QuizAppSpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.QuizAppSpringBoot.DAO.QuestionDAO;
import com.example.QuizAppSpringBoot.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questiondao;

	public  ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		System.out.println("getAllQuestions called");
		try {
			System.out.println(questiondao.findAll());
			return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			List<Question> questions= questiondao.findByCategory(category);
			System.out.println(questions);
			return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		try {
			questiondao.save(question);
			return new ResponseEntity<>("Success",HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed",HttpStatus.CONFLICT);
		
	}

}
