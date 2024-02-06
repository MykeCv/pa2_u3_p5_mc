package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	// Join Types en JPA
	// 1) Join
	// 1.1) Inner Join
	// 1.2) Outer Join
	// 1.2.1)Right
	// 1.2.2)Left
	// 1.2.3)Full
	// 2) Join Where
	// 3) Fetch Join

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura buscar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero,f.fecha) FROM Factura f",
				FacturaDTO.class);
		return myQuery.getResultList();
	}

}
