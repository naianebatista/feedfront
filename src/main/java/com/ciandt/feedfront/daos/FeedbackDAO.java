package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.excecoes.EntidadeNaoSerializavelException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.FeedBack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FeedbackDAO implements DAO<FeedBack> {

    private final String repositorioPath = "src/main/resources/data/feedback/";
    private String comoMelhora;

    public String getComoMelhora() {
        return comoMelhora;
    }

    public void setComoMelhora(String comoMelhora) {
        this.comoMelhora = comoMelhora;
    }
    public static ObjectOutputStream getOutputStream(String arquivo) throws IOException {
        return new ObjectOutputStream(new FileOutputStream(arquivo));
    }

    public static ObjectInputStream getInputStream(String arquivo) throws IOException {
        return new ObjectInputStream(new FileInputStream(arquivo));
    }

    @Override
    public boolean tipoImplementaSerializable() {

        return Employee.class instanceof Serializable;
    }

    @Override
    public List<FeedBack> listar() throws IOException, EntidadeNaoSerializavelException {
        List<FeedBack> feedbacks;
        Stream<Path> paths = Files.walk(Paths.get(repositorioPath));

        List<String> files = paths
                .map(p -> p.getFileName().toString())
                .filter(p -> p.endsWith(".byte"))
                .map(p -> p.replace(".byte", ""))
                .collect(Collectors.toList());

        feedbacks = files.stream().map(id -> {
            try {
                return buscar(id);
            } catch (IOException | EmployeeNaoEncontradoException ex) {
                throw new EntidadeNaoSerializavelException();
            }
        }).collect(Collectors.toList());
        return feedbacks;

    }

    @Override
    public boolean isEmailExistente(Employee employee) throws IOException {
        return false;
    }

    @Override
    public FeedBack buscar(String id) throws IOException, EntidadeNaoSerializavelException, EmployeeNaoEncontradoException {
        FeedBack feedback;
        ObjectInputStream inputStream;

        try {
            inputStream = getInputStream(repositorioPath + id + ".byte");
            feedback = (FeedBack) inputStream.readObject();

            inputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("");
        }

        return feedback;
    }

    @Override
    public FeedBack salvar(FeedBack feedBack) throws IOException, EntidadeNaoSerializavelException {
        return null;
    }

    @Override
    public boolean apagar(String id) throws IOException, EntidadeNaoSerializavelException, EmployeeNaoEncontradoException {
        return false;
    }
}
