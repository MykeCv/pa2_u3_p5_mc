package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {

	public void insertar(Factura factura);

	public List<FacturaDTO> seleccionarFacturasDTO();

	public List<Factura> seleccionarTodos();

}
