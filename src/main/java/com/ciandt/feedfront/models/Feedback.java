package com.ciandt.feedfront.models;

import com.ciandt.feedfront.exceptions.ComprimentoInvalidoException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

//TODO: UTILIZE ANOTAÇÕES DO LOMBOK COMO @ALLARGSCONSTRUTOR E RETIRE O QUE NÃO FOR MAIS NECESSÁRIO COMO O CONSTRUTOR COM TODOS OS ARGUMENTOS. DEIXE SEU CÓDIGO MAIS SUSCINTO.


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feedback {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    @Size(min = 3)    // @Length(min = 3)
    private String descricao;
    @Column
    private String oQueMelhora;
    @Column
    private String comoMelhora;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data ;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Employee autor;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Employee proprietario;




}
