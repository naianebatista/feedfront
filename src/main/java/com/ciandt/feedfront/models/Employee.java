package com.ciandt.feedfront.models;

import com.ciandt.feedfront.exceptions.ComprimentoInvalidoException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;


//TODO: UTILIZE ANOTAÇÕES DO LOMBOK COMO @ALLARGSCONSTRUTOR E RETIRE O QUE NÃO FOR MAIS NECESSÁRIO COMO O CONSTRUTOR COM TODOS OS ARGUMENTOS. DEIXE SEU CÓDIGO MAIS SUSCINTO.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    private Long id;

    @Size(min = 3)
    @Column  (nullable = false)
    private String nome;

    @Size(min = 3)
    @Column  (nullable = false)
    private String sobrenome;

    @Column  (unique = true)
    private String email;

    @OneToMany // fetch = FetchType.LAZY
    private List<Feedback> feedbackFeitos;

    @OneToMany // fetch = FetchType.LAZY
    private List<Feedback> feedbackRecebidos;


}



