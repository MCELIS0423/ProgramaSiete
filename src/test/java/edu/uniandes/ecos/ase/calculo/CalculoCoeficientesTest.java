/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.calculo;

import edu.uniandes.ecos.ase.dto.CasoPrueba;
import edu.uniandes.ecos.ase.utilidad.Constantes;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mariocelis
 */
public class CalculoCoeficientesTest {
    
    public CalculoCoeficientesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of rango method, of class CalculoCoeficientes.
     */
    @Test
    public void testRango() {
        System.out.println("rango");
        CalculoCoeficientes instance = new CalculoCoeficientes();
        double expResult = 230.0017197;
        double result = Constantes.RANGO_CASO_UNO;
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of upi method, of class CalculoCoeficientes.
     */
    @Test
    public void testUpi() {
        System.out.println("upi");
        double yk = 644.4293838;
        double rango = Constantes.RANGO_CASO_UNO;
        CalculoCoeficientes instance = new CalculoCoeficientes();
        double expResult = 874.4311035;
        double result = instance.upi(yk, rango);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of lpi method, of class CalculoCoeficientes.
     */
    @Test
    public void testLpi() {
        System.out.println("lpi");
        double yk = 644.4293838;
        double rango = Constantes.RANGO_CASO_UNO;
        CalculoCoeficientes instance = new CalculoCoeficientes();
        double expResult = 414.4276641;
        double result = instance.lpi(yk, rango);
        assertEquals(expResult, result, 0.0);
    }
    
}
