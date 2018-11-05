package misql;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import utilities.Util;

/**
 * @author Eduardo Araos 
 * Clase de nuestra primera estructura; sera simplemente
 * una lista a partir de un archivo de texto.
 */
public class TextFile extends AbstractDatabase {
	
	// Nuestra lista de nodos
	private ArrayList<Node> NodeList;
	private String FilePath;
	
	public TextFile(String Fl) 
	{	
		this.NodeList = new ArrayList<Node>();	
		this.FilePath = Fl;
	}
	
	// Insertar un nodo en nuestra Lista 
	// y agregarlo a nuestro archivo de texto
	@Override
	public void Insert(Node n) 
	{	
		this.NodeList.add(n);
		this.WriteObjectTofile(n);
	}
	
	public void InsertMerge(Node n)
	{
		this.NodeList.add(n);
	}
	
	// Insertar una lista de nodos en nuestra lista
	public void InsertByList( ArrayList<Node> ListofNodes ) 
	{
		for(Node n : ListofNodes) 
		{
			this.Insert(n);
		}
	}
	
	public void MergeSortProductNodes(String attribute) throws IOException {
		
		// Tamaño del bloque de memoria
		int B = (int) Math.pow(10, 1);
		
		
    	// Abro el archivo
        BufferedReader reader = new BufferedReader(new FileReader(this.FilePath));
    	// Numero de nodos en nuestro archivo
    	int TotalNodes =  Util.readFileNlines(this.FilePath);
    	
    	// numero de bloques iniciales
    	int Bloques;
    	// Numero total de bloques a leer
    	if( TotalNodes%B == 0)
    	{
    		Bloques = TotalNodes/B;
    	}
    	else
    	{
    		Bloques = (TotalNodes/B) +1; 
    	}

        
		// Contador de lineas leidas n
    	int n = 0;
        // La linea con la que ire leyendo
        String line;
        
        // *** INICIO A1 ***
        // Leo el archivo entero lo escribo en tantos bloques
        // de memoria a priori 10e5 y los ordeno uno a uno en memoria ram
        for(int i = 1; i <= Bloques;i++)
        {
	        // Mientras leo una linea y n <  B (Bloques de tamaño B)
        	// añado el nodo a la lista de nodos de nuestro TextFile
	        while ( n<B)
	        {
	          
	          if((line = reader.readLine()) == null )
	          {
	        	  break;
	          }
	          // Spliteo la linea por separador de comas
	          String[] splits = line.split(",");
	          
	          // Creo mi nuevo nodo que esta descrito en split
	          Node NodeRead = new ProductNode();
	          NodeRead.insert("id", splits[0]);
	          NodeRead.insert("precio", splits[1]);
	          NodeRead.insert("puntosNec", splits[2]);
	          NodeRead.insert("puntosRec", splits[3]);
	          
	          // Lo agrego a nuestra lista de nodos 
	          this.InsertMerge(NodeRead);
	          n ++;
	        }
	        
	        // Ordenamos nuestro bloque en ram
	        Collections.sort(this.NodeList, new Comparator<Node>() {
	            @Override
	            public int compare(Node lhs, Node rhs) {
	                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
	                return lhs.Get(attribute) < rhs.Get(attribute) ? -1 : (lhs.Get(attribute) > rhs.Get(attribute)) ? 1 : 0;
	            }
	        });
	        
	        String path = "data/temp/bloques"+i+".txt";
	        // Lo insertamos en un nuevo archivo temporal
	        
	        File Temp = new File(path); 
	        Temp.createNewFile();
	        Util.saveNodesToFile(path, this.NodeList);
	        
	        // Limpio el arraylist y el numero de lineas leidas
	        this.NodeList.clear();
	        n = 0;
	        
        }
        reader.close();
        // *** FIN A1 ***

        
	}
	
	/**
	 * @author Eduardo Araos 
	 * Toma un nodo, le asigna un id, y lo envia para guardarlo en el archivo
	 * de este TextFile
	 */
	public void WriteObjectTofile(Node n)
	{
		try
		{
			int lin = Util.readFileNlines(this.FilePath);
			int id = lin+1;
			n.insert("id", Integer.toString(id));
			Util.save1NodeToFile(this.FilePath, n);
			System.out.println("¡Nodo agregado exitosamente!");
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
}
