package org.zer0.pocs.rest.servicioExpuesto.dto;

public class Empleado {

	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int edad;
	private String sexo;
	private Contrato contratoActual;
	
	public Empleado() {
	}
	
	public Empleado(String nombres, String apellidoPaterno, String apellidoMaterno, int edad, String sexo,
			Contrato contratoActual) {
		super();
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.edad = edad;
		this.sexo = sexo;
		this.contratoActual = contratoActual;
	}

	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Contrato getContratoActual() {
		return contratoActual;
	}
	public void setContratoActual(Contrato contratoActual) {
		this.contratoActual = contratoActual;
	}
	
}
