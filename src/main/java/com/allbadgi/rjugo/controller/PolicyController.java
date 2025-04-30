package com.allbadgi.rjugo.controller;

import com.allbadgi.rjugo.dto.*;
import com.allbadgi.rjugo.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    // POST /api/policies/search
    @PostMapping("/search")
    public ResponseEntity<List<PolicyDto>> search(
            @RequestBody PolicyFilterRequest filters
    ) {
        List<PolicyDto> results = service.search(filters);
        return ResponseEntity.ok(results);
    }
}
