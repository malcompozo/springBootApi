package com.malcom.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "permisos")

//anotaciones de LOMBOK // SI TENEMOS ALGUN FETCH TIPO LAZY SE CREA MANUAL ToString, equals, hashcode
//@ToString
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Permiso extends BaseEntity {

    @Column(name = "nombre")
    @Getter @Setter // anotacion de LOMBOK
    private String nombre;

    // ROLES //
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("rol_id") // traemos solo el id
    @ManyToOne(fetch = FetchType.LAZY) // traera solo la referencia del rol
    @JoinColumn(name = "rol_id") // se anlaza a la columna
    @Getter @Setter // anotacion de LOMBOK
    private Roles role;

	@Override
	public String toString() {
		return "Permiso [nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permiso other = (Permiso) obj;
		return Objects.equals(nombre, other.nombre);
	}
    
    
    
}
