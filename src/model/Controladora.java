package model;

import model.Entrenador;
import model.Pokemon;


public class Controladora {
    // Atributos de objeto del modelo
    private Entrenador[] entrenadores;

    public Controladora() {
        // Relacion con objeto del modelo
    }
	
	// Controladora: encargada de gestión de entidades del modelo
	// QUE se comunican con ella. Gestión: crear, modificar, eliminar.
	

	
	// Método empaquetador para crear objetos del modelo

    public Entrenador crearEntrenador(String nombre, int edad, Pokemon pokemon) {

		Entrenador entrenador = new Entrenador(nombre, edad, pokemon);
    	return entrenador;
    }

    public Pokemon crearPokemon(String nombre, String tipo, int salud, int valorAtaque) {

		Pokemon pokemon = new Pokemon(nombre, tipo, salud, valorAtaque);
    	return pokemon;
    }

    public void agregarEntrenador(Entrenador entrenador) {
        for (int i = 0; i < entrenadores.length; i++) {
            if (entrenadores[i] == null) {
                entrenadores[i] = entrenador;
                break;
            }
        }
    }
	



	

}