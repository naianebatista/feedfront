package com.ciandt.feedfront.contracts;

import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.services.EmployeeService;
import com.ciandt.feedfront.services.FeedbackService;

import java.io.IOException;
import java.util.List;


public interface Service<E>  {

    // interface que define um contrato entre os serviços da nossa aplicação
    List<E> listar() throws IOException;

    E buscar(String id) throws IOException, BusinessException, EmployeeNaoEncontradoException;

    E salvar(E e) throws IOException, BusinessException, IllegalArgumentException;

    E atualizar(E e) throws ArquivoException, BusinessException, IllegalArgumentException;

    void apagar(String id) throws ArquivoException, BusinessException;
    void setDAO(DAO<E> dao);
}
