package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.excecoes.EntidadeNaoSerializavelException;
import com.ciandt.feedfront.models.FeedBack;

import java.io.IOException;
import java.util.List;

public class FeedbackDAO implements DAO<FeedBack> {

    private String comoMelhora;

    public String getComoMelhora() {
        return comoMelhora;
    }

    public void setComoMelhora(String comoMelhora) {
        this.comoMelhora = comoMelhora;
    }

    @Override
    public boolean tipoImplementaSerializable() {
        return false;
    }

    @Override
    public List<FeedBack> listar() throws IOException, EntidadeNaoSerializavelException {
        return null;
    }

    @Override
    public FeedBack buscar(String id) throws IOException, EntidadeNaoSerializavelException, EmployeeNaoEncontradoException {
        return null;
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
