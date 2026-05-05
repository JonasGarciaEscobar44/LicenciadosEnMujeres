public class Ataque {
    private String nombre;
    private int dano;
    private int costeMana;

    public Ataque(String nombre, int dano, int costeMana) {
        this.nombre = nombre;
        this.dano = dano;
        this.costeMana = costeMana;
    }

    public String getNombre() { return nombre; }
    public int getDano() { return dano; }
    public int getCosteMana() { return costeMana; }
}