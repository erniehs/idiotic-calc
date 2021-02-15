package com.vgernsoft.calc.add;

import static java.lang.String.format;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
class AddController {

    @GetMapping("/add/{a}/to/{b}")
    public ResponseEntity<String> calc(@PathVariable String a, @PathVariable String b) {
        log.debug("attempting operation {} + {}", a, b);
        final double da = Double.parseDouble(a);
        final double db = Double.parseDouble(b);
        return new ResponseEntity<String>(format("%f", da + db), HttpStatus.OK);
    }
}