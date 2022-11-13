package com.jpedroborges.fd.togglemanager.repository.converters;

import com.jpedroborges.fd.togglemanager.configs.TlaConfigurationProperties;
import com.jpedroborges.fd.togglemanager.models.converters.Converter;
import com.jpedroborges.fd.togglemanager.repository.dto.Tla;
import com.jpedroborges.fd.togglemanager.repository.dto.Toggle;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hibernate.internal.util.StringHelper.isEmpty;

@Component
@RequiredArgsConstructor
public class ToTlaModel implements Converter<Tla, com.jpedroborges.fd.togglemanager.models.Tla> {
    @NonNull
    private final TlaConfigurationProperties tlaConfiguration;
    @NonNull
    private final Converter<Toggle, com.jpedroborges.fd.togglemanager.models.Toggle> toggleConverter;

    @Override
    public com.jpedroborges.fd.togglemanager.models.Tla convert(Tla convertableObject) {
        if (convertableObject == null) return null;
        String name = convertableObject.getName();
        String internalName = appendNameSuffix(name.toLowerCase());
        List<com.jpedroborges.fd.togglemanager.models.Toggle> toggles = newArrayList();
        for (Toggle dto : convertableObject.getToggles()) {
            toggles.add(toggleConverter.convert(dto));
        }

        return com.jpedroborges.fd.togglemanager.models.Tla.builder()
                .name(name)
                .internalName(internalName)
                .urlPattern(getTlaURL(internalName))
                .toggles(toggles)
                .build();
    }

    private String appendNameSuffix(String name) {
        if (isEmpty(tlaConfiguration.getSuffix())) return name;
        return name + tlaConfiguration.getSuffix();
    }

    private String getTlaURL(String tlaName) {
        return tlaConfiguration.getUrlPattern().replace("{$TLA}", tlaName);
    }

}
