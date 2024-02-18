package com.uce.edu.funcional;

public class MetodosReferenciados {

	public String getID() {
		// TODO Auto-generated method stub
		String cedula = "1724362106";
		cedula = cedula + "provincia";
		return cedula;
	}

	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("Se proceso la cadena");
	}

	public boolean evaluar(String cadena) {
		return "Michael".contains(cadena);
	}

	public boolean evaluar(Integer numero) {
		return 8 == numero;
	}

	public Ciudadano cambiar(Empleado empleado) {
		Ciudadano c = new Ciudadano();
		c.setNombre(empleado.getNombreCompleto().split(" ")[0]);
		c.setApellido(empleado.getNombreCompleto().split(" ")[1]);
		c.setProvincia("Pichincha");
		return c;
	}

	public Empleado procesar(Empleado empleado) {
		empleado.setNombreCompleto(empleado.getNombreCompleto() + " " + empleado.getPais());
		empleado.setPais(empleado.getPais() + " de nacimiento");
		return empleado;
	}
}
