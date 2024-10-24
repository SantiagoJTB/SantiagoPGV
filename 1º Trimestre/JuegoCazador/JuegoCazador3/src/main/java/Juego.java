import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Juego {
    public static void main(String[] args) throws InterruptedException {
        int numMonstruos = 5;
        int numCazadores = 3;

        // Crear el mapa
        Mapa mapa = new Mapa(5);

        // Crear la cueva con capacidad limitada (la mitad del número de monstruos)
        Semaphore cueva = new Semaphore(numMonstruos / 2);

        // Crear un ThreadPool para gestionar la concurrencia
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // Crear cazadores
        for (int i = 1; i <= numCazadores; i++) {
            Cazador cazador = new Cazador("Cazador " + i, mapa, cueva);
            pool.submit(cazador);
        }

        // Crear monstruos
        for (int i = 1; i <= numMonstruos; i++) {
            Monstruo monstruo = new Monstruo("Monstruo " + i, mapa, cueva);
            mapa.agregarMonstruo(monstruo);
            pool.submit(monstruo);
        }

        // Esperar por un tiempo y luego terminar la simulación
        Thread.sleep(10000);
        pool.shutdownNow(); // Interrumpir todos los hilos
        System.out.println("Juego terminado.");
    }
}
