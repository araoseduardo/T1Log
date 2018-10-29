package misql;

import java.util.Random;

public class ProductNode extends Node {

    public ProductNode() {
        super();
    }

    public ProductNode(String id, String precio, String puntosNec, String puntosRec) {
        this();
        this.insert("id", id);
        this.insert("precio", precio);
        this.insert("puntosNec", puntosNec);
        this.insert("puntosRec", puntosRec);
    }


    private static int randomIntBetween(int min, int max, Random random) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static ProductNode randomProductNode(int i, Random random) {
        String id = Integer.toString(i);
        int price = randomIntBetween(10000, 10000000, random);
        String precio = Integer.toString(price);
        String puntosNec = Long.toString(Math.round(price*0.0005));
        String puntosRec = Long.toString(Math.round(price*0.000025)); // Each 20 purchased, exchange one free.
        return new ProductNode(id, precio, puntosNec, puntosRec);
    }
}
