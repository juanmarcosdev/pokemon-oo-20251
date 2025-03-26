package model;

import model.Pokemon;

public class Entrenador {
    private String nombre;
    private int edad;
    private Pokemon pokemon;


    public Entrenador(String nombre, int edad, Pokemon pokemon) {
        this.nombre = nombre;
        this.edad = edad;
        this.pokemon = pokemon;
    }


    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    // Mostrar información del entrenador
    public void mostrarInfo() {
        System.out.println("Entrenador: " + nombre + ", Edad: " + edad);
        if (pokemon != null) {
            System.out.println("Posee el Pokémon: ");
            pokemon.mostrarInfo();
        }
    }
}
