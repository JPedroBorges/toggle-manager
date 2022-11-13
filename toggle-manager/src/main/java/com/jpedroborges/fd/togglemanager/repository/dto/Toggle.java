package com.jpedroborges.fd.togglemanager.repository.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class Toggle {
    @Id
    private String name;
    private Boolean status;
    private boolean master;
    @ElementCollection(targetClass = String.class)
    private List<String> tags;
}
