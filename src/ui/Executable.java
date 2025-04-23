package ui;

import java.util.List;
import java.util.Scanner;
import model.Controladora;
import model.Entrenador;
import model.Pokemon;

public class Executable {
    private Scanner reader;
    private Controladora cont;
    private boolean flag;

    public Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
        flag = false;
    }

    public void run() {
        while (!flag) {
            System.out.println("\n=== Menú Pokemon ===");
            System.out.println("1. Crear entrenador");
            System.out.println("2. Listar entrenadores");
            System.out.println("3. Crear Pokemon y asignar a entrenador");
            System.out.println("4. Listar Pokemons de un entrenador");
            System.out.println("5. Poner a luchar dos Pokemons");
            System.out.println("6. Salir");
            System.out.print("Seleccione una Opcion: ");
            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1: crearEntrenador(); break;
                case 2: listarEntrenadores(); break;
                case 3: crearPokemonYAsignar(); break;
                case 4: listarPokemonesEntrenador(); break;
                case 5: lucharPokemons(); break;
                case 6: flag = true; System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion inválida.");
            }
        }
    }

    private void crearEntrenador() {
        System.out.print("Nombre del entrenador: ");
        String nombre = reader.nextLine();
        System.out.print("Edad: ");
        int edad = reader.nextInt();
        reader.nextLine();
        Entrenador e = cont.crearEntrenador(nombre, edad);
        cont.agregarEntrenador(e);
        System.out.println("Entrenador creado: " + e.getNombre());
    }

    private void listarEntrenadores() {
        String info = cont.mostrarTodosEntrenadores();
        System.out.println(info);
    }

    private void crearPokemonYAsignar() {
        System.out.print("Nombre del Pokemon: ");
        String nombre = reader.nextLine();
        System.out.print("Tipo: ");
        String tipo = reader.nextLine();
        System.out.print("Salud inicial: ");
        int salud = reader.nextInt();
        System.out.print("Valor de ataque: ");
        int ataque = reader.nextInt();
        reader.nextLine();

        List<Entrenador> entrenadores = cont.listarEntrenadores();
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores disponibles.");
            return;
        }
        System.out.println("Seleccione Indice de entrenador:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println(i + ". " + entrenadores.get(i).getNombre());
        }
        int idx = reader.nextInt();
        reader.nextLine();
        if (idx < 0 || idx >= entrenadores.size()) {
            System.out.println("Indice invalido.");
            return;
        }
        Pokemon p = cont.crearPokemon(nombre, tipo, salud, ataque);
        cont.agregarPokemon(entrenadores.get(idx), p);
        System.out.println("Pokemon " + p.getNombre() + " asignado a " + entrenadores.get(idx).getNombre());
    }

    private void listarPokemonesEntrenador() {
        List<Entrenador> entrenadores = cont.listarEntrenadores();
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        System.out.println("Seleccione Indice de entrenador:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println(i + ". " + entrenadores.get(i).getNombre());
        }
        int idx = reader.nextInt();
        reader.nextLine();
        if (idx < 0 || idx >= entrenadores.size()) {
            System.out.println("Indice invalido.");
            return;
        }
        String info = cont.mostrarPokemonesDeEntrenador(entrenadores.get(idx));
        System.out.println(info);
    }

    private void lucharPokemons() {
        List<Entrenador> entrenadores = cont.listarEntrenadores();
        if (entrenadores.size() < 2) {
            System.out.println("Se necesitan al menos 2 entrenadores.");
            return;
        }
        // Selección primer Pokemon
        System.out.println("Selecciona el primer entrenador que va a pelear:");
        Entrenador e1 = seleccionarEntrenador();
        if (e1 == null) return;
        Pokemon p1 = seleccionarPokemon(e1);
        if (p1 == null) return;
        // Selección segundo Pokemon
        System.out.println("Selecciona el segundo entrenador:");
        Entrenador e2 = seleccionarEntrenador();
        if (e2 == null) return;
        Pokemon p2 = seleccionarPokemon(e2);
        if (p2 == null) return;

        // Simulación de la lucha
        System.out.println("Comienza la batalla entre " + p1.getNombre() + " y " + p2.getNombre() + "!");
        while (p1.getSalud() > 0 && p2.getSalud() > 0) {
            int dano1 = p1.atacar();
            p2.recibirDanio(dano1);
            System.out.println(p2.getNombre() + " tiene " + p2.getSalud() + " salud.");
            if (p2.getSalud() <= 0) break;

            int dano2 = p2.atacar();
            p1.recibirDanio(dano2);
            System.out.println(p1.getNombre() + " tiene " + p1.getSalud() + " salud.");
        }
        String ganador = p1.getSalud() > 0 ? p1.getNombre() : p2.getNombre();
        System.out.println("La batalla ha terminado. Ganador: " + ganador);
    }

    private Entrenador seleccionarEntrenador() {
        List<Entrenador> entrenadores = cont.listarEntrenadores();
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println(i + ". " + entrenadores.get(i).getNombre());
        }
        int idx = reader.nextInt();
        reader.nextLine();
        if (idx < 0 || idx >= entrenadores.size()) {
            System.out.println("Indice invalido.");
            return null;
        }
        return entrenadores.get(idx);
    }

    private Pokemon seleccionarPokemon(Entrenador e) {
        List<Pokemon> pokes = cont.listarPokemones(e);
        if (pokes.isEmpty()) {
            System.out.println("Este entrenador no tiene Pokemons.");
            return null;
        }
        System.out.println("Selecciona un Pokemon de " + e.getNombre() + ":");
        for (int i = 0; i < pokes.size(); i++) {
            System.out.println(i + ". " + pokes.get(i).getNombre());
        }
        int idx = reader.nextInt();
        reader.nextLine();
        if (idx < 0 || idx >= pokes.size()) {
            System.out.println("Indice invalido.");
            return null;
        }
        return pokes.get(idx);
    }

    public static void main(String[] args) {
        new Executable().run();
    }
}
