package com.pea3.api.service;

import java.util.List;

import com.pea3.api.model.DetalleDeudaPago;
import com.pea3.api.model.Deuda;
import com.pea3.api.model.Pago;




public interface DetalleDeudaPagoService {
	public List<DetalleDeudaPago> ListAllDetalleDeudaPago();
	public DetalleDeudaPago getDetalleDeudaPago(Long id);
	
	public DetalleDeudaPago createDetalleDeudaPago(DetalleDeudaPago detalledeudapago);
	public DetalleDeudaPago updateDetalleDeudaPago(DetalleDeudaPago detalledeudapago);
	public DetalleDeudaPago deleteDetalleDeudaPago(Long id);
	
	public List<DetalleDeudaPago> findByDeuda(Deuda deuda);
	public List<DetalleDeudaPago> findByPago(Pago pago);
	//public Cliente updateStock(Long id, Double quantity);
}
