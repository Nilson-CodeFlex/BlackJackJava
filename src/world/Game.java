/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Game {

    private String tipoJuego;
    private boolean isStart = false;
    private int cupos;

    private ArrayList players = new ArrayList();//Contiene a los jugadores en mesa
    private ArrayList playersLose = new ArrayList();//Jugadores que perdieron
    private ArrayList baraja = new ArrayList();//Contiene una baraja sin barajar
    private ArrayList barajaCambiante = new ArrayList();//Contiene una baraja, hecha aleatoriamente

    private int ronda = 0;//Indica la ronda en la que estan
    private int rondas = 0;//Indica las rondas jugadas

    private boolean finish = false;//Indica si la ronda actual esta acabada

    //Modos de juegos
    public static final String blackJack = "BlackJack-21";
    public static final String blackJackIA = "BlackJack-21-IA";
    public static final String poker = "Poker-Normal";
    public static final String poker3 = "Poker de 3";

    private Crupier crupier = new Crupier(); //Instancias de un crupier
    private Player IA1;//IA
    private Player IA2;//IA
    private Player jugador;//Jugador

    public Game(String tipoJuego, int cupos) {
        this.tipoJuego = tipoJuego;
        this.cupos = cupos;

    }

    public Game(String tipoJuego) {
        this.tipoJuego = tipoJuego;

    }

    /**
     * En este metodo resulta importante resaltar que el parametro jugador tiene
     * el siguiente orden para establecer la apuesta de un jugador en la mesa
     * esto incluira la IA.
     * <p>
     * <b>Funcionamiento</b></p>
     * <ul>
     * <li><p>
     * <b>0</b> como parametro de jugador, sera la puesta del primer
     * jugador</p></li>
     * <li><p>
     * <b>1</b> como parametro de jugador, sera la puesta de la IA<b>1</B>
     * jugador</p></li>
     * <li><p>
     * <b>2</b> como parametro de jugador, sera la puesta de la IA<b>2</B>
     * jugador</p></li>
     * </ul>
     *
     * @param apuesta
     * @param jugador
     */
    public void establecerApuestas(int apuesta, int jugador)//Establece las apuestas iniciales, al acabar de manera logica la ronda finaliza(Apuestas)
    {
        switch (jugador) {
            case 0:

                ((Player) players.get(jugador)).setApuesta(apuesta);
                break;
            case 1:
                ((Player) players.get(jugador)).setApuesta(apuesta);
                break;
            default:
                ((Player) players.get(jugador)).setApuesta(apuesta);
                break;
        }
    }

    /**
     * Este metodo selecciona todos los jugadores y muestra sus apuestas
     */
    public void verApuestas() {
        for (int i = 0; i < players.size() - 1; i++) {
            String jugadorx = ((Player) players.get(i)).getApodo();
            int apuestax = ((Player) players.get(i)).getApuesta();
            System.out.println("Nombre de jugador: " + jugadorx + ", Apuesta: " + apuestax);
        }

    }

    public void verNumeroDeJugadores() {
        System.out.println("Jugadores en mesa:" + players.size());
    }

    public void verJugadores() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Nombre de jugador: " + ((Player) players.get(i)).getApodo());
        }

    }

    public void jugar(Player IA1, Player IA2, Player jugador) {//Este metodo inicia el juego

        this.IA1 = IA1;
        this.IA2 = IA2;
        this.jugador = jugador;

        //Se agregan jugadores en la mesa
        players.add(jugador);//1
        players.add(IA1);//2
        players.add(IA2);//3
        players.add(crupier);//4

        this.crearBaraja();

        this.Barajar();

        //Apuestas iniciales
        this.establecerApuestas(50, 0);
        this.establecerApuestas(500, 1);
        this.establecerApuestas(5000, 2);

        //Reparte cartas a cada jugador
        this.repartir();

        //this.verApuestas();
        this.reverlarCarta();

        //
        this.initGame();

    }

    /* Este metodo verifica si un jugador puede seguir jugando, para permitir
       que el crupier pregunte sobre las opciones que tiene un jugador para realizar.
       Recorreriendo cada jugador hasta que este se plante, gane o pierda, para finalmente llegar al crupier, 
       donde se compararan las sumas de las cartas solamente si estos se plantaron.   
       
    
     */
    public void initGame() {
        for (int i = 0; i < players.size(); i++) {
            Player jugadorF = (Player) players.get(i);
            if (i == 3) {
                this.crupierRevelaSusCartas(i);
                this.crupierDecide(i);
                
                this.compararCartas();
            } else {
                while (this.puedeJugar(jugadorF)) {

                    this.crupierPregunta(i);

                }

            }

        }

    }

    public boolean puedeJugar(Player p) {
        boolean canYouPlay = false;
        Baraja baraja = (Baraja) p.getCartas();
        int[] sumaCartas = baraja.getSumaBaraja();

        if (!(p.isJugadorPlantado())) {

            if (sumaCartas[1] > 0) {
                if (sumaCartas[1] < 21) {
                    canYouPlay = true;
                }

            } else {
                if (sumaCartas[0] < 21) {
                    canYouPlay = true;
                }

            }

        }

        return canYouPlay;
    }

    public void compararCartas() {
        

    }

    public void reverlarCarta() {
        this.mostrarCartasXJugador(0);
        this.mostrarCartasXJugador(1);
        this.mostrarCartasXJugador(2);
        this.mostrarCartasXJugador(3);
    }

    public void crupierPregunta(int x) {
        Player jugadorPoint = (Player) players.get(x);
        System.out.println("Porfavor digite su accion: " + jugadorPoint.getApodo());
        System.out.println("1: Pedir carta");
        System.out.println("2: Plantarse");
        System.out.println("3: Dividir baraja");
        System.out.println("4: Doblar apuesta");
        System.out.println("5: Salir");
        System.out.print(">>");

        Scanner input = new Scanner(System.in);
        String opcion = input.next();

        switch (opcion) {
            case "1":
                this.pedir(x);
                break;
            case "2":
                this.plantarse(x);
                break;
            case "3":
                break;
            case "4":
                this.doblar(x);
                break;
            case "5":
                System.exit(0);
                break;

            default:
                this.crupierPregunta(x);
                break;
        }

    }

    public void crearBaraja() {
        String[] letras = {"J", "Q", "K", "A"};

        for (int j = 2; j <= 10; j++) { //Picas
            Carta carta = new Carta(Integer.toString(j), "Negro", "Picas");
            baraja.add(carta);
        }

        for (int i = 0; i < letras.length; i++) {
            Carta carta = new Carta(letras[i], "Negro", "Picas");
            baraja.add(carta);
        }

        for (int j = 2; j <= 10; j++) { //Diamantes
            Carta carta = new Carta(Integer.toString(j), "Rojo", "Diamantes");
            baraja.add(carta);
        }

        for (int i = 0; i < letras.length; i++) {
            Carta carta = new Carta(letras[i], "Rojo", "Diamantes");
            baraja.add(carta);
        }

        for (int j = 2; j <= 10; j++) { //Trebol
            Carta carta = new Carta(Integer.toString(j), "Negro", "Trebol");
            baraja.add(carta);
        }

        for (int i = 0; i < letras.length; i++) {
            Carta carta = new Carta(letras[i], "Negro", "Trebol");
            baraja.add(carta);
        }

        for (int j = 2; j <= 10; j++) { //Corazones
            Carta carta = new Carta(Integer.toString(j), "Rojo", "Corazones");
            baraja.add(carta);
        }

        for (int i = 0; i < letras.length; i++) {
            Carta carta = new Carta(letras[i], "Rojo", "Corazones");
            baraja.add(carta);
        }

        System.out.println("Baraja Creada");
        int x = 0;

        /*
        for (int i = 0; i < baraja.size(); i++) {
            System.out.println("Carta: " + ((Carta) baraja.get(i)).getCarta()+ ", Color: " + ((Carta) baraja.get(i)).getColor()+", Figura: " + ((Carta) baraja.get(i)).getFigura());
           x = i;
        }
         */
        this.Barajar();

    }

    public void Barajar() {
        int numAleatorio = 0;
        ArrayList numeroUse = new ArrayList();
        boolean isFound = false;

        do {

            numAleatorio = (int) Math.floor(Math.random() * 52);

            if (numeroUse.isEmpty()) {
                numeroUse.add(numAleatorio);

            } else {
                if (numeroUse.indexOf(numAleatorio) == -1) {
                    numeroUse.add(numAleatorio);
                }

            }

        } while (numeroUse.size() <= 51);

        /* //Testeo
        for (int i = 0; i < numeroUse.size(); i++) {
            System.out.println("Carta: "+numeroUse.get(i));
        }
        
        System.out.println(numeroUse.size());
        try {
            Thread.sleep(8000);
            
        } catch (Exception e) {
        }
        
        int mayor = 0;
        
        for (int i = 0; i < numeroUse.size(); i++) {
            if ((int)numeroUse.get(i) > mayor) {
                mayor = (int)numeroUse.get(i);
            }
            
        }
        
        System.out.println("Mayor"+mayor);
         */
        ArrayList barajada = new ArrayList();

        /*
        for (int i = 0; i < numeroUse.size(); i++) {//Testea si hay cartas para el indice generado aleatoriamente
            System.out.println("Posicion:"+i+", numero:"+(int)numeroUse.get(i));
            //System.out.println("Posicion: "+i+", valor: "+((Carta)baraja.get(i)).getLon());
            System.out.println("");
        }
         */
        for (int i = 0; i < numeroUse.size(); i++) {
            barajada.add((Carta) baraja.get((int) numeroUse.get(i)));
        }

        //Imprime las cartas barajadas
        /*
        for (int i = 0; i < barajada.size(); i++) {
              System.out.println("Carta: " + ((Carta) barajada.get(i)).getCarta()+ ", Color: " + ((Carta) barajada.get(i)).getColor()+", Figura: " + ((Carta) barajada.get(i)).getFigura());

        }
         */
        barajaCambiante = barajada;

        //System.out.println("Barajado aleatoriamente");
    }

    public void repartir() { //Se reparte inicialmente
        //System.out.println("El crupier saca una nueva baraja"); *
        //System.out.println("El crupier baraja"); *

        //El crupier obtiene la baraja para el juego
        crupier.setBaraja(barajaCambiante);

        for (int i = 0; i < players.size(); i++) {
            Baraja cartas = new Baraja();

            for (int j = 0; j <= 1; j++) {
                cartas.add((Carta) crupier.getBaraja().remove(j));
            }

            ((Player) players.get(i)).setCartas(cartas);
        }
        /*
        for (int i = 0; i < players.size(); i++) {
            ArrayList cartas = new ArrayList();
            for (int j = 1; j <= 2; j++) {
                
                cartas.add(Crupier.getCartas().remove(j));
               
                
            }
            ((Player)players.get(i)).setCartas(cartas);

        }
        
         */

 /* Test de cartas repartidas
        
        ArrayList carta = crupier.getCartas();
        
        
        System.out.println(carta.size());
        
        
        for (int i = 0; i < carta.size(); i++) {
            
            Carta cartas = (Carta)(carta.get(i));
            System.out.println("Carta:"+cartas.getCarta());
            System.out.println("Color:"+cartas.getColor());
            System.out.println("Figura:"+cartas.getFigura());
        }
        
         */
    }

    public void crupierDecide(int x) {
        
        Baraja cartas = (Baraja) ((Crupier) players.get(x)).getCartas();
        Player crp = (Player)players.get(x);
        
        int[] sumas = cartas.getSumaBaraja();
        System.out.println("Suma max:"+sumas[0]);
        System.out.println("Suma min:"+sumas[1]);
        
        /* 
        if (sumas[1] > 0) {

        } else {
            if (sumas[0] >= 17) {
                this.plantarse(x);

            } else if (sumas[0] <= 16) {

                this.pedir(x);

            }

        }
        
         */
        
            if (sumas[0] == 21 || sumas[1] == 21) {
                this.plantarse(x);
            } else if( sumas[0] >= 17 || sumas[1] >= 17)
            {
                this.plantarse(x);
            }else{
                this.pedir(x);
            }
            
            if(!(crp.isJugadorPlantado()))
            {
                this.crupierDecide(x);
            }
            

        
        
        
        
        

    }

    public void crupierRevelaSusCartas(int x) {
        Baraja cartas = (Baraja) ((Crupier) players.get(x)).getCartas();

        Carta carta = (Carta) cartas.get(0);
        Carta carta2 = (Carta) cartas.get(1);

        System.out.println("Cartas Crupier");
        System.out.println("#1 Carta: " + carta.getCarta() + " Figura:" + carta.getFigura());
        System.out.println("#2 Carta: " + carta2.getCarta() + " Figura:" + carta2.getFigura());
  
    }

    public void mostrarCartasXJugador(int x) {

        if (x < 4) {
            Player jugadorX = (Player) players.get(x);
            String nombre = jugadorX.getApodo();
            ArrayList cartas = jugadorX.getCartas();

            Carta carta1 = (Carta) cartas.get(0);
            Carta carta2 = (Carta) cartas.get(1);
            if (x == 3) {
                if (((Crupier) players.get(x)).isCartaMostrada() == false) {
                    System.out.println("Jugador:" + nombre + " Carta:" + carta1.getCarta() + " Figura:" + carta1.getFigura());
                    ((Crupier) players.get(x)).setCartaMostrada(true);
                } else {
                    System.out.println("Jugador:" + nombre + " Carta:" + carta2.getCarta() + " Figura:" + carta2.getFigura());
                    ((Crupier) players.get(x)).setCartaDosMostrada(true);
                }

            } else {

                System.out.println("Jugador:" + nombre + " Carta:" + carta1.getCarta() + " Figura:" + carta1.getFigura());
                System.out.println("Jugador:" + nombre + " Carta:" + carta2.getCarta() + " Figura:" + carta2.getFigura());
            }
        }

    }

    public void pedir(int jugadorC) {

        Carta nuevaCarta = (Carta) crupier.getBaraja().remove(0);
        Player jugador = (Player) players.get(jugadorC);
        ((Player) players.get(jugadorC)).recibirCarta(nuevaCarta);
        System.out.println("Mas cartas para " + jugador.getApodo() + "!! ♦♣♠♥");
        System.out.println("Carta:" + nuevaCarta.getCarta() + " Figura:" + nuevaCarta.getFigura() + " Color:" + nuevaCarta.getColor());
    }

    public void plantarse(int jugadorAP) {
        ((Player) players.get(jugadorAP)).setJugadorPlantado(true);
    }

    public void doblar(int jugadorDoblado) {

        if (jugadorDoblado != 3) {

            Player jugadorD = (Player) players.get(jugadorDoblado);
            //Se dobla la apuesta inicial
            int apuestaNueva = jugadorD.getApuesta() * 2;
            System.out.println("Su apuesta se dobla a:" + apuestaNueva);
            ((Player) players.get(jugadorDoblado)).setApuesta(apuestaNueva);

            //El crupier reparte una nueva carta al jugador que doblo
            Carta nuevaCarta = (Carta) crupier.getBaraja().remove(0);
            ((Player) players.get(jugadorDoblado)).recibirCarta(nuevaCarta);

            System.out.println("Mas cartas para " + jugadorD.getApodo() + "!! ♦♣♠♥");
            System.out.println("Carta:" + nuevaCarta.getCarta() + " Figura:" + nuevaCarta.getFigura() + " Color:" + nuevaCarta.getColor());

        }

    }

    public String getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(String tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public boolean isIsStart() {
        return isStart;
    }

    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public ArrayList getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList players) {
        this.players = players;
    }

    public ArrayList getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList baraja) {
        this.baraja = baraja;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

}
