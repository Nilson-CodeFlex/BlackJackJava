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
public class Carta {

    private String lon; //Letra o numero
    private String color;
    private String figura;
    private String src = "none";
    private boolean isPreDraw;

    public Carta(String carta, String color, String figura) {
        this.lon = carta;
        this.color = color;
        this.figura = figura;
        this.isPreDraw = true;

    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public String getCarta() {
        return lon;
    }

    public void setCarta(String carta) {
        this.lon = carta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;

    }

    public void setIsPreDraw(boolean isPreDraw) {
        this.isPreDraw = isPreDraw;
    }

    public boolean isIsPreDraw() {
        return isPreDraw;
    }

    public int getValor() {
        int valor = 0;
        if (this.getCarta().equalsIgnoreCase("J") || this.getCarta().equalsIgnoreCase("Q") || this.getCarta().equalsIgnoreCase("K")) {

            valor = 10;
        } else if (this.getCarta().equalsIgnoreCase("A")) {
            valor = -1;
        } else {
            valor = Integer.parseInt(this.getCarta());
        }

        return valor;
    }

}
