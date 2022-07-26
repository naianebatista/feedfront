package com.ciandt.feedfront.services;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.daos.EmployeeDAO;
import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;

import java.io.IOException;
import java.util.List;

public class EmployeeService implements Service<Employee> {
    private DAO<Employee> dao;

    public EmployeeService() {
        this.dao=new EmployeeDAO();
    }
    @Override
    public List<Employee> listar() throws IOException {
       return dao.listar();
    }

    @Override
    public Employee buscar(String id) throws IOException, BusinessException, EmployeeNaoEncontradoException {
       return dao.buscar(id);
    }

    @Override
    public Employee salvar(Employee employee) throws IOException, BusinessException {
       return dao.salvar(employee);
    }

    @Override
    public Employee atualizar(Employee employee) throws ArquivoException, BusinessException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void apagar(String id) throws ArquivoException, BusinessException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDAO(DAO<Employee> dao) {

    }
}
