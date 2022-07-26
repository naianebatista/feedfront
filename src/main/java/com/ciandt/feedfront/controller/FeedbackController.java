package com.ciandt.feedfront.controller;

import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.FeedBack;
import com.ciandt.feedfront.services.EmployeeService;
import com.ciandt.feedfront.services.FeedbackService;

import java.io.IOException;
import java.util.List;

public class FeedbackController {
    private Service<FeedBack> service;

    public FeedbackController() {
        this.service = new FeedbackService();
    }

    public List<FeedBack> listar() throws IOException   {
        return service.listar();
    }

    public FeedBack buscar(String id ) throws IOException, BusinessException, EmployeeNaoEncontradoException {
        return service.buscar(id);
    }
    public FeedBack salvar(FeedBack f) throws IOException, BusinessException{
        return service.salvar(f);
    }
    public FeedBack atualizar(FeedBack fAtualiza) throws ArquivoException,BusinessException {
        return service.atualizar(fAtualiza);
    }

    public void apagar(String id) throws  ArquivoException,BusinessException{
        this.service.apagar(id);
    }

    public Service<FeedBack> getService() {
        return service;
    }

    public void setService(Service<FeedBack> service) {
        this.service = service;
    }
}
