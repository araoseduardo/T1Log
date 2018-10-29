package misql;
import java.util.ArrayList;
import utilities.Util;

/**
 * @author Eduardo Araos 
 * Clase de nuestra primera estructura; sera simplemente
 * una lista a partir de un archivo de texto.
 */
public class TextFile extends AbstractDatabase {
	
	// Nuestra lista de nodos
	// **** A PRIORI NO ES NECESARIA **** HAY QUE DEPRECARLA ****D****
	private ArrayList<Node> NodeList;
	private String FilePath;
	
	public TextFile(String Fl) 
	{	
		this.NodeList = new ArrayList<Node>();	
		this.FilePath = Fl;
	}
	
	// Insertar un nodo en nuestra Lista 
	// y agregarlo a nuestro archivo de texto
	//****D****
	@Override
	public void Insert(Node n) 
	{	
		this.NodeList.add(n);
		this.WriteObjectTofile(n);
		
	}
	
	// Insertar una lista de nodos en nuestra lista
	// ****D****
	public void InsertByList( ArrayList<Node> ListofNodes ) 
	{
		for(Node n : ListofNodes) 
		{
			this.Insert(n);
		}
	}
	
	/**
	 * @author Eduardo Araos 
	 * Toma un nodo, le asigna un id, y lo envia para guardarlo en el archivo
	 * de este TextFile
	 */
	@Override
	public void MergeSort(String a) {
		// TODO Auto-generated method stub
		
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
