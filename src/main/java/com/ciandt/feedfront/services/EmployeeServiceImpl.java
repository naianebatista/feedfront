package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//TODO: IMPLEMENTE AS CLASSES E MAPEIE A CLASSE PARA O SPRINGBOOT
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listar() throws UnsupportedOperationException {
        return employeeRepository.findAll();
    }

    @Override
    public Employee buscar(long id) throws BusinessException,UnsupportedOperationException {
        Optional<Employee> employee=employeeRepository.findById(id);
        return employee.get();
    }

    @Override
    public Employee salvar(Employee employee) throws BusinessException,UnsupportedOperationException {
        return employeeRepository.save(employee);

    }
    @Override
    public Long atualizar(Long id, Employee employee) throws BusinessException,UnsupportedOperationException {
        Optional<Employee> employee1=employeeRepository.findById(id);
       return employee.getId();
    }

    @Override
    public void apagar(long id) throws BusinessException,UnsupportedOperationException {
       employeeRepository.deleteById(id);
    }
}