package com.jpedroborges.fd.togglemanager.controllers.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ToggleResponse {
    private String name;
    private boolean status;
    private List<String> tags;
}
