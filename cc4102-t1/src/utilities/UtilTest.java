package utilities;

import misql.Node;

import java.util.ArrayList;

public class UtilTest {

    public static void main(String[] args) {

        /* Testing of method printArrayList*/
        ArrayList<Node> nodes = new ArrayList<>();
        Node nodeOne = new Node();
        Node nodeTwo = new Node();
        Node nodeThree = new Node();
        nodeOne.insert("id", "5");
        nodeTwo.insert("id", "7");
        nodeThree.insert("id", "2");
        nodes.add(nodeOne);
        nodes.add(nodeTwo);
        nodes.add(nodeThree);
        Util.printArrayList(nodes);
    }
}
