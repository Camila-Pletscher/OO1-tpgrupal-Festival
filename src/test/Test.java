package test;

import java.time.LocalDate;

import modelo.*;

public class Test {

	public static void main(String[] args) {
		Sistema s = new Sistema();

		try {

			System.out.println("\n========== CU1 ALTAS ==========");

			s.agregarCocinero("Juan", "Perez", "12345678", LocalDate.of(1990, 5, 10), LocalDate.of(2020, 1, 1),
					"Parrilla", 25000);

			s.agregarCajero("Maria", "Gomez", "87654321", LocalDate.of(1995, 3, 15), LocalDate.of(2021, 1, 1),
					Turno.MANIANA);

			System.out.println(s.getLstEmpleados());

			System.out.println("Cantidad empleados esperada: 2");

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

		System.out.println("\n========== CU2 NO ENCONTRADO ==========");

		Empleado e = s.buscarEmpleadoPorDni("00000000");

		if (e == null) {

			System.out.println("Empleado inexistente OK");

		}

	}

}