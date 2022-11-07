package com.jpedroborges.fd.togglemanager.controllers.converters;

import com.jpedroborges.fd.togglemanager.controllers.dto.TlaResponse;
import com.jpedroborges.fd.togglemanager.controllers.dto.ToggleResponse;
import com.jpedroborges.fd.togglemanager.models.Tla;
import com.jpedroborges.fd.togglemanager.models.Toggle;
import com.jpedroborges.fd.togglemanager.models.converters.Converter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@RequiredArgsConstructor
@Component
public class ToTlaResponse implements Converter<Tla, TlaResponse> {
    @NonNull
    private final ToToggleResponse toggleConverter;

    @Override
    public TlaResponse convert(Tla convertableObject) {
        if (convertableObject == null) return null;
        List<ToggleResponse> toggles = newArrayList();
        for (Toggle model : convertableObject.getToggles()) {
            toggles.add(toggleConverter.convert(model));
        }

        return TlaResponse.builder()
                .name(convertableObject.getName())
                .internalName(convertableObject.getInternalName())
                .toggles(toggles)
                .build();
    }
}
