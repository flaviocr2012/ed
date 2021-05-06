package ed.fila;

public class TesteDaFila {

    public static void main(String[] args) {

        Fila fila = new Fila();

        fila.adiciona("Mauricio");
        fila.adiciona("Douglas");

        System.out.println(fila);

        fila.remove();
        System.out.println(fila);

        fila.vazia();
        System.out.println(fila);
    }


}
