package modelo;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public abstract class UnidadVenta {
	private int id;
	protected String nombreComercial;
	protected Empleado responsable;
	protected double superficie;
	protected String codigo;
	protected List<Empleado> personal;
	protected List<Plato> platos;
	protected List<Pedido> pedidos;
	
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
		this.pedidos = new ArrayList<>();
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
	public List<Pedido> getPedidos(){
		return this.pedidos;
	}

	public double calcularRecaudacion(Festival festival)
	{
	    double total = 0;

	    for(Pedido pedido : pedidos)
	    {
	        if(pedido.getFestival().equals(festival))
	        {
	            total += pedido.calcularTotal();
	        }
	    }

	    return total;
	}
	
	@Override
	public String toString() {
		return "UnidadVenta: [Nombre Comercial: "+this.getNombreComercial()+
				" | Responsable: "+ this.getResponsable().toString()+
				" | Superficie: "+ this.getSuperficie()+
				" | Codigo: "+ this.getCodigo()+
				" | Personal: "+ this.getPersonal().toString()+
				" | Platos: "+ this.getPlatos().toString();
	}
	
	public boolean equals(UnidadVenta unidad)
	{
	    return this.codigo.equals(unidad.getCodigo());
	}

	
	public abstract double calcularCanon();
	
	// CASO DE USO N°8: Cálculo de rentabilidad neta: calcular la ganancia de una unidad
	// (pedidos totales - costos de platos) y restar obligatoriamente los sueldos y el canon
	
	public double calcularRentabilidadNeta() {
		double total = 0;
		for(Pedido p : this.getPedidos()) {
			for(ItemPedido item : p.getItems()) {
				total+= (item.getPlato().getPrecioVenta() - item.getPlato().getCostoProduccion()) * item.getCantidad();
			}
		}
		for(Empleado e : this.getPersonal()) {
			total -= e.calcularSueldo();
		}
		total -= this.calcularCanon();
		
		return total;
	}
	// CASO DE USO N°9: Para una unidad, calcule la rentabilidad neta entre dos fechas. 
	public double calcularRentabilidadNetaEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta) {
		double total = 0;
		for(Pedido p : this.getPedidos()) {
			if(!p.getFecha().isBefore(fechaDesde) && !p.getFecha().isAfter(fechaHasta)) {
				for(ItemPedido item : p.getItems()) {
					total+= (item.getPlato().getPrecioVenta() - item.getPlato().getCostoProduccion()) * item.getCantidad();
				}
			}
		}
		for(Empleado e : this.getPersonal()) {
			total -= e.calcularSueldo();
		}
		total -= this.calcularCanon();
		
		return total;
	}
	
	// CU11 - PLATO ESTRELLA
	
	public Plato platoEstrella(Festival festival) {
		Plato platoEstrella = null;
		int maxCantidad = 0;
		for(Plato plato : this.platos) {
			int cantidad = 0;
			
			for(Pedido p : this.pedidos) {
				if(p.getFestival().equals(festival)) { 
					for(ItemPedido item : p.getItems()) {
						if(item.getPlato().equals(plato)) {
							cantidad += item.getCantidad();
						}
					}
				}
			}
			if(cantidad > maxCantidad) {
				maxCantidad = cantidad;
				platoEstrella = plato;
			}
		}

		return platoEstrella;
	}

}
