package com.example.QuizAppSpringBoot.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz")

public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
//	@JoinTable(
//	        name = "quiz_questions",
//	        joinColumns = @JoinColumn(name = "quiz_id",referencedColumnName="id"),
//	        inverseJoinColumns = @JoinColumn(name = "questions_id", referencedColumnName="id" )
//	    )
	@ManyToMany
	private List<Question> questions;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", questions=" + questions + "]";
	}
	
	
}
