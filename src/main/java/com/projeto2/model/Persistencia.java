package com.projeto2.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Igor J Rodrigues
 */
public class Persistencia {
    private File estoque;
    private File pedidos;

    public Persistencia(String estoque, String pedidos) {
        this.estoque = new File(estoque);
        this.pedidos = new File (pedidos);
    }

    public void escreverPedidos(ArrayList<Pedido> prods) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream(pedidos);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(prods);
        oos.flush();
        oos.close();
    }
    
    public ArrayList<Pedido> lerPedidos() throws FileNotFoundException, IOException, ClassNotFoundException {
        boolean cont = true;
        ArrayList<Pedido> ped = new ArrayList();

        try {
            FileInputStream fis = new FileInputStream(pedidos);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = null;

            while (cont) {
                if (fis.available() != 0) {
                    obj = ois.readObject();
                    ped = ((ArrayList<Pedido>) obj);
                } else {
                    cont = false;
                }
            }
        } catch (Exception e) {

        }
        return ped;
    }

    public void escreverEstoque(Estoque est) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream(estoque);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(est);
        oos.flush();
        oos.close();
    }

    public Estoque lerEstoque() throws FileNotFoundException, IOException, ClassNotFoundException {
        boolean cont = true;
        Estoque est = new Estoque();

        try {
            FileInputStream fis = new FileInputStream(estoque);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = null;

            while (cont) {
                if (fis.available() != 0) {
                    obj = ois.readObject();
                    est = ((Estoque) obj);
                } else {
                    cont = false;
                }
            }
        } catch (Exception e) {

        }
        return est;
    }

}
