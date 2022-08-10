package com.ciandt.feedfront.services;



import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

//TODO: IMPLEMENTE AS CLASSES E MAPEIE A CLASSE PARA O SPRINGBOOT

public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedBackRepository;

    @Override
    public List<Feedback> listar() throws  UnsupportedOperationException{
        return feedBackRepository.findAll();

    }

    @Override
    public Feedback buscar(long id) throws BusinessException,UnsupportedOperationException {
        Optional<Feedback>feedback=feedBackRepository.findById(id);
        return feedback.get();
    }

    @Override
    public Feedback salvar(Feedback feedback) throws BusinessException, IllegalArgumentException,UnsupportedOperationException {
        return feedBackRepository.save(feedback);
    }

}
