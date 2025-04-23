package model;

import model.Pokemon;
import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private int edad;
    private List<Pokemon> pokemones;

    public Entrenador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.pokemones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void agregarPokemon(Pokemon pokemon) {
        if (pokemon != null) {
            pokemones.add(pokemon);
        }
    }

    public void removerPokemon(Pokemon pokemon) {
        pokemones.remove(pokemon);
    }

    // Mostrar información del entrenador
    public void mostrarInfo() {
        System.out.println("Entrenador: " + nombre + ", Edad: " + edad);
        if (pokemones.isEmpty()) {
            System.out.println("No posee ningún Pokémon.");
        } else {
            System.out.println("Posee los siguientes Pokémon:");
            for (Pokemon p : pokemones) {
                p.mostrarInfo();
            }
        }
    }
}