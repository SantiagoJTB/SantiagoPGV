import java.util.concurrent.Semaphore;

public class Cazador implements Runnable {
    private String nombre;
    private Mapa mapa;
    private Semaphore cueva;

    public Cazador(String nombre, Mapa mapa, Semaphore cueva) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.cueva = cueva;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Patrullar el mapa buscando monstruos
                String ubicacion = mapa.generarUbicacion();
                System.out.println(nombre + " patrullando en " + ubicacion);

                // Verificar si algún monstruo ha salido de la cueva
                if (mapa.hayMonstruoEnUbicacion(ubicacion)) {
                    System.out.println(nombre + " ha capturado un monstruo en " + ubicacion);
                    mapa.removerMonstruoDeUbicacion(ubicacion); // Capturar monstruo
                }

                // Simular tiempo de patrullaje
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " ha sido interrumpido.");
        }
    }
}
