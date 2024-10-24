public class Juego {
    public static void main(String[] args) throws InterruptedException {
        Mapa mapa = new Mapa(5);
        
        // Crear cazadores
        Cazador cazador1 = new Cazador("Cazador 1", mapa);
        Cazador cazador2 = new Cazador("Cazador 2", mapa);

        // Añadir algunos monstruos al mapa
        Monstruo monstruo1 = new Monstruo(mapa.generarUbicacion());
        Monstruo monstruo2 = new Monstruo(mapa.generarUbicacion());

        mapa.agregarMonstruo(monstruo1);
        mapa.agregarMonstruo(monstruo2);

        System.out.println("Monstruos generados: ");
        System.out.println(monstruo1);
        System.out.println(monstruo2);

        // Iniciar los cazadores
        cazador1.start();
        cazador2.start();

        // Ejecutar el juego por 10 segundos
        Thread.sleep(10000);

        // Interrumpir los cazadores y finalizar el juego
        cazador1.interrupt();
        cazador2.interrupt();

        // Esperar a que terminen
        cazador1.join();
        cazador2.join();

        System.out.println("Juego terminado.");
    }
}
