package com.Kostyl.financial.controllers;

import com.Kostyl.financial.model.FinancialCard;
import com.Kostyl.financial.services.FinancialCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/financial")
public class FinancialCardController {

    @Autowired
    private FinancialCardService financialCardService;


    @GetMapping(value = "/cards" , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<FinancialCard> getCards() {
        var cards = financialCardService.GetAll();
        return cards;
    }

}
