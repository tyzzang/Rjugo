package com.allbadgi.rjugo.service;

import com.allbadgi.rjugo.dto.BankDto;
import com.allbadgi.rjugo.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankService {
    private final BankRepository repo;
    public BankService(BankRepository repo) { this.repo = repo; }
    public List<BankDto> getAllBanks() {
        return repo.findAll().stream()
                .map(b -> new BankDto(b.getId(), b.getName()))
                .collect(Collectors.toList());
    }
}
