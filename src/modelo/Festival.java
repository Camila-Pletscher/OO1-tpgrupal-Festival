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
	// TODO private List<UnidadVenta> unidades;
	private List<Costo> costos;
	
	
	
	
	
	public Festival(int id, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			List<Costo> costos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costos = costos;
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
	public List<Costo> getCostos() {
		return costos;
	}
	public void setCostos(List<Costo> costos) {
		this.costos = costos;
	}
	
	
	@Override
	public String toString() {
		return "\nFestival [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", costos=" + costos + "]";
	}

	

	
	public boolean equals(Festival festival)
	{
		return festival.getId() == this.id;
	}

	
	
	

	
	
	
	
	
	
}
