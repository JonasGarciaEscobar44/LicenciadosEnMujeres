package com.example;

import java.util.Scanner;

/**
 * Clase encargada de gestionar los eventos aleatorios entre pisos.
 * Aporta modularidad y variedad al desarrollo del juego.
 */
public class Evento {

    /**
     * Lanza un evento aleatorio que afecta al heroe.
     * @param heroe El personaje jugador.
     * @param sc Scanner para las decisiones.
     */
    public static void aparecer(Personaje heroe, Scanner sc) {
        int suerte = (int) (Math.random() * 3); 

        System.out.println("\n--- [EVENTO EN EL PASILLO] ---");

        switch (suerte) {
            case 0:
                System.out.println("Te encuentras una maquina de Vending que hace ruidos raros...");
                System.out.println("1. Meterle una guaya (50% Bifruta | 50% Calambrazo)");
                System.out.println("2. Seguir de largo");
                System.out.print("Elige: ");
                if (sc.nextLine().equals("1")) {
                    if (Math.random() > 0.5) {
                        System.out.println("¡Ole! Cae un Bifrutas gratis.");
                        heroe.anadirBotin();
                    } else {
                        System.out.println("¡ZASCA! Calambrazo del 15. Pierdes 15 HP.");
                        heroe.recibirDano(15);
                    }
                }
                break;
            case 1:
                System.out.println("Ves a una repetidora que parece que sabe lo que hace.");
                System.out.println("Te ofrece compartir sus apuntes (Mana) o sus protes (Vida).");
                System.out.println("1. Apuntes | 2. Protes");
                System.out.print("Elige: ");
                if (sc.nextLine().equals("1")) {
                    System.out.println("Te despejas la mente. +30 MP.");
                    heroe.curarMana(30);
                } else {
                    System.out.println("Te pones como un toro. +30 HP.");
                    heroe.curarVida(30);
                }
                break;
            case 2:
                System.out.println("Encuentras un sitio tranquilo cerca de los baños.");
                System.out.println("Te echas un cigarrito y descansas. Recuperas 20 HP y 20 MP.");
                heroe.curarVida(20);
                heroe.curarMana(20);
                break;
        }
        System.out.println("------------------------------\n");
    }
}