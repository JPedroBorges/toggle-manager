package com.jpedroborges.fd.togglemanager.controllers.converters;

import com.jpedroborges.fd.togglemanager.controllers.dto.TlaResponse;
import com.jpedroborges.fd.togglemanager.models.Tla;
import com.jpedroborges.fd.togglemanager.models.converters.Converter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
@RequiredArgsConstructor
public class ToListTlaResponse implements Converter<List<Tla>, List<TlaResponse>> {
    @NonNull
    private final ToTlaResponse tlaConverter;

    @Override
    public List<TlaResponse> convert(List<Tla> convertableObject) {
        if (convertableObject == null) return null;
        List<TlaResponse> tlas = newArrayList();
        for (Tla model : convertableObject) {
            tlas.add(tlaConverter.convert(model));
        }
        return tlas;
    }
}
