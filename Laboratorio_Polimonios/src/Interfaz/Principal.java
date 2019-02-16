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
	private int[] coef;
	private JTextArea zeros;
	Random r = new Random();

	public Principal() {

		zeros = new JTextArea("Ceros Polinomicos");
		zeros.setForeground(Color.black);
		zeros.setFocusable(false);

		buttons = new ButtonsPane(this);
		operator = new PaneOperator(this);
		coef = null;

		setSize(600, 200);
		setResizable(false);
		setTitle("LABORATORIO ******* AED ****** POLINOMIOS ****** BIENVENIDO");
		setLayout(new BorderLayout());

		operator.setPreferredSize(new Dimension(100, 50));

		add(buttons, BorderLayout.SOUTH);
		add(operator, BorderLayout.EAST);
		add(zeros, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(zeros);
		getContentPane().add(scroll);

		pack();
	}

	public JTextArea getZeros() {
		return zeros;
	}

	public void calculate() throws HeadlessException, IOException, ArrayIndexOutOfBoundsException{

		
		try {
			g = new Graeffe(coef);
			g.mostrarRaices();
			

			if (g.getReals().equalsIgnoreCase("Raices reales: \n")) {

				JOptionPane.showMessageDialog(null, "El polinomio no tiene soluciones reales \n", "Ceros", 1);
			} else {

				JOptionPane.showMessageDialog(null, g.getReals(), "Ceros", 1);
			}

			if (g.getComplexes().equalsIgnoreCase("Raices complejas: \n")) {

				JOptionPane.showMessageDialog(null, "El polinomio no tiene soluciones complejas \n", "Ceros", 1);
			} else {

				JOptionPane.showMessageDialog(null, g.getComplexes(), "Ceros", 1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Este polinomio no tiene solución.", "Sin respuesta", 1);
		}
		

	}

	public int[] getRandom() {
		coef = new int[11];
		String st = "";
		int aux = coef.length - 1;
		g = new Graeffe(coef);
		
		for (int i = 0; i < coef.length; i++) {

			coef[i] = r.nextInt(100);

			if (coef[i] > 0 && aux < coef.length-1) {

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
				} else {

					st += coef[i];
				}
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

	public void getInformation() throws IOException, NumberFormatException {
		
		try {
			int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado del polinomio"));
			coef = new int[n + 1];
			g = new Graeffe(coef);
			String st = "";
			int aux = n;
			
			
			for (int i = 0; i <= n; i++) {

				int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente de grado " + aux));
				coef[i] = c;

				if (coef[i] > 0 && aux < n) {

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
					} else {

						st += coef[i];
					}
				}

				aux--;
			}

			st += " = 0";
			zeros.setText(st);
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Por favor ingrese los datos nuevamente.", "Error",3);
		}
		
	}

	public static void main(String[] args) {

		Principal main = new Principal();
		main.setVisible(true);

	}

	public void cleanTextArea() {
		zeros.setText("");
	}

}
