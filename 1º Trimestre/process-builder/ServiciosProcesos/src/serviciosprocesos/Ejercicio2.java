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

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            // Primer proceso: ping
            ProcessBuilder pingProcess = new ProcessBuilder("ping", "google.com");
            Process process1 = pingProcess.start();
            process1.waitFor(); // Esperar a que el proceso termine
            System.out.println("Ping finalizado.\n");

            // Segundo proceso: dir (o ls)
            ProcessBuilder dirProcess = new ProcessBuilder("cmd", "/c", "dir");
            Process process2 = dirProcess.start();
            process2.waitFor(); // Esperar a que el proceso termine
            System.out.println("Dir finalizado.\n");

            // Tercer proceso: echo
            ProcessBuilder echoProcess = new ProcessBuilder("cmd", "/c", "echo", "¡Comandos ejecutados!");
            Process process3 = echoProcess.start();
            process3.waitFor(); // Esperar a que el proceso termine
            System.out.println("Echo finalizado.\n");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

