package com.pea3.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pea3.api.model.Deuda;
import com.pea3.api.service.DeudaService;

@RestController
@RequestMapping(value = "/deuda")
public class DeudaController {
	
	@Autowired
	DeudaService pagoServicio;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Deuda>> getCliente(){
		List<Deuda>empleado=pagoServicio.ListAllDeuda();
		return ResponseEntity.ok(empleado);
	}
	/*//@GetMapping("/")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Deuda>> ListarPago(@RequestParam(name = "ventaId",
	required = false) Long ventaId) {
		
		List<Deuda> pagos = new ArrayList<>();
		
		if(ventaId == null) {
			pagos = pagoServicio.ListAllDeuda();
			if(pagos.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			pagos = pagoServicio.findByVenta(Venta.builder()
					.idventa(ventaId).build());
			if(pagos.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		
		return ResponseEntity.ok(pagos);
	}*/
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Deuda> getVenta(@PathVariable("id") Long id){
		
		Deuda pago = pagoServicio.getDeuda(id);
		if(pago == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pago);
	}
	
	@PostMapping
	public ResponseEntity<Deuda> CrearPago(@Valid @RequestBody Deuda pago,BindingResult result){
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
		}

		Deuda pagoCreado = pagoServicio.createDeuda(pago);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pagoCreado);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Deuda> actualizarPago(@PathVariable("id") Long id,
			@RequestBody Deuda pago){
		
		pago.setIddeuda(id);
		Deuda pagoEncontrado = pagoServicio.updateDeuda(pago);
		
		if(pagoEncontrado == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pagoEncontrado);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<Deuda> deletePago(@PathVariable("id") Long id){
		Deuda pagoDelete = pagoServicio.deleteDeuda(id);
		
		if(pagoDelete == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pagoDelete);
	}
	
	/*@RequestMapping(value = "/eliminar/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Pago> eliminarPago(@PathVariable("id") Long id,
			@RequestBody Pago pago){
		
		pago.setIdpago(id);
		Pago pagoeliminar = pagoServicio.deletePago(id);
		
		if(pagoeliminar == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pagoeliminar);
	}*/
	
	private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
	
}