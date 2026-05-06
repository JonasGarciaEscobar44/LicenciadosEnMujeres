import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== PELEA CALLEJERA V2: AHORA CON MAGIA, BIFRUTAS Y ESTADOS ALTERADOS ===");
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
        // --- PLANTILLA DE HÉROES (Añadido el estado al final de cada ataque) ---
        Personaje[] heroes = {
            new Personaje("Fonso", 120, 30, new Ataque[]{
                new Ataque("Guaya fina", 15, 0, "Ninguno"), 
                new Ataque("Abrir vscode cuando no toca", 30, 15, "Aturdir")
            }, 2, 1),
            new Personaje("Chum chum", 85, 100, new Ataque[]{
                new Ataque("IA en local", 8, 0, "Ninguno"),
                new Ataque("Stalkear pibas en insta", 35, 30, "Aturdir")
            }, 1, 3)
        };

        // --- PLANTILLA DE ENEMIGOS ---
        Personaje[] enemigos = {
            new Personaje("khiqe", 100, 0, new Ataque[]{
                new Ataque("cigarro y cola", 12, 0, "Veneno"), // Envenena
                new Ataque("java krry", 20, 0, "Aturdir")
            }, 0, 0),
            new Personaje("Pakito Ju", 60, 50, new Ataque[]{
                new Ataque("Manipular altavoz", 8, 0, "Ninguno"),
                new Ataque("Encendida de proyector", 25, 20, "Aturdir") // Aturde
            }, 0, 0)
        };

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

            // --- APLICAR VENENO AL INICIO DEL TURNO ---
            if (miHeroe.tieneVeneno()) {
                System.out.println("Tabaco del malo, estas fuera por fumador pasivo, -7hp.");
                miHeroe.sufrirVeneno();
            }
            if (miEnemigo.tieneVeneno() && miEnemigo.estaVivo()) {
                System.out.println("El " + miEnemigo.getNombre() + " tose raro por el veneno y pierde 7 de vida.");
                miEnemigo.sufrirVeneno();
            }

            // Si alguien se muere por el veneno, cortamos el rollo
            if (!miHeroe.estaVivo() || !miEnemigo.estaVivo()) break;
            
            // --- TU TURNO ---
            if (miHeroe.isAturdido()) {
                System.out.println("Te has quedao cuajao. Pierdes el turno.");
                miHeroe.setAturdido(false); // Te curas el aturdimiento para el siguiente
            } else {
                System.out.println("¿Qué vas a hacer?");
                System.out.println("1. Tirar una guaya (Atacar)");
                System.out.println("2. Tirar de bifru (+30 HP) [Quedan: " + miHeroe.getBifrutas() + "]");
                System.out.println("3. Meterse un cafele malo de aldi (+40 MP) [Quedan: " + miHeroe.getCafeles() + "]");
                System.out.print("Elige rápido: ");
                
                String accion = sc.nextLine();
                System.out.println(""); 
                
                if (accion.equals("1")) {
                    System.out.println("Elige cómo le vas a dar:");
                    Ataque[] misAtaques = miHeroe.getAtaques();
                    for (int i = 0; i < misAtaques.length; i++) {
                        System.out.println((i+1) + ". " + misAtaques[i].getNombre() + " (Daño: " + misAtaques[i].getDano() + " | MP: " + misAtaques[i].getCosteMana() + " | Efecto: " + misAtaques[i].getEfecto() + ")");
                    }
                    int numAtaque = Integer.parseInt(sc.nextLine()) - 1;
                    Ataque ataqueElegido = misAtaques[numAtaque];

                    if (miHeroe.gastarMana(ataqueElegido.getCosteMana())) {
                        // --- PROBABILIDAD DE ESQUIVAR ENEMIGO (8%) ---
                        int probabilidadEsquivar = (int)(Math.random() * 100) + 1;
                        if (probabilidadEsquivar <= 8) {
                            System.out.println("¡Hostia! El " + miEnemigo.getNombre() + " te ha hecho la cobra y esquiva el ataque entero.");
                        } else {
                            int danoFinal = ataqueElegido.getDano();
                            int probabilidadCritico = (int)(Math.random() * 10) + 1; 
                            if (probabilidadCritico == 1) { 
                                danoFinal = (int)(danoFinal * 1.5); 
                                System.out.println("Criticazo, folladon gordo.");
                            }

                            System.out.println("Le tiras un " + ataqueElegido.getNombre() + " y le quitas " + danoFinal + " de vida al " + miEnemigo.getNombre() + ".");
                            miEnemigo.recibirDano(danoFinal);

                            // --- APLICAR ESTADO ALTERADO ---
                            if (ataqueElegido.getEfecto().equals("Veneno")) {
                                System.out.println("¡Le has dejado fino! Envenenado por 2 turnos.");
                                miEnemigo.aplicarVeneno(2);
                            } else if (ataqueElegido.getEfecto().equals("Aturdir")) {
                                System.out.println("¡Le has dejado pajarito! Pierde su próximo turno.");
                                miEnemigo.setAturdido(true);
                            }
                        }
                    } else {
                        System.out.println("¡Estás tieso de maná! Pierdes el turno por tolai.");
                    }

                } else if (accion.equals("2")) {
                    if (miHeroe.usarBifruta()) {
                        System.out.println("Tiras de bifru y te curas 30 puntos de vida.");
                        miHeroe.curarVida(30);
                    } else {
                        System.out.println("¡Rebuscas en la mochila y no te quedan bifrutas! Pierdes el turno por tolai.");
                    }
                } else if (accion.equals("3")) {
                    if (miHeroe.usarCafe()) {
                        System.out.println("Abres un cafele malo d aldi y recuperas 40 de maná.");
                        miHeroe.curarMana(40);
                    } else {
                        System.out.println("¡Estás a cero de cafeles! Pierdes el turno por tolai.");
                    }
                } else {
                    System.out.println("Te has liado con los botones y pierdes el turno por tolai.");
                }
            }
            
            // --- TURNO DEL MONSTRUO ---
            if (miEnemigo.estaVivo()) {
                if (miEnemigo.isAturdido()) {
                    System.out.println("El " + miEnemigo.getNombre() + " está viendo las estrellas y pierde el turno.");
                    miEnemigo.setAturdido(false);
                } else {
                    Ataque[] ataquesEnemigo = miEnemigo.getAtaques();
                    int ataqueRandom = (int)(Math.random() * ataquesEnemigo.length);
                    Ataque ataqueDelMalo = ataquesEnemigo[ataqueRandom];

                    if (miEnemigo.gastarMana(ataqueDelMalo.getCosteMana())) {
                        // --- PROBABILIDAD DE ESQUIVAR TUYA (10%) ---
                        int probabilidadEsquivar = (int)(Math.random() * 100) + 1;
                        if (probabilidadEsquivar <= 10) {
                            System.out.println("Te has fumao el ataque de " + miEnemigo.getNombre() + " cual curso de webinars.");
                        } else {
                            int danoFinalEnemigo = ataqueDelMalo.getDano();
                            int probabilidadCriticoEnemigo = (int)(Math.random() * 10) + 1; 
                            if (probabilidadCriticoEnemigo == 1) { 
                                danoFinalEnemigo = (int)(danoFinalEnemigo * 1.5); 
                                System.out.println("El " + miEnemigo.getNombre() + " se ha venido arriba. Palo gordo");
                            }

                            System.out.println("El " + miEnemigo.getNombre() + " contraataca con " + ataqueDelMalo.getNombre() + " y te sopla un palo de " + danoFinalEnemigo + " de vida.");
                            miHeroe.recibirDano(danoFinalEnemigo);

                            // --- APLICAR ESTADO ALTERADO ENEMIGO ---
                            if (ataqueDelMalo.getEfecto().equals("Veneno")) {
                                System.out.println("Fumador pasivo. Estás envenenado por 2 turnos.");
                                miHeroe.aplicarVeneno(2);
                            } else if (ataqueDelMalo.getEfecto().equals("Aturdir")) {
                                System.out.println("¡Te ha pegado una buena hostia! Cuajada en tu próximo turno.");
                                miHeroe.setAturdido(true);
                            }
                        }
                    } else {
                        System.out.println("El " + miEnemigo.getNombre() + " intenta hacer algo raro pero está sin maná. Se queda mirando al proyector.");
                    }
                }
            }
        }
        
        // --- FIN DE LA PARTIDA ---
        System.out.println("\n=== SE ACABÓ EL TEMA ===");
        if (miHeroe.estaVivo()) {
            System.out.println("¡Has ganado! Eres dios, vaya culo.");
        } else {
            System.out.println("Bujarrada y ridiculo historico, te ha palmado el personaje.");
        }
    }
}