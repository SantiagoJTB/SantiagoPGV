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

    // Mueve a un cazador a una nueva ubicación
    public void moverCazador(Cazador cazador, String nuevaUbicacion) {
        ubicaciones.put(cazador.getNombre(), nuevaUbicacion);
        System.out.println(cazador.getNombre() + " se ha movido a " + nuevaUbicacion);
    }

    // Añade un monstruo en una ubicación específica del mapa
    public void agregarMonstruo(Monstruo monstruo) {
        ubicaciones.put("Monstruo_" + ubicaciones.size(), monstruo.getUbicacion());
        System.out.println("Monstruo añadido en " + monstruo.getUbicacion());
    }

    // Verifica si hay un monstruo en una ubicación específica
    public boolean hayMonstruoEnUbicacion(String ubicacion) {
        for (String key : ubicaciones.keySet()) {
            if (key.startsWith("Monstruo_") && ubicaciones.get(key).equals(ubicacion)) {
                return true;
            }
        }
        return false;
    }

    // Obtener el mapa de ubicaciones
    public ConcurrentHashMap<String, String> getUbicaciones() {
        return ubicaciones;
    }
}
