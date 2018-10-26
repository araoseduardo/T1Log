package misql;

import java.util.HashMap;

public class Nodo {

    private HashMap<String, String> myNodo;

    public Nodo() {
        this.myNodo = new HashMap<>();
    }

    public void insertarFila(String llave, String valor){
        myNodo.put(llave, valor);
    }

    public String oneLine(){
        return myNodo.toString();
    }
}
