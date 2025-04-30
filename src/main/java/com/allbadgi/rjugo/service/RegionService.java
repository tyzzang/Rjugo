package com.allbadgi.rjugo.service;

import com.allbadgi.rjugo.dto.RegionDto;
import com.allbadgi.rjugo.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionService {

    private final RegionRepository repo;

    public RegionService(RegionRepository repo) {
        this.repo = repo;
    }

    public List<RegionDto> getAllRegions() {
        return repo.findAll().stream()
                .map(r -> new RegionDto(r.getId(), r.getName()))
                .collect(Collectors.toList());
    }
}
