package com.ciandt.feedfront.services;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.daos.FeedbackDAO;
import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.daos.EmployeeDAO;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.FeedBack;

import java.util.List;

public class FeedbackService  implements Service<FeedBack>{
    private DAO<FeedBack> dao;

    public FeedbackService(){
        this.dao= new FeedbackDAO();

    }

    @Override
    public List<FeedBack> listar() throws ArquivoException {
        return null;
    }

    @Override
    public FeedBack buscar(String id) throws ArquivoException, BusinessException {
        return null;
    }

    @Override
    public FeedBack salvar(FeedBack feedBack) throws ArquivoException, BusinessException, IllegalArgumentException {
        return null;
    }

    @Override
    public FeedBack atualizar(FeedBack feedBack) throws ArquivoException, BusinessException, IllegalArgumentException {
        return null;
    }

    @Override
    public void apagar(String id) throws ArquivoException, BusinessException {

    }

    @Override
    public void setDAO(DAO<FeedBack> dao) {

    }
}
