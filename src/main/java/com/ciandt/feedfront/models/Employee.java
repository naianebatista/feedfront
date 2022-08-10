package com.ciandt.feedfront.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


//TODO: UTILIZE ANOTAÇÕES DO LOMBOK COMO @ALLARGSCONSTRUTOR E RETIRE O QUE NÃO FOR MAIS NECESSÁRIO COMO O CONSTRUTOR COM TODOS OS ARGUMENTOS. DEIXE SEU CÓDIGO MAIS SUSCINTO.
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

//    @Size(min = 3)
    @Column  (nullable = false)
    private String nome;

//    @Size(min = 3)
    @Column  (nullable = false)
    private String sobrenome;

    @Column  (unique = true)
    private String email;

    @JsonIgnore
    @OneToMany // fetch = FetchType.LAZY
    private List<Feedback> feedbackFeitos;

    @JsonIgnore
    @OneToMany // fetch = FetchType.LAZY
    private List<Feedback> feedbackRecebidos;



}



