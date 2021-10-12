package com.pea3.api.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pea3.api.model.Deuda;



//import com.practica.api.modelo.Venta;
@Repository
public interface DeudaRepository extends JpaRepository<Deuda, Long> {

	//public List<Deuda> findByVenta(Venta venta);
}
	