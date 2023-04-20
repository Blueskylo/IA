// Importamos las librerías necesarias
import net.sourceforge.jFuzzyLogic.FIS;

public class ClasificacionCH {

    public static void main(String[] args) {
    
        // Cargamos el archivo FCL
        String fileName = "clasificacion_hoteles.fcl";
        FIS fis = FIS.load(fileName,true);

        // Si el archivo FCL no se carga correctamente, se muestra un mensaje de error
        if( fis == null ) {
            System.err.println("No se pudo cargar el archivo: '"+fileName+"'");
            return;
        }

        // Definimos las entradas y las salidas
        fis.setVariable("limpieza", 7.5);
        fis.setVariable("comodidad", 8.0);
        fis.setVariable("servicios", 9.0);

        // Evaluamos las reglas
        fis.evaluate();

        // Obtenemos el valor de la salida
        double puntaje = fis.getVariable("puntaje").getValue();
        
        // Imprimimos el resultado
        System.out.println("El puntaje del hotel es: " + puntaje);
    }
}