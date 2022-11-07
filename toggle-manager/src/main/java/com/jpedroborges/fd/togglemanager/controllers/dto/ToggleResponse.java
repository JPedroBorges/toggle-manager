package com.jpedroborges.fd.togglemanager.controllers.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ToggleResponse {
    private String name;
    private Boolean status;
    private boolean master;
    private List<String> tags;
}
