/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

/**
 *
 * @author USER
 */
public class Pila {

    private Nodo nodo;
    private int elementos;

    public Pila() {
        this.elementos = 0;
        this.nodo = new Nodo();
    }

    public boolean isEmpty() {
        return elementos == 0;
    }

    public void agregarNodo(Nodo nuevoNodo) {
        if (isEmpty()) {
            nodo = nuevoNodo;
            elementos++;

        } else {
            nuevoNodo.setAtras(nodo);
            nodo.setSiguiente(nuevoNodo);
            nodo = nodo.getSiguiente();
            elementos++;
        }
    }

    public void verPila() {

        Nodo nodoTemporal = nodo;


        for (int i = 0; i < this.getElementos(); i++) {
            System.out.println("------------------------");
            System.out.println("Ficha");
            System.out.println("Valor: "+nodoTemporal.getFicha().getValor());
            System.out.println("Color: "+nodoTemporal.getFicha().getColor());
            System.out.println("Numeracion: "+nodoTemporal.getFicha().getNumeracion());
            System.out.println("------------------------");
            nodoTemporal = nodoTemporal.getAtras();
        }

    }

    public void verElemento()//ValorFicha
    {

    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

}
