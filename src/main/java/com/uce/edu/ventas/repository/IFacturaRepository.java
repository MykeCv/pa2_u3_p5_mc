package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaRepository {

	public Factura seleccionarPorNumero(String numero);

	public void insertar(Factura factura);

	public List<Factura> seleccionarFacturasInnerJoin();

	public List<Factura> seleccionarFacturasRightJoin();

	public List<Factura> seleccionarFacturasLeftJoin();

	public List<Factura> seleccionarFacturasFullJoin();

	public List<Factura> seleccionarFacturasWhereJoin();

	public List<Factura> seleccionarFacturasFetchJoin();
}
