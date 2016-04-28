/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.calculo;

import edu.uniandes.ecos.ase.dto.CasoPrueba;
import edu.uniandes.ecos.ase.utilidad.Constantes;
import java.util.List;

/**
 * @since 02/03/2016
 * @author mariocelis
 * @Description Clase que contiene los métodos para realizar cáculos
 * estádísticos
 */
public class CalculoCoeficientes implements ICalculoEstadistica {

    public CalculoCoeficientes() {

    }

    /**
     * @since 02/03/2016
     * @param datos
     * @return La sumatoria de todos los números ingresados como parámetros a
     * través de una lista
     */
    public Double sumatoria(List<String> datos) {
        double sumatoria = 0;
        try {
            for (String dato : datos) {
                sumatoria += Double.valueOf(dato);
            }
        } catch (Exception e) {
            System.out.println("Error calculando la sumatoria el primer "
                    + "conjunto de datos. Detalle: " + e.getMessage());
        }
        return sumatoria;
    }

    /**
     * @since 02/03/2016
     * @param datos
     * @return El promedio de todos los números ingresados como parámetros a
     * través de una lista
     */
    public Double promedio(List<String> datos) {
        Integer numeroRegistros;
        Double media = null;
        double sumatoria = 0;
        numeroRegistros = datos.size();
        try {
            if (numeroRegistros != 0) {
                for (String dato : datos) {
                    sumatoria += Double.parseDouble(dato);
                }
                media = sumatoria / numeroRegistros;
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error en el calculo de la media "
                    + "- Detalle: " + e.getMessage());
        }
        return media;
    }

    /**
     * @since 02/03/2016
     * @param datos
     * @return retorna la sumatoria elevada al cuadrado de una lista de números
     */
    public Double sumatoriaCuadrado(List<String> datos) {
        double sumatoria = 0;
        try {
            for (String dato : datos) {
                sumatoria += Math.pow((Double.valueOf(dato)), 2);
            }
        } catch (Exception e) {
            System.out.println("Error calculando la sumatoria al cuadrado: "
                    + e.getMessage());
        }
        return sumatoria;
    }

    /**
     * @since 02/03/2016
     * @param datosConjuntoUno
     * @param datosConjuntoDos
     * @return la sumatoria del producto uno a uno de cada valor de las listas
     * ingresadas como parámetros
     */
    public Double sumatoriaXY(List<String> datosConjuntoUno, List<String> datosConjuntoDos) {
        double sumatoria = 0;
        int i = 0;
        try {
            for (String dato : datosConjuntoUno) {
                sumatoria += (Double.parseDouble(dato)) * (Double.parseDouble(datosConjuntoDos.get(i)));
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error calculando la sumatoria de la "
                    + "multiplicación entre dos set de datos: "
                    + e.getMessage());
        }
        return sumatoria;
    }

    /**
     * @since 02/03/2016
     * @param datosConjuntoUno
     * @param datosConjuntoDos
     * @return Cálculo del coeficiente B0 de la regresión lineal
     */
    public Double betaCero(List<String> datosConjuntoUno, List<String> datosConjuntoDos) {
        double betaUno = 0;
        double promedioY = 0;
        double promedioX = 0;
        double betaCero = 0;
        try {
            betaUno = betaUno(datosConjuntoUno, datosConjuntoDos);
            promedioY = promedio(datosConjuntoDos);
            promedioX = promedio(datosConjuntoUno);
            betaCero = promedioY - (betaUno * promedioX);
        } catch (Exception e) {
            System.out.println("Error calculando B0: "
                    + e.getMessage());
        }
        return betaCero;
    }

    /**
     * @since 02/03/2016
     * @param datosConjuntoUno
     * @param datosConjuntoDos
     * @return Cálculo del coeficiente B1 de la regresión lineal
     */
    public Double betaUno(List<String> datosConjuntoUno, List<String> datosConjuntoDos) {
        Integer n = 0;
        double sumatoriaXY = 0;
        double promedioX = 0;
        double promedioY = 0;
        double sumatoriaXCuadrado = 0;
        double betaUno = 0;
        try {
            n = datosConjuntoUno.size();
            sumatoriaXY = sumatoriaXY(datosConjuntoUno, datosConjuntoDos);
            promedioX = promedio(datosConjuntoUno);
            promedioY = promedio(datosConjuntoDos);
            sumatoriaXCuadrado = sumatoriaCuadrado(datosConjuntoUno);
            betaUno = ((sumatoriaXY - (n * promedioX * promedioY)) / (sumatoriaXCuadrado - (n * (Math.pow(promedioX, 2)))));
        } catch (Exception e) {
            System.out.println("Error calculando B1: "
                    + e.getMessage());
        }
        return betaUno;
    }

