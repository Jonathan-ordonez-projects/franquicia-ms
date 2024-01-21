package com.api.franquicia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "franchise")
@Builder
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Branch> branches;
}
