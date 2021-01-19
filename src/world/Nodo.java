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
public class Nodo
{
    private Ficha ficha;
    private Nodo siguiente;
    private Nodo atras;

    public Nodo(Ficha ficha, Nodo siguiente, Nodo atras) {
        this.ficha = ficha;
        this.siguiente = siguiente;
        this.atras = atras;
    }
    public Nodo(Ficha ficha) {
    this.ficha = ficha;
    siguiente = null;
    atras = null;
    }
    
    public Nodo()
    {
    
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }

    
    
    
    
    
   
}
