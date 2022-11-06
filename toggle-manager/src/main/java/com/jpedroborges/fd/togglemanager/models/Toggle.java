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
    private boolean status;
    private List<String> tags;
}
