package com.uce.edu.funcional;

public class Ciudadano {

	private String nombre;
    private String apellido;
    private String provincia;

    //SETS Y GETS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    @Override
    public String toString() {
        return "Ciudadano [nombre=" + nombre + ", apellido=" + apellido + ", provincia=" + provincia + "]";
    }
}

