package misql;

import utilities.NodeGenerator;
import utilities.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * Generates random nodes of type Product by using an ArrayList and then saving the array's content into a File.
     * @throws IOException
     */
    private static void productNodesArrayToFile(String fileName, NodeGenerator ng, int numberOfNodes) throws IOException {
        System.out.println("\n* Generating Array of " + Integer.toString(numberOfNodes) + " nodes *");
        ArrayList<Node> randomProducts = ng.generateProductNodesArray(numberOfNodes);
        Util.saveNodesToFile(fileName, randomProducts);
        System.out.println("The nodes were saved to file '" + fileName + "' .");
        //Util.printArrayList(randomProducts);
    }


    /**
     * Generates random nodes of type Product saving them directly into a File.
     * @throws IOException
     */
    private static void productNodesFile(String fileName, NodeGenerator ng, int numberOfNodes) throws IOException {
        System.out.println("\n* Generating " + Integer.toString(numberOfNodes) + " nodes *");
        ng.generateProductNodesToFile(numberOfNodes, fileName);
        System.out.println("The nodes were saved to file '" + fileName + "' .");
    }

    public static void main(String[] args) throws IOException {
        /* Setting initial data */
        String fileName = "data/input/random_product_nodes.txt";
        long startTime, stopTime, firstElapsedTime, secondElapsedTime;
        NodeGenerator ng = new NodeGenerator();
        int numberOfNodes;

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        while (true) {
            System.out.println("Enter the number of the power of 10 to generate nodes: ");
            int n = reader.nextInt();
            if (n < 0 || n > 7)
                System.out.println("\nPlease consider only numbers from 0 to 7\n");

            numberOfNodes = (int) Math.pow(10, n);
            break;
        }
        reader.close();

        /*
        // Testing of random generation of nodes of type Product <ArrayList approach>
        startTime = System.currentTimeMillis();
        productNodesArrayToFile(fileName, ng, numberOfNodes);
        stopTime = System.currentTimeMillis();
        firstElapsedTime = stopTime - startTime;
        System.out.println("--Elapsed time: " + firstElapsedTime + "\n");
        */

        /* Testing of random generation of nodes of type Product <DirectToFile approach> */
        startTime = System.currentTimeMillis();
        productNodesFile(fileName, ng, numberOfNodes);
        stopTime = System.currentTimeMillis();
        secondElapsedTime = stopTime - startTime;
        System.out.println("--Elapsed time: " + secondElapsedTime + "\n");

    }
}
