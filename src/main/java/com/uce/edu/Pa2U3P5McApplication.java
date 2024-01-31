package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5McApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UPDATE");

		int cantidad = this.facturaService.actualizarFechas(LocalDateTime.of(2020, 1, 9, 12, 50),
				LocalDateTime.of(2020, 1, 15, 12, 00));
		System.out.println("Cantidad de registro actualizados");
		System.out.println(cantidad);

		System.out.println("DELETE");
		int cantidad2 = this.facturaService.borrarPorNumero("-205170");
		System.out.println("Cantidad de registro borrados");
		System.out.println(cantidad2);

		// System.err.println("DELETE NORMAL");
		// this.facturaService.borrar(1);
		// System.out.println("Cantidad de registro borrados normalmente");

		// DTO: Data Transfer object:Patron de diseño para transferir datos mediante un
		// objeto

		System.out.println("BUSCAR FACTURADTO");
		List<FacturaDTO> listaDTO = this.facturaService.buscarFacturasDTO();
		for (FacturaDTO fdto : listaDTO) {
			System.out.println(fdto);
		}
	}
}
