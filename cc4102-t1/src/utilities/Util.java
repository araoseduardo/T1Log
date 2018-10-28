package utilities;

import misql.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Util {

    public static void HelloWorld() {
        System.out.print("Güena!" + '\n');
    }

    public static void printArrayList(ArrayList<Node> nodeList) {
        for (Node node : nodeList)
            System.out.println(node.oneLine());
    }

    public static void saveNodesToFile(String fileName, ArrayList<Node> nodeArray) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

        for (Node node : nodeArray)
            writer.append(node.oneLine()+"\n");

        writer.close();
    }

}
