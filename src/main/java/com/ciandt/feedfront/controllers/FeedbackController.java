package com.ciandt.feedfront.controllers;


import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.services.FeedbackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: APLIQUE AS ANOTAÇÕES NECONHEÇA AS DIESSÁRIAS PARA QUE O PROGRAMA RECFERENTES CAMADAS COMO @SERVICE, @RESTCONTROLLER. NÃO ESQUEÇA DAS INJEÇÕES DE DEPENDENCIA COM O @AUTOWIRED
//TODO: APLIQUE AS ANOTAÇÕES DO SWAGGER CONFORME O EXEMPLO @ApiOperation

@RestController
@RequestMapping("/v1/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @ApiOperation(value = "Este retorna todos os dados enviados pelos usuários no banco de dados.")
    @GetMapping
    public ResponseEntity<List<Feedback>> listar() throws UnsupportedOperationException {
        return ResponseEntity.ok(feedbackService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> buscar(@PathVariable long id) throws BusinessException, UnsupportedOperationException {
        return ResponseEntity.ok(feedbackService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Feedback> salvar(@RequestBody Feedback feedback) throws BusinessException, UnsupportedOperationException {
         feedbackService.salvar(feedback);
        return ResponseEntity.ok(feedback);

    }
}
