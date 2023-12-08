package com.projeto2;

import com.formdev.flatlaf.FlatLightLaf;
import com.projeto2.view.TelaInicial;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Igor J Rodrigues
 */
public class Projeto2 
{

    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Arial", Font.PLAIN, 14));
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Setting Look and Feel */
        setLookAndFeel();
        /* Create and display the form TelaIncial */
        new TelaInicial().setVisible(true);
    }
}
