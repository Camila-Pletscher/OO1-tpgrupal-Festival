package modelo;

import java.time.LocalDate;

public class Cajero extends Empleado {

	private Turno turno;

	public Cajero(int id,
			String nombre,
			String apellido,
			String dni,
			LocalDate fechaNacimiento,
			LocalDate fechaIngreso,
			Turno turno) {

		super(id, nombre, apellido, dni, fechaNacimiento, fechaIngreso);

		this.turno = turno;
	}

	public Turno getTurno() {
		return turno;
	}

	@Override
	public double calcularSueldo() {
		return 20; //solo para no de error
		//return Sistema.SUELDO_BASE +(calcularAntiguedad() * Sistema.PLUS_ANTIGUEDAD_POR_ANIO);
	}
}