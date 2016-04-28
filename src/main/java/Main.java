
import java.util.ArrayList;

import static spark.Spark.*;
import static spark.Spark.get;

import edu.uniandes.ecos.ase.calculo.CalculoCoeficientes;
import edu.uniandes.ecos.ase.dto.CasoPrueba;
import edu.uniandes.ecos.ase.reporte.DibujarTablaValores;
import edu.uniandes.ecos.ase.utilidad.Constantes;
import edu.uniandes.ecos.ase.utilidad.LeerDatosFuenteExterna;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        get("/correlacion", (req, res) -> {
            String retorno;
            List<String> datosEPS = new ArrayList<String>();
            List<String> datosAAMS = new ArrayList<String>();
            List<String> datosPAMS = new ArrayList<String>();
            List<String> datosADH = new ArrayList<String>();
            List<CasoPrueba> casosPrueba = new ArrayList<CasoPrueba>();

            LeerDatosFuenteExterna leerDatosFuenteExterna = new LeerDatosFuenteExterna();
            CalculoCoeficientes calculoCoeficientes = new CalculoCoeficientes();
            DibujarTablaValores dibujarTablaValores = new DibujarTablaValores();
            datosEPS = leerDatosFuenteExterna.leerArchivoPlano("src/main/resources/archivo/EstimatedProxySize.txt");
            datosAAMS = leerDatosFuenteExterna.leerArchivoPlano("src/main/resources/archivo/ActualAddedAndModifiedSize.txt");
            datosPAMS = leerDatosFuenteExterna.leerArchivoPlano("src/main/resources/archivo/PlanAddedAndModifiedSize.txt");
            datosADH = leerDatosFuenteExterna.leerArchivoPlano("src/main/resources/archivo/ActualDevelopmentHours.txt");

            //Caso de prueba 1
            CasoPrueba casoPruebaUno = new CasoPrueba();
            casoPruebaUno = calculoCoeficientes.obtenerCoeficientes(datosEPS, datosAAMS);
            casoPruebaUno.setSignificancia(Constantes.SIGNIFICANCIA_CASO_UNO);
            casoPruebaUno.setRango(Constantes.RANGO_CASO_UNO);
            casoPruebaUno.setUpi(calculoCoeficientes.upi(casoPruebaUno.getYk(), Constantes.RANGO_CASO_UNO));
            casoPruebaUno.setLpi(calculoCoeficientes.lpi(casoPruebaUno.getYk(), Constantes.RANGO_CASO_UNO));
            casosPrueba.add(casoPruebaUno);

            //Caso de prueba 2
            CasoPrueba casoPruebaDos = new CasoPrueba();
            casoPruebaDos = calculoCoeficientes.obtenerCoeficientes(datosEPS, datosADH);
            casoPruebaDos.setSignificancia(Constantes.SIGNIFICANCIA_CASO_DOS);
            casoPruebaDos.setRango(Constantes.RANGO_CASO_DOS);
            casoPruebaDos.setUpi(calculoCoeficientes.upi(casoPruebaDos.getYk(), Constantes.RANGO_CASO_DOS));
            casoPruebaDos.setLpi(calculoCoeficientes.lpi(casoPruebaDos.getYk(), Constantes.RANGO_CASO_DOS));
            casosPrueba.add(casoPruebaDos);

            dibujarTablaValores.DibujarReporte(casosPrueba);
            retorno = "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<style>"
                    + "table, th, td {"
                    + "border: 1px solid black;"
                    + "border-collapse: collapse;"
                    + "}"
                    + "th, td {"
                    + "padding: 5px;"
                    + "text-align: left;"
                    + "}"
                    + "table#t01 {"
                    + "width: 100%;    "
                    + "background-color: #A9BCF5;"
                    + "}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<table id=\"t01\">"
                    + "<tbody>"
                    + "<tr>"
                    + "<th>rxy</th>"
                    + "<th>r^2</th>"
                    + "<th>Significancia</th>"
                    + "<th>B0</th>"
                    + "<th>B1</th>"
                    + "<th>yk</th>"
                    + "<th>Rango</th>"
                    + "<th>UPI</th>"
                    + "<th>LPI</th>"
                    + "</tr>";
            int i = 1;
            for (CasoPrueba casoPrueba : casosPrueba) {
                retorno += "<tr>"
                        + "<td>" + casoPrueba.getRxy() + i + "</td>"
                        + "<td>" + casoPrueba.getrCuadrado() + i + "</td>"
                        + "<td>" + casoPrueba.getSignificancia() + i + "</td>"
                        + "<td>" + casoPrueba.getBetaCero() + "</td>"
                        + "<td>" + casoPrueba.getBetaUno() + "</td>"
                        + "<td>" + casoPrueba.getYk() + "</td>"
                        + "<td>" + casoPrueba.getRango() + "</td>"
                         + "<td>" + casoPrueba.getUpi() + "</td>"
                         + "<td>" + casoPrueba.getLpi() + "</td>"
                        + "</tr>";
                i++;
            }
            retorno += "</tbody>"
                    + "</table>"
                    + "</body>"
                    + "</html>";
            return retorno;
        });

    }
}
