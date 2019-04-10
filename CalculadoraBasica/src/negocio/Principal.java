
package negocio;

import javax.swing.JFrame;
import presentacion.CalculadoraSinNumeros;

public class Principal {

    public static void main(String[] args) {
        CalculadoraSinNumeros calSinN=new CalculadoraSinNumeros();
        calSinN.setVisible(true);
        calSinN.setLocation(400, 200);
        calSinN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
}
