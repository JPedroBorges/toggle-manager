package com.jpedroborges.fd.togglemanager.controllers;

import com.jpedroborges.fd.togglemanager.controllers.dto.TlaResponse;
import com.jpedroborges.fd.togglemanager.models.Tla;
import com.jpedroborges.fd.togglemanager.models.converters.Converter;
import com.jpedroborges.fd.togglemanager.services.TlaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tla")
public class TlaController {
    private static final Logger log = LoggerFactory.getLogger(TlaController.class);

    @NonNull
    private final TlaService service;
    @NonNull
    private final Converter<List<Tla>, List<TlaResponse>> converter;

    @GetMapping()
    public @ResponseBody ResponseEntity<List<TlaResponse>> getTlas() {
        List<Tla> tlas = service.getTlas();
        List<TlaResponse> response = converter.convert(tlas);
        log.info("-- operation: getTlas -- message: requested getTlas {}", response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
