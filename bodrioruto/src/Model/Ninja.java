/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author camper
 */
public class Ninja {
    private String nombre;
    private String rango;
    private String aldea;
    
    
    public Ninja (String nombre, String rango, String aldea){

        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
    }
    
    public Ninja(){}
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    @Override
    public String toString() {
        return "Ninja{, nombre=" + nombre + ", rango=" + rango + ", aldea=" + aldea + '}';
    }
    
    
    
}
