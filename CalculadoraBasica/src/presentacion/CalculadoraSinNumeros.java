
package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import negocio.Calculadora;

public class CalculadoraSinNumeros extends JFrame{
    
    private JTextField txtPantalla;
    private JButton btnMas;
    private JButton btnMenos;
    private JButton btnCero;
    private JButton btnMultiplicacion;
    private JButton btnDivision;
    private JButton btnIgual;
    private Calculadora calcu;
    
    public CalculadoraSinNumeros(){
        this.setTitle("Calculadora");
        this.setLayout(null);
        this.setSize(280, 200);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        //this.set
        txtPantalla=new JTextField();
        txtPantalla.setHorizontalAlignment(JTextField.RIGHT);
        txtPantalla.setSize(170, 30);
        txtPantalla.setLocation(50, 10);
        this.getContentPane().add(txtPantalla);
        btnMas=new JButton("+");
        btnMas.setSize(50, 30);
        btnMas.setLocation(50, 50);
        this.getContentPane().add(btnMas);
        btnMas.addActionListener(new EscuchaAccion(1));
        btnMenos=new JButton("-");
        btnMenos.setSize(50, 30);
        btnMenos.setLocation(110, 50);
        this.getContentPane().add(btnMenos);
        btnMenos.addActionListener(new EscuchaAccion(2));
        btnCero=new JButton("C");
        btnCero.setSize(50, 30);
        btnCero.setLocation(170, 50);
        this.getContentPane().add(btnCero);
        btnCero.addActionListener(new EscuchaAccion());
        btnMultiplicacion=new JButton("*");
        btnMultiplicacion.setSize(50, 30);
        btnMultiplicacion.setLocation(50, 90);
        this.getContentPane().add(btnMultiplicacion);
        btnMultiplicacion.addActionListener(new EscuchaAccion(3));
        btnDivision=new JButton("/");
        btnDivision.setSize(50, 30);
        btnDivision.setLocation(110, 90);
        this.getContentPane().add(btnDivision);
        btnDivision.addActionListener(new EscuchaAccion(4));
        btnIgual=new JButton("=");
        btnIgual.setSize(50, 30);
        btnIgual.setLocation(170, 90);
        this.getContentPane().add(btnIgual);
        btnIgual.addActionListener(new EscuchaAccion());
        calcu=new Calculadora();
        
    }
    
    public void limpiarPantallaYVolverCursor(){
        txtPantalla.setText("");
        txtPantalla.requestFocus();
    }
    
    
    class EscuchaAccion implements ActionListener{
        int boton;
        int contClickCero;
        
        public EscuchaAccion(int b){
            boton=b;
        }
        
        public EscuchaAccion(){
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String pant=txtPantalla.getText().trim();
            if(pant.equals(""))
                pant="0";
            System.out.println(pant);
            float valorCapt=Float.parseFloat(pant);
            
            if(boton!=0){
                calcu.setOperacion(boton);
                calcu.setArgumento(valorCapt);
                limpiarPantallaYVolverCursor();
            }
            else
                if(e.getSource()==btnCero){
                    contClickCero++;
                    if(contClickCero==1)
                        limpiarPantallaYVolverCursor();
                    else{
                        calcu.setArgumento(0);
                        calcu.setOperacion(-1);
                        contClickCero=0;
                        limpiarPantallaYVolverCursor();
                    }
                }                
                else
                    if(e.getSource()==btnIgual){
                        float res=calcu.igual(valorCapt);
                        txtPantalla.setText(Float.toString(res));
                        }
        }
    }
            
            
}

    
    

