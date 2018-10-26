package utilities;

import misql.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class will be used for experimental purposes, to generate random input data.
 */
public class NodeGenerator {
    private Random random;

    public NodeGenerator() {
        random = new Random();
    }

    private int randomIntBetween(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * This method will randomly generate a set of Node of type Product.
     * @param size is the amount of generated nodes desired.
     * @return an ArrayList<Node> with the generated product-nodes.
     */
    public ArrayList<Node> generateProductNodes(int size) {
        System.out.println(size);
        // Note: the id will be generated with incremental numbers so it does not contain duplicated
        // ids, but the list will be returned shuffled.

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i=1; i <= size; i++) {
            Node node = new Node();
            node.insert("id", Integer.toString(i));
            int precio = randomIntBetween(10000, 10000000);
            node.insert("precio", Integer.toString(precio));
            node.insert("puntosNec", Long.toString(Math.round(precio*0.0005)));
            node.insert("puntosRec", Long.toString(Math.round(precio*0.000025))); // Each 20 purchased, exchange one free.

            nodes.add(node);
        }

        Collections.shuffle(nodes);
        return nodes;
    }
}
