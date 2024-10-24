import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

public class Mapa {
    private int size;
    private ConcurrentHashMap<String, String> ubicaciones;

    public Mapa(int size) {
        this.size = size;
        this.ubicaciones = new ConcurrentHashMap<>();
    }

    // Genera una ubicación aleatoria en el mapa
    public String generarUbicacion() {
        Random random = new Random();
        int x = random.nextInt(size);
        int y = random.nextInt(size);
        return x + "," + y;
    }

    // Mueve a un monstruo a una nueva ubicación
    public void moverMonstruo(Monstruo monstruo, String nuevaUbicacion) {
        ubicaciones.put(monstruo.getUbicacion(), nuevaUbicacion);
        System.out.println(monstruo.getUbicacion() + " se ha movido a " + nuevaUbicacion);
    }

    // Añade un monstruo en una ubicación específica del mapa
    public void agregarMonstruo(Monstruo monstruo) {
        ubicaciones.put(monstruo.getUbicacion(), monstruo.getUbicacion());
        System.out.println("Monstruo añadido en " + monstruo.getUbicacion());
    }

    // Verifica si hay un monstruo en una ubicación específica
    public boolean hayMonstruoEnUbicacion(String ubicacion) {
        return ubicaciones.containsKey(ubicacion);
    }

    // Remover un monstruo de una ubicación específica
    public void removerMonstruoDeUbicacion(String ubicacion) {
        ubicaciones.remove(ubicacion);
    }
}
