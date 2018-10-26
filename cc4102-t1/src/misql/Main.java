package misql;

public class Main {
    public static void main(String[] args) {

        Nodo myNodo = new Nodo();
        myNodo.insertarFila("id", "1");
        myNodo.insertarFila("puntos", "34553");
        System.out.println(myNodo.oneLine());
    }
}
