package com.example;

import java.util.Scanner;

public class Main {

    /**
     * FUNCIÓN PRINCIPAL (main)
     * Aquí arranca la movida. Prepara el escáner, pinta el logo y te da a elegir
     * si juegas o te vas a casa.
     */
    public static void main(String[] args) {
        // Preparamos el Scanner para leer lo que metas por teclado
        Scanner sc = new Scanner(System.in);

        // Llamamos a la función que pinta el dibujo guapo de la mazmorra
        imprimirLogo();

        // Imprimimos el menú inicial
        System.out.println("1. Entrar a MEDAC OPEN (10 pisos)");
        System.out.println("2. Cagarse y volver a casa");
        System.out.print("\nElige tu destino, fiera: ");

        // Guardamos lo que eliges
        String opcion = sc.nextLine();

        // Evaluamos la opción elegida
        if (opcion.equals("antonio_god")) {
            // Huevo de pascua (Easter egg): Si escribes esto, entras chetado (Modo Dios)
            System.out.println("\n[MODO DIOS ACTIVADO] Antonio Barbado te ha bendecido con el aprobado manual.");
            empezarPelea(sc, true);
        } else if (opcion.equals("1")) {
            // Empieza la partida normal
            empezarPelea(sc, false);
        } else {
            // Si eliges la 2 o pones cualquier otra cosa, te echa del programa
            System.out.println("\nMalillo cagón, hueles a peste. Vuelve cuando te hayas duchado.");
        }

        // Cerramos el Scanner porque ya no lo vamos a usar más aquí (buena práctica)
        sc.close();
    }

    /**
     * FUNCIÓN IMPRIMIR LOGO
     * Función que simplemente escupe texto por pantalla para hacer el logo.
     * Puro arte ASCII.
     */
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

    /**
     * FUNCIÓN OBTENER ENEMIGO FIJO
     * Te saca un enemigo al azar dependiendo del piso.
     * Escala la vida y el daño sumando dependiendo del piso en el que estés.
     */
    public static Personaje obtenerEnemigoFijo(int piso) {
        // Genera un número aleatorio entre 0 y 9 para elegir al jefe del piso
        int random = (int) (Math.random() * 10);

        switch (random) {
            case 0:
                return new Personaje("khiqe (Piso " + piso + ")", 100 + (piso * 15), 50 + (piso * 10),
                        new Ataque[] { new Ataque("cigarro y cola", 12 + (piso * 2), 10, "Veneno"),
                                new Ataque("java krry", 20 + (piso * 3), 15, "Ninguno") },
                        0, 0);
            case 1:
                return new Personaje("Pakito Ju (Piso " + piso + ")", 60 + (piso * 15), 50 + (piso * 10),
                        new Ataque[] { new Ataque("Manipular altavoz", 8 + (piso * 2), 5, "Ninguno"),
                                new Ataque("Encendida de proyector", 25 + (piso * 3), 20, "Aturdir") },
                        0, 0);
            case 2:
                return new Personaje("ffumon (Piso " + piso + ")", 80 + (piso * 15), 40 + (piso * 10),
                        new Ataque[] { new Ataque("Cable de red al cuello", 15 + (piso * 2), 10, "Aturdir"),
                                new Ataque("Reiniciar router", 20 + (piso * 3), 15, "Ninguno") },
                        0, 0);
            case 3:
                return new Personaje("La pickme (Piso " + piso + ")", 90 + (piso * 15), 60 + (piso * 10),
                        new Ataque[] { new Ataque("Dinámica de grupo absurda", 10 + (piso * 2), 15, "Veneno"),
                                new Ataque("Sonrisa falsa", 18 + (piso * 3), 10, "Ninguno") },
                        0, 0);
            case 4:
                return new Personaje("El gordito de las Crypto (Piso " + piso + ")", 70 + (piso * 15), 80 + (piso * 10),
                        new Ataque[] { new Ataque("Explicar qué es un NFT", 12 + (piso * 2), 20, "Aturdir"),
                                new Ataque("Invertir en shitcoins", 22 + (piso * 3), 15, "Veneno") },
                        0, 0);
            case 5:
                return new Personaje("La repetidora lerda (Piso " + piso + ")", 110 + (piso * 15), 20 + (piso * 10),
                        new Ataque[] { new Ataque("Pedir apuntes un día antes", 14 + (piso * 2), 5, "Ninguno"),
                                new Ataque("Contagiar pereza", 18 + (piso * 3), 15, "Aturdir") },
                        0, 0);
            case 6:
                return new Personaje("El profe de BBDD (Piso " + piso + ")", 85 + (piso * 15), 70 + (piso * 10),
                        new Ataque[] { new Ataque("Select * From Hostia", 25 + (piso * 3), 25, "Ninguno"),
                                new Ataque("Suspender por una coma", 15 + (piso * 2), 10, "Veneno") },
                        0, 0);
            case 7:
                return new Personaje("Nacho pijoletas (Piso " + piso + ")", 130 + (piso * 15), 30 + (piso * 10),
                        new Ataque[] { new Ataque("Batido de protes caducao", 16 + (piso * 2), 10, "Veneno"),
                                new Ataque("Curl de biceps en tu cara", 24 + (piso * 3), 20, "Ninguno") },
                        0, 0);
            case 8:
                return new Personaje("El gamer otaku gordito (Piso " + piso + ")", 75 + (piso * 15), 90 + (piso * 10),
                        new Ataque[] { new Ataque("Insultos por micro", 12 + (piso * 2), 15, "Veneno"),
                                new Ataque("Rage quit", 28 + (piso * 3), 30, "Aturdir") },
                        0, 0);
            default:
                return new Personaje("Dami profe guapo y apuesto (Piso " + piso + ")", 95 + (piso * 15),
                        50 + (piso * 10),
                        new Ataque[] { new Ataque("Post motivacional de humo", 10 + (piso * 2), 20, "Aturdir"),
                                new Ataque("Networking agresivo", 20 + (piso * 3), 15, "Ninguno") },
                        0, 0);
        }
    }

