/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author acer
 */
public class Converter extends JFrame implements ActionListener {

	JButton btn[];
	JTextArea txt;
	JTextField input;
	JRadioButton btnFrom[], btnTo[];

	public Converter(String name) {
		super(name);
		setBounds(40, 40, 800, 240);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setLayout(null);

		JPanel panBtns = new JPanel(new GridLayout(4, 3));
		JPanel panKey = new JPanel(new BorderLayout());
		JPanel panInput = new JPanel(new FlowLayout());

		txt = new JTextArea(20, 10);
		btn = new JButton[14];

		String[] namebtn = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "c", "0", "." };

		for (int i = 0; i < namebtn.length; i++) {
			btn[i] = new JButton("" + namebtn[i]);
			panBtns.add(btn[i]);
			btn[i].addActionListener(this);
		}
		btn[13] = new JButton("Convert");
		btn[13].addActionListener(this);
		panKey.add(panBtns, BorderLayout.CENTER);
		panKey.add(btn[13], BorderLayout.SOUTH);

//        panInput.add();
		this.input = new JTextField(20);
		this.input.setEditable(false);
		JLabel lbl = new JLabel("Distance in :");

		panInput.add(lbl);
		panInput.add(this.input);

		JPanel panRadio = new JPanel(new GridLayout(1, 2));
		JPanel panFrom = new JPanel(new GridLayout(3, 1));
		panFrom.setBorder(BorderFactory.createTitledBorder("From"));
		JPanel panTo = new JPanel(new GridLayout(3, 1));
		panTo.setBorder(BorderFactory.createTitledBorder("To"));
		String strTools[] = { "mm", "cm", "km" };
		btnFrom = new JRadioButton[3];
		btnTo = new JRadioButton[3];
		ButtonGroup groupFrom = new ButtonGroup();
		ButtonGroup groupTo = new ButtonGroup();
		for (int i = 0; i < 3; i++) {
			btnFrom[i] = new JRadioButton(strTools[i]);
			groupFrom.add(btnFrom[i]);
			btnTo[i] = new JRadioButton(strTools[i]);
			groupTo.add(btnTo[i]);
			panFrom.add(btnFrom[i]);
			panTo.add(btnTo[i]);
		}
		panRadio.add(panFrom);
		panRadio.add(panTo);
		this.add(panRadio, BorderLayout.WEST);
		this.add(panInput, BorderLayout.NORTH);
		this.add(panKey, BorderLayout.EAST);
		this.add(txt, BorderLayout.CENTER);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < btn.length - 1; i++) {
			if (e.getSource() == btn[i] && i != 9) {
				this.input.setText(this.input.getText() + btn[i].getText());
				return;
			}

		}
		if (e.getSource() == btn[9]) {
			input.setText("");
			return;
		}
		
		if (e.getSource() == btn[13]) {
			if(input.getText().isEmpty())
				return;
			double num = (Integer.parseInt(this.input.getText()));
			String typeOfInput = "";
			String typeOfOutput = "";

			for (JRadioButton r : btnFrom) {
				if (r.isSelected()) {
					typeOfInput = r.getText();
				}
			}

			for (JRadioButton r : btnTo) {
				if (r.isSelected()) {
					typeOfOutput = r.getText();
				}
			}
			if (typeOfInput.equals("") || typeOfOutput.equals("")) {
				JOptionPane.showMessageDialog(null, "Selected the type");
				return;
			}

			double MInput =-1;
			double MOutput = -1;
			

			{
				if (typeOfInput.equals("mm")) 
				{
					MInput = 0.001;
				}
				if (typeOfInput.equals("cm")) 
				{
					MInput = 0.01;
				}
				if (typeOfInput.equals("km")) 
				{
					MInput = 1000;
				}
			}
			{
				if (typeOfOutput.equals("mm")) 
				{
					MOutput = 0.001;
				}
				if (typeOfOutput.equals("cm")) 
				{
					MOutput = 0.01;
				}
				if (typeOfOutput.equals("km")) 
				{
					MOutput = 1000;
				}
			}
			String result = "the result is of convert from " + num +" " +typeOfInput+" to "+typeOfOutput+" " +(num*MInput)/MOutput ;
			txt.setText(result);
			//JOptionPane.showMessageDialog(null, MInput+"");
        	//JOptionPane.showMessageDialog(null, MOutput+"");
        	//JOptionPane.showMessageDialog(null, result+"");

		}

	}

}
