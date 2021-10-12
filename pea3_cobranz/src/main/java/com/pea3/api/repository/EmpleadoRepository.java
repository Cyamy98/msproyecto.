package com.pea3.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pea3.api.model.Empleado;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	/*public List<Producto> findByPedidoInterno(PedidoInterno pedidointerno);
	public List<Producto> findByVenta(Venta venta);
	public List<Producto> findByCompra(Compra compra);*/
	
}
