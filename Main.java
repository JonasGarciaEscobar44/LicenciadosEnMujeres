import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== PELEA CALLEJERA V2: AHORA CON MAGIA Y BIFRUTAS ===");
        System.out.println("1. Inflarse a palos");
        System.out.println("2. Cagarse");
        System.out.print("Elige: ");
        
        String opcion = sc.nextLine();
        
        if (opcion.equals("1")) {
            empezarPelea(sc);
        } else {
            System.out.println("Malillo cagon, te has perdido la diversion. Chao pescao.");
        }
        
        sc.close();
    }
    
    public static void empezarPelea(Scanner sc) {
        // --- PLANTILLA DE HÉROES ---
        Personaje[] heroes = {
            new Personaje("Fonso", 120, 30, new Ataque[]{
                new Ataque("Guaya fina", 15, 0), // No gasta maná
                new Ataque("Abrir vscode cuando no toca", 35, 15) // Gasta maná
            }),
            new Personaje("Chum chum", 85, 100, new Ataque[]{
                new Ataque("IA en local", 8, 0),
                new Ataque("Stalkear pibas en insta", 40, 30) 
            })
        };

        // --- PLANTILLA DE ENEMIGOS ---
        Personaje[] enemigos = {
            new Personaje("khiqe", 100, 0, new Ataque[]{
                new Ataque("cigarro y cola", 12, 0),
                new Ataque("java krry", 20, 0)
            }),
            new Personaje("Pakito Ju", 60, 50, new Ataque[]{
                new Ataque("Manipular altavoz", 8, 0),
                new Ataque("Encendida de proyector", 25, 20)
            })
        };

        // --- PANTALLA DE SELECCIÓN ---
        System.out.println("\n¿Con quién vas a repartir?");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println((i+1) + ". " + heroes[i].getNombre() + " (HP: " + heroes[i].getVida() + " | MP: " + heroes[i].getMana() + ")");
        }
        int elecHeroe = Integer.parseInt(sc.nextLine()) - 1;
        Personaje miHeroe = heroes[elecHeroe];

        System.out.println("\n¿A quién le quieres meter fuerte?");
        for (int i = 0; i < enemigos.length; i++) {
            System.out.println((i+1) + ". " + enemigos[i].getNombre());
        }
        int elecEnemigo = Integer.parseInt(sc.nextLine()) - 1;
        Personaje miEnemigo = enemigos[elecEnemigo];

        System.out.println("\n¡Un " + miEnemigo.getNombre() + " salvaje se china contigo por vscode!");
        
        // --- EL BUCLE DE LAS TORTAS ---
        while (miHeroe.estaVivo() && miEnemigo.estaVivo()) {
            System.out.println("\n--- MARCADOR ---");
            System.out.println("Tú (" + miHeroe.getNombre() + "): " + miHeroe.getVida() + " HP | " + miHeroe.getMana() + " MP");
            System.out.println("Enemigo (" + miEnemigo.getNombre() + "): " + miEnemigo.getVida() + " HP | " + miEnemigo.getMana() + " MP");
            System.out.println("----------------");
            
            System.out.println("¿Qué vas a hacer?");
            System.out.println("1. Tirar una guaya (Atacar)");
            System.out.println("2. Tirar de bifru (+30 HP)");
            System.out.println("3. Meterse un cafele malo de aldi (+40 MP)");
            System.out.print("Elige rápido: ");
            
            String accion = sc.nextLine();
            System.out.println(""); 
            
            // --- TU TURNO ---
            if (accion.equals("1")) {
                System.out.println("Elige cómo le vas a dar:");
                Ataque[] misAtaques = miHeroe.getAtaques();
                for (int i = 0; i < misAtaques.length; i++) {
                    System.out.println((i+1) + ". " + misAtaques[i].getNombre() + " (Daño: " + misAtaques[i].getDano() + " | Gasta MP: " + misAtaques[i].getCosteMana() + ")");
                }
                int numAtaque = Integer.parseInt(sc.nextLine()) - 1;
                Ataque ataqueElegido = misAtaques[numAtaque];

                // Comprobamos si tiene maná para el ataque
                if (miHeroe.gastarMana(ataqueElegido.getCosteMana())) {
                    System.out.println("Le tiras un " + ataqueElegido.getNombre() + " y le quitas " + ataqueElegido.getDano() + " de vida al " + miEnemigo.getNombre() + ".");
                    miEnemigo.recibirDano(ataqueElegido.getDano());
                } else {
                    System.out.println("¡Estás tieso de maná! Pierdes el turno por tolai.");
                }

            } else if (accion.equals("2")) {
                System.out.println("Tiras de bifru y te curas 30 puntos de vida.");
                miHeroe.curarVida(30);
            } else if (accion.equals("3")) {
                System.out.println("Abres un cafele malo d aldi y recuperas 40 de maná.");
                miHeroe.curarMana(40);
            } else {
                System.out.println("Te has liado con los botones y pierdes el turno por tolai.");
            }
            
            // --- TURNO DEL MONSTRUO ---
            if (miEnemigo.estaVivo()) {
                // Elige un ataque suyo al azar
                Ataque[] ataquesEnemigo = miEnemigo.getAtaques();
                int ataqueRandom = (int)(Math.random() * ataquesEnemigo.length);
                Ataque ataqueDelMalo = ataquesEnemigo[ataqueRandom];

                // Comprueba si el enemigo tiene maná
                if (miEnemigo.gastarMana(ataqueDelMalo.getCosteMana())) {
                    System.out.println("El " + miEnemigo.getNombre() + " contraataca con " + ataqueDelMalo.getNombre() + " y te sopla un palo de " + ataqueDelMalo.getDano() + " de vida.");
                    miHeroe.recibirDano(ataqueDelMalo.getDano());
                } else {
                    System.out.println("El " + miEnemigo.getNombre() + " intenta hacer algo raro pero está sin maná. Se queda mirando al aire.");
                }
            }
        }
        
        // --- FIN DE LA PARTIDA ---
        System.out.println("\n=== SE ACABÓ EL TEMA ===");
        if (miHeroe.estaVivo()) {
            System.out.println("¡Has ganado! Eres dios, vaya culo.");
        } else {
            System.out.println("Bujarrada y ridiculo historico, te ha ganado un anciano.");
        }
    }
}