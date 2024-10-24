import java.util.concurrent.Semaphore;

public class Monstruo implements Runnable {
    private String nombre;
    private String ubicacion;
    private Mapa mapa;
    private Semaphore cueva;

    public Monstruo(String nombre, Mapa mapa, Semaphore cueva) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.cueva = cueva;
        this.ubicacion = mapa.generarUbicacion();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Intentar entrar en la cueva
                System.out.println(nombre + " intentando entrar en la cueva.");
                cueva.acquire(); // Adquirir permiso para entrar

                System.out.println(nombre + " ha entrado en la cueva.");
                Thread.sleep(3000); // Quedarse un rato en la cueva

                // Salir de la cueva
                System.out.println(nombre + " ha salido de la cueva.");
                cueva.release(); // Liberar permiso al salir

                // Colocarse en una nueva ubicación fuera de la cueva
                ubicacion = mapa.generarUbicacion();
                mapa.moverMonstruo(this, ubicacion);

                Thread.sleep(2000); // Simular el tiempo fuera de la cueva
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " ha sido interrumpido.");
        }
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
