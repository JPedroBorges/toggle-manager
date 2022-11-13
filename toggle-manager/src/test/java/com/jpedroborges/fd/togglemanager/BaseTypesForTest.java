package com.jpedroborges.fd.togglemanager;

import com.jpedroborges.fd.togglemanager.controllers.dto.TlaResponse;
import com.jpedroborges.fd.togglemanager.controllers.dto.ToggleResponse;
import com.jpedroborges.fd.togglemanager.models.Tla;
import com.jpedroborges.fd.togglemanager.models.Toggle;

import static com.google.common.collect.Lists.newArrayList;

public abstract class BaseTypesForTest {
    private int tlaModelIndex = 0;
    private int tlaResponseIndex = 0;
    private int tlaDTOIndex = 0;
    private int toggleModelIndex = 0;
    private int toggleResponseIndex = 0;

    protected Toggle toggleModel() {
        return Toggle.builder()
                .name("toggleName" + toggleModelIndex++)
                .status(false)
                .master(true)
                .tags(newArrayList("a"))
                .build();
    }

    protected ToggleResponse toggleResponse() {
        return ToggleResponse.builder()
                .name("toggleName" + toggleResponseIndex++)
                .status(false)
                .tags(newArrayList("a"))
                .build();
    }

    protected com.jpedroborges.fd.togglemanager.repository.dto.Toggle toggleDTO() {
        com.jpedroborges.fd.togglemanager.repository.dto.Toggle dto = new com.jpedroborges.fd.togglemanager.repository.dto.Toggle();
        dto.setName("toggleName" + tlaDTOIndex++);
        dto.setTags(newArrayList("a"));
        dto.setStatus(false);
        dto.setMaster(true);
        return dto;
    }

    protected Tla tlaModel() {
        int index = tlaModelIndex++;
        return Tla.builder()
                .internalName("abc" + index)
                .toggles(newArrayList(toggleModel(), toggleModel()))
                .name("abc")
                .urlPattern("abc" + index + "-{XHY}")
                .build();
    }

    protected TlaResponse tlaResponse() {
        int index = tlaResponseIndex++;
        return TlaResponse.builder()
                .internalName("abc" + index)
                .name("abc")
                .toggles(newArrayList(toggleResponse(), toggleResponse()))
                .build();
    }

    protected com.jpedroborges.fd.togglemanager.repository.dto.Tla tlaDTO() {
        com.jpedroborges.fd.togglemanager.repository.dto.Tla dto = new com.jpedroborges.fd.togglemanager.repository.dto.Tla();
        dto.setName("abc");
        dto.setToggles(newArrayList(toggleDTO(), toggleDTO()));
        return dto;
    }
}
