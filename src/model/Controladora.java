package model;

import java.util.ArrayList;
import java.util.List;

public class Controladora {
    // Lista dinámica de entrenadores
    private List<Entrenador> entrenadores;

    public Controladora() {
        this.entrenadores = new ArrayList<>();
    }

    /**
     * Crea un nuevo entrenador sin pokemones inicialmente.
     */
    public Entrenador crearEntrenador(String nombre, int edad) {
        return new Entrenador(nombre, edad);
    }

    /**
     * Crea un nuevo Pokemon.
     */
    public Pokemon crearPokemon(String nombre, String tipo, int salud, int valorAtaque) {
        return new Pokemon(nombre, tipo, salud, valorAtaque);
    }

    /**
     * Agrega un entrenador a la lista.
     */
    public void agregarEntrenador(Entrenador entrenador) {
        if (entrenador != null) {
            entrenadores.add(entrenador);
        }
    }

    /**
     * Agrega un pokemon a un entrenador.
     */
    public void agregarPokemon(Entrenador entrenador, Pokemon pokemon) {
        if (entrenador != null && pokemon != null) {
            entrenador.agregarPokemon(pokemon);
        }
    }

    /**
     * Devuelve la lista de entrenadores registrados.
     */
    public List<Entrenador> listarEntrenadores() {
        return new ArrayList<>(entrenadores);
    }

    /**
     * Devuelve la lista de pokemones de un entrenador dado.
     */
    public List<Pokemon> listarPokemones(Entrenador entrenador) {
        if (entrenador != null) {
            return new ArrayList<>(entrenador.getPokemones());
        }
        return new ArrayList<>();
    }

    /**
     * Retorna un String con la información de todos los entrenadores y sus pokemones,
     * sin usar StringBuilder ni Streams.
     */
    public String mostrarTodosEntrenadores() {
        if (entrenadores.isEmpty()) {
            return "No hay entrenadores registrados.";
        }
        String resultado = "";
        for (int i = 0; i < entrenadores.size(); i++) {
            Entrenador e = entrenadores.get(i);
            resultado += "Entrenador: " + e.getNombre() + ", Edad: " + e.getEdad() + "\n";
            List<Pokemon> pokes = e.getPokemones();
            if (pokes.isEmpty()) {
                resultado += "  No posee ningun Pokemon.\n";
            } else {
                resultado += "  Pokemones:" + "\n";
                for (int j = 0; j < pokes.size(); j++) {
                    Pokemon p = pokes.get(j);
                    resultado += "    - " + p.getNombre() + " (" + p.getTipo() + ", Salud: " + p.getSalud() + ", Ataque: " + p.getValorAtaque() + ")" + "\n";
                }
            }
        }
        return resultado.trim();
    }

    /**
     * Retorna un String con los pokemones de un entrenador específico,
     * sin usar StringBuilder ni Streams.
     */
    public String mostrarPokemonesDeEntrenador(Entrenador entrenador) {
        if (entrenador == null) {
            return "Entrenador no encontrado.";
        }
        List<Pokemon> pokes = entrenador.getPokemones();
        String resultado = "Pokemones de " + entrenador.getNombre() + ":\n";
        if (pokes.isEmpty()) {
            resultado += "  Ninguno.";
        } else {
            for (int i = 0; i < pokes.size(); i++) {
                Pokemon p = pokes.get(i);
                resultado += "  - " + p.getNombre() + " (" + p.getTipo() + ", Salud: " + p.getSalud() + ", Ataque: " + p.getValorAtaque() + ")" + "\n";
            }
            resultado = resultado.trim();
        }
        return resultado;
    }
}