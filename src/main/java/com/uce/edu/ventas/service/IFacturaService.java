package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaService {

	public Factura buscarPorNumero(String numero);

	public void guardar(Factura factura);
}
