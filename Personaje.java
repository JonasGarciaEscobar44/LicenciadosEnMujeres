/**
 * Clase principal para los combatientes (Héroes y Enemigos).
 * Gestiona estadísticas como vida, maná y estados alterados.
 */
public class Personaje {
    /**
     * Aplica daño al personaje y comprueba que la vida no baje de cero.
     * @param cantidad Puntos de vida a restar.
     */
    private String nombre;
    private int vida, vidaMaxima;
    private int mana, manaMaximo;
    private Ataque[] ataques;
    
    private int bifrutas;
    private int cafeles;

    private int turnosVeneno;
    private boolean aturdido;

    public Personaje(String nombre, int vidaMaxima, int manaMaximo, Ataque[] ataques, int bifrutas, int cafeles) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.manaMaximo = manaMaximo;
        this.mana = manaMaximo;
        this.ataques = ataques;
        this.bifrutas = bifrutas;
        this.cafeles = cafeles;
        this.turnosVeneno = 0;
        this.aturdido = false;
    }

    public boolean estaVivo() { return vida > 0; }

    public void recibirDano(int cantidad) {
        vida -= cantidad;
        if (vida < 0) vida = 0;
    }

    public void curarVida(int cantidad) {
        vida += cantidad;
        if (vida > vidaMaxima) vida = vidaMaxima;
    }

    public void curarMana(int cantidad) {
        mana += cantidad;
        if (mana > manaMaximo) mana = manaMaximo;
    }

    public boolean gastarMana(int cantidad) {
        if (mana >= cantidad) {
            mana -= cantidad;
            return true; 
        }
        return false; 
    }

    public boolean usarBifruta() {
        if (bifrutas > 0) {
            bifrutas--;
            return true;
        }
        return false;
    }

    public boolean usarCafe() {
        if (cafeles > 0) {
            cafeles--;
            return true;
        }
        return false;
    }

    // --- NUEVO: LOOTEO AL GANAR Y RESETEO DE ESTADOS ---
    public void anadirBotin() {
        bifrutas++;
        cafeles++;
    }
    /**
     * Limpia los efectos negativos (veneno y aturdimiento).
     * Se llama al finalizar cada combate.
     */
    public void resetearEstados() {
        turnosVeneno = 0;
        aturdido = false;
    }

    public void aplicarVeneno(int turnos) { this.turnosVeneno += turnos; }
    public boolean tieneVeneno() { return turnosVeneno > 0; }
    public void sufrirVeneno() {
        if (turnosVeneno > 0) {
            recibirDano(5);
            turnosVeneno--;
        }
    }
    public void setAturdido(boolean estado) { this.aturdido = estado; }
    public boolean isAturdido() { return aturdido; }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getMana() { return mana; }
    public Ataque[] getAtaques() { return ataques; }
    public int getBifrutas() { return bifrutas; }
    public int getCafeles() { return cafeles; }
}