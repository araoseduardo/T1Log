package misql;

import utilities.NodeGenerator;
import utilities.Util;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static void productNodes() throws IOException {
        String fileName = "data/input/random_product_nodes.txt";
        NodeGenerator ng = new NodeGenerator();
        int numberOfNodes = (int) Math.pow(10,3);
        System.out.println("- Generating " + Integer.toString(numberOfNodes) + " nodes -");
        ArrayList<Node> randomProducts = ng.generateProductNodes(numberOfNodes);
        Util.saveNodesToFile(fileName, randomProducts);
        System.out.println("\nThe nodes were saved to file '" + fileName + "' .\n");
        //Util.printArrayList(randomProducts);
    }

    public static void main(String[] args) throws IOException {
        /* Testing of random generation of nodes of type Product */
        productNodes();
    }
}
