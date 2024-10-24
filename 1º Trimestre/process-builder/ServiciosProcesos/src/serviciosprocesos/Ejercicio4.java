/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package serviciosprocesos;

/**
 *
 * @author santi
 */
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        try {
            // Ejecutar otro programa Java pasando como argumento el nombre de un archivo
            ProcessBuilder processBuilder = new ProcessBuilder(
                "java", "EscribirArchivo", "archivo_salida.txt");

            Process process = processBuilder.start();
            process.waitFor(); // Esperar que termine

            System.out.println("El programa EscribirArchivo ha sido ejecutado.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
