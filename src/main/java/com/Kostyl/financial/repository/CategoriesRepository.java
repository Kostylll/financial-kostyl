package com.Kostyl.financial.repository;

import com.Kostyl.financial.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
