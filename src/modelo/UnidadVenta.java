package modelo;
import java.util.List;
import java.util.ArrayList;

public abstract class UnidadVenta {
	private int id;
	protected String nombreComercial;
	protected Empleado responsable;
	protected double superficie;
	protected String codigo;
	protected List<Empleado> personal;
	protected List<Plato> platos;
	
	
	public UnidadVenta(int id, String nombreComercial,
						Empleado responsable, double superficie,
						String codigo) {
		this.setId(id);
		this.setNombreComercial(nombreComercial);
		this.setResponsable(responsable);
		this.setSuperficie(superficie);
		this.setCodigo(codigo);
		this.personal = new ArrayList<>();
		this.platos = new ArrayList<>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public Empleado getResponsable() {
		return responsable;
	}
	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<Empleado> getPersonal() {
		return personal;
	}
	public void setPersonal(List<Empleado> personal) {
		this.personal = personal;
	}
	public List<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
	
	@Override
	public String toString() {
		return "UnidadVenda: [Nombre Comercial: "+this.getNombreComercial()+
				" | Responsable: "+ this.getResponsable().toString()+
				" | Superficie: "+ this.getSuperficie()+
				" | Codigo: "+ this.getCodigo()+
				" | Personal: "+ this.getPersonal().toString()+
				" | Platos: "+ this.getPlatos().toString();
	}
	public abstract double calcularCanon();
	
	public boolean equals(UnidadVenta unidad)
	{
	    return this.codigo.equals(unidad.getCodigo());
	}
}
