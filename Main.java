import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        imprimirLogo();
        
        System.out.println("1. Entrar a MEDAC OPEN (10 pisos)");
        System.out.println("2. Cagarse y volver a casa");
        System.out.print("\nElige tu destino, fiera: ");
        
        String opcion = sc.nextLine();
        
        // Antonio Barbado
        if (opcion.equals("antonio_god")) {
            System.out.println("\n[MODO DIOS ACTIVADO] Antonio Barbado te ha bendecido con el aprobado manual.");
            empezarPelea(sc, true);
        } else if (opcion.equals("1")) {
            empezarPelea(sc, false);
        } else {
            System.out.println("\nMalillo cagon, hueles peste. Vuelve cuando te hayas duchado.");
        }
        
        sc.close();
    }

    public static void imprimirLogo() {
        System.out.println("   _________________________________________________");
        System.out.println("  |                                                 |");
        System.out.println("  |        LUNES EN DAW: LA MAZMORRA DE MEDAC       |");
        System.out.println("  |                                                 |");
        System.out.println("  |_________________________________________________|");
        System.out.println("                |               |");
        System.out.println("                |   ( >_<)      |  <-- El de BBDD");
        System.out.println("                |    / | \\      |      mirando tu código");
        System.out.println("                |      |        |");
        System.out.println("                |_____/ \\_______|");
        System.out.println();
    }

    public static Personaje obtenerEnemigoFijo(int piso) {
        int random = (int)(Math.random() * 10); 
        switch(random) {
            case 0: return new Personaje("khiqe (Piso " + piso + ")", 100 + (piso * 15), 0, new Ataque[]{new Ataque("cigarro y cola", 12 + (piso * 2), 0, "Veneno"), new Ataque("java krry", 20 + (piso * 3), 0, "Ninguno")}, 0, 0);
            case 1: return new Personaje("Pakito Ju (Piso " + piso + ")", 60 + (piso * 15), 50 + (piso * 10), new Ataque[]{new Ataque("Manipular altavoz", 8 + (piso * 2), 0, "Ninguno"), new Ataque("Encendida de proyector", 25 + (piso * 3), 20, "Aturdir")}, 0, 0);
            case 2: return new Personaje("El notas de Sistemas (Piso " + piso + ")", 80 + (piso * 15), 40 + (piso * 10), new Ataque[]{new Ataque("Cable de red al cuello", 15 + (piso * 2), 10, "Aturdir"), new Ataque("Reiniciar router", 20 + (piso * 3), 0, "Ninguno")}, 0, 0);
            case 3: return new Personaje("La de RRHH (Piso " + piso + ")", 90 + (piso * 15), 60 + (piso * 10), new Ataque[]{new Ataque("Dinámica de grupo absurda", 10 + (piso * 2), 15, "Veneno"), new Ataque("Sonrisa falsa", 18 + (piso * 3), 0, "Ninguno")}, 0, 0);
            case 4: return new Personaje("El pesao de Crypto (Piso " + piso + ")", 70 + (piso * 15), 80 + (piso * 10), new Ataque[]{new Ataque("Explicar qué es un NFT", 12 + (piso * 2), 20, "Aturdir"), new Ataque("Invertir en shitcoins", 22 + (piso * 3), 0, "Veneno")}, 0, 0);
            case 5: return new Personaje("El repetidor de 4to (Piso " + piso + ")", 110 + (piso * 15), 20 + (piso * 10), new Ataque[]{new Ataque("Pedir apuntes un día antes", 14 + (piso * 2), 0, "Ninguno"), new Ataque("Contagiar pereza", 18 + (piso * 3), 15, "Aturdir")}, 0, 0);
            case 6: return new Personaje("El profe de BBDD (Piso " + piso + ")", 85 + (piso * 15), 70 + (piso * 10), new Ataque[]{new Ataque("Select * From Hostia", 25 + (piso * 3), 25, "Ninguno"), new Ataque("Suspender por una coma", 15 + (piso * 2), 10, "Veneno")}, 0, 0);
            case 7: return new Personaje("El chaval del GYM (Piso " + piso + ")", 130 + (piso * 15), 10 + (piso * 10), new Ataque[]{new Ataque("Batido de protes caducao", 16 + (piso * 2), 0, "Veneno"), new Ataque("Curl de biceps en tu cara", 24 + (piso * 3), 0, "Ninguno")}, 0, 0);
            case 8: return new Personaje("El gamer tóxico (Piso " + piso + ")", 75 + (piso * 15), 90 + (piso * 10), new Ataque[]{new Ataque("Insultos por micro", 12 + (piso * 2), 0, "Veneno"), new Ataque("Rage quit", 28 + (piso * 3), 30, "Aturdir")}, 0, 0);
            default: return new Personaje("El fantasma de LinkedIn (Piso " + piso + ")", 95 + (piso * 15), 50 + (piso * 10), new Ataque[]{new Ataque("Post motivacional de humo", 10 + (piso * 2), 20, "Aturdir"), new Ataque("Networking agresivo", 20 + (piso * 3), 0, "Ninguno")}, 0, 0);
        }
    }
    
    public static void empezarPelea(Scanner sc, boolean modoDios) {
        Personaje[] heroes = {
            new Personaje("Fonso", 150, 50, new Ataque[]{new Ataque("Cadereo sensual", 30, 0, "Ninguno"), new Ataque("Abrir vscode cuando no toca", 65, 15, "Aturdir")}, 2, 1),
            new Personaje("Chum chum", 120, 120, new Ataque[]{new Ataque("IA en local", 25, 0, "Ninguno"), new Ataque("Stalkear pibas en insta", 75, 30, "Aturdir")}, 1, 3),
            new Personaje("Joseca", 60, 100, new Ataque[]{new Ataque("Feria Sevilla", 80, 0, "Ninguno"), new Ataque("Beberse hasta el agua de los floreros", 75, 5, "Aturdir")}, 2, 1),
            new Personaje("Julio", 80, 10, new Ataque[]{new Ataque("Calvicie", 90, 0, "Ninguno"), new Ataque("Estar casi mas calvo que Johnny Sins", 45, 5, "Aturdir")}, 2, 1)
        };

        if (modoDios) {
            heroes = new Personaje[]{new Personaje("Antonio Barbado", 999, 999, new Ataque[]{new Ataque("Formatear Disco Duro", 500, 0, "Ninguno"), new Ataque("Aprobado General", 1000, 0, "Ninguno")}, 10, 10)};
        }

        System.out.println("\n¿Con quién vas a bajar a la mazmorra?");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println((i+1) + ". " + heroes[i].getNombre() + " (HP: " + heroes[i].getVida() + " | MP: " + heroes[i].getMana() + ")");
        }
        int elecHeroe = Integer.parseInt(sc.nextLine()) - 1;
        Personaje miHeroe = heroes[elecHeroe];

        boolean javiFase2 = false; // Antonio Barbado:

        for (int piso = 1; piso <= 10; piso++) {
            Personaje miEnemigo;

            if (piso == 10) {
                System.out.println("\n==============================================");
                System.out.println(" ¡CUIDAO! HAS LLEGADO AL PISO 10: JAVI. ");
                System.out.println("==============================================");
                miEnemigo = new Personaje("JAVI", 400, 300, new Ataque[]{new Ataque("Crud revenio", 30, 0, "Ninguno")}, 40, 10);
            } else {
                System.out.println("\n--- ENTRANDO AL PISO " + piso + " ---");
                miEnemigo = obtenerEnemigoFijo(piso);
                System.out.println("¡Te ha saltado un " + miEnemigo.getNombre() + " salvaje!");
            }
            
            while (miHeroe.estaVivo() && (miEnemigo.estaVivo() || (piso == 10 && !javiFase2))) {
                
                // Antonio Barbado: 
                if (piso == 10 && !miEnemigo.estaVivo() && !javiFase2) {
                    System.out.println("\nJavi: '¿Os creíais que era tan fácil?'");
                    System.out.println("Javi se toma un café del Aldi y entra en MODO DEPURACIÓN.");
                    miEnemigo = new Personaje("JAVI (FULL POWER)", 450, 999, new Ataque[]{new Ataque("Merge Conflict", 50, 0, "Aturdir"), new Ataque("Código Espagueti", 40, 0, "Veneno")}, 0, 0);
                    javiFase2 = true;
                    System.out.println("--- JAVI HA RECUPERADO TODA LA VIDA ---");
                }

                System.out.println("\n--- MARCADOR ---");
                System.out.println("Tú (" + miHeroe.getNombre() + "): " + miHeroe.getVida() + " HP | " + miHeroe.getMana() + " MP");
                System.out.println("Enemigo (" + miEnemigo.getNombre() + "): " + miEnemigo.getVida() + " HP");

                if (miHeroe.tieneVeneno()) miHeroe.sufrirVeneno();
                if (miEnemigo.tieneVeneno() && miEnemigo.estaVivo()) miEnemigo.sufrirVeneno();
                if (!miHeroe.estaVivo() || !miEnemigo.estaVivo()) break;
                
                if (miHeroe.isAturdido()) {
                    System.out.println("Estás atontao perdío. Pierdes el turno.");
                    miHeroe.setAturdido(false); 
                } else {
                    System.out.println("\n1. Atacar | 2. Bifrutar ("+miHeroe.getBifrutas()+") | 3. Cafele ("+miHeroe.getCafeles()+")");
                    String accion = sc.nextLine();
                    
                    if (accion.equals("1")) {
                        Ataque at = miHeroe.getAtaques()[(int)(Math.random() * miHeroe.getAtaques().length)];
                        if (miHeroe.gastarMana(at.getCosteMana())) {
                            int danoFinal = at.getDano();
                            double suerte = Math.random();

                            //Antonio Barbado:
                            if (miHeroe.getNombre().equals("Joseca") && miHeroe.getVida() < 25) {
                                danoFinal *= 2; 
                                System.out.println("[PASIVA SEVILLANA] Joseca entra en modo cierre de feria. ¡DAÑO DOBLE!");
                            }

                            if (suerte > 0.88) {
                                danoFinal *= 2;
                                System.out.println("¡¡CRÍTICO!! Menudo viaje le has dao.");
                            } else if (suerte < 0.08) {
                                danoFinal = 0;
                                System.out.println("¡FALLO! El código no compila y no haces nada.");
                            }

                            System.out.println("Usas " + at.getNombre() + " -> " + danoFinal + " pupa.");
                            miEnemigo.recibirDano(danoFinal);
                        }
                    } else if (accion.equals("2") && miHeroe.usarBifruta()) {
                        miHeroe.curarVida(35);
                    } else if (accion.equals("3") && miHeroe.usarCafe()) {
                        miHeroe.curarMana(45);
                    }
                }
                
                if (miEnemigo.estaVivo()) {
                    // El Insta-kill de Javi
                    if (miEnemigo.getNombre().contains("JAVI") && Math.random() < 0.2) {
                        System.out.println("\n¡EXAMEN SORPRESA! " + miHeroe.getNombre() + " no sabe por dónde le da el aire. Has muerto.");
                        miHeroe.recibirDano(9999);
                    } else if (!miEnemigo.isAturdido()) {
                        Ataque atM = miEnemigo.getAtaques()[(int)(Math.random() * miEnemigo.getAtaques().length)];
                        System.out.println("El " + miEnemigo.getNombre() + " usa " + atM.getNombre() + "!");
                        miHeroe.recibirDano(atM.getDano());
                    } else {
                        System.out.println("El enemigo está aturdido.");
                        miEnemigo.setAturdido(false);
                    }
                }
            }

            if (!miHeroe.estaVivo()) {
                System.out.println("\nHas caído en el piso " + piso + ". Te vas para septiembre, máquina.");
                break;
            } else {
                if (piso == 10) {
                    System.out.println("\n¡HAS DERROTADO A JAVI! Eres el rey de MEDAC. ");
                } else {
                    System.out.println("\n¡Piso " + piso + " superado!");
                    miHeroe.anadirBotin();
                    miHeroe.resetearEstados();
                    Evento.aparecer(miHeroe, sc);
                    for (Ataque a : miHeroe.getAtaques()) a.mejorarDano();
                }
            }
        }
    }
}