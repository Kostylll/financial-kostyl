package com.Kostyl.financial.services;

import com.Kostyl.financial.model.FinancialCard;
import com.Kostyl.financial.repository.FinancialCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialCardService {

    @Autowired
    private FinancialCardRepository financialCardRepository;

    public List<FinancialCard> GetAll(){
        List<FinancialCard> cards = financialCardRepository.findAll();
        return cards;
    }


}
