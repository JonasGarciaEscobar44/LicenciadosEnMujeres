package com.example;

/**
 * Clase principal para los combatientes (Héroes y Enemigos).
 * Gestiona estadísticas como vida, maná, inventario y estados alterados.
 */
public class Personaje {
    
    // Atributos básicos del personaje
    private String nombre;
    private int vida, vidaMaxima;
    private int mana, manaMaximo;
    private Ataque[] ataques;
    
    // Inventario para curarse
    private int bifrutas;
    private int cafeles;

    // Estados alterados (lo que te jode por turno)
    private int turnosVeneno;
    private boolean aturdido;

    // Constructor para montar al personaje cuando lo instanciamos
    public Personaje(String nombre, int vidaMaxima, int manaMaximo, Ataque[] ataques, int bifrutas, int cafeles) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima; // Empiezas con la vida a tope
        this.manaMaximo = manaMaximo;
        this.mana = manaMaximo; // Empiezas con el maná a tope
        this.ataques = ataques;
        this.bifrutas = bifrutas;
        this.cafeles = cafeles;
        this.turnosVeneno = 0;
        this.aturdido = false;
    }

    // Chivato para saber si el bicho sigue en pie
    public boolean estaVivo() { 
        return vida > 0; 
    }

    /**
     * Aplica daño al personaje y comprueba que la vida no baje de cero.
     * @param cantidad Puntos de vida a restar por la hostia recibida.
     */
    public void recibirDano(int cantidad) {
        vida -= cantidad;
        if (vida < 0) vida = 0; // Para no tener vida negativa, que queda feo
    }

    /** 
     * Te cura vida sin pasarse de tu tope máximo.
     * @param cantidad Puntos de vida a sumar.
     */
    public void curarVida(int cantidad) {
        vida += cantidad;
        if (vida > vidaMaxima) vida = vidaMaxima;
    }

    /** 
     * Te recupera maná sin pasarse del tope.
     * @param cantidad Puntos de maná a sumar.
     */
    public void curarMana(int cantidad) {
        mana += cantidad;
        if (mana > manaMaximo) mana = manaMaximo;
    }

    /** 
     * Comprueba si tienes maná suficiente para el ataque y te lo resta.
     * @param cantidad Maná que cuesta la habilidad.
     * @return true si tenías maná y se gastó, false si estás seco.
     */
    public boolean gastarMana(int cantidad) {
        if (mana >= cantidad) {
            mana -= cantidad;
            return true; 
        }
        return false; 
    }

    /** 
     * Te bebes un bifrutas si te quedan en la mochila.
     * @return true si te lo tomas, false si no te quedan.
     */
    public boolean usarBifruta() {
        if (bifrutas > 0) {
            bifrutas--;
            return true;
        }
        return false;
    }

    /** 
     * Te tomas un café si te quedan.
     * @return true si te lo tomas, false si no hay.
     */
    public boolean usarCafe() {
        if (cafeles > 0) {
            cafeles--;
            return true;
        }
        return false;
    }

    // --- LOOTEO AL GANAR Y RESETEO DE ESTADOS ---
    
    /**
     * Te da un ítem de cada cuando te pasas un piso.
     */
    public void anadirBotin() {
        bifrutas++;
        cafeles++;
    }

    /**
     * Limpia los efectos negativos (veneno y aturdimiento).
     * Se llama al finalizar cada combate para empezar el siguiente fresquito.
     */
    public void resetearEstados() {
        turnosVeneno = 0;
        aturdido = false;
    }

    // --- GESTIÓN DE ESTADOS ALTERADOS (Veneno y Aturdir) ---

    // Este es el método que nos faltaba para que cuadre con el Main.
    // Le metemos 3 turnos de veneno por defecto si le entra el estado.
    public void setVeneno(boolean estado) {
        if (estado) {
            this.turnosVeneno = 3; 
        } else {
            this.turnosVeneno = 0;
        }
    }

    public void aplicarVeneno(int turnos) { this.turnosVeneno += turnos; }
    
    public boolean tieneVeneno() { return turnosVeneno > 0; }
    
    // Esto es lo que te quita vida al principio de cada turno si estás intoxicado
    public void sufrirVeneno() {
        if (turnosVeneno > 0) {
            System.out.println("¡" + nombre + " sufre 5 de daño por veneno!");
            recibirDano(5);
            turnosVeneno--;
        }
    }

    public void setAturdido(boolean estado) { this.aturdido = estado; }
    public boolean isAturdido() { return aturdido; }

    // --- GETTERS (Para pillar la info desde otras clases) ---
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getMana() { return mana; }
    public Ataque[] getAtaques() { return ataques; }
    public int getBifrutas() { return bifrutas; }
    public int getCafeles() { return cafeles; }
}