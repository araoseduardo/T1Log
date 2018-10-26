package misql;

public class Main {

    public static void main(String[] args) {
        Node myNode = new Node();
        myNode.insert("id", "1");
        myNode.insert("puntos", "34553");
        System.out.println(myNode.oneLine());
    }
}
