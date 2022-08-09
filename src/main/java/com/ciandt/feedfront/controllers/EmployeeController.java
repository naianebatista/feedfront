package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: APLIQUE AS ANOTAÇÕES NECESSÁRIAS PARA QUE O PROGRAMA RECONHEÇA AS DIFERENTES CAMADAS COMO @SERVICE, @RESTCONTROLLER. NÃO ESQUEÇA DAS INJEÇÕES DE DEPENDENCIA COM O @AUTOWIRED
//TODO: APLIQUE AS ANOTAÇÕES DO SWAGGER CONFORME O EXEMPLO @ApiOperation EM FEEDBACKCONTROLLER.

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Utilize o exemplo de salvar na classe FeedbackController para implementar os métodos:
    @ApiOperation(value = "Este retorna todos os dados enviados pelos usuários no banco de dados.")
    @GetMapping
    public ResponseEntity<List<Employee>> listar() throws UnsupportedOperationException {
        return ResponseEntity.ok(employeeService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> buscar(@PathVariable long id) throws BusinessException,UnsupportedOperationException {
        return  ResponseEntity.ok(employeeService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Employee> salvar(@RequestBody Employee employee) throws BusinessException ,UnsupportedOperationException{
        employeeService.salvar(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Employee>apagar(@PathVariable long id) throws BusinessException ,UnsupportedOperationException{
       employeeService.apagar(id);
       return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> atualizar (@RequestBody Employee employee) throws BusinessException ,UnsupportedOperationException{
       employeeService.atualizar(employee);
       return ResponseEntity.ok(employee);
    }
}