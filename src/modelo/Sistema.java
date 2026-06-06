package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Festival;

public class Sistema {

	//CONSTANTES DEL SISTEMA 
	public static final double SUELDO_BASE = 100000;
	public static final double COSTO_POR_M2 = 500;
	public static final double COSTO_POR_MONTAJE_POR_MIN = 10;
	public static final double PLUS_ELECTRICIDAD = 2000;
	public static final double PLUS_ANTIGUEDAD_POR_ANIO = 5000;
	
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
	
	//FESTIVAL
	public Festival agregarFestival (String nombre, String temporada,LocalDate fechaInicio,LocalDate fechaFin, List<Costo> costos) throws Exception
	{
		if(buscarFestival(nombre)!=null)
		{
			throw new Exception("El festival ya esta ingresado");
		}
		
		int id= lstFestivales.isEmpty()?1: lstFestivales.get(lstFestivales.size()-1).getId()+1;
		Festival nuevo = new Festival(id,nombre,temporada,fechaInicio,fechaFin, costos);
		lstFestivales.add(nuevo);
		return nuevo;
	}
	
	
	public boolean eliminarFestival(int id)
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

	    return eliminado;
	}
	
	
	
	public Festival buscarFestival(String nombre)
	{
		Festival f = null;
		int i=0;
		while(i<lstFestivales.size() && f==null)
	    {
			
			if(lstFestivales.get(i).getNombre().equals(nombre))
			{	
				f = lstFestivales.get(i);

			}
			i++;
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
	
	
	
	public boolean eliminarUnidadVenta(String codigo)
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
		return eliminado;
	}
	
	
	public UnidadVenta buscarUnidadPorCodigo(String codigo)
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
		return uv;
	}
	
	
	

	//EMPLEADO
	public Empleado agregarEmpleado(Empleado empleado)
	        throws Exception
	{
	    if(buscarEmpleadoPorDni(empleado.getDni()) != null)
	    {
	        throw new Exception("Empleado ya registrado");
	    }

	    lstEmpleados.add(empleado);

	    return empleado;
	}
	
	public boolean eliminarEmpleado(String dni)
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
		return eliminado;
	}
	
	
	public Empleado buscarEmpleadoPorDni(String dni)
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
		return e;
	}

	
	
	
	
	
	
	
	
	
	
	/*
	public void registrarPedido();
	
	Registro de Pedido Validado: 
	Método para agregar un pedido que invoque internamente al CU #2 
	para validar la existencia de la Unidad y el Festival.
	
	*/
	
	
	
	
	
	
	
	/*
	Reporte de Recaudación: Dado un festival, 
	retornar la lista de unidades y su recaudación total (usar clase ReporteVenta, no persistente). 
	
	public List<ReporteVenta> reporteRecaudacion(int festivalId)
	{
		List<ReporteVenta> reportesEncontrados = new ArrayList<ReporteVenta>();
		int i=0;
		while(i<lstFestivales.size())
		{
			if(lstFestivales.get(i).getId() == festivalId)
			{
				
			}
			i++;
		}
		
		return reportesEncontrados;
	}
	*/
	
	
	
	
	
	
	public List<Empleado> filtrarEmpleadosPorEdad(LocalDate desde,LocalDate hasta)
	{
		List<Empleado> empleadosEncontrados = new ArrayList<Empleado>();
		int i=0;
		while(i<lstEmpleados.size())
		{
			if(
				(!lstEmpleados.get(i).getFechaNacimiento().isAfter(desde))
				&& 
				(!lstEmpleados.get(i).getFechaNacimiento().isBefore(hasta))
				)
			{
				empleadosEncontrados.add(lstEmpleados.get(i));
			}
			i++;
		}
		return empleadosEncontrados;
	}
	
	
	public List<UnidadVenta> rankingUnidades(int festivalId)
	{
		List<UnidadVenta> lstRankingUnidades = new ArrayList<UnidadVenta>();
		int i=0;
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
	

	/*
	Auditoría de Personal del Festival:
	Método que retorne la lista de todo el personal que trabajó en un festival específico. 
	 
	public List<Empleado> auditoriaPersonal(int festivalId)
	{
		List<Empleado> empleadosEncontrados = new ArrayList<Empleado>();
		int i=0;
		 while(i < lstEmpleados.size())
		 {
			if()
			{
					// comparación
			}
			
			 i++;
		 }
		 return empleadosEncontrados;
	}
	/*
	 
	 
	
	/*Funciones pendientes
	+auditoriaPersonal(festivalId:int): List<Empleado>
	+top3UnidadesMayorCanon(festivalId:int): List<ReporteMayoresCanon
	*/
}
