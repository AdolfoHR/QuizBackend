package com.derechos.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Data
public class QuestionChoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="choices_id")
    private Long id;

    @Column(name ="choices_text")
    @NotBlank
    private String ChoicesText;


    //Relación muchos a uno con Question
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="question_id")
    private  Question question;




}













//create table Question_choices (
   //     choices_id INT primary key,
     //   question_id INT
       //                               choices_text: VARCHAR (255) not null,
//foreign key (question_id) references Question (question_id)

