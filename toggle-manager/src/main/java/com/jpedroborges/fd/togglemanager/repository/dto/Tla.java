package com.jpedroborges.fd.togglemanager.repository.dto;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Tla {
    @Id
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Toggle> toggles;

}
