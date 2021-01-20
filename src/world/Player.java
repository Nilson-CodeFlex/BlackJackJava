/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Player {

    private String nombre, apellido;

    private String apodo;

    private int dinero, apuesta;//Dinero = al dinero para entrar en un juego NO son fichas
    //Apuesta = es la apuesta inicial de cada jugador al jugar

    private MontoFichas monto;

    private String ID;

    private Baraja cartas;

    private boolean participe = true;
    private boolean turno = false;
    
    private boolean isWon = false;
    private boolean isEmpate = false;
    private boolean jugadorPlantado = false;
    private boolean jugando = true;

    public Player(String apodo) {
        this.apodo = apodo;
        this.dinero = 5000;
        this.apuesta = 0;

        cartas = new Baraja();
    }

    public Player()//Inicializar un crupier
    {
        this.nombre = "Arturo";
        this.apellido = "De la sier";
        this.apodo = "Crupier";
        this.dinero = 99999;
        this.apuesta = 99999;

        cartas = new Baraja();

    }
    
    public void recibirCarta(Carta carta)
    {
        cartas.add(carta);
    }

    /**
     * Lista de acciones retornadas
     * <ol>
     * <li>Pedicar una carta[0]</li>
     * <li>Plantarse[1]</li>
     * <li>Dividir baraja[2]</li>
     * <li>Doblar apuesta[3]</li>
     * <li>Gano[4]</li>
     * <li>Perdio[5]</li>
     * </ol>
     *
     *
     *
     * @return Retorna el conjutno de opciones posibles segun un baraja de un jugador
     */
    public boolean[] analisarBaraja() {
        boolean[] opcionesDeJuego = new boolean[6];

        opcionesDeJuego[0] = false;
        opcionesDeJuego[1] = false;
        opcionesDeJuego[2] = false;
        opcionesDeJuego[3] = false;
        opcionesDeJuego[4] = false;
        opcionesDeJuego[5] = false;

        int sumas[] = this.cartas.getSumaBaraja();

        if (sumas[1] > 0) {
            if (sumas[1] < 21) {

            } else if (sumas[1] > 21) {

            }

        } else {
            if (sumas[0] < 21) {
                opcionesDeJuego[0] = true;
                opcionesDeJuego[1] = true;
                if (this.cartas.size() == 2) {
                    opcionesDeJuego[3] = true;

                    Carta carta = (Carta) this.cartas.get(0);
                    Carta carta2 = (Carta) this.cartas.get(1);

                    if (carta.getCarta().equalsIgnoreCase(carta2.getCarta())) {
                        opcionesDeJuego[2] = true;

                    } else {
                        opcionesDeJuego[2] = false;
                    }

                } else {
                    opcionesDeJuego[3] = false;
                    opcionesDeJuego[2] = false;

                }
                opcionesDeJuego[4] = false;
                opcionesDeJuego[5] = false;

            } else if (sumas[0] == 21) {
                opcionesDeJuego[0] = false;
                opcionesDeJuego[1] = true;
                opcionesDeJuego[2] = false;
                opcionesDeJuego[3] = false;
                opcionesDeJuego[4] = true;
                opcionesDeJuego[5] = false;
                
                this.setIsWon(true);

            } else if (sumas[0] > 21) {

                opcionesDeJuego[0] = false;
                opcionesDeJuego[1] = false;
                opcionesDeJuego[2] = false;
                opcionesDeJuego[3] = false;
                opcionesDeJuego[4] = false;
                opcionesDeJuego[5] = true;
                this.setIsWon(false);

            }

        }

        return opcionesDeJuego;

    }

    public ArrayList getCartas() {
        return cartas;
    }

    public void setCartas(Baraja cartas) {
        this.cartas = cartas;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public MontoFichas getMonto() {
        return monto;
    }

    public void setMonto(MontoFichas monto) {
        this.monto = monto;
    }

    public boolean isParticipe() {
        return participe;
    }

    public void setParticipe(boolean participe) {
        this.participe = participe;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public boolean isIsWon() {
        return isWon;
    }

    public void setIsWon(boolean isWon) {
        this.isWon = isWon;
    }

    public boolean isJugadorPlantado() {
        return jugadorPlantado;
    }

    public void setJugadorPlantado(boolean jugadorPlantado) {
        this.jugadorPlantado = jugadorPlantado;
    }

    public boolean isJugando() {
        return jugando;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }

    public boolean isIsEmpate() {
        return isEmpate;
    }

    public void setIsEmpate(boolean isEmpate) {
        this.isEmpate = isEmpate;
    }
    
    
    
    
    

}
