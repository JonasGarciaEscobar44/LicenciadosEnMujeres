import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== PELEA CALLEJERA V2: AHORA CON MAGIA, BIFRUTAS Y MOCHILA ===");
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
        // --- PLANTILLA DE HÉROES (Ahora con mochila: bifrutas, cafeles) ---
        Personaje[] heroes = {
            // Fonso es más tanque, lleva 2 curas y 1 maná
            new Personaje("Fonso", 120, 30, new Ataque[]{
                new Ataque("Guaya fina", 15, 0), 
                new Ataque("Abrir vscode cuando no toca", 35, 15) 
            }, 2, 1),
            // Chum chum es más mago, lleva 1 cura y 3 manás
            new Personaje("Chum chum", 85, 100, new Ataque[]{
                new Ataque("IA en local", 8, 0),
                new Ataque("Stalkear pibas en insta", 40, 30) 
            }, 1, 3)
        };

        // --- PLANTILLA DE ENEMIGOS (Con mochila vacía: 0, 0) ---
        Personaje[] enemigos = {
            new Personaje("khiqe", 100, 0, new Ataque[]{
                new Ataque("cigarro y cola", 12, 0),
                new Ataque("java krry", 20, 0)
            }, 0, 0),
            new Personaje("Pakito Ju", 60, 50, new Ataque[]{
                new Ataque("Manipular altavoz", 8, 0),
                new Ataque("Encendida de proyector", 25, 20)
            }, 0, 0)
        };

        // --- PANTALLA DE SELECCIÓN ---
        System.out.println("\n¿Con quién vas a repartir?");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println((i+1) + ". " + heroes[i].getNombre() + " (HP: " + heroes[i].getVida() + " | MP: " + heroes[i].getMana() + " | Bifrutas: " + heroes[i].getBifrutas() + " | Cafeles: " + heroes[i].getCafeles() + ")");
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
            // Aquí le he puesto que te avise de cuántos te quedan
            System.out.println("2. Tirar de bifru (+30 HP) [Quedan: " + miHeroe.getBifrutas() + "]");
            System.out.println("3. Meterse un cafele malo de aldi (+40 MP) [Quedan: " + miHeroe.getCafeles() + "]");
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

                if (miHeroe.gastarMana(ataqueElegido.getCosteMana())) {
                    int danoFinal = ataqueElegido.getDano();
                    
                    int probabilidadCritico = (int)(Math.random() * 10) + 1; 
                    if (probabilidadCritico == 1) { 
                        danoFinal = (int)(danoFinal * 1.5); 
                        System.out.println("¡BUM! ¡CRÍTICO! Le has metido un viaje guapo.");
                    }

                    System.out.println("Le tiras un " + ataqueElegido.getNombre() + " y le quitas " + danoFinal + " de vida al " + miEnemigo.getNombre() + ".");
                    miEnemigo.recibirDano(danoFinal);
                } else {
                    System.out.println("¡Estás tieso de maná! Pierdes el turno por tolai.");
                }

            } else if (accion.equals("2")) {
                // Comprobamos la mochila antes de curar
                if (miHeroe.usarBifruta()) {
                    System.out.println("Tiras de bifru y te curas 30 puntos de vida.");
                    miHeroe.curarVida(30);
                } else {
                    System.out.println("¡Rebuscas en la mochila y no te quedan bifrutas! Pierdes el turno por tolai.");
                }

            } else if (accion.equals("3")) {
                // Comprobamos la mochila antes de dar maná
                if (miHeroe.usarCafe()) {
                    System.out.println("Abres un cafele malo d aldi y recuperas 40 de maná.");
                    miHeroe.curarMana(40);
                } else {
                    System.out.println("¡Estás a cero de cafeles! Pierdes el turno por tolai.");
                }

            } else {
                System.out.println("Te has liado con los botones y pierdes el turno por tolai.");
            }
            
            // --- TURNO DEL MONSTRUO ---
            if (miEnemigo.estaVivo()) {
                Ataque[] ataquesEnemigo = miEnemigo.getAtaques();
                int ataqueRandom = (int)(Math.random() * ataquesEnemigo.length);
                Ataque ataqueDelMalo = ataquesEnemigo[ataqueRandom];

                if (miEnemigo.gastarMana(ataqueDelMalo.getCosteMana())) {
                    int danoFinalEnemigo = ataqueDelMalo.getDano();

                    int probabilidadCriticoEnemigo = (int)(Math.random() * 10) + 1; 
                    if (probabilidadCriticoEnemigo == 1) { 
                        danoFinalEnemigo = (int)(danoFinalEnemigo * 1.5); 
                        System.out.println("¡OJO! El " + miEnemigo.getNombre() + " se ha flipado. ¡GOLPE CRÍTICO!");
                    }

                    System.out.println("El " + miEnemigo.getNombre() + " contraataca con " + ataqueDelMalo.getNombre() + " y te sopla un palo de " + danoFinalEnemigo + " de vida.");
                    miHeroe.recibirDano(danoFinalEnemigo);
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