package com.malcom.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")

// anotaciones de LOMBOK //
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends BaseEntity {


    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // anotacion para dejar el json solo de lectura
    @ManyToOne(fetch=FetchType.EAGER) // anotacion de persistencia muchas a uno, EAGER siempre trae todo el contenido
    @JoinColumn(name="rol_id") // anotacion que indica a que columna se unira y bajo que nombre
    @Getter @Setter // anotacion de LOMBOK 
    private Roles role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // anotacion para dejar el json solo de escritura
    @Column(name = "password")
    @Getter @Setter // anotacion de LOMBOK
    private String password;

    @Column(name = "nombre")
    @Getter @Setter // anotacion de LOMBOK
    private String nombre;

    @Column(name = "apellido")
    @Getter @Setter // anotacion de LOMBOK
    private String apellido;

    @Column(name = "email")
    @Getter @Setter // anotacion de LOMBOK
    private String email;

    @Column(name = "telefono")
    @Getter @Setter // anotacion de LOMBOK
    private String telefono;

    @Column(name = "fecha_nac")
    @Getter @Setter // anotacion de LOMBOK
    private Date fechaNac;

    // CONSTRUCTOR AUTOGENERADO //

	public Usuario(long id, String password, String nombre, String apellido, 
					String email, String telefono,Date fechaNac) {
		setId(id);
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
	}

	
	
    
    
}
