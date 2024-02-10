package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {

	public void guardar(Factura factura, Cliente cliente);

	public List<FacturaDTO> buscarFacturasDTO();

	public void prueba();

	public void pruebaSupport();

	public void pruebaNever();

}
