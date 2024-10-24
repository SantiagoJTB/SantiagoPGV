/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package serviciosprocesos;

/**
 *
 * @author santi
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ejercicio5 {
    public static void main(String[] args) {
        try {
            // Ejecutar un comando erróneo
            ProcessBuilder processBuilder = new ProcessBuilder("comandoInexistente");

            // Ejecutar el proceso
            Process process = processBuilder.start();

            // Capturar la salida de error
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = errorReader.readLine()) != null) {
                System.out.println("Error: " + line);
            }

            // Esperar que el proceso termine
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
