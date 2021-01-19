/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import world.Baraja;
import world.Carta;
import world.Ficha;
import world.Game;
import world.Nodo;
import world.Pila;
import world.Player;

/**
 *
 * @author USER
 */
public class InterfazApp {

    /**
     * @param args the command line arguments
     */
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        
        
        
        
        
        Player IA1 = new Player("Carlos");//IA 1
        
        Player IA2 = new Player("Pedro");//IA 2

        Player jugador = new Player("PerroLoko"); //Jugador
        
          
        
        Game juegoNuevo = new Game(Game.blackJackIA);
        juegoNuevo.jugar(IA1, IA2, jugador);
        
        
        
        
        
        
        
       
        
        
        
         

 /* Test Nodos para pilas
        Ficha ficha1 = new Ficha("Azul", 50, 2);
        Ficha ficha2 = new Ficha("Roja", 80, 5);
        Ficha ficha3 = new Ficha("Verde", 100, 50);
        Ficha ficha4 = new Ficha("Dorada", 500, 100);
        
        Nodo nodo1 = new Nodo(ficha1);
        Nodo nodo2 = new Nodo(ficha2);
        Nodo nodo3 = new Nodo(ficha3);
        Nodo nodo4 = new Nodo(ficha4);
        
        nodo1.setSiguiente(nodo2);
        nodo2.setAtras(nodo1);
        nodo1 = nodo1.getSiguiente();
        
        nodo1.setSiguiente(nodo3);
        nodo3.setAtras(nodo1);
        nodo1 = nodo1.getSiguiente();
        
        nodo1.setSiguiente(nodo4);
        nodo4.setAtras(nodo1);
        nodo1 = nodo1.getSiguiente();
        

        System.out.println(nodo1.getAtras().getAtras().getAtras().getFicha().getColor());
        
         */
 /*
        Ficha ficha1 = new Ficha("Azul", 50, 2);
        Ficha ficha2 = new Ficha("Roja", 80, 5);
        Ficha ficha3 = new Ficha("Verde", 100, 50);
        Ficha ficha4 = new Ficha("Dorada", 500, 100);

        Nodo nodo1 = new Nodo(ficha1);
        Nodo nodo2 = new Nodo(ficha2);
        Nodo nodo3 = new Nodo(ficha3);
        Nodo nodo4 = new Nodo(ficha4);

        Pila monto = new Pila();
        System.out.println(monto.getElementos());

        monto.agregarNodo(nodo1);
        System.out.println(monto.getElementos());

        monto.agregarNodo(nodo4);
        System.out.println(monto.getElementos());

        monto.agregarNodo(nodo2);
        monto.agregarNodo(nodo3);

        monto.verPila();
         */
        //Game juego = new Game("BlackJack");
        //juego.crearBaraja();
        //juego.Barajar();
        // Carta carta = new Carta("Jota", "Rojo", "Diamantes");
        //carta.setSrc("XDDD");
        //Menu
    }

   
 

   

   

}
