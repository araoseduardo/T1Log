package misql;

public class Main {
    public static void main(String[] args) {

        Node myNode = new Node();
        myNode.insertarFila("id", "1");
        myNode.insertarFila("puntos", "34553");
        System.out.println(myNode.oneLine());
    }
}
