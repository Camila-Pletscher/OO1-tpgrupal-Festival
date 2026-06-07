package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Empleado {

	private int id;
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;

	public Empleado(int id, String nombre, String apellido, String dni,
			LocalDate fechaNacimiento, LocalDate fechaIngreso) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public boolean esMayorDeEdad() {

		return Period.between(fechaNacimiento, LocalDate.now())
				.getYears() >= 18;
	}

	public int calcularAntiguedad() {

		return Period.between(fechaIngreso, LocalDate.now()).getYears();
	}

	//METODO ABSTRACTO
	public abstract double calcularSueldo();


	@Override
	public String toString() {

		return "Empleado [id=" + id +
				", nombre=" + nombre +
				", apellido=" + apellido +		
				", dni=" + dni + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, fechaIngreso, fechaNacimiento, id, nombre);
	}

	public boolean equals(Empleado empleado)
	{
	    return this.dni.equals(empleado.getDni());
	}
	
	
	
}
