public class Ataque {
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

    public String getNombre() { return nombre; }
    public int getDano() { return dano; }
    public int getCosteMana() { return costeMana; }
    public String getEfecto() { return efecto; }
}