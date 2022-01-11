package com.malcom.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")

//anotaciones de LOMBOK //
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Roles extends BaseEntity  {

    @Column(name = "nombre")
    @Getter @Setter // anotacion de LOMBOK
    private String nombre;

    // PERMISOS //
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
    @Getter @Setter // anotacion de LOMBOK
    private Set<Permiso> permisos;
}
