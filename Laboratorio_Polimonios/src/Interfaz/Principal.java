package Interfaz;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

import Model.*;
import javax.swing.*;



public class Principal extends JFrame {
	
	
	private ButtonsPane buttons;
	private PaneOperator operator;
	private Graeffe g;
	private int [] coef;
	private JTextArea zeros;
	Random r = new Random();
	
	public Principal(){
		
		zeros = new JTextArea("Ceros Polin�micos");
		zeros.setForeground(Color.black);
		zeros.setFocusable(false);
		
		buttons = new ButtonsPane(this);
		operator = new PaneOperator(this);
		coef = null;
		
		setSize(600,200);
		setResizable(false);
		setTitle("LABORATORIO ******* AED ****** POLINOMIOS ****** BIENVENIDO");
		setLayout(new BorderLayout());
		
		operator.setPreferredSize(new Dimension(100,50));
		
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
	
	public void calculate() throws HeadlessException, IOException {
		
		Graeffe graeffe = new Graeffe(coef); 
		 graeffe.mostrarRaices();
		 
		if(graeffe.getReals().equalsIgnoreCase("Raices reales: \n")) {
			 
			 JOptionPane.showMessageDialog(null, "El polinomio no tiene soluciones reales \n","Ceros", 1);
		 }else {
			 
			 JOptionPane.showMessageDialog(null, graeffe.getReals(),"Ceros", 1);
		 }
		 
		 if(graeffe.getComplexes().equalsIgnoreCase("Raices complejas: \n")) {
			 
			 JOptionPane.showMessageDialog(null, "El polinomio no tiene soluciones complejas \n","Ceros", 1);
		 }else {
			 
			 JOptionPane.showMessageDialog(null, graeffe.getComplexes(),"Ceros", 1);
		 }

	}

	public int[] getRandom() {
	coef = new int [11];
	String st = "";
	int aux = coef.length-1;
	for (int i = 0; i < coef.length; i++) {
		
		
		coef[i] = r.nextInt(9999);
		
		
		if (aux > 1) {

			if (coef[i] == 1) {

				st += "X^" + aux;
			} else if (coef[i] == 0) {

				st += "";
			} else {

				st += coef[i] + "X^" + aux;
			}
		} else if (aux == 1) {

			if (coef[i] == 1) {

				st += "X^" + aux;
			} else if (coef[i] == 0) {

				st += "";
			} else {
				st += coef[i] + "X";
			}

		} else {

			if (coef[i] == 0) {

				st += "";
			}else {
				
				st += coef[i];
			}
		}
		

		if (coef[i] > 0 && aux > 0) {

			st += " + ";
		}
		aux--;
	
		
	}
	
	zeros.setText(st);
		System.out.println(st);
		return coef;
	}

	public void setZeros(JTextArea zeros) {
		this.zeros = zeros;
	}

	public void getInformation() {

		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio"));
		coef = new int[n + 1];
		g = new Graeffe(coef);
		String st = "";
		int aux = n;
		for (int i = 0; i <= n; i++) {

			int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente de grado " + aux));
			coef[i] = c;

			if(coef[i] > 0 && aux < n) {
				
				st += " + ";
			}
			
			if (aux > 1) {

				if (coef[i] == 1) {

					st += "X^" + aux;
				} else if (coef[i] == 0) {

					st += "";
				} else {

					st += coef[i] + "X^" + aux;
				}
			} else if (aux == 1) {

				if (coef[i] == 1) {

					st += "X";
				} else if (coef[i] == 0) {

					st += "";
				} else {
					st += coef[i] + "X";
				}

			} else {

				if (coef[i] == 0) {

					st += "";
				}else {
					
					st += coef[i];
				}
			}
			
			

			
			aux--;
			
			

		}
		
		st += " = 0";
		zeros.setText(st);
	}
	
	
	public static void main(String []args){
		
		Principal main = new Principal();
		main.setVisible(true);
		
	}
	
	public void cleanTextArea() {
		zeros.setText("");
	}

}
