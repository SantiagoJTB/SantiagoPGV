/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package serviciosprocesos;

/**
 *
 * @author santi
 */
import java.io.File;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            // Crear un ProcessBuilder para ejecutar el comando dir
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "dir");

            // Redirigir la salida a un archivo
            File outputFile = new File("salida_comando.txt");
            processBuilder.redirectOutput(outputFile);

            // Iniciar el proceso
            Process process = processBuilder.start();
            process.waitFor(); // Esperar a que el proceso termine

            System.out.println("Comando ejecutado, la salida está en 'salida_comando.txt'.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
