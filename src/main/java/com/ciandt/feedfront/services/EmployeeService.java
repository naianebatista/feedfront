package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeService  {


    List<Employee> listar() throws UnsupportedOperationException;

    Employee buscar(long id) throws BusinessException;

    Employee salvar(Employee e) throws BusinessException, IllegalArgumentException;

    Long atualizar(Long id, Employee e) throws BusinessException, IllegalArgumentException;

    void apagar(long id) throws BusinessException;
}
