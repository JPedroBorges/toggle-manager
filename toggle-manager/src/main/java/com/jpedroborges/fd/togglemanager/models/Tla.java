package com.jpedroborges.fd.togglemanager.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class Tla {
    private String name;
    private String internalName;
    private String urlPattern;
    private List<Toggle> toggles;

}
