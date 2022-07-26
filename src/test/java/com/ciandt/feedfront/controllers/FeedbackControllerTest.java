package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.controller.FeedbackController;
import com.ciandt.feedfront.controllers.FeedbackControllerTest;
import com.ciandt.feedfront.daos.EmployeeDAO;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.FeedBack;
import com.ciandt.feedfront.models.FeedBack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackControllerTest extends FeedBack{

    private FeedBack feedback;

    private Employee autor;

    private Employee proprietario;

    private FeedbackController controller;

    private EmployeeDAO employeeDAO;

    public FeedbackControllerTest(LocalDate now, Employee autor, Employee proprietario, String s) {
        super(now, autor, proprietario, s);
    }

    @BeforeEach
    public void initEach() throws IOException, BusinessException {
        Files.walk(Paths.get("src/main/resources/data/feedback/"))
                .filter(p -> p.toString().endsWith(".byte"))
                .forEach(p -> {
                    new File(p.toString()).delete();
                });

        controller = new FeedbackController();
        autor = new Employee("João", "Silveira", "j.silveira@email.com");
        proprietario = new Employee("Mateus", "Santos", "m.santos@email.com");

        feedback = new FeedBack(LocalDate.now(), autor, proprietario,"Agradeco muito pelo apoio feito pelo colega!");//construtor 1

        controller.salvar(feedback);
    }
    @Test
    public void listar() throws IOException {
        Collection<FeedBack> listaFeedback = controller.listar();

        assertNotNull(listaFeedback);
    }

    @Test
    public void salvar() {
        assertDoesNotThrow(() -> controller.salvar(feedback));
    }

    @Test
    public void buscar() {
        String uuid = feedback.getId();

        FeedBack feedbackSalvo = assertDoesNotThrow(() -> controller.buscar(uuid));

        assertEquals(feedback, feedbackSalvo);

    }

}
