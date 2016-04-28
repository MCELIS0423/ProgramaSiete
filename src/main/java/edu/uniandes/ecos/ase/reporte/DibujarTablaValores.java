/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.reporte;

import edu.uniandes.ecos.ase.dto.CasoPrueba;
import java.util.List;

/**
 * @since 02/03/2016
 * @author mariocelis
 */
public class DibujarTablaValores {

    /**
     * Costructor de la aplicación
     */
    public DibujarTablaValores() {

    }

    /**
     * @since 02/03/2016
     * @param casosPrueba
     * @description Función encargada de dibujar los datos en consola, dibuja
     * los coeficientes
     */
    public void DibujarReporte(List<CasoPrueba> casosPrueba) {
        int i = 1;
        System.out.println("ORDEN");
        System.out.println("| NOMBRE | B0 | B1 | rxy | r^2 | yk |");
        for (CasoPrueba caso : casosPrueba) {
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("|" + caso.getNombre() + i + "|" + caso.getBetaCero() + "|" + caso.getBetaUno() + "|" + caso.getRxy() + "|" + caso.getrCuadrado() + "|" + caso.getYk() + "|");
            i++;
        }
    }

}