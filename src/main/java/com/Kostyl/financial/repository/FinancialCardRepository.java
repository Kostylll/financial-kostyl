package com.Kostyl.financial.repository;

import com.Kostyl.financial.model.FinancialCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialCardRepository extends JpaRepository<FinancialCard, Long> {
}