    /**
     * FUNCIÓN EMPEZAR PELEA
     * Aquí está el motor del juego. Gestiona la selección del personaje,
     * los combates piso a piso, los turnos, la vida, el maná y los ataques.
     */
    public static void empezarPelea(Scanner sc, boolean modoDios) {
        // Creamos la lista de personajes. He dopado un poco a Joseca y a Julio para que no mueran de un soplido.
        Personaje[] heroes = {
                new Personaje("Fonso", 150, 50,
                        new Ataque[] { new Ataque("Cadereo sensual", 30, 0, "Ninguno"),
                                new Ataque("Abrir vscode cuando no toca", 65, 15, "Aturdir") },
                        2, 1),
                new Personaje("Chum chum", 120, 120,
                        new Ataque[] { new Ataque("IA en local", 25, 0, "Ninguno"),
                                new Ataque("Stalkear pibas en insta", 75, 30, "Aturdir") },
                        1, 3),
                new Personaje("Joseca", 110, 100, // Le subimos la vida y el maná
                        new Ataque[] { new Ataque("Feria Sevilla", 50, 15, "Ninguno"),
                                new Ataque("Beberse hasta el agua de los floreros", 75, 25, "Veneno") },
                        2, 1),
                new Personaje("Julio", 100, 60, // Le subimos la vida y el maná
                        new Ataque[] { new Ataque("Calvicie deslumbrante", 45, 10, "Aturdir"),
                                new Ataque("Estar casi mas calvo que Johnny Sins", 60, 20, "Ninguno") },
                        2, 1)
        };

        // Modo Dios: sobreescribimos el array y juegas con Antonio Barbato, rotísimo.
        if (modoDios) {
            heroes = new Personaje[] { new Personaje("Antonio Barbato", 999, 999,
                    new Ataque[] { new Ataque("Formatear Disco Duro", 500, 0, "Ninguno"),
                            new Ataque("Aprobado General", 1000, 0, "Aturdir") },
                    10, 10) };
        }

        // BUCLE DE SELECCIÓN DE HÉROE (con control de errores para no petar)
        System.out.println("\n¿Con quién vas a bajar a la mazmorra?");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println((i + 1) + ". " + heroes[i].getNombre() + " (HP: " + heroes[i].getVida() + " | MP: "
                    + heroes[i].getMana() + ")");
        }

        int elecHeroe = -1;
        boolean eleccionValida = false;

