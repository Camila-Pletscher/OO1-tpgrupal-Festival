package test;

import java.time.LocalDate;

import modelo.*;

public class Test {

	public static void main(String[] args) {

		try {

			System.out.println("======== CU1 ALTAS ========");

			Sistema s = new Sistema();

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

		}
		catch(Exception e) {

			System.out.println("ERROR:");
			System.out.println(e.getMessage());

		}

	}

}