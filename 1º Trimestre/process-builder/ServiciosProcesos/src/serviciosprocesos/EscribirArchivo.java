/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package serviciosprocesos;

/**
 *
 * @author santi
 */
import java.io.FileWriter;
import java.io.IOException;

public class EscribirArchivo {
    public static void main(String[] args) {
        if (args.length > 0) {
            String fileName = args[0];
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write("Hola Mundo\n");
                System.out.println("Escrito 'Hola Mundo' en el archivo: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se ha proporcionado el nombre del archivo.");
        }
    }
}
