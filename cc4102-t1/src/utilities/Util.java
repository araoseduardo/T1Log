package utilities;

import misql.Node;

import java.util.ArrayList;

public class Util {

    public static void HelloWorld() {
        System.out.print("Güena!" + '\n');
    }

    public static void printArrayList(ArrayList<Node> nodeList) {
        for (Node node : nodeList)
            System.out.println(node.oneLine());
    }

}
