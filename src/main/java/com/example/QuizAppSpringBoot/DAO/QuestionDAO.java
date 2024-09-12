package com.example.QuizAppSpringBoot.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.QuizAppSpringBoot.model.Question;

//@Repository
//public interface QuestionDAO extends JpaRepository<Question, Integer> {
//
//	List<Question> findByCategory(String category);
//	//@Query(value="Select * from question", nativeQuery = true)
//	//@Query(value="SELECT q FROM Question q WHERE q.category=:category ORDER BY FUNC('RAND')")
//	//@Query(value= "SELECT * FROM question q WHERE q.category = ?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
//	
//	@Query(value="SELECT * FROM question q Where  q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
//	List<Question> findRandomQuestionsByCategory(String category, Integer numQ);
//
//	//@Query(value="Select * From question q Where q.level=:level",nativeQuery = true)
//	//List<Question> findQuestionByLevel(String level);
//	
//	//@Query(value="Select * From question q ORDER BY q.level",nativeQuery = true)
//	//List<Question> findQuestionByLevel();
//}

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

	// @Query("Select q.* From question q Where q.level=:level")
	List<Question> findByCategory(String level);
	
	//here, Select * from question returning all question but bycategory not return anything
	@Query(value = "SELECT * FROM question q WHERE q.category =:category", nativeQuery = true)
	List<Question> getIdByCategory( @Param("category") String category);

	
	//@Query(value = "SELECT id FROM question q Where q.category=:category ", nativeQuery = true)
	//List<Integer> getIdByCategory(String category);

	// @Query(value="Select * From question q Where q.level=:level",nativeQuery =
	// true)
	// List<Question> findQuestionByLevel(String level);

	@Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);
}