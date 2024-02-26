package com.derechos.demo.Service;

import com.derechos.demo.Model.Question;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> getAllQuestions();

    List<Question> getQuestionsByCategory(String category);

    Optional<Question> getQuestionById(Long id);

    HttpStatus addQuestion(Question question);

    Question updateQuestion(Long id, Question updatedQuestion);

    void deleteQuestion(Long id);

    List<String> getAllCategories();
}
