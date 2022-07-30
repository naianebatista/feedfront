package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.excecoes.*;
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
import java.util.UUID;
import java.util.concurrent.Flow;

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
        Files.walk(Paths.get("src/main/resources/data/feedback"))//feedback
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

        assertTrue(result.isEmpty());
    }
    @Test
    public void buscar() throws IOException{
        String idValido = feedback.getId();
        String idInvalido = UUID.randomUUID().toString();

        assertThrows(IOException.class, () -> feedBackDAO.buscar(idInvalido));
        FeedBack feedbackSalvo = assertDoesNotThrow(() -> feedBackDAO.buscar(idValido));

        assertEquals(feedbackSalvo.getId(), feedback.getId());

    }
    @Test
    public void salvar() throws IOException, ComprimentoInvalidoException, EmployeeNaoEncontradoException, FeedbackNaoEncontradoException {
        String id = feedback.getId();
        FeedBack feedbackSalvo = feedBackDAO.buscar(id);
        autor = new Employee("João", "Silveira", "j.silveira@email.com");
        proprietario = new Employee("Mateus", "Santos", "m.santos@email.com");
        FeedBack feedbackNaoSalvo = new FeedBack(localDate, autor, proprietario, LOREM_IPSUM_FEEDBACK);

        assertEquals(feedback.getId(), feedbackSalvo.getId());
        assertDoesNotThrow(() -> feedBackDAO.salvar(feedbackNaoSalvo));
    }

    @Test
    public void atualizarDados() throws IOException, ComprimentoInvalidoException, EmailInvalidoException, EmployeeNaoEncontradoException {
        feedback.setOqueMelhora("A cobertura de testes");
        feedback.setComoMelhora("Fazendo novos testes");
        FeedBack feedbackSalvo = feedBackDAO.buscar(feedback.getId());

        assertNotEquals(feedbackSalvo.getComoMelhora(), feedback.getComoMelhora());
        assertNotEquals(feedbackSalvo.getOqueMelhora(), feedback.getOqueMelhora());

        FeedBack feedbackAtualizado = feedBackDAO.salvar(feedback);

        assertEquals(feedbackAtualizado, feedback);
    }

    @Test
    public void apagar() {
        boolean apagou = assertDoesNotThrow(() -> feedBackDAO.apagar(feedback.getId()));
        assertTrue(apagou);
        assertThrows(IOException.class, () -> feedBackDAO.buscar(feedback.getId()));
    }





}
