public class Personaje {
    private String nombre;
    private int vida, vidaMaxima;
    private int mana, manaMaximo;
    private Ataque[] ataques;
    
    // --- NUEVO: MOCHILA ---
    private int bifrutas;
    private int cafeles;

    public Personaje(String nombre, int vidaMaxima, int manaMaximo, Ataque[] ataques, int bifrutas, int cafeles) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.manaMaximo = manaMaximo;
        this.mana = manaMaximo;
        this.ataques = ataques;
        this.bifrutas = bifrutas;
        this.cafeles = cafeles;
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

    // --- NUEVO: FUNCIONES DE MOCHILA ---
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

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getMana() { return mana; }
    public Ataque[] getAtaques() { return ataques; }
    public int getBifrutas() { return bifrutas; }
    public int getCafeles() { return cafeles; }
}