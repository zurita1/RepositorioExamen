package examenEntornos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCCuenta {
	private static BufferedReader dato;

	public static void main(String[] args) {
		dato = new BufferedReader(new InputStreamReader(
				System.in));
		CCuenta cuenta;

		int opcion = 0;
		cuenta = new CCuenta("Rigoberta Piedra", "0000-6523-85-678912345",
				2500, 0);
		recogerOpcion(dato, cuenta, opcion);
		System.out.println("Saldo actual: " + cuenta.estado());
	}

	/**
	 * @param dato
	 * @param cuenta1
	 * @param opcion
	 */
	private static void recogerOpcion(BufferedReader dato, CCuenta cuenta1, int opcion) {
		do {
			try {
				mostrarMenu();
				opcion = Integer.parseInt(dato.readLine());

				switch (opcion) {
				case 1:
					System.out.println("Indica cantidad a ingresar: ");
					ingresar(dato, cuenta1);
					break;
				case 2:
					System.out.println("Indica cantidad a retirar: ");
					retirar(dato, cuenta1);
					break;
				case 3:
					System.out.println("Aaaaaaaaaadios");
				}
			} catch (IOException ex) {
				Logger.getLogger(TestCCuenta.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		} while (opcion != 3);
	}

	/**
	 * @param dato
	 * @param cuenta1
	 * @throws IOException
	 */
	private static void retirar(BufferedReader dato, CCuenta cuenta1) throws IOException {
		float retirar = Integer.parseInt(dato.readLine());
		try {
			cuenta1.retirar(retirar);
		} catch (Exception e) {
			System.out.print("Fallo al retirar");
		}
	}

	/**
	 * @param dato
	 * @param cuenta1
	 * @throws IOException
	 */
	private static void ingresar(BufferedReader dato, CCuenta cuenta1) throws IOException {
		float ingresar = Integer.parseInt(dato.readLine());
		try {
			System.out.println("Ingreso en cuenta");
			cuenta1.ingresando(ingresar);
		} catch (Exception e) {
			System.out.print("Fallo al ingresar");
		}
	}

	/**
	 * 
	 */
	private static void mostrarMenu() {
		System.out.println("MENU DE OPERACIONES");
		System.out.println("-------------------");
		System.out.println("1 - Ingresar");
		System.out.println("2 - Retirar");
		System.out.println("3 - Salir");
	}
}
