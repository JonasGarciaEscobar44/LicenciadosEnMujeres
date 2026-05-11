import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== LUNES EN DAW: LA MAZMORRA ===");
        System.out.println("1. Entrar a MEDAC OPEN (10 pisos)");
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
    
    public static void empezarPelea(Scanner sc) {
        Personaje[] heroes = {
            new Personaje("Fonso", 150, 50, new Ataque[]{new Ataque("Cadereo sensual", 30, 0, "Ninguno"), new Ataque("Abrir vscode cuando no toca", 65, 15, "Aturdir")}, 2, 1),
            new Personaje("Chum chum", 120, 120, new Ataque[]{new Ataque("IA en local", 25, 0, "Ninguno"), new Ataque("Stalkear pibas en insta", 75, 30, "Aturdir")}, 1, 3)
        };

        System.out.println("\n¿Con quién vas a bajar a la mazmorra?");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println((i+1) + ". " + heroes[i].getNombre() + " (HP: " + heroes[i].getVida() + " | MP: " + heroes[i].getMana() + " | Bifrutas: " + heroes[i].getBifrutas() + " | Cafeles: " + heroes[i].getCafeles() + ")");
        }
        int elecHeroe = Integer.parseInt(sc.nextLine()) - 1;
        Personaje miHeroe = heroes[elecHeroe];

        for (int piso = 1; piso <= 10; piso++) {
            Personaje miEnemigo;

            if (piso == 10) {
                System.out.println("\n==============================================");
                System.out.println(" ¡CUIDAO! HAS LLEGADO AL PISO 10: JAVI. ");
                System.out.println("==============================================");
                // Cambio realizado por Pedro: Añadido Javi como Final Boss
                miEnemigo = new Personaje("JAVI", 500, 300, new Ataque[]{new Ataque("Castigo sin recreo", 30, 0, "Ninguno")}, 0, 0);
            } else {
                System.out.println("\n--- ENTRANDO AL PISO " + piso + " ---");
                miEnemigo = obtenerEnemigoFijo(piso);
                System.out.println("¡Te ha saltado un " + miEnemigo.getNombre() + " salvaje!");
            }
            
            while (miHeroe.estaVivo() && miEnemigo.estaVivo()) {
                System.out.println("\n--- MARCADOR ---");
                System.out.println("Tú (" + miHeroe.getNombre() + "): " + miHeroe.getVida() + " HP | " + miHeroe.getMana() + " MP");
                System.out.println("Enemigo (" + miEnemigo.getNombre() + "): " + miEnemigo.getVida() + " HP");
                System.out.println("----------------");

                if (miHeroe.tieneVeneno()) miHeroe.sufrirVeneno();
                if (miEnemigo.tieneVeneno() && miEnemigo.estaVivo()) miEnemigo.sufrirVeneno();
                if (!miHeroe.estaVivo() || !miEnemigo.estaVivo()) break;
                
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
                    
                    if (accion.equals("1")) {
                        Ataque at = miHeroe.getAtaques()[(int)(Math.random() * miHeroe.getAtaques().length)];
                        if (miHeroe.gastarMana(at.getCosteMana())) {
                            System.out.println("Le tiras un " + at.getNombre() + " y le quitas " + at.getDano());
                            miEnemigo.recibirDano(at.getDano());
                        }
                    } else if (accion.equals("2") && miHeroe.usarBifruta()) {
                        miHeroe.curarVida(30);
                    } else if (accion.equals("3") && miHeroe.usarCafe()) {
                        miHeroe.curarMana(40);
                    }
                }
                
                if (miEnemigo.estaVivo()) {
                    // --- CAMBIO REALIZADO POR PEDRO: EVENTO ESPECIAL JAVI (INSTA-KILL) ---
                    if (miEnemigo.getNombre().equals("JAVI") && Math.random() < 0.3) {
                        System.out.println("\n[JAVI SE PARA EN MITAD DEL AULA]");
                        System.out.println("Javi: 'Chavales, guardad todo. Sacad un folio y poned el nombre.'");
                        System.out.println("Javi: 'EXAMEN SORPRESA DE PROGRAMACION.'");
                        System.out.println("\n" + miHeroe.getNombre() + " (con la mirada perdida): '¿Pero que dice? Pff... estamos cooked.'");
                        System.out.println("\n¡INSTA-KILL! Tu nota es un 0. Has muerto por error de sintaxis.");
                        miHeroe.recibirDano(9999);
                    } else if (miEnemigo.isAturdido()) {
                        System.out.println("El enemigo esta viendo las estrellas.");
                        miEnemigo.setAturdido(false);
                    } else {
                        Ataque atM = miEnemigo.getAtaques()[(int)(Math.random() * miEnemigo.getAtaques().length)];
                        System.out.println("El " + miEnemigo.getNombre() + " usa " + atM.getNombre());
                        miHeroe.recibirDano(atM.getDano());
                    }
                }
            }

            if (!miHeroe.estaVivo()) {
                System.out.println("\n Has tragao fuerte, te has quedado en el piso " + piso + ". Te toca volver a empezar de cero, pajero.");
                break;
            } else {
                if (piso == 10) {
                    System.out.println("\n Pa un lunes no esta mal, bien jugao. ");
                } else {
                    System.out.println("\n ¡Te has cargado al enemigo del piso " + piso + "! ");
                    miHeroe.anadirBotin();
                    miHeroe.resetearEstados();
                    
                    // --- CAMBIO REALIZADO POR PEDRO: LLAMADA AL EVENTO ALEATORIO ---
                    Evento.aparecer(miHeroe, sc);
                    
                    for (Ataque a : miHeroe.getAtaques()) a.mejorarDano();
                    System.out.println("Aprendes a pelear mejor tete, eres bueno.");
                }
            }
        }
    }
}