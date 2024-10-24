public class Monstruo {
    private String ubicacion;

    public Monstruo(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return "Monstruo en " + ubicacion;
    }
}