    /**
     * @since 02/03/2016
     * @param datosConjuntoUno
     * @param datosConjuntoDos
     * @return Coeficiente de correlación
     */
    public Double rxy(List<String> datosConjuntoUno, List<String> datosConjuntoDos) {
        Integer n = 0;
        double sumatoriaXY = 0;
        double sumatoriaX = 0;
        double sumatoriaY = 0;
        double sumatoriaXCuadrado = 0;
        double sumatoriaYCuadrado = 0;
        double coeficienteRxy = 0;
        try {
            n = datosConjuntoUno.size();
            sumatoriaXY = sumatoriaXY(datosConjuntoUno, datosConjuntoDos);
            sumatoriaX = sumatoria(datosConjuntoUno);
            sumatoriaY = sumatoria(datosConjuntoDos);
            sumatoriaXCuadrado = sumatoriaCuadrado(datosConjuntoUno);
            sumatoriaYCuadrado = sumatoriaCuadrado(datosConjuntoDos);
            coeficienteRxy = ((n * sumatoriaXY - (sumatoriaX * sumatoriaY)) / (Math.sqrt((n * sumatoriaXCuadrado - Math.pow(sumatoriaX, 2)) * (n * sumatoriaYCuadrado - Math.pow(sumatoriaY, 2)))));
        } catch (Exception e) {
            System.out.println("Error calculando el coeficiente rxy: "
                    + e.getMessage());
        }
        return coeficienteRxy;
    }

    /**
     * @since 02/03/2016
     * @param rxy
     * @return Coeficiente de correlación al cuadrado
     */
    public Double rCuadrado(double rxy) {
        double rCuadrado = 0;
        try {
            rCuadrado = Math.pow(rxy, 2);
        } catch (Exception e) {
            System.out.println("Error calculando el coeficiente r cuadrado: "
                    + e.getMessage());
        }
        return rCuadrado;
    }

    /**
     * @since 02/03/2016
     * @param datosConjuntoUno
     * @param datosConjuntoDos
     * @return Valor de la ecuación de la recta de la regresión lineal
     */
    public Double yk(List<String> datosConjuntoUno, List<String> datosConjuntoDos) {
        double yk = 0;
        double betaCero = 0;
        double betaUno = 0;
        try {
            betaCero = betaCero(datosConjuntoUno, datosConjuntoDos);
            betaUno = betaUno(datosConjuntoUno, datosConjuntoDos);
            yk = betaCero + betaUno * (Constantes.XK);
        } catch (Exception e) {
            System.out.println("Error calculando el coeficiente Yk: "
                    + e.getMessage());
        }
        return yk;
    }

    /**
     * @since 02/03/2016
     * @param datosConjuntoUno
     * @param datosConjuntoDos
     * @return DTO con todos los coeficientes para un caso de prueba específico
     */
    public CasoPrueba obtenerCoeficientes(List<String> datosConjuntoUno, List<String> datosConjuntoDos) {
        double betaCero = 0;
        double betaUno = 0;
        double rxy = 0;
        double rCuadrado = 0;
        double yk = 0;
        CasoPrueba casoPrueba = new CasoPrueba();
        try {
            betaCero = betaCero(datosConjuntoUno, datosConjuntoDos);
            betaUno = betaUno(datosConjuntoUno, datosConjuntoDos);
            rxy = rxy(datosConjuntoUno, datosConjuntoDos);
            rCuadrado = rCuadrado(rxy);
            yk = yk(datosConjuntoUno, datosConjuntoDos);
            
            casoPrueba.setNombre(Constantes.NOMBRE_CASO_PRUEBA);
            casoPrueba.setBetaCero(betaCero);
            casoPrueba.setBetaUno(betaUno);
            casoPrueba.setRxy(rxy);
            casoPrueba.setYk(yk);
            casoPrueba.setrCuadrado(rCuadrado);
        } catch (Exception e) {
            System.out.println("Error calculando los coeficientes. Excepción "
                    + e.getMessage());
        }
        return casoPrueba;
    }

    /**
     * Se obtiene el valor de la significancia
     * @param rxy
     * @param numeroDatos
     * @return el valor de la significancia
     */
    @Override
    public double calcularSignificancia(double rxy, Integer numeroDatos) {
        double significancia = 0;
        try {
            significancia = (((Math.abs(rxy))*(Math.sqrt(numeroDatos-2)))/(Math.sqrt((1-(Math.pow(rxy, 2))))));
        } catch (Exception e) {
            System.out.println("Error calculando la significancia. Excepción "
                    + e.getMessage());
        }
        return significancia;
    }

     /**
     * Calculo del rango
     * @return valor del rango
     */
    @Override
    public double rango() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Obtiene el valor del upi
     * @param rango
     * @param  yk
     * @return valor del upi
     */
    @Override
    public double upi(double yk, double rango) {
        return yk + rango;
    }

     /**
     * Obtiene el valor de lpi
     * @param rango
     * @param  yk
     * @return valor del lpi
     */
    @Override
    public double lpi(double yk, double rango) {
        return yk - rango;
    }
}