package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.*;

public class Test {

	public static void main(String[] args) {
		Sistema s = new Sistema();

		// ARMADO DEL SISTEMA
		try {

			// ====================================================
			// EMPLEADOS - CU 1
			// ====================================================

			s.agregarCocinero("Juan", "Perez", "12345678", LocalDate.of(1990, 5, 10), LocalDate.of(2020, 1, 1),
					"Parrilla", 25000);

			s.agregarCajero("Maria", "Gomez", "87654321", LocalDate.of(1995, 3, 15), LocalDate.of(2021, 1, 1),
					Turno.MANIANA);

			s.agregarCajero("Pedro", "Lopez", "33333333", LocalDate.of(1992, 8, 20), LocalDate.of(2022, 1, 1),
					Turno.NOCHE);

			// ====================================================
			// RECUPERO EMPLEADOS
			// ====================================================

			Empleado juan = s.buscarEmpleadoPorDni("12345678");
			Empleado maria = s.buscarEmpleadoPorDni("87654321");
			Empleado pedro = s.buscarEmpleadoPorDni("33333333");

			// ====================================================
			// UNIDADES DE VENTA - CU 1
			// ====================================================

			s.agregarFoodTruck("Truck Burger", juan, 20, "ABC1234567", "AA123BB", true);

			s.agregarPuestoDesarmable("Puesto Pizza", pedro, 20, "XYZ1234567", 2, 30);

			s.agregarFoodTruck("Truck Tacos", maria, 30, "DEF1234567", "BB123CC", false);

			s.agregarPuestoDesarmable("Puesto Helados", juan, 25, "HIJ1234567", 4, 20);

			// ====================================================
			// RECUPERO UNIDADES
			// ====================================================

			FoodTruck foodtruck = (FoodTruck) s.buscarUnidadPorCodigo("ABC1234567");

			PuestoDesarmable puesto = (PuestoDesarmable) s.buscarUnidadPorCodigo("XYZ1234567");

			FoodTruck truckTacos = (FoodTruck) s.buscarUnidadPorCodigo("DEF1234567");

			PuestoDesarmable puestoHelados = (PuestoDesarmable) s.buscarUnidadPorCodigo("HIJ1234567");

			// ====================================================
			// PERSONAL DE CADA UNIDAD
			// ====================================================

			foodtruck.getPersonal().add(juan);
			foodtruck.getPersonal().add(maria);

			puesto.getPersonal().add(pedro);

			truckTacos.getPersonal().add(maria);

			puestoHelados.getPersonal().add(juan);

			// ====================================================
			// PLATOS
			// ====================================================

			Plato hamburguesa = new Plato(1, "Hamburguesa", 15000, 7000);

			Plato papas = new Plato(2, "Papas Fritas", 8000, 3000);

			Plato pizza = new Plato(3, "Pizza", 12000, 5000);

			Plato tacos = new Plato(4, "Tacos", 10000, 4000);

			Plato nachos = new Plato(5, "Nachos", 7000, 2500);

			// ====================================================
			// AGREGAR PLATOS A LAS UNIDADES
			// ====================================================

			foodtruck.getPlatos().add(hamburguesa);
			foodtruck.getPlatos().add(papas);

			puesto.getPlatos().add(pizza);

			truckTacos.getPlatos().add(tacos);
			truckTacos.getPlatos().add(nachos);

			// ====================================================
			// FESTIVAL - CU 1
			// ====================================================

			Festival festival = s.agregarFestival("Lollapalooza", "Verano", LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23));

			Festival festivalRock = s.agregarFestival("Cosquin Rock", "Invierno", LocalDate.of(2025, 7, 10),
					LocalDate.of(2025, 7, 12));

			// ====================================================
			// UNIDADES DEL FESTIVAL
			// ====================================================

			festival.getUnidades().add(foodtruck);
			festival.getUnidades().add(puesto);

			festivalRock.getUnidades().add(foodtruck);
			festivalRock.getUnidades().add(truckTacos);

			// ====================================================
			// PEDIDOS
			// ====================================================

			// ITEMS
			ItemPedido item1 = new ItemPedido(2, hamburguesa);

			ItemPedido item2 = new ItemPedido(3, papas);

			List<ItemPedido> items = new ArrayList<ItemPedido>();

			items.add(item1);
			items.add(item2);

			// PEDIDO
			s.agregarPedido(LocalDate.of(2025, 3, 22), "ABC1234567", "Lollapalooza", LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23), items);

			List<ItemPedido> items2 = new ArrayList<ItemPedido>();

			items2.add(new ItemPedido(4, hamburguesa));
			items2.add(new ItemPedido(2, papas));

			s.agregarPedido(LocalDate.of(2025, 3, 23), "ABC1234567", "Lollapalooza", LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23), items2);

			List<ItemPedido> items3 = new ArrayList<ItemPedido>();

			items3.add(new ItemPedido(5, pizza));

			s.agregarPedido(LocalDate.of(2025, 3, 21), "XYZ1234567", "Lollapalooza", LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23), items3);

			List<ItemPedido> items4 = new ArrayList<ItemPedido>();

			items4.add(new ItemPedido(8, pizza));

			s.agregarPedido(LocalDate.of(2025, 3, 22), "XYZ1234567", "Lollapalooza", LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23), items4);

			List<ItemPedido> items5 = new ArrayList<ItemPedido>();

			items5.add(new ItemPedido(6, tacos));
			items5.add(new ItemPedido(3, nachos));

			s.agregarPedido(LocalDate.of(2025, 7, 10), "DEF1234567", "Cosquin Rock", LocalDate.of(2025, 7, 10),
					LocalDate.of(2025, 7, 12), items5);

			List<ItemPedido> items6 = new ArrayList<ItemPedido>();

			items6.add(new ItemPedido(10, tacos));

			s.agregarPedido(LocalDate.of(2025, 7, 11), "DEF1234567", "Cosquin Rock", LocalDate.of(2025, 7, 10),
					LocalDate.of(2025, 7, 12), items6);

			Plato helado = new Plato(6, "Helado", 5000, 1500);

			Plato brownie = new Plato(7, "Brownie", 4000, 1000);

			puestoHelados.getPlatos().add(helado);
			puestoHelados.getPlatos().add(brownie);

			List<ItemPedido> items7 = new ArrayList<ItemPedido>();

			items7.add(new ItemPedido(12, helado));
			items7.add(new ItemPedido(5, brownie));

			s.agregarPedido(LocalDate.of(2025, 3, 22), "HIJ1234567", "Lollapalooza", LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23), items7);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n========== CU1 ERROR EMPLEADO REPETIDO ==========");

			s.agregarCocinero("Pedro", "Lopez", "12345678", LocalDate.of(1980, 1, 1), LocalDate.of(2020, 1, 1),
					"Pastas", 10000);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n========== CU1 ERROR MENOR DE EDAD ==========");

			s.agregarCajero("Luis", "Diaz", "99999999", LocalDate.now().minusYears(15), LocalDate.now(), Turno.NOCHE);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n========== CU2 BUSQUEDAS ==========");

			Empleado e = s.buscarEmpleadoPorDni("12345678");

			System.out.println("Empleado encontrado: ");
			System.out.println(e);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		// NO TIENE EXCEPTION
		System.out.println("\n========== CU2 NO ENCONTRADO ==========");

		Empleado emp = s.buscarEmpleadoPorDni("00000000");

		if (emp == null) {

			System.out.println("Empleado inexistente");

		}
		;

		try {

			System.out.println("\n========== CU3 CANON ==========");

			UnidadVenta ft = s.buscarUnidadPorCodigo("ABC1234567");

			System.out.println("Calculo de canon de: " + ft);
			System.out.println(ft.calcularCanon());

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU4 SUELDO =====");

			Empleado e = s.buscarEmpleadoPorDni("12345678");

			System.out.println("Calculo de sueldo de:" + e);
			System.out.println(e.calcularSueldo());

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU5 ERROR FECHA =====");

			List<ItemPedido> items = new ArrayList<ItemPedido>();

			s.agregarPedido(LocalDate.of(2025, 5, 10), "ABC1234567", "Lollapalooza", LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23), items);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU6 RECAUDACION =====");

			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			List<ReporteVenta> lista = s.reporteRecaudacion(festival);

			for (ReporteVenta r : lista) {
				System.out.println(r);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU7 FILTRO =====");

			List<Empleado> lista = s.filtrarEmpleadosPorEdad(LocalDate.of(1980, 1, 1), LocalDate.of(1993, 1, 1));

			for (Empleado e : lista) {
				System.out.println(e);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU8 RENTABILIDAD =====");

			FoodTruck foodtruck = (FoodTruck) s.buscarUnidadPorCodigo("ABC1234567");

			System.out.println(foodtruck.calcularRentabilidadNeta());

			System.out.println("\n===== CU9 RENTABILIDAD ENTRE FECHAS =====");

			System.out.println(foodtruck.calcularRentabilidadNetaEntreFechas(LocalDate.of(2025, 3, 21),
					LocalDate.of(2025, 3, 23)));

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU10 RANKING =====");

			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			List<UnidadVenta> ranking = s.rankingUnidades(festival);

			for (UnidadVenta u : ranking) {
				System.out.println(u.getNombreComercial());
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU11 PLATO ESTRELLA =====");

			FoodTruck foodtruck = (FoodTruck) s.buscarUnidadPorCodigo("ABC1234567");
			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			System.out.println(foodtruck.platoEstrella(festival));

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU12 AUDITORIA =====");

			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			List<Empleado> lista = s.auditoriaPersonal(festival);

			for (Empleado e : lista) {
				System.out.println(e);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		try {

			System.out.println("\n===== CU13 TOP 3 =====");

			Festival festival = s.buscarFestival("Lollapalooza", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 3, 23));

			List<ReporteMayoresCanon> lista = s.top3UnidadesMayorCanon(festival);

			for (ReporteMayoresCanon r : lista) {
				System.out.println(r);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

}