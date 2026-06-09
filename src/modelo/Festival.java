package modelo;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.time.LocalDate;

public class Festival {
	private int id;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private List<UnidadVenta> unidades;
	private List<Empleado> empleados;
	
	public Festival(int id, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.unidades = new ArrayList<UnidadVenta>();
		this.empleados = new ArrayList<Empleado>();

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public List<UnidadVenta> getUnidades() {
		return this.unidades;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	@Override
	public String toString() {
		return "\nFestival [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaInicio=" + fechaInicio

				+ ", fechaFin=" + fechaFin + " Unidades=" + unidades + "Empleados=" + empleados + " ]";
	
	}


	
	public boolean equals(Festival festival)
	{
		return this.getNombre().equalsIgnoreCase(festival.getNombre()) && 
				this.getFechaInicio().isEqual(festival.fechaInicio) && 
				this.getFechaFin().isEqual(festival.getFechaFin());
	}



	
	
}
