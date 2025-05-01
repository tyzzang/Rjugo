package com.allbadgi.rjugo.repository;

import com.allbadgi.rjugo.entity.FinancialProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialProductRepository extends JpaRepository<FinancialProduct, Integer>, JpaSpecificationExecutor<FinancialProduct> {
}

