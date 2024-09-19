package com.example.QuizAppSpringBoot.service;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.QuizAppSpringBoot.model.QuestionWrapper;
import com.example.QuizAppSpringBoot.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.QuizAppSpringBoot.DAO.QuestionDAO;
import com.example.QuizAppSpringBoot.DAO.QuizDAO;
import com.example.QuizAppSpringBoot.model.Question;
import com.example.QuizAppSpringBoot.model.Quiz;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class QuizService {
	
	@Autowired
	QuizDAO quizDAO;
	
	@Autowired
	QuestionDAO questiondao;
	
	public ResponseEntity<String> createQuiz(String category,Integer numQ, String title)
	{
		//Write a logic to check category and title of quiz is not null
		//Write a logic to check numQ should be less or equal than total question for category

		if (category.isBlank() || title.isBlank()){
			return new ResponseEntity<>("Category or Title is null",HttpStatus.BAD_REQUEST);
		}

		List<Question> questions= questiondao.findRandomQuestionsByCategory(category,numQ);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		System.out.println(quiz);
		
		quizDAO.save(quiz);
		
		//System.out.println(quiz.toString());
		return new ResponseEntity<>("Quiz created",HttpStatus.CREATED);
		
	}


	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDAO.findById(id);

		List<Question> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<>();

		for (Question q: questionsFromDB){
			questionForUser.add(new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4()));
		}

		return new ResponseEntity<>(questionForUser,HttpStatus.OK);

	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDAO.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right = 0;
		int i = 0;
		for(Response response : responses){
			if(response.getResponse().equals(questions.get(i).getAnswer()))
				right++;

			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
}


