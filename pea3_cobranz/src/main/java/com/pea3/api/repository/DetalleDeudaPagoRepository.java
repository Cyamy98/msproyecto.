package com.pea3.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pea3.api.model.DetalleDeudaPago;
import com.pea3.api.model.Deuda;
import com.pea3.api.model.Pago;

@Repository
public interface DetalleDeudaPagoRepository extends JpaRepository<DetalleDeudaPago, Long> {

	public List<DetalleDeudaPago> findByDeuda(Deuda deuda);
	public List<DetalleDeudaPago> findByPago(Pago pago);

	
}
