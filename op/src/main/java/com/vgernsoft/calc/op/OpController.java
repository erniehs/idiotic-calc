package com.vgernsoft.calc.op;

import static com.vgernsoft.calc.common.Op.exec;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/1.0.0")
@RequiredArgsConstructor
class OpController {

    private final Map<String, String> opMap;

    @GetMapping("/{a}/{op}/{b}")
    public ResponseEntity<Double> calc(@PathVariable String a, @PathVariable String op, @PathVariable String b) {
        log.debug("attempting operation {} {} {}", a, op, b);
        return new ResponseEntity<Double>(exec(opMap.get(op), Double.valueOf(a), Double.valueOf(b)), HttpStatus.OK);
    }
}