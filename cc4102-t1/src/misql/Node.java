package misql;

import java.util.HashMap;
import java.util.Iterator;

public class Node {

    private HashMap<String, String> node;


    public Node() {
        this.node = new HashMap<>();
    }
    
    // Get method for this hashmap collection
    public int Get(String a) {
    	
    	return Integer.parseInt(this.node.get(a));
    }

    public void insert(String key, String value){
        node.put(key, value);
    }

    /**
     * Serializes current node to one straight line.
     * @return a String with the serialized node.
     */
    public String oneLine(){
        return node.toString();
        
    }
    
    /**
     * @author EduardoAraos
     * Serializa el nodo a un string de la forma:
     * "<id>,<precio>,<puntosNec>,<puntosRec>"
     * @return un String de la forma señalada
     */
    public String Serialize() 
    {
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append(this.node.get("id")).append(',');
    	stringBuffer.append(this.node.get("precio")).append(',');
    	stringBuffer.append(this.node.get("puntosNec")).append(',');
    	stringBuffer.append(this.node.get("puntosRec"));
    	return stringBuffer.toString();
    	
    }
    
    @Override
    // No pude overridearlo y igual no usaremos esto
    // NO PESCAR!!!!
    public String toString() 
    {
    	StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.node.entrySet().iterator();
        while (it.hasNext()) 
        {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            stringBuffer.append(pair.getKey().toString()).append( " : ").append( pair.getValue().toString());
            it.remove();
        }
        
        return stringBuffer.toString();
    }
}
