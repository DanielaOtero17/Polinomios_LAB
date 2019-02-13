package Interfaz;

import java.awt.*;
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
	

	public int[] getRandom() {
	coef = new int [11];
	String st = "";

	for (int i = 0; i < coef.length; i++) {
		
		
		coef[i] = r.nextInt(Integer.MAX_VALUE);
		
		
		if(i==0){
			if(coef[i]!=0){
				st+= coef[i];
			}
			
		}	
		
		else{
			
			
			if(coef[i] > 0) {
				
				st+= " + ";
			} 
			
			if(i==1) {
				
				st += coef[i]+"X";
				
			}else if(coef[i] == 0) {
				
				st += "";
			}
			else if(coef[i] == 1) {
				
				st+= " X^"+  i;
			}else if(coef[i] == -1) {
				st +="- X^"+i;
			}else {
				
				st += coef[i]+"X^"+i;
			}
		
		}
		
	}
	
	zeros.setText(st);
		System.out.println(st);
		return coef;
	}

	public void setZeros(JTextArea zeros) {
		this.zeros = zeros;
	}
	public void getInformation(){
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio"));
		coef = new int [n+1];
		g = new Graeffe(coef);
		String st = "";
		int aux = n;
		for(int i=0; i<=n; i++){
			
			int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente de grado "+ i));
			coef[i] = c;
			
			if(i==0){
				if(coef[i]!=0){
					st+= coef[i];
				}
				
			}	
			
			else{
				
				
				if(coef[i] > 0) {
					
					st+= " + ";
				} 
				
				if(i==1) {
					
					st += coef[i]+"X";
					
				}else if(coef[i] == 0) {
					
					st += "";
				}
				else if(coef[i] == 1) {
					
					st+= " X^"+  i;
				}else if(coef[i] == -1) {
					st +="- X^"+i;
				}else {
					
					st += coef[i]+"X^"+i;
				}
			
			}
			
			
		}
		
		zeros.setText(st);

		//operator.getZeros().setEditable(false);
	}
	
	
	public static void main(String []args){
		
		Principal main = new Principal();
		main.setVisible(true);
		
	}
	
	public void cleanTextArea() {
		zeros.setText("");
	}

}
