package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

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
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero = :numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact = myQuery.getSingleResult();
		fact.getDetalleFactura().size();
		return fact;
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub

		// SQL: SELECT * FROM factura f inner join detalle_factura d
		// on f.fact_id=d.defa_id_factura

		// select f1_0.fac_id,f1_0.fac_cedula,f1_0.fac_fecha,f1_0.fac_numero
		// from factura f1_0 join detalle_factura df1_0
		// on f1_0.fac_id=df1_0.defa_id_factura

		// select f1_0.fac_id,f1_0.fac_cedula,f1_0.fac_fecha,f1_0.fac_numero
		// from factura f1_0 join detalle_factura df1_0
		// on f1_0.fac_id=df1_0.defa_id_factura

		// JPQL: SELECT f FROM Factura f INNER JOIN f.detalleFactura d
		//// JPQL: SELECT f FROM Factura f JOIN f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalleFactura d",
				Factura.class);

		List<Factura> lista = myQuery.getResultList();
//		for (Factura f : lista) {
//			f.getDetalleFactura().size();//señal
//
//		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT f.* FROM factura f, detalle_factura d WHERE f.fact_id =
		// d.defa_id_factura

		// Usando JPQL: SELECT f FROM Factura f, DetalleFactura d
		// WHERE f.id = d.factura.id
		// WHERE f = d.factura
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura", Factura.class);
		List<Factura> facturas = myQuery.getResultList();
		for (Factura factura : facturas) {
			factura.getDetalleFactura().size();// señal
		}
		return facturas;

	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		// JPQL: SELECT f FROM Factura f INNER JOIN f.detalleFactura d (TIENE LA PALABRA
		// FETCH AL LADO DERECHO)
		// SQL: SELECT f FROM Factura f JOIN FETCH f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalleFactura d", Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		// SELECT * FROM Factura WHERE fecha >=fechaActual
		// Lista
		// Recorrer la lista
		// Por cada factura seteo la nueva fecha
		// Actualizar la factura
		// SQL: UPDATE Factura set fact_fecha =: fechaNueva WHERE fact_fecha
		// >=fechaActual
		// JPQL: UPDATE Factura f SET f.fecha =: fechaNueva WHERE f.fecha >=
		// :fechaActual
		Query query = this.entityManager
				.createQuery("Update Factura f set f.fecha = :fechaNueva where f.fecha >= :fechaActual");
		query.setParameter("fechaNueva", fechaNueva);
		query.setParameter("fechaActual", fechaActual);
		return query.executeUpdate();
		// Cantidad de registros afectados / actualizados
	}

	public Factura buscar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.entityManager.find(Factura.class, id));
	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		// SQL:DELETE FROM Factura WHERE fact_numero = :numero
		// JPQL: DELETE FORM Factura f WHERE f.numero = :numero
		Query myQuery = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero = :numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();

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
