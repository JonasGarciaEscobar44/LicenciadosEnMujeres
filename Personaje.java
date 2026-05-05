public class Personaje {
    private String nombre;
    private int vida, vidaMaxima;
    private int mana, manaMaximo;
    private Ataque[] ataques; // Cada personaje tendrá sus propios ataques

    public Personaje(String nombre, int vidaMaxima, int manaMaximo, Ataque[] ataques) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.manaMaximo = manaMaximo;
        this.mana = manaMaximo;
        this.ataques = ataques;
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
            return true; // Pudo gastar el maná
        }
        return false; // No tiene maná suficiente
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getMana() { return mana; }
    public Ataque[] getAtaques() { return ataques; }
}