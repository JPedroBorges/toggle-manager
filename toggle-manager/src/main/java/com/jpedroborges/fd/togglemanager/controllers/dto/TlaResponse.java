package com.jpedroborges.fd.togglemanager.controllers.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TlaResponse {
    private String name;
    private String internalName;
    private int numberOfInstances;
    private List<ToggleResponse> toggles;

}
