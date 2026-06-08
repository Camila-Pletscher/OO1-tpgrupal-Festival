package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Sistema {
	
	List<Festival> lstFestivales;
	List<Empleado> lstEmpleados;
	List<UnidadVenta> lstUnidadVenta;
	
	
	public Sistema() {
		super();
		this.lstFestivales = new ArrayList<Festival>();
		this.lstEmpleados = new ArrayList<Empleado>();
		this.lstUnidadVenta = new ArrayList<UnidadVenta>();
	}


	public List<Festival> getLstFestivales() {
		return lstFestivales;
	}

	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}

	public List<UnidadVenta> getLstUnidadVenta() {
		return lstUnidadVenta;
	}
	
	public Festival agregarFestival (String nombre, String temporada,LocalDate fechaInicio,LocalDate fechaFin, List<Costo> costos) throws Exception
	{
		if(buscarFestival(nombre)!=null)
		{
			throw new Exception("El festival ya esta ingresado");
		}
		
		int id= lstFestivales.isEmpty()?1: lstFestivales.get(lstFestivales.size()-1).getId()+1;
		Festival nuevo = new Festival(id,nombre,temporada,fechaInicio,fechaFin);
		lstFestivales.add(nuevo);
		return nuevo;
	}
	
	
	public boolean eliminarFestival(int id) throws Exception
	{
	    boolean eliminado = false;

	    int i = 0;

	    while(i < lstFestivales.size() && !eliminado)
	    {
	        if(lstFestivales.get(i).getId() == id)
	        {
	            lstFestivales.remove(i);
	            eliminado = true;
	        }

	        i++;
	    }

	    if(eliminado==false)
	    {
	    	throw new Exception("El festival a eliminar no se encontró");
	    }
	    return eliminado;
	}
	
	
	
	public Festival buscarFestival(String nombre) throws Exception
	{
		Festival f = null;
		int i=0;
		while(i<lstFestivales.size() && f==null)
	    {
			
			if(lstFestivales.get(i).getNombre().equalsIgnoreCase(nombre))
			{	
				f = lstFestivales.get(i);
			}
			i++;
	    }
		
		if(f==null)
		{
			throw new Exception("El festival ingresado no existe");
		}
		return f;
	}

	
	
	//UNIDAD
	public boolean agregarFoodTruck(String nombreComercial,	Empleado responsable, double superficie,String codigo,String patente,boolean requiereElectricidad) throws Exception {

		boolean agregado = false;

		if(buscarUnidadPorCodigo(codigo) != null) {
			throw new Exception("Ya existe una unidad con ese código");
		}

		int id;

		if(lstUnidadVenta.isEmpty()) {
			id = 1;
		}else {
			id = lstUnidadVenta.get(lstUnidadVenta.size()-1).getId() + 1;
		}

		FoodTruck nuevo = new FoodTruck(id,nombreComercial,responsable,	superficie,	codigo,	patente,requiereElectricidad);

		agregado = lstUnidadVenta.add(nuevo);

		return agregado;
	}
	
	public boolean agregarPuestoDesarmable(	String nombreComercial,	Empleado responsable,double superficie,	String codigo,int cantidadCarpas,	int tiempoMontaje) throws Exception {

		boolean agregado = false;

		if(buscarUnidadPorCodigo(codigo) != null) {
			throw new Exception("Ya existe una unidad con ese código");
		}

		int id;

		if(lstUnidadVenta.isEmpty()) {
			id = 1;
		}else {
			id = lstUnidadVenta.get(lstUnidadVenta.size()-1).getId() + 1;
		}

		PuestoDesarmable nuevo = new PuestoDesarmable(id,nombreComercial,responsable,superficie,codigo,	cantidadCarpas,	tiempoMontaje);

		agregado = lstUnidadVenta.add(nuevo);

		return agregado;
	}
	
	
	
	public boolean eliminarUnidadVenta(String codigo) throws Exception
	{
		boolean eliminado=false;
		int i=0;
		while(i<lstUnidadVenta.size() && eliminado==false)
	    {
			  if(lstUnidadVenta.get(i).getCodigo().equals(codigo))
			  {
			      lstUnidadVenta.remove(i);
			      eliminado = true;
			  }
			  i++;    
		}
		
		if(eliminado==false)
		{
			throw new Exception("La Unidad-Venta ingresada no existe");
		}
		return eliminado;
	}
	
	
	public UnidadVenta buscarUnidadPorCodigo(String codigo) throws Exception
	{
		UnidadVenta uv = null;
		int i=0;
		while(i<lstUnidadVenta.size() && uv==null)
	    {
			
			if(lstUnidadVenta.get(i).getCodigo().equals(codigo))
			{
				uv = lstUnidadVenta.get(i);
			}
			i++;
	    }
		
		
		if(uv==null)
		{
			throw new Exception("La Unidad-Venta buscada no existe");
		}
		return uv;
	}
	
	
	

	//EMPLEADO
	public boolean agregarCajero(String nombre,	String apellido,String dni,	LocalDate fechaNacimiento,LocalDate fechaIngreso,Turno turno) throws Exception {

		boolean agregado = false;

		if(buscarEmpleadoPorDni(dni) != null) {
			throw new Exception("El empleado ya existe");
		}

		int id;

		if(lstEmpleados.isEmpty()) {
			id = 1;
		}else {
			id = lstEmpleados.get(lstEmpleados.size()-1).getId() + 1;
		}

		Cajero nuevo = new Cajero(id,nombre,apellido,dni,fechaNacimiento,fechaIngreso,turno);

		agregado = lstEmpleados.add(nuevo);

		return agregado;
	}
	
	public boolean agregarCocinero(	String nombre,String apellido,String dni,LocalDate fechaNacimiento,	LocalDate fechaIngreso,	String especialidad,double plusCategoria) throws Exception {

		boolean agregado = false;

		if(buscarEmpleadoPorDni(dni) != null) {
			throw new Exception("El empleado ya existe");
		}
		

		int id;

		if(lstEmpleados.isEmpty()) {
			id = 1;
		}else {
			id = lstEmpleados.get(lstEmpleados.size()-1).getId() + 1;
		}

		Cocinero nuevo = new Cocinero(id,nombre,apellido,dni,fechaNacimiento,fechaIngreso,especialidad,	plusCategoria);
		agregado = lstEmpleados.add(nuevo);

		return agregado;
	}
	
	public boolean eliminarEmpleado(String dni) throws Exception
	{
		boolean eliminado=false;
		int i=0;
		while(i<lstEmpleados.size() && eliminado==false)
	    {
			  if(lstEmpleados.get(i).getDni().equals(dni))
			  {
			      lstEmpleados.remove(i);
			      eliminado = true;
			  }
			  i++;     
		}
		if(eliminado==false)
		{
			throw new Exception("El empleado a eliminar no existe");
		}
		return eliminado;
	}
	
	
	public Empleado buscarEmpleadoPorDni(String dni) throws Exception
	{
		Empleado e = null;
		int i=0;
		while(i<lstEmpleados.size() && e==null)
	    {
			
			if(lstEmpleados.get(i).getDni().equals(dni))
			{
				e = lstEmpleados.get(i);
			}
			i++;	
	    }
		
		if(e==null)
		{
			throw new Exception("El empleado buscado no existe");
		}
		
		return e;
	}

	
	// CASO DE USO N°5: Registro de pedido validado:  Método para agregar un pedido que invoque 
	// internamente al CU #2 para validar la existencia de la Unidad y el Festival. 
	public boolean agregarPedido(LocalDate fecha, String codigoUnidad,String nombreFestival, List<ItemPedido> items) throws Exception{
		Festival festival = buscarFestival(nombreFestival);
		UnidadVenta unidad = buscarUnidadPorCodigo(codigoUnidad);
		if(festival == null || unidad == null) {
			throw new Exception("Error: unidadVenta o festival no encontrado.");
		}
		int id;
		if(unidad.getPedidos().isEmpty()) {
			id = 1;
		}else {
			id = unidad.getPedidos().get(unidad.getPedidos().size()-1).getId()+1;
		}
		return unidad.getPedidos().add(new Pedido(id,fecha, festival, items));
	}
	

	
	
	
	// CASO DE USO N°6: Reporte de Recaudación
	// Dado un festival, retornar la lista de unidades y su recaudación total 
	// (usar clase ReporteVenta, no persistente)
	public List<ReporteVenta> reporteRecaudacion(int festivalId)
	{
	    List<ReporteVenta> reporte = new ArrayList<>();

		// Acá tendría que usarse  if(buscarFestival(nombre)!=null) {} 
	    
	    for(UnidadVenta unidad : lstUnidadVenta)
	    {
	        double recaudacion =
	                unidad.calcularRecaudacion(festivalId);

	        if(recaudacion > 0)
	        {
	            reporte.add(
	                new ReporteVenta(
	                    unidad,
	                    recaudacion));
	        }
	    }

	    return reporte;
	}
	

	
	
	// CASO DE USO N°7: Filtro de Personal por Edad
	//  Retornar una lista de empleados nacidos entre dos fechas
	public List<Empleado> filtrarEmpleadosPorEdad(LocalDate desde,LocalDate hasta)
	{
		List<Empleado> empleadosEncontrados = new ArrayList<Empleado>();
		int i=0;
		while(i<lstEmpleados.size())
		{
			if(
				(!lstEmpleados.get(i).getFechaNacimiento().isBefore(desde))
				&& 
				(!lstEmpleados.get(i).getFechaNacimiento().isAfter(hasta))
				)
			{
				empleadosEncontrados.add(lstEmpleados.get(i));
			}
			i++;
		}
		return empleadosEncontrados;
	}
	
	
	public List<UnidadVenta> rankingUnidades(int festivalId) throws Exception
	{
		List<UnidadVenta> lstRankingUnidades = new ArrayList<UnidadVenta>();
		int i=0;
		
		// Acá tendría que usarse  if(buscarFestival(nombre)!=null) {} 
			while(i < lstUnidadVenta.size())
			 {
				 int j= i+1;
				 while(j < lstUnidadVenta.size())
				 {
					 if(lstRankingUnidades.get(i).calcularRecaudacion(festivalId) 
						 < 
						lstRankingUnidades.get(j).calcularRecaudacion(festivalId))
					 {
						 UnidadVenta aux = lstRankingUnidades.get(i);
			             lstRankingUnidades.set(i, lstRankingUnidades.get(j));
			             lstRankingUnidades.set(j, aux);
					 } 
					 j++;	 
				 }
			     i++;
			 }
		
		return lstRankingUnidades;
	}
	

	//CASO DE USO N°12: Auditoría de Personal del Festival:
	//Método que retorne la lista de todo el personal que trabajó en un festival específico. 
	 
	public List<Empleado> auditoriaPersonal(String nombre) throws Exception 
	{
		Festival f = buscarFestival(nombre);
		return f.getEmpleados();
	}

	
	
}
