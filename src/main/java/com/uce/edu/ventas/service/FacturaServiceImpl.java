package com.uce.edu.ventas.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IClienteService clienteService;

	@Override
	@Transactional(value = TxType.REQUIRED) // trans 1
	public void guardar(Factura factura, Cliente cliente) {
		// TODO Auto-generated method stub
		BigDecimal valor = new BigDecimal(100);
		valor = valor.multiply(new BigDecimal(0.12));
		factura.setValorIVA(valor);
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.facturaRepository.insertar(factura);
		System.out.println("Paso el insert de factura");
		this.clienteService.guardar(cliente);
		System.out.println("Paso el insert de cliente");
	}

	/*
	 * Begin insert factura (ok) insert cliente (ok) commit
	 * 
	 * Begin insert factura (ok) insert cliente (error) commit
	 * 
	 */

	@Override
	public List<FacturaDTO> buscarFacturasDTO() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasDTO();
	}

	@Override
	@Transactional(value = TxType.MANDATORY) // Obliga a que desde donde se lo llama, tenga una transaccion
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("Este metodo es de prueba");
		System.out.println("Prueba: " + TransactionSynchronizationManager.isActualTransactionActive());
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaSupport() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaSupports();
	}

	public void pruebaSupport1() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaSupports();
	}

	@Transactional(value = TxType.REQUIRED)
	public void pruebaSupport2() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaSupports();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Never: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaNever();
	}

}
