package Interfaz;

import java.awt.*;
import Model.*;

import javax.swing.*;


public class Principal extends JFrame {
	
	
	private ButtonsPane buttons;
	private PaneOperator operator;
	private Graeffe g;
	private double[] coef;
	private JTextArea zeros;
	
	public Principal(){
		
		zeros = new JTextArea("Ceros Polinómicos");
		zeros.setForeground(Color.black);
		zeros.setFocusable(false);
		
		buttons = new ButtonsPane(this);
		operator = new PaneOperator(this);
		coef = null;
		
		setSize(600,200);
		setResizable(false);
		setTitle("LABORATORIO ******* AED ****** POLINOMIOS ****** BIENVENIDO");
		setLayout(new BorderLayout());
		
		add(buttons,BorderLayout.SOUTH);
		add(operator,BorderLayout.EAST);
		add(zeros,BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(zeros);
		getContentPane().add(scroll);
		
			pack();
	}
	public JTextArea getZeros() {
		return zeros;
	}


	public void setZeros(JTextArea zeros) {
		this.zeros = zeros;
	}
	public void getInformation(){
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio"));
		coef = new double[n+1];
		g = new Graeffe(coef);
		String cad = "";
		int aux = n;
		for(int i=0; i<=n; i++){
			
			int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente de grado "+ i));
			coef[i] = c;
			
			if(i==0){
				if(c!=0){
					cad+= c;
				}
			}else if(i==1){
				
				if(c>0){
					
					cad+= " + ";
				}
				cad += c+"X";
			}
			else{
				
				if(c>0){
					
					cad+= "+";
				}
				cad += c+"X^"+aux;
				aux--;
			}
			
			
		}
		
		zeros.setText(cad);

		//operator.getZeros().setEditable(false);
	}
	
	
	public static void main(String []args){
		
		Principal main = new Principal();
		main.setVisible(true);
		
	}

}
