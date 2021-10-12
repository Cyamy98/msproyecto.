package com.pea3.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pea3.api.model.Empleado;
import com.pea3.api.model.Pago;



@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

	public List<Pago> findByEmpleado(Empleado empleado);

}
