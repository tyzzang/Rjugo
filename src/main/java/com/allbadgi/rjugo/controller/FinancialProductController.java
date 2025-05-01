package com.allbadgi.rjugo.controller;

import com.allbadgi.rjugo.dto.FinancialProductDto;
import com.allbadgi.rjugo.dto.FinancialProductFilterRequest;
import com.allbadgi.rjugo.service.FinancialProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financial-products")
public class FinancialProductController {
    private final FinancialProductService service;
    public FinancialProductController(FinancialProductService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/search",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<FinancialProductDto> search(
            @RequestBody FinancialProductFilterRequest filter
    ) {
        return service.search(
                filter.getBankIds(),
                filter.getRateSort(),
                filter.getTerms(),
                filter.getMinAmounts()
        );
    }
}