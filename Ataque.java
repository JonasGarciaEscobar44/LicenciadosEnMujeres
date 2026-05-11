/**
 * Clase que representa un ataque dentro del juego.
 * Contiene el daño, coste de maná y efectos secundarios.
 */
public class Ataque {
    /**
     * Incrementa el daño base del ataque en un 15%.
     * Se utiliza como recompensa al subir de piso.
     */
    private String nombre;
    private int dano;
    private int costeMana;
    private String efecto; 

    public Ataque(String nombre, int dano, int costeMana, String efecto) {
        this.nombre = nombre;
        this.dano = dano;
        this.costeMana = costeMana;
        this.efecto = efecto;
    }

    // --- NUEVO: FUNCION PARA CHETAR EL DAÑO ---
    public void mejorarDano() {
        // Le suma un 15% al daño base que tenga en ese momento
        this.dano = (int)(this.dano * 1.15);
    }

    public String getNombre() { return nombre; }
    public int getDano() { return dano; }
    public int getCosteMana() { return costeMana; }
    public String getEfecto() { return efecto; }
}