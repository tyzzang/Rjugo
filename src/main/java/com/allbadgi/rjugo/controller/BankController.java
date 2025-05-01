package com.allbadgi.rjugo.controller;

import com.allbadgi.rjugo.dto.BankDto;
import com.allbadgi.rjugo.service.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {
    private final BankService service;
    public BankController(BankService service) { this.service = service; }

    @GetMapping
    public List<BankDto> list() {
        return service.getAllBanks();
    }
}