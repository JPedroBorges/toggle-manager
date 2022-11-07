package com.jpedroborges.fd.togglemanager.controllers.converters;

import com.jpedroborges.fd.togglemanager.controllers.dto.ToggleResponse;
import com.jpedroborges.fd.togglemanager.models.Toggle;
import com.jpedroborges.fd.togglemanager.models.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToToggleResponse implements Converter<Toggle, ToggleResponse> {
    @Override
    public ToggleResponse convert(Toggle convertableObject) {
        if (convertableObject == null) return null;
        return ToggleResponse.builder()
                .name(convertableObject.getName())
                .status(convertableObject.getStatus())
                .master(convertableObject.isMaster())
                .tags(convertableObject.getTags())
                .build();
    }
}
