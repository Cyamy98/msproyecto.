package com.pea3.api.model;


import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "deuda")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Deuda {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long iddeuda;
		
		@NotEmpty(message = "El estado no debe estar vacio")
		private String estado;
		private String fechavencimiento;
		private String status;
		
}