package com.doguedogue.rest.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table (name="clientes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotEmpty
	@Size(min=4, max=12)
	@Column(name = "nombre", nullable=false)
	private String nombre;
	
	@NotEmpty
	@Column(name = "apellido")
	private String apellido;
	
	@NotEmpty
	@Email
	@Column(name = "email", unique=true)
	private String email;

	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@PrePersist
	private void prepersist() {
		createdAt = new Date();
	}
}