        while (!eleccionValida) {
            try {
                elecHeroe = Integer.parseInt(sc.nextLine()) - 1;
                if (elecHeroe >= 0 && elecHeroe < heroes.length) {
                    eleccionValida = true;
                } else {
                    System.out.println("¡Ese héroe no está en la lista! Elige un número del 1 al " + heroes.length + ":");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bro, escribe un número de verdad... Intenta de nuevo:");
            }
        }

        Personaje miHeroe = heroes[elecHeroe];
        System.out.println("Has elegido a: " + miHeroe.getNombre());

        boolean javiFase2 = false;

        // BUCLE TOCHO DE LOS 10 PISOS
        for (int piso = 1; piso <= 10; piso++) {
            Personaje miEnemigo;

            if (piso == 10) {
                System.out.println("\n==============================================");
                System.out.println(" ¡CUIDAO! HAS LLEGADO AL PISO 10: JAVI. ");
                System.out.println("==============================================");
                miEnemigo = new Personaje("JAVI", 400, 300,
                        new Ataque[] { new Ataque("Crud revenío", 40, 20, "Veneno") }, 40, 10);
            } else {
                System.out.println("\n--- ENTRANDO AL PISO " + piso + " ---");
                miEnemigo = obtenerEnemigoFijo(piso);
                System.out.println("¡Te ha saltado un " + miEnemigo.getNombre() + " salvaje!");
            }

            // BUCLE DE PELEA DEL PISO ACTUAL
            while (miHeroe.estaVivo() && (miEnemigo.estaVivo() || (piso == 10 && !javiFase2))) {

                // Fase 2 de Javi (jefe final)
                if (piso == 10 && !miEnemigo.estaVivo() && !javiFase2) {
                    System.out.println("\nJavi: '¿Os creíais que era tan fácil?'");
                    System.out.println("Javi se toma un café del Aldi y entra en MODO DEPURACIÓN.");
                    miEnemigo = new Personaje("JAVI (FULL POWER)", 450, 999,
                            new Ataque[] { new Ataque("Merge Conflict", 50, 30, "Aturdir"),
                                    new Ataque("Código Espagueti", 40, 25, "Veneno") },
                            0, 0);
                    javiFase2 = true;
                    System.out.println("--- JAVI HA RECUPERADO TODA LA VIDA ---");
                }

                // Marcadores
                System.out.println("\n--- MARCADOR ---");
                System.out.println("Tú (" + miHeroe.getNombre() + "): " + miHeroe.getVida() + " HP | "
                        + miHeroe.getMana() + " MP");
                System.out.println("Enemigo (" + miEnemigo.getNombre() + "): " + miEnemigo.getVida() + " HP | " 
                        + miEnemigo.getMana() + " MP");

                // Sistema de Veneno
                if (miHeroe.tieneVeneno()) miHeroe.sufrirVeneno();
                if (miEnemigo.tieneVeneno() && miEnemigo.estaVivo()) miEnemigo.sufrirVeneno();

                if (!miHeroe.estaVivo() || !miEnemigo.estaVivo()) break;

                // --- TURNO DEL HÉROE ---
                if (miHeroe.isAturdido()) {
                    System.out.println("Estás atontao perdío. Pierdes el turno.");
                    miHeroe.setAturdido(false);
                } else {
                    boolean turnoCompletado = false;
                    
                    // Bucle para que no pierdas el turno si le das a una tecla sin querer
                    while (!turnoCompletado) {
                        System.out.println("\n1. Atacar | 2. Bifrutar (" + miHeroe.getBifrutas() + ") | 3. Cafele (" + miHeroe.getCafeles() + ")");
                        String accion = sc.nextLine();

                        if (accion.equals("1")) {
                            // Selector manual de ataque
                            boolean ataqueElegido = false;
                            while (!ataqueElegido) {
                                System.out.println("¿Qué ataque quieres usar?");
                                for (int j = 0; j < miHeroe.getAtaques().length; j++) {
                                    Ataque a = miHeroe.getAtaques()[j];
                                    System.out.println((j + 1) + ". " + a.getNombre() + " (Daño: " + a.getDano() + " | MP: " + a.getCosteMana() + " | Efecto: " + a.getEfecto() + ")");
                                }
                                System.out.println("0. Volver atrás");

                                try {
                                    int elecAt = Integer.parseInt(sc.nextLine());
                                    
                                    if (elecAt == 0) {
                                        break; // Rompe este bucle y vuelve al menú principal de acciones
                                    }

                                    elecAt -= 1; // Ajustamos para el array

                                    if (elecAt >= 0 && elecAt < miHeroe.getAtaques().length) {
                                        Ataque at = miHeroe.getAtaques()[elecAt];
                                        
                                        // Comprobamos si hay maná
                                        if (miHeroe.gastarMana(at.getCosteMana())) {
                                            int danoFinal = at.getDano();
                                            double suerte = Math.random();

                                            // Pasiva especial de Joseca
                                            if (miHeroe.getNombre().equals("Joseca") && miHeroe.getVida() < 25) {
                                                danoFinal *= 2;
                                                System.out.println("[PASIVA SEVILLANA] Joseca entra en modo cierre de feria. ¡DAÑO DOBLE!");
                                            }

                                            // Críticos y fallos
                                            if (suerte > 0.88) {
                                                danoFinal *= 2;
                                                System.out.println("¡¡CRÍTICO!! Menudo viaje le has dao.");
                                            } else if (suerte < 0.08) {
                                                danoFinal = 0;
                                                System.out.println("¡FALLO! El código no compila y no haces nada.");
                                            }

                                            System.out.println("Usas " + at.getNombre() + " -> " + danoFinal + " pupa.");
                                            miEnemigo.recibirDano(danoFinal);
                                            
                                            // Aplicar estados alterados al enemigo
                                            if (danoFinal > 0) {
                                                if (at.getEfecto().equals("Veneno")) {
                                                    miEnemigo.setVeneno(true); 
                                                    System.out.println("¡Has envenenado al notas!");
                                                } else if (at.getEfecto().equals("Aturdir")) {
                                                    miEnemigo.setAturdido(true);
                                                    System.out.println("¡Lo has dejado moñeco (aturdido)!");
                                                }
                                            }
                                            
                                            ataqueElegido = true;
                                            turnoCompletado = true; // Todo ok, pasamos turno
                                        } else {
                                            System.out.println("No tienes maná pa' eso, bro. Pilla otro ataque o tómate un cafele.");
                                        }
                                    } else {
                                        System.out.println("Ese ataque no existe.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Escribe un número, fiera.");
                                }
                            }
                        } else if (accion.equals("2")) {
                            if (miHeroe.usarBifruta()) {
                                miHeroe.curarVida(35);
                                turnoCompletado = true;
                            } else {
                                System.out.println("¡No te quedan bifrutas!");
                            }
                        } else if (accion.equals("3")) {
                            if (miHeroe.usarCafe()) {
                                miHeroe.curarMana(45);
                                turnoCompletado = true;
                            } else {
                                System.out.println("¡Te has quedado sin cafeles!");
                            }
                        } else {
                            System.out.println("Opción incorrecta. Pulsa 1, 2 o 3.");
                        }
                    }
                }

                // --- TURNO DEL ENEMIGO ---
                if (miEnemigo.estaVivo()) {
                    if (miEnemigo.getNombre().contains("JAVI") && Math.random() < 0.2) {
                        System.out.println("\n¡EXAMEN SORPRESA! " + miHeroe.getNombre() + " no sabe por dónde le da el aire. Has muerto.");
                        miHeroe.recibirDano(9999);
                    } else if (!miEnemigo.isAturdido()) {
                        
                        // El enemigo intenta buscar un ataque
                        Ataque atM = miEnemigo.getAtaques()[(int) (Math.random() * miEnemigo.getAtaques().length)];
                        
                        // Ahora los enemigos también gastan maná
                        if (miEnemigo.gastarMana(atM.getCosteMana())) {
                            System.out.println("El " + miEnemigo.getNombre() + " usa " + atM.getNombre() + "!");
                            miHeroe.recibirDano(atM.getDano());
                            
                            // Aplicar estados alterados al héroe
                            if (atM.getEfecto().equals("Veneno")) {
                                miHeroe.setVeneno(true); 
                                System.out.println("¡Te han envenenado!");
                            } else if (atM.getEfecto().equals("Aturdir")) {
                                miHeroe.setAturdido(true);
                                System.out.println("¡Te han aturdido!");
                            }
                        } else {
                            System.out.println("El " + miEnemigo.getNombre() + " intenta usar " + atM.getNombre() + " pero se ha quedado sin maná. ¡Turno gratis!");
                        }
                        
                    } else {
                        System.out.println("El enemigo está aturdido y no hace na'.");
                        miEnemigo.setAturdido(false);
                    }
                }
            } // Fin de la pelea del piso

            // --- RESULTADO DEL COMBATE ---
            if (!miHeroe.estaVivo()) {
                System.out.println("\nHas caído en el piso " + piso + ". Te vas para septiembre, máquina.");
                break; // Game Over, sales del bucle
            } else {
                if (piso == 10) {
                    System.out.println("\n¡HAS DERROTADO A JAVI! Eres el rey de MEDAC. ");
                } else {
                    System.out.println("\n¡Piso " + piso + " superado!");
                    miHeroe.anadirBotin(); 
                    miHeroe.resetearEstados(); // Limpiamos la porquería (veneno, etc)
                    
                    // Asumo que tienes una clase Evento
                    Evento.aparecer(miHeroe, sc); 
                    
                    for (Ataque a : miHeroe.getAtaques()) {
                        a.mejorarDano();
                    }
                }
            }
        } // Fin del bucle de los pisos
    }
}