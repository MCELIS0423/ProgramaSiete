/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.calculo;

import edu.uniandes.ecos.ase.dto.CasoPrueba;
import java.util.List;

/**
 *
 * @author mariocelis
 * @since 02/03/2016
 * @description Interfaz con el diseño de los métodos necesarios para calcular
 * los coeficientes de una regresión lineal y una correclación
 */
public interface ICalculoEstadistica {

    /**
     *
     * @param datos
     * @return Resultado de la sumatoria de todos los números ingresados, para
     * el caso del conjunto de datos 1
     */
    public Double sumatoria(List<String> datos);

    /**
     *
     * @param datos
     * @return Promedio de los parámetros ingresados, conjunto de datos 1
     */
    public Double promedio(List<String> datos);

    /**
     *
     * @param datos
     * @return Sumatoria de todos los datos ingresados con exponente 2, conjunto
     * de datos 1
     */
    public Double sumatoriaCuadrado(List<String> datos);

    /**
     *
     * @param datosConjuntoUno
     * @param datosConjuntoDos 
     * @return Sumatoria de la multiplicación entre el conjunto de datos 1 y 2
     */
    public Double sumatoriaXY(List<String> datosConjuntoUno, 
            List<String> datosConjuntoDos);

    /**
     * @param datosConjuntoUno 
     * @param datosConjuntoDos 
     * @return Retorna el resultado de la formula para el cálculo del
     * coeficiente B0
     */
    public Double betaCero(List<String> datosConjuntoUno, List<String> datosConjuntoDos);

    /**
     * @param datosConjuntoUno 
     * @param datosConjuntoDos
     * @return Retorna el resultado de la formula para el cálculo del
     * coeficiente B1
     */
    public Double betaUno(List<String> datosConjuntoUno, List<String> datosConjuntoDos);

    /**
     * @param datosConjuntoUno 
     * @param datosConjuntoDos
     * @return Retorna el resultado del coeficiente de correlación
     */
    public Double rxy(List<String> datosConjuntoUno, List<String> datosConjuntoDos);

    /**
     * @param rxy 
     * @return Retorna el resultado del coeficiente de correlación
     */
    public Double rCuadrado(double rxy);

    /**
     * @param datosConjuntoUno 
     * @param datosConjuntoDos 
     * @return Retorna valor de predicción
     */
    public Double yk(List<String> datosConjuntoUno, List<String> datosConjuntoDos);
    
     /**
     * @since 02/03/2016
     * @param datosConjuntoUno
     * @param datosConjuntoDos
     * @return DTO con todos los coeficientes para un caso de prueba específico
     */
    public CasoPrueba obtenerCoeficientes(List<String> datosConjuntoUno, List<String> datosConjuntoDos);
    
    /**
     * Se obtiene el valor de la significancia
     * @param rxy
     * @param numeroDatos
     * @return el valor de la significancia
     */
    public double calcularSignificancia(double rxy, Integer numeroDatos);
    
    /**
     * Calculo del rango
     * @return valor del rango
     */
    public double rango();
    
    /**
     * Obtiene el valor del upi
     * @param rango
     * @return valor del upi
     */
    public double upi(double yk, double rango);
    
    /**
     * Obtiene el valor de lpi
     * @param rango
     * @return valor del lpi
     */
    public double lpi(double yk, double rango);
    
}