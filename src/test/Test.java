package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.*;

public class Test {

	public static void main(String[] args) {
		Sistema s = new Sistema();
		

		try {

			System.out.println("======== CU1 ALTAS ========");

			
			s.agregarCocinero(
					"Juan",
					"Perez",
					"12345678",
					LocalDate.of(1990, 5, 10),
					LocalDate.of(2020, 1, 1),
					"Parrilla",
					25000);

			s.agregarCajero(
					"Maria",
					"Gomez",
					"87654321",
					LocalDate.of(1995, 3, 15),
					LocalDate.of(2021, 1, 1),
					Turno.MANIANA);

			System.out.println("Cantidad empleados esperada: 2");
			System.out.println("Cantidad empleados obtenida: "
					+ s.getLstEmpleados().size());

			Empleado responsable =
					s.buscarEmpleadoPorDni("12345678");

			s.agregarFoodTruck(
					"Truck Burger",
					responsable,
					20,
					"ABC1234567",
					"AA123BB",
					true);

			s.agregarPuestoDesarmable(
					"Puesto Pizza",
					responsable,
					20,
					"XYZ1234567",
					2,
					30);

			System.out.println("Cantidad unidades esperada: 2");
			System.out.println("Cantidad unidades obtenida: "
					+ s.getLstUnidadVenta().size());



			System.out.println("\n======== CU2 BUSQUEDAS ========");

			Empleado e =
					s.buscarEmpleadoPorDni("12345678");

			if(e != null) {
				System.out.println("Empleado encontrado OK");
				System.out.println(e);
			}else {
				System.out.println("ERROR empleado no encontrado");
			}


			UnidadVenta uv =
					s.buscarUnidadPorCodigo("ABC1234567");

			if(uv != null) {
				System.out.println("Unidad encontrada OK");
				System.out.println(uv);
			}else {
				System.out.println("ERROR unidad no encontrada");
			}



			System.out.println("\n======== CU3 CALCULO CANON ========");

			UnidadVenta ft =
					s.buscarUnidadPorCodigo("ABC1234567");

			System.out.println("FoodTruck");
			System.out.println("Canon esperado: 12000");
			System.out.println("Canon obtenido: "
					+ ft.calcularCanon());


			UnidadVenta puesto =
					s.buscarUnidadPorCodigo("XYZ1234567");

			System.out.println("\nPuesto Desarmable");
			System.out.println("Canon esperado: 9700");
			System.out.println("Canon obtenido: "
					+ puesto.calcularCanon());



			System.out.println("\n======== CU4 LIQUIDACION HABERES ========");

			Empleado cocinero =
					s.buscarEmpleadoPorDni("12345678");

			System.out.println("Cocinero");
			System.out.println("Sueldo esperado: 125000");
			System.out.println("Sueldo obtenido: "
					+ cocinero.calcularSueldo());


			Empleado cajero =
					s.buscarEmpleadoPorDni("87654321");

			System.out.println("\nCajero");

			int antiguedad =
					cajero.calcularAntiguedad();

			double sueldoEsperado =
					Constantes.SUELDO_BASE
					+
					(antiguedad *
					 Constantes.PLUS_ANTIGUEDAD_POR_ANIO);

			System.out.println("Antiguedad: "
					+ antiguedad);

			System.out.println("Sueldo esperado: "
					+ sueldoEsperado);

			System.out.println("Sueldo obtenido: "
					+ cajero.calcularSueldo());
			
			System.out.println("\n======== CU6 REPORTE RECAUDACION ========");

			// FESTIVAL
			Festival festival = s.agregarFestival(
			        "Festival Gourmet",
			        "Verano",
			        LocalDate.of(2026, 1, 10),
			        LocalDate.of(2026, 1, 15));

			// PLATOS
			Plato hamburguesa =
			        new Plato(
			                1,
			                "Hamburguesa",
			                1000,
			                400);

			Plato papas =
			        new Plato(
			                2,
			                "Papas Fritas",
			                500,
			                150);

			// ITEMS
			ItemPedido item1 =
			        new ItemPedido(
			                2,
			                hamburguesa);

			ItemPedido item2 =
			        new ItemPedido(
			                3,
			                papas);

			List<ItemPedido> items =
			        new ArrayList<ItemPedido>();

			items.add(item1);
			items.add(item2);
		

			// PROBAMOS CALCULO DE RECAUDACION
			System.out.println("\nRecaudacion esperada: 3500");
			System.out.println("Recaudacion obtenida: "
			        + ft.calcularRecaudacion(festival));

			// REPORTE
			List<ReporteVenta> reporte =
			        s.reporteRecaudacion(festival);

			System.out.println("\nCantidad reportes esperada: 1");
			System.out.println("Cantidad reportes obtenida: "
			        + reporte.size());

			for(ReporteVenta r : reporte)
			{
			    System.out.println(
			            r.getUnidad().getNombreComercial()
			            + " -> "
			            + r.getTotalRecaudado());
			}
			System.out.println("\n======== CU5 AGREGAR PEDIDO ========");
			// PEDIDO : SE CREA Y AGREGA A FOODTRUCK || COMENTAR PARA PROBAR EXCEPTION
			s.agregarPedido(LocalDate.of(2026, 2, 11), "ABC1234567", festival, items); // ESTE TIRA EXCEPTION
			s.agregarPedido(LocalDate.of(2026, 2, 11), "ABC1234567", festival, items); // ESTE AGREGA BIEN
			
			

		}
		catch(Exception e) {

			System.out.println("ERROR:");
			System.out.println(e.getMessage());

		}
		
		try {
			System.out.println("\n======== CU12 AUDITORIA PERSONAL DEL FESTIVAL ========");

			// Crear festival
			Festival festival = new Festival(
			        1,
			        "Festival Gourmet",
			        "Verano",
			        LocalDate.of(2025, 1, 10),
			        LocalDate.of(2025, 1, 15)
			);

			// Recuperar empleados ya creados
			Empleado cocinero = s.buscarEmpleadoPorDni("12345678");
			Empleado cajero = s.buscarEmpleadoPorDni("87654321");

			// Recuperar unidades ya creadas
			UnidadVenta foodTruck = s.buscarUnidadPorCodigo("ABC1234567");
			UnidadVenta puesto = s.buscarUnidadPorCodigo("XYZ1234567");

			// Agregar empleados a las unidades
			foodTruck.getPersonal().add(cocinero);
			foodTruck.getPersonal().add(cajero);

			// El cocinero trabaja también en el puesto
			puesto.getPersonal().add(cocinero);

			// Asociar unidades al festival
			festival.getUnidades().add(foodTruck);
			festival.getUnidades().add(puesto);

			// Ejecutar CU12
			List<Empleado> auditoria = s.auditoriaPersonal(festival);

			System.out.println("Cantidad esperada: 2");
			System.out.println("Cantidad obtenida: " + auditoria.size());

			System.out.println("\nEmpleados encontrados:");

			for(Empleado e : auditoria)
			{
			    System.out.println(e);
			}
		} catch(Exception e) {

			System.out.println("ERROR:");
			System.out.println(e.getMessage());

		} 

	}

}