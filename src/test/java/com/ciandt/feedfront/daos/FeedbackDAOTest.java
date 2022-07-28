package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.FeedBack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedbackDAOTest {

    private final LocalDate localDate = LocalDate.now();
    private final String LOREM_IPSUM_FEEDBACK = "Lorem Ipsum is simply dummy text of the printing and typesetting industry";
    private FeedBack feedback;

    private Employee autor;

    private Employee proprietario;

   // private Service<FeedBack> service;
    private DAO<FeedBack> feedBackDAO;

    @BeforeEach
    public void initEach() throws IOException, BusinessException,IllegalArgumentException {
        // Este trecho de código serve somente para limpar o repositório
        Files.walk(Paths.get("src/main/resources/feedback"))//feedback
                .filter(p -> p.toString().endsWith(".byte"))
                .forEach(p -> {
                    new File(p.toString()).delete();
                });

        feedBackDAO = new FeedbackDAO();

        autor = new Employee("João", "Silveira", "j.silveira@email.com");
        proprietario = new Employee("Mateus", "Santos", "m.santos@email.com");

        feedback = new FeedBack(localDate, autor, proprietario, LOREM_IPSUM_FEEDBACK);
        feedBackDAO.salvar(feedback);
    }
    @Test
    public void listar() throws IOException {
        List<FeedBack> result = feedBackDAO.listar();

        assertFalse(result.isEmpty());
        // assertTrue(lista.contains(feedback));
        //assertEquals(1, lista.size());
    }





}
