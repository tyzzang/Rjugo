package com.allbadgi.rjugo.controller;

import com.allbadgi.rjugo.dto.RegionDto;
import com.allbadgi.rjugo.service.RegionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    private final RegionService service;

    public RegionController(RegionService service) {
        this.service = service;
    }

    @GetMapping
    public List<RegionDto> list() {
        return service.getAllRegions();
    }
}
