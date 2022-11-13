package com.jpedroborges.fd.togglemanager.services;

import com.jpedroborges.fd.togglemanager.models.Tla;
import com.jpedroborges.fd.togglemanager.models.converters.Converter;
import com.jpedroborges.fd.togglemanager.repository.TlaRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TlaService {
    private static final Logger log = LoggerFactory.getLogger(TlaService.class);
    @NonNull
    private TlaRepository tlaRepository;
    @NonNull
    private Converter<Iterable<com.jpedroborges.fd.togglemanager.repository.dto.Tla>, List<Tla>> tlaConverter;
    private List<Tla> tla;


    public List<Tla> getTlas() {
        if (tla == null) {
            log.warn("-- operation: getTlas -- message: No TLAs found. Loading new ones.");
            reloadTlas();
        }
        return tla;
    }

    public void reloadTlas() {
        Iterable<com.jpedroborges.fd.togglemanager.repository.dto.Tla> loadedTlas = tlaRepository.findAll();
        int counter = 0;
        for (com.jpedroborges.fd.togglemanager.repository.dto.Tla ignored : loadedTlas) {
            counter++;
        }

        log.warn("-- operation: reloadTlas -- message: Found {} tlas", counter);
        tla = tlaConverter.convert(loadedTlas);
    }

}
