package com.ciandt.feedfront.contracts;

import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.excecoes.EntidadeNaoSerializavelException;
import com.ciandt.feedfront.daos.EmployeeDAO;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.FeedBack;

import java.io.IOException;
import java.util.List;

//define o contrato de comunicação de persistência de dados.
public interface DAO<E>  {
    boolean tipoImplementaSerializable();

    List<E> listar() throws IOException, EntidadeNaoSerializavelException;

    boolean isEmailExistente(Employee employee) throws IOException;

    E buscar(String id) throws IOException, EntidadeNaoSerializavelException, EmployeeNaoEncontradoException;

    E salvar(E e) throws IOException, EntidadeNaoSerializavelException;

    boolean apagar(String id) throws IOException, EntidadeNaoSerializavelException, EmployeeNaoEncontradoException;

       // boolean isEmailExistente(E e) throws IOException;


}
