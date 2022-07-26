package com.ciandt.feedfront.excecoes;

import com.ciandt.feedfront.daos.EmployeeDAO;

public class EntidadeNaoEncontradaException extends BusinessException {
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
