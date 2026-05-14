package com.example;

/**
 * Clase que representa los palos que pegas (o que te pegan) en el juego.
 * Guarda el nombre, el daño, lo que cuesta tirarlo y si envenena o aturde.
 */
public class Ataque {
    
    // Atributos básicos del ataque
    private String nombre;
    private int dano;
    private int costeMana;
    private String efecto; 

    // Constructor: lo usamos para darle valores al ataque cuando lo creamos
    public Ataque(String nombre, int dano, int costeMana, String efecto) {
        this.nombre = nombre;
        this.dano = dano;
        this.costeMana = costeMana;
        this.efecto = efecto;
    }

    /**
     * Incrementa el daño base del ataque en un 15%.
     * Se utiliza como recompensa al subir de piso para que pegues más fuerte.
     */
    public void mejorarDano() {
        // Multiplica el daño por 1.15 y lo castea a int (sin decimales)
        this.dano = (int)(this.dano * 1.15);
    }

    // Getters: funciones que usa el Main para saber cuánto quitas o si envenenas
    public String getNombre() { return nombre; }
    public int getDano() { return dano; }
    public int getCosteMana() { return costeMana; }
    public String getEfecto() { return efecto; }
}