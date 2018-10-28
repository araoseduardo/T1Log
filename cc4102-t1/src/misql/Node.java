package misql;
import java.io.Serializable;

import java.util.HashMap;
import java.util.Iterator;

public class Node implements Serializable {

    private HashMap<String, String> node;
    private static final long serialVersionUID = 1L;


    public Node() {
        this.node = new HashMap<>();
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
    
    @Override
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
