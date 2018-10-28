package misql;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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
	@Override
	public void Insert(Node n) 
	{	
		this.NodeList.add(n);
		this.WriteObjectTofile(n);
		
	}
	
	// Insertar una lista de nodos en nuestra lista
	public void InsertByList( ArrayList<Node> ListofNodes ) 
	{
		for(Node n : ListofNodes) 
		{
			this.Insert(n);
		}
	}
	
	// Algoritmo de ordenamiento MergeSort para memoria externa
	@Override
	public void MergeSort(String a) {
		// TODO Auto-generated method stub
		
	}
	
	// Escribe el nuevo nodo al archivo de texto de este textfile
	public void WriteObjectTofile(Node n)
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(this.FilePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(n.oneLine());
			objectOut.close();
			System.out.println("¡Nodo agregado exitosamente!");
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
}
