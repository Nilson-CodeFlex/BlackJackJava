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
public class Baraja extends ArrayList {

    private int numAS = 0;
    private boolean thAs= false;
    public int[] getSumaBaraja() {

        //Posicion 0 del array es una sumaMaxima
        //Posicion 1 del array es una sumaMinima
        int[] sumas = new int[2];

        sumas[0] = 0;
        sumas[1] = 0;
        
        int cantAS = 0;

        for (int i = 0; i < this.size(); i++) {
            int valorCarta = ((Carta) this.get(i)).getValor();

            if (valorCarta == -1) {
                cantAS++;
                this.setThAs(true);
                sumas[0] += 11;

            } else {

                sumas[0] += valorCarta;

            }

        }
        this.setNumAS(cantAS);

        if (this.isThAs()) {
            
            for (int i = 0; i < this.getNumAS(); i++) {
                sumas[1] += 1;
                
            }
            
            
            for (int i = 0; i < this.size(); i++) {
                int valorCarta = ((Carta) this.get(i)).getValor();
                if (valorCarta != -1) {
                    sumas[1] += valorCarta;
                }

            }
        }

        return sumas;
    }

    public int getNumAS() {
        return numAS;
    }

    public void setNumAS(int numAS) {
        this.numAS = numAS;
    }

    public boolean isThAs() {
        return thAs;
    }

    public void setThAs(boolean thAs) {
        this.thAs = thAs;
    }

    

}
