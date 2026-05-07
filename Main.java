import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== PELEA CALLEJERA V3.1: LA MAZMORRA CON LOS CLÁSICOS ===");
        System.out.println("1. Entrar a la mazmorra (10 pisos)");
        System.out.println("2. Cagarse y volver a casa");
        System.out.print("Elige: ");
        
        String opcion = sc.nextLine();
        
        if (opcion.equals("1")) {
            empezarPelea(sc);
        } else {
            System.out.println("Malillo cagon, hueles peste.");
        }
        
        sc.close();
    }

    // --- NUEVO: 10 ENEMIGOS FIJOS PERO ALEATORIOS Y ESCALABLES ---
    public static Personaje obtenerEnemigoFijo(int piso) {
        int random = (int)(Math.random() * 10); // Del 0 al 9
        
        switch(random) {
            case 0:
                return new Personaje("khiqe (Piso " + piso + ")", 100 + (piso * 15), 0, new Ataque[]{
                    new Ataque("cigarro y cola", 12 + (piso * 2), 0, "Veneno"),
                    new Ataque("java krry", 20 + (piso * 3), 0, "Ninguno")
                }, 0, 0);
            case 1:
                return new Personaje("Pakito Ju (Piso " + piso + ")", 60 + (piso * 15), 50 + (piso * 10), new Ataque[]{
                    new Ataque("Manipular altavoz", 8 + (piso * 2), 0, "Ninguno"),
                    new Ataque("Encendida de proyector", 25 + (piso * 3), 20, "Aturdir")
                }, 0, 0);
            case 2:
                return new Personaje("El notas de Sistemas (Piso " + piso + ")", 80 + (piso * 15), 40 + (piso * 10), new Ataque[]{
                    new Ataque("Cable de red al cuello", 15 + (piso * 2), 10, "Aturdir"),
                    new Ataque("Reiniciar router", 20 + (piso * 3), 0, "Ninguno")
                }, 0, 0);
            case 3:
                return new Personaje("La de RRHH (Piso " + piso + ")", 90 + (piso * 15), 60 + (piso * 10), new Ataque[]{
                    new Ataque("Dinámica de grupo absurda", 10 + (piso * 2), 15, "Veneno"),
                    new Ataque("Sonrisa falsa", 18 + (piso * 3), 0, "Ninguno")
                }, 0, 0);
            case 4:
                return new Personaje("El pesao de Crypto (Piso " + piso + ")", 70 + (piso * 15), 80 + (piso * 10), new Ataque[]{
                    new Ataque("Explicar qué es un NFT", 12 + (piso * 2), 20, "Aturdir"),
                    new Ataque("Invertir en shitcoins", 22 + (piso * 3), 0, "Veneno")
                }, 0, 0);
            case 5:
                return new Personaje("El repetidor de 4to (Piso " + piso + ")", 110 + (piso * 15), 20 + (piso * 10), new Ataque[]{
                    new Ataque("Pedir apuntes un día antes", 14 + (piso * 2), 0, "Ninguno"),
                    new Ataque("Contagiar pereza", 18 + (piso * 3), 15, "Aturdir")
                }, 0, 0);
            case 6:
                return new Personaje("El profe de BBDD (Piso " + piso + ")", 85 + (piso * 15), 70 + (piso * 10), new Ataque[]{
                    new Ataque("Select * From Hostia", 25 + (piso * 3), 25, "Ninguno"),
                    new Ataque("Suspender por una coma", 15 + (piso * 2), 10, "Veneno")
                }, 0, 0);
            case 7:
                return new Personaje("El chaval del GYM (Piso " + piso + ")", 130 + (piso * 15), 10 + (piso * 10), new Ataque[]{
                    new Ataque("Batido de protes caducao", 16 + (piso * 2), 0, "Veneno"),
                    new Ataque("Curl de biceps en tu cara", 24 + (piso * 3), 0, "Ninguno")
                }, 0, 0);
            case 8:
                return new Personaje("El gamer tóxico (Piso " + piso + ")", 75 + (piso * 15), 90 + (piso * 10), new Ataque[]{
                    new Ataque("Insultos por micro", 12 + (piso * 2), 0, "Veneno"),
                    new Ataque("Rage quit", 28 + (piso * 3), 30, "Aturdir")
                }, 0, 0);
            case 9:
            default:
                return new Personaje("El fantasma de LinkedIn (Piso " + piso + ")", 95 + (piso * 15), 50 + (piso * 10), new Ataque[]{
                    new Ataque("Post motivacional de humo", 10 + (piso * 2), 20, "Aturdir"),
                    new Ataque("Networking agresivo", 20 + (piso * 3), 0, "Ninguno")
                }, 0, 0);
        }
    }
    
    public static void empezarPelea(Scanner sc) {
        // --- PLANTILLA DE HÉROES ---
        Personaje[] heroes = {
            new Personaje("Fonso", 150, 50, new Ataque[]{
                new Ataque("Cadereo sensual", 15, 0, "Ninguno"), 
                new Ataque("Abrir vscode cuando no toca", 30, 15, "Aturdir") 
            }, 2, 1),
            new Personaje("Chum chum", 120, 120, new Ataque[]{
                new Ataque("IA en local", 12, 0, "Ninguno"),
                new Ataque("Stalkear pibas en insta", 35, 30, "Aturdir") 
            }, 1, 3)
        };

        System.out.println("\n¿Con quién vas a bajar a la mazmorra?");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println((i+1) + ". " + heroes[i].getNombre() + " (HP: " + heroes[i].getVida() + " | MP: " + heroes[i].getMana() + " | Bifrutas: " + heroes[i].getBifrutas() + " | Cafeles: " + heroes[i].getCafeles() + ")");
        }
        int elecHeroe = Integer.parseInt(sc.nextLine()) - 1;
        Personaje miHeroe = heroes[elecHeroe];

        // --- SISTEMA DE PISOS (LA MAZMORRA) ---
        for (int piso = 1; piso <= 10; piso++) {
            Personaje miEnemigo;

            if (piso == 10) {
                // JEFE FINAL
                System.out.println("\n==============================================");
                System.out.println("⚠️ ¡CUIDAO! HAS LLEGADO AL PISO 10: EL JEFE FINAL ⚠️");
                System.out.println("==============================================");
                miEnemigo = new Personaje("EL DIRECTOR BUJARRILLA", 400, 200, new Ataque[]{
                    new Ataque("Se pira pq le sale del nabo", 25, 0, "Ninguno"),
                    new Ataque("Excursion de javi (es roña)", 40, 30, "Veneno"),
                    new Ataque("Arrastrada por las 5 estrellas en trustpilot", 35, 10, "Aturdir")
                }, 0, 0);
            } else {
                System.out.println("\n--- ENTRANDO AL PISO " + piso + " ---");
                // Ahora tira de los fijos de toda la vida
                miEnemigo = obtenerEnemigoFijo(piso);
                System.out.println("¡Te ha saltado un " + miEnemigo.getNombre() + " salvaje!");
            }
            
            // --- EL BUCLE DE LAS TORTAS ---
            while (miHeroe.estaVivo() && miEnemigo.estaVivo()) {
                System.out.println("\n--- MARCADOR ---");
                System.out.println("Tú (" + miHeroe.getNombre() + "): " + miHeroe.getVida() + " HP | " + miHeroe.getMana() + " MP");
                System.out.println("Enemigo (" + miEnemigo.getNombre() + "): " + miEnemigo.getVida() + " HP | " + miEnemigo.getMana() + " MP");
                System.out.println("----------------");

                if (miHeroe.tieneVeneno()) {
                    System.out.println("Tienes tuberculosis y pierdes 5 de vida.");
                    miHeroe.sufrirVeneno();
                }
                if (miEnemigo.tieneVeneno() && miEnemigo.estaVivo()) {
                    System.out.println("El " + miEnemigo.getNombre() + " tose raro por el veneno y pierde 5 de vida.");
                    miEnemigo.sufrirVeneno();
                }

                if (!miHeroe.estaVivo() || !miEnemigo.estaVivo()) break;
                
                // --- TU TURNO ---
                if (miHeroe.isAturdido()) {
                    System.out.println("Estás atontao perdío por un golpe anterior. Pierdes el turno.");
                    miHeroe.setAturdido(false); 
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
                            int probabilidadEsquivar = (int)(Math.random() * 100) + 1;
                            if (probabilidadEsquivar <= 15) {
                                System.out.println("¡Hostia! El " + miEnemigo.getNombre() + " te ha hecho la cobra y esquiva el ataque entero.");
                            } else {
                                int danoFinal = ataqueElegido.getDano();
                                int probabilidadCritico = (int)(Math.random() * 10) + 1; 
                                if (probabilidadCritico == 1) { 
                                    danoFinal = (int)(danoFinal * 1.5); 
                                    System.out.println("Palo gordo (critico), al nivel de no me conoce.");
                                }

                                System.out.println("Le tiras un " + ataqueElegido.getNombre() + " y le quitas " + danoFinal + " de vida al " + miEnemigo.getNombre() + ".");
                                miEnemigo.recibirDano(danoFinal);

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
                            System.out.println("No te enteras de na, que no te quedan payo. Pierdes el turno por tolai.");
                        }
                    } else if (accion.equals("3")) {
                        if (miHeroe.usarCafe()) {
                            System.out.println("Abres un cafele malo d aldi y recuperas 40 de maná.");
                            miHeroe.curarMana(40);
                        } else {
                            System.out.println("Cuajada gorda. Pierdes el turno por tolai.");
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
                            int probabilidadEsquivar = (int)(Math.random() * 100) + 1;
                            if (probabilidadEsquivar <= 15) {
                                System.out.println("¡Fiu! Has esquivado el ataque de " + miEnemigo.getNombre() + ", eres virgen.");
                            } else {
                                int danoFinalEnemigo = ataqueDelMalo.getDano();
                                int probabilidadCriticoEnemigo = (int)(Math.random() * 10) + 1; 
                                if (probabilidadCriticoEnemigo == 1) { 
                                    danoFinalEnemigo = (int)(danoFinalEnemigo * 1.5); 
                                    System.out.println("¡OJO! El " + miEnemigo.getNombre() + " te ha metido el pene.");
                                }

                                System.out.println("El " + miEnemigo.getNombre() + " contraataca con " + ataqueDelMalo.getNombre() + " y te sopla un palo de " + danoFinalEnemigo + " de vida.");
                                miHeroe.recibirDano(danoFinalEnemigo);

                                if (ataqueDelMalo.getEfecto().equals("Veneno")) {
                                    System.out.println("Por fumador pasivo. Estás envenenado por 2 turnos.");
                                    miHeroe.aplicarVeneno(2);
                                } else if (ataqueDelMalo.getEfecto().equals("Aturdir")) {
                                    System.out.println("Palo gordo, te cuajas y pierdes tu próximo turno.");
                                    miHeroe.setAturdido(true);
                                }
                            }
                        } else {
                            System.out.println("El " + miEnemigo.getNombre() + " intenta hacer algo raro pero está sin maná. Se queda mirando al techo.");
                        }
                    }
                }
            }

            // --- RESULTADO DEL PISO ---
            if (!miHeroe.estaVivo()) {
                System.out.println("\n💀 Has tragao fuerte " + piso + ". Te toca volver a empezar de cero, pajero.");
                break; // Rompe el bucle de la mazmorra porque has muerto
            } else {
                if (piso == 10) {
                    System.out.println("\n🏆 Pa un lunes no esta mal, bien jugao, mañana toca progra a primera asi que espabila. 🏆");
                } else {
                    System.out.println("\n✨ ¡Te has cargado al enemigo del piso " + piso + "! ✨");
                    System.out.println("Loteas el cuerpo y encuentras 1 Bifruta y 1 Cafele.");
                    
                    // Mejoramos al héroe
                    miHeroe.anadirBotin();
                    miHeroe.resetearEstados(); // Limpiamos la mierda para el siguiente piso
                    
                    Ataque[] misAtaques = miHeroe.getAtaques();
                    for (int i = 0; i < misAtaques.length; i++) {
                        misAtaques[i].mejorarDano(); // Sube el daño un 15%
                    }
                    System.out.println("Aprendes a pelear mejor tete, eres bueno.");
                }
            }
        }
    }
}