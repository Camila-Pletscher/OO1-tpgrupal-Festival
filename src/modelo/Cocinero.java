package modelo;

import java.time.LocalDate;

public class Cocinero extends Empleado {

	private String especialidad;
	private double plusCategoria;

	public Cocinero(int id,
			String nombre,
			String apellido,
			String dni,
			LocalDate fechaNacimiento,
			LocalDate fechaIngreso,
			String especialidad,
			double plusCategoria) {

		super(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso);

		this.especialidad = especialidad;
		this.plusCategoria = plusCategoria;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public double getPlusCategoria() {
		return plusCategoria;
	}

	//@Override
	public double calcularSueldo() {
		return 20; // solo para que no de error 

		//return Sistema.SUELDO_BASE + plusCategoria;
	}
}