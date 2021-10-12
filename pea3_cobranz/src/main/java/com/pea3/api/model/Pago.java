package com.pea3.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pago")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpago;
	private Double totalpago;
	@Column(name="fechapago")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	private String status;

	@NotNull(message = "El empleado no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idempleado")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Empleado empleado;
}
