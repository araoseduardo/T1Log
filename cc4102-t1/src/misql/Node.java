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

    public HashMap<String, String> getNodeMap () {
        return node;
    }

    public void insert(String key, String value){
        node.put(key, value);
    }

    /**
     * Serializes current node to one straight line.
     * @return a String with the serialized node.
     */
    public String serialize() {
        return node.toString();
    }

}
