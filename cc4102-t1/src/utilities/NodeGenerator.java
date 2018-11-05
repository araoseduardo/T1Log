package utilities;

import misql.Node;
import misql.ProductNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class will be used for experimental purposes, to generate random input data.
 */
public class NodeGenerator {

    /**
     * This method will randomly generate a set of Node of type Product.
     * @param size is the amount of generated nodes desired.
     * @return an ArrayList<Node> with the generated product-nodes.
     */
    public ArrayList<Node> generateProductNodesArray(int size) {
        // Note: the id will be generated with incremental numbers so it does not contain duplicated
        // ids, but the list will be returned shuffled.
        Random random = new Random();

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i=1; i <= size; i++)
            nodes.add(ProductNode.randomProductNode(i, random));

        Collections.shuffle(nodes);
        return nodes;
    }

    public void generateProductNodesToFile(int size, String fileName) throws IOException {
        Random random = new Random();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

        ArrayList<Integer> ids = new ArrayList<>(); // Array with shuffled ids
        for (int i=1; i <= size; i++)
            ids.add(i);
        Collections.shuffle(ids);

        for (int id : ids)
            writer.append(ProductNode.randomProductNode(id, random).serialize()+"\n");
       

        writer.close();
    }
}
