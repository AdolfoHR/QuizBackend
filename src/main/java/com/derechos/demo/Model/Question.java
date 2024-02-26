package com.derechos.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(name ="category")
    @NotBlank
    private String category;

    @Column(name ="question_type")
    @NotBlank
    private String questionType;

    @Column(name ="question_text")
    @NotBlank
    private String questionText;


    //Relación Uno es a muchos con tabla QuestionChoices
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionChoices> choices;

    //Relación uno es a uno con tabla correctChoices
    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private CorrectChoices correctChoices;

}





//create table Question(
       // question_id INT primary key,
   //     subject VARCHAR(255),
//questionType VARCHAR (255),
//question_text VARCHAR(255) not null
        //