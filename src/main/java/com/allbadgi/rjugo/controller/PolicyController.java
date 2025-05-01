package com.allbadgi.rjugo.controller;

import com.allbadgi.rjugo.dto.PolicyDto;
import com.allbadgi.rjugo.dto.PolicyFilterRequest;
import com.allbadgi.rjugo.service.PolicyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);
    private final PolicyService service;
    private final ObjectMapper objectMapper;

    public PolicyController(PolicyService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/search",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> search(@RequestBody PolicyFilterRequest filters) {
        logger.info("[PolicyController.search] 필터: {}", filters);

        // 1) DB 조회
        List<PolicyDto> results = service.search(filters);
        logger.info("[PolicyController.search] 결과 개수: {}건", results.size());

        try {
            // 2) JSON 문자열로 변환
            String json = objectMapper.writeValueAsString(results);
            System.out.println(results);
            // 3) JSON 그대로 내려줌
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(json);
        } catch (Exception e) {
            logger.error("JSON 직렬화 실패", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"JSON 직렬화 실패\"}");
        }
    }
}
