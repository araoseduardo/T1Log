package misql;

import utilities.NodeGenerator;
import utilities.Util;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /* Testing of random generation of nodes of type Product */
        NodeGenerator ng = new NodeGenerator();
        int numberOfNodes = (int) Math.pow(10,2);
        System.out.println("- Generating " + Integer.toString(numberOfNodes) + " nodes -");
        ArrayList<Node> randomProducts = ng.generateProductNodes(numberOfNodes);
        Util.printArrayList(randomProducts);
    }
}
