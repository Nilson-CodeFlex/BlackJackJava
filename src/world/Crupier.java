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
public class Crupier extends Player
{
    private ArrayList baraja;
    private boolean cartaMostrada = false;
    private boolean cartaDosMostrada = false;

    

    public Crupier() {
    }

    public ArrayList getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList baraja) {
        this.baraja = baraja;
    }

    public boolean isCartaMostrada() {
        return cartaMostrada;
    }

    public void setCartaMostrada(boolean cartaMostrada) {
        this.cartaMostrada = cartaMostrada;
    }

    public boolean isCartaDosMostrada() {
        return cartaDosMostrada;
    }

    public void setCartaDosMostrada(boolean cartaDosMostrada) {
        this.cartaDosMostrada = cartaDosMostrada;
    }
    
    
    
    
    
}
