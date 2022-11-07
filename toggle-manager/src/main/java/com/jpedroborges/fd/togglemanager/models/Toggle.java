package com.jpedroborges.fd.togglemanager.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class Toggle {
    private String name;
    private Boolean status;
    private boolean master;
    private List<String> tags;
}
