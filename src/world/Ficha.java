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
public class Ficha
{
    private String Color;
    private int valor;//Valor en dinero
    private int numeracion;

    
    
    public Ficha(String Color, int valor, int numeracion) {
        this.Color = Color;
        this.valor = valor;
        this.numeracion = numeracion;
    }
    
    public Ficha()
    {
        
        
    }

    
    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }
    
    
    
    
}
