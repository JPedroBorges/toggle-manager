package com.jpedroborges.fd.togglemanager.repository.dto;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Toggle {
    @Id
    private String name;
    private Boolean status;
    private boolean master;
    @ElementCollection(targetClass = String.class)
    private List<String> tags;
}
