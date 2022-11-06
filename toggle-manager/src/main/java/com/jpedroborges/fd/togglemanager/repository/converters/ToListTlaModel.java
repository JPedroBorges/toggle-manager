package com.jpedroborges.fd.togglemanager.repository.converters;

import com.jpedroborges.fd.togglemanager.models.converters.Converter;
import com.jpedroborges.fd.togglemanager.repository.dto.Tla;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
@RequiredArgsConstructor
public class ToListTlaModel implements Converter<Iterable<Tla>, List<com.jpedroborges.fd.togglemanager.models.Tla>> {
    @NonNull
    private final ToTlaModel serviceConverter;

    @Override
    public List<com.jpedroborges.fd.togglemanager.models.Tla> convert(Iterable<Tla> convertableObject) {
        if (convertableObject == null) return null;
        List<com.jpedroborges.fd.togglemanager.models.Tla> tlas = newArrayList();
        for (Tla dto : convertableObject) {
            tlas.add(serviceConverter.convert(dto));
        }
        return tlas;
    }
}
