package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

	// Atributos de la clase Ejecutable
	private Scanner reader;
	private Controladora cont;
	private static boolean flag;

	private Executable() {
		reader = new Scanner(System.in);
		cont = new Controladora();
	}
	
	

	public void run(boolean flag)
	{

		flag = false;

		while (!flag) {

			System.out.println("\n \n Bienvenido al menu:\n");
			System.out.println("Opciones:\n" + "1. Opcion 1 \n" + "2. Opcion 2 \n"
					+ "3. Opcion 3 \n" + "4. Opcion 4 \n" + "5. Opcion 5 \n" + "6. Salir del programa \n");

			int option = reader.nextInt();

			reader.nextLine();

			switch (option) {
					case 1:
						opcionUno();
						break;
					case 2:
						opcionDos();
						break;
					case 3:
						opcionTres();
						break;
					case 4:
						opcionCuatro();
						break;
					case 5:
						opcionCinco();
						break;
					case 6:
						flag = true;
						System.exit(0);
						break;
					default:
						System.out.print("Por favor ingrese una opcion valida");
						continue;
			}

		}

	}

	public static void main(String[] args) {
		Executable mainApp = new Executable();
		mainApp.run(flag);
	}
	
	public void opcionUno() {

    }

    public void opcionDos() {

    }

    public void opcionTres() {

    }

    public void opcionCuatro() {

    }

    public void opcionCinco() {

    }


	
	



	

	
}