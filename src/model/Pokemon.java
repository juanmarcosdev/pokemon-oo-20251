package model;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int salud;
    private int valorAtaque;

    public Pokemon(String nombre, String tipo, int salud, int valorAtaque) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salud = salud;
        this.valorAtaque = valorAtaque;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getSalud() {
        return salud;
    }

    public int getValorAtaque() {
        return valorAtaque;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setValorAtaque(int valorAtaque) {
        this.valorAtaque = valorAtaque;
    }

    // Recibe daño
    public void recibirDanio(int cantidad) {
        this.salud -= cantidad;
        if (this.salud < 0) {
            this.salud = 0;
        }
    }

    // Curar salud
    public void curar(int cantidad) {
        this.salud += cantidad;
    }

    // Método para mostrar info
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Tipo: " + tipo + ", Salud: " + salud + ", Ataque: " + valorAtaque);
    }

    // Método de ataque
    public int atacar() {
        System.out.println(nombre + " esta atacando con un poder de " + valorAtaque);
        return valorAtaque;
    }
}