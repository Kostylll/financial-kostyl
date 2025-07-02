package com.Kostyl.financial.controllers;

import com.Kostyl.financial.model.dtos.FinancialCardDTO;
import com.Kostyl.financial.services.FinancialCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/financial")
public class FinancialCardController {

    @Autowired
    private FinancialCardService financialCardService;


    @GetMapping(value = "/cards", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<FinancialCardDTO> getCards() {
        try {
            var cards = financialCardService.GetAll();
            return cards;
        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of();
        }
    }

    @PostMapping(value = "/create")
    public FinancialCardDTO createCard(@RequestBody FinancialCardDTO financialCardDTO) {
        var card = financialCardService.createCard(financialCardDTO);
        return card;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id) {
        financialCardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update")
    public FinancialCardDTO updateCard(@RequestBody FinancialCardDTO financialCardDTO) {
        var updatedCard = financialCardService.updateCard(financialCardDTO);
        return updatedCard;
    }

}
