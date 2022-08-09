package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//TODO: APLIQUE AS ANOTAÇÕES NECESSÁRIAS PARA QUE O PROGRAMA RECONHEÇA AS DIFERENTES CAMADAS COMO @SERVICE, @RESTCONTROLLER. NÃO ESQUEÇA DAS INJEÇÕES DE DEPENDENCIA COM O @AUTOWIRED
//TODO: APLIQUE AS ANOTAÇÕES DO SWAGGER CONFORME O EXEMPLO @ApiOperation EM FEEDBACKCONTROLLER.

@RequestMapping("/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Utilize o exemplo de salvar na classe FeedbackController para implementar os métodos:

    @GetMapping
    public ResponseEntity<List<Employee>> listar()  {

        throw new UnsupportedOperationException();
    }

    public ResponseEntity<Employee> buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity<Employee> salvar(Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity apagar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity<Employee> atualizar (Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}