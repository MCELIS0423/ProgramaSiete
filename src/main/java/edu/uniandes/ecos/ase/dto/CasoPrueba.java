/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.dto;

import java.io.Serializable;

/**
 * @since 02/03/2016
 * @author mariocelis
 * @Description DTO con los atributos de una prueba
 */
public class CasoPrueba implements Serializable{
    
    private String nombre;
    private double betaCero;
    private double betaUno;
    private double rxy;
    private double rCuadrado;
    private double yk;
    private double significancia;
    private double rango;
    private double upi;
    private double lpi;

    public double getBetaCero() {
        return betaCero;
    }

    public void setBetaCero(double betaCero) {
        this.betaCero = betaCero;
    }

    public double getBetaUno() {
        return betaUno;
    }

    public void setBetaUno(double betaUno) {
        this.betaUno = betaUno;
    }

    public double getRxy() {
        return rxy;
    }

    public void setRxy(double rxy) {
        this.rxy = rxy;
    }

    public double getrCuadrado() {
        return rCuadrado;
    }

    public void setrCuadrado(double rCuadrado) {
        this.rCuadrado = rCuadrado;
    }

    public double getYk() {
        return yk;
    }

    public void setYk(double yk) {
        this.yk = yk;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSignificancia() {
        return significancia;
    }

    public void setSignificancia(double significancia) {
        this.significancia = significancia;
    }

    public double getRango() {
        return rango;
    }

    public void setRango(double rango) {
        this.rango = rango;
    }

    public double getUpi() {
        return upi;
    }

    public void setUpi(double upi) {
        this.upi = upi;
    }

    public double getLpi() {
        return lpi;
    }

    public void setLpi(double lpi) {
        this.lpi = lpi;
    }
   
}