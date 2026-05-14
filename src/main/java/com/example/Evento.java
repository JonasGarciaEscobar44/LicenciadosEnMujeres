package com.example;

import java.util.Scanner;

/**
 * Clase encargada de meterle salseo al juego entre piso y piso.
 * Te salta un evento aleatorio para que no sea todo el rato solo pegar tortas.
 */
public class Evento {

    /**
     * Lanza un evento al azar que te puede ayudar (o joder un poco).
     * @param heroe El personaje con el que estás jugando.
     * @param sc El Scanner para leer si decides jugártela o pasar del tema.
     */
    public static void aparecer(Personaje heroe, Scanner sc) {
        // Genera un número del 0 al 2 para elegir qué evento toca
        int suerte = (int) (Math.random() * 3); 

        System.out.println("\n--- [EVENTO EN EL PASILLO] ---");

        switch (suerte) {
            case 0:
                System.out.println("Te encuentras una máquina de Vending que hace ruidos raros...");
                System.out.println("1. Meterle una guantá (50% Botín extra | 50% Calambrazo)");
                System.out.println("2. Pasar de largo, no vaya a ser...");
                System.out.print("Elige: ");
                
                // Si pones "1" te la juegas, si pones cualquier otra cosa asume que pasas
                if (sc.nextLine().equals("1")) {
                    if (Math.random() > 0.5) { // 50% de probabilidad
                        System.out.println("¡Ole! Le has dado en el punto clave. Cae un Bifrutas y un Cafele gratis.");
                        heroe.anadirBotin(); // Te da 1 de cada
                    } else {
                        System.out.println("¡ZASCA! Calambrazo del 15 por toquetear. Pierdes 15 HP.");
                        heroe.recibirDano(15);
                    }
                } else {
                    System.out.println("Mejor no tentar a la suerte. Sigues tu camino.");
                }
                break;

            case 1:
                System.out.println("Ves a una repetidora de segundo que parece que sabe lo que hace.");
                System.out.println("Te ofrece compartir sus apuntes (Maná) o sus protes (Vida).");
                
                boolean eleccionValida = false;
                
                // Bucle de seguridad por si le das a una tecla sin querer
                while (!eleccionValida) {
                    System.out.println("1. Apuntes | 2. Protes");
                    System.out.print("Elige: ");
                    String opcion = sc.nextLine();
                    
                    if (opcion.equals("1")) {
                        System.out.println("Te lees los apuntes y se te despeja la mente. +30 MP.");
                        heroe.curarMana(30);
                        eleccionValida = true;
                    } else if (opcion.equals("2")) {
                        System.out.println("Te bebes el batido y te pones como un toro. +30 HP.");
                        heroe.curarVida(30);
                        eleccionValida = true;
                    } else {
                        System.out.println("Bro, elige 1 o 2. No te quedes mirando pajaros.");
                    }
                }
                break;

            case 2:
                System.out.println("Encuentras un sitio tranquilo cerca de los baños.");
                System.out.println("Te echas un cigarrito y descansas un rato. Recuperas 20 HP y 20 MP.");
                // Curación automática por pura potra
                heroe.curarVida(20);
                heroe.curarMana(20);
                break;

            default:
                // Esto por si en un futuro metes más eventos y falla algo
                System.out.println("¡Vaya! Parece que no ha pasado nada interesante por aquí.");
                break;
        }

        System.out.println("------------------------------\n");
    }
}