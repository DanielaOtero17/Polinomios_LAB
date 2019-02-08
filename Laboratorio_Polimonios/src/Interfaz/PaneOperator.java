package Interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class PaneOperator extends JPanel implements ActionListener{

	private JButton insert;
	
	private Principal V;
	
	public PaneOperator (Principal v) {
	
		V=v;
		
		insert= new JButton("Insertar");
		insert.setFont(new Font("Arial Rounded MT Bold", 15,15));
		insert.setBackground(Color.WHITE);
		
	//	insert.setBorder(BorderFactory.createLineBorder(Color.RED));
        insert.setBorder(new LineBorder(Color.RED));

		setLayout(new BorderLayout());
		
		insert.addActionListener(this);
		insert.setActionCommand("insertar");
		add(insert,BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
