package com.projeto2.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Igor J Rodrigues
 */
public class Persistencia {
    private File dados;

    public Persistencia(String estoque) {
        this.dados = new File(estoque);
    }

    public void escreverDados(Restaurante rest) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream(dados);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(rest);
        oos.flush();
        oos.close();
    }

    public Restaurante lerDados() throws FileNotFoundException, IOException, ClassNotFoundException {
        boolean cont = true;
        Restaurante rest = new Restaurante();

        try {
            FileInputStream fis = new FileInputStream(dados);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = null;

            while (cont) {
                if (fis.available() != 0) {
                    obj = ois.readObject();
                    rest = ((Restaurante) obj);
                } else {
                    cont = false;
                }
            }
        } catch (Exception e) {

        }
        return rest;
    }

}
