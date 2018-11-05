package utilities;

import misql.Node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static void HelloWorld() {
        System.out.print("Güena!" + '\n');
    }

    public static void printArrayList(ArrayList<Node> nodeList) {
        for (Node node : nodeList)
            System.out.println(node.serialize());
    }
    // *** IMPORTANTE***
    // Diego aqui cambie el oneLine() por Serialize()
    public static void saveNodesToFile(String fileName, ArrayList<Node> nodeArray) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

        for (Node node : nodeArray)
            writer.append(node.serialize()+"\n");

        writer.close();
    }
    
    /**
     * @author Eduardo Araos 
	 * Guarda un nodo <node> en el archivo de texto con filepath <fileName>
	 * de la forma serialize()
     */
    public static void save1NodeToFile(String fileName, Node node) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        
        writer.append(node.serialize()+"\n");

        writer.close();
    }
    
    /**
     * @author Eduardo Araos 
     * Recibe un filepath del cual leera todos los nodos y los guardara en una
     * lista records
	 * @return List<String> con los nodos del archivo leido
     */
    public static List<String> readFile(String filename)
    {
      List<String> records = new ArrayList<String>();
      try
      {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null)
        {
          records.add(line);
        }
        reader.close();
        return records;
      }
      catch (Exception e)
      {
        System.err.format("Exception occurred trying to read '%s'.", filename);
        e.printStackTrace();
        return null;
      }
    }
    
    
    /**
     * @author Eduardo Araos 
	 * Cuenta las lineas que posee un archivo de texto con el objetivo de obtener
	 * un id para un nodo que no lo tiene
	 * @return El numero de lineas del archivo de texto
     */
    public static int readFileNlines(String filename)
    {
    	
      try
      {
    	int n = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null)
        {
          n ++;
        }
        reader.close();
        return n;
      }
      catch (Exception e)
      {
        System.err.format("Exception occurred trying to read '%s'.", filename);
        e.printStackTrace();
        return -1;
      }
    }
    

}
