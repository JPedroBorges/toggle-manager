package com.jpedroborges.fd.togglemanager.repository.converters;

import com.jpedroborges.fd.togglemanager.models.converters.Converter;
import com.jpedroborges.fd.togglemanager.repository.dto.Toggle;
import org.springframework.stereotype.Component;

@Component
public class ToToggleModel implements Converter<Toggle, com.jpedroborges.fd.togglemanager.models.Toggle> {

    @Override
    public com.jpedroborges.fd.togglemanager.models.Toggle convert(Toggle convertableObject) {
        if (convertableObject == null) return null;
        return com.jpedroborges.fd.togglemanager.models.Toggle.builder()
                .name(convertableObject.getName())
                .status(convertableObject.isStatus())
                .tags(convertableObject.getTags())
                .build();
    }
}
