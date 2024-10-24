public class Cazador extends Thread {
    private String nombre;
    private Mapa mapa;

    public Cazador(String nombre, Mapa mapa) {
        this.nombre = nombre;
        this.mapa = mapa;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Generar una nueva ubicación
                String nuevaUbicacion = mapa.generarUbicacion();
                
                // Mover al cazador a la nueva ubicación
                mapa.moverCazador(this, nuevaUbicacion);
                
                // Verificar si hay un monstruo en la nueva ubicación
                if (mapa.hayMonstruoEnUbicacion(nuevaUbicacion)) {
                    System.out.println(nombre + " ha encontrado un monstruo en " + nuevaUbicacion);
                }

                // Simular tiempo de espera
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " ha sido interrumpido.");
        }
    }
}
