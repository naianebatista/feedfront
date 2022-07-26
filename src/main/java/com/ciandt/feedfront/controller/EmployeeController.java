package com.ciandt.feedfront.controller;



import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.excecoes.EmailInvalidoException;
import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.services.EmployeeService;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import static com.ciandt.feedfront.daos.EmployeeDAO.*;

public class EmployeeController  {
    private Service<Employee> service;

    public EmployeeController() {
        this.service = new EmployeeService();

    }

    public List<Employee> listar() throws IOException {

        return service.listar();
    }

    public Employee buscar(String id) throws IOException, BusinessException, EmployeeNaoEncontradoException {
        return service.buscar(id);
    }

    public Employee salvar(Employee employee) throws BusinessException, IOException {
        return service.salvar(employee);
    }

    public Employee atualizar(Employee employee) throws BusinessException, ArquivoException {
        return service.atualizar(employee);

    }

    public void apagar(String id) throws BusinessException, ArquivoException {
         service.apagar(id);
    }

    public void setService(Service<Employee> service) {
        this.service = service;
    }
}
