package com.derechos.demo.Service;

import com.derechos.demo.Model.Question;
import com.derechos.demo.Repository.QuestionRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public HttpStatus addQuestion(Question question) {
        try {
            questionRepository.save(question);
            return HttpStatus.CREATED;
        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Optional<Question> existingQuestionOptional = questionRepository.findById(id);

        if (existingQuestionOptional.isPresent()) {
            Question existingQuestion = existingQuestionOptional.get();

            existingQuestion.setQuestionText(updatedQuestion.getQuestionText());
            existingQuestion.setChoices(updatedQuestion.getChoices());
            existingQuestion.setCorrectChoices(updatedQuestion.getCorrectChoices());

            return questionRepository.save(existingQuestion);
        } else {
            return null;
        }
    }

    @Override
    public void deleteQuestion(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
        }
    }

    @Override
    public List<String> getAllCategories() {
        return questionRepository.findDistinctCategory();
    }
}
