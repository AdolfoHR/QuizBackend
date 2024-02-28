package com.derechos.demo.Controller;


import com.derechos.demo.Model.Question;
import com.derechos.demo.Service.QuestionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {


    private final QuestionServiceImpl questionService;


    //Traer todas las preguntas
    @GetMapping("/all-questions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    //Crear nueva pregunta
    @PostMapping("/add-question")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        HttpStatus status = questionService.addQuestion(question);
        if (status == HttpStatus.CREATED) {
            return new ResponseEntity<>("Pregunta agregada exitosamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al agregar la pregunta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Actualiza una pregunta por su ID

    @PatchMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        Question preguntaActualizada = questionService.updateQuestion(id, updatedQuestion);
        if (preguntaActualizada != null) {
            return new ResponseEntity<>(preguntaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }}

    //Busca una pregunta por su ID
    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Question> theQuestion = questionService.getQuestionById(id);
        if (theQuestion.isPresent()) {
            return ResponseEntity.ok(theQuestion.get());
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    //Borra una pregunta por su ID

    @DeleteMapping("/question/{id}/delete")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }


    //Trae una pregunta por la categoría a la que pertenece
    @GetMapping("/subjects")
    public ResponseEntity<List<String>> getAllSubjects(){
        List<String> subjects = questionService.getAllCategories();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/categoryJuego/{categoriaJuego}")
    public ResponseEntity<List<Question>> getQuestions(@PathVariable String categoriaJuego) {
        List<Question> questions = questionService.getQuestionsByCategory(categoriaJuego);

        return ResponseEntity.of(Optional.ofNullable(questions).filter(list -> !list.isEmpty()));
    }
}


