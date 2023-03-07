package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class Conversor {

	private JFrame frmConversorDeMoedas;
	private JTextField txtValor;
	JLabel lblResultado = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor window = new Conversor();
					window.frmConversorDeMoedas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Conversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversorDeMoedas = new JFrame();
		frmConversorDeMoedas.setTitle("Conversor de Moedas");
		frmConversorDeMoedas.setBounds(100, 100, 732, 212);
		frmConversorDeMoedas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorDeMoedas.getContentPane().setLayout(null);
		JComboBox comboBox = new JComboBox();
		JButton btnNewButton = new JButton("Converter");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String valor = txtValor.getText();	
			int index = comboBox.getSelectedIndex();
			String codigo = Util.getMoeda(index);
			
			if(valor.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Informe o valor a ser conertido");
//https://www.alura.com.br/artigos/verificar-se-e-letra-ou-numero-no-java?gclid=CjwKCAiA3pugBhAwEiwAWFzwdbCJ1c572TIS60jdKqAyX9LJtLRLGtegfmbWfle0tfJIjSPC10EWVBoC4AYQAvD_BwE	
				}else if(valor.matches("^[A-Za-z]*")){
					
					JOptionPane.showMessageDialog(null, "Informe apenas números");
				}else {
					
					try {
				 	Moeda moeda=	Util.getMoedaJson(codigo);
				   double resultadoConversao = 0;
				   resultadoConversao=	Util.calcConversao(Double.parseDouble(valor), moeda);
				   JOptionPane.showMessageDialog(null, "Resutado da conversão foi :" + resultadoConversao );
										
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			
			}
		});
		btnNewButton.setBounds(10, 41, 173, 34);
		frmConversorDeMoedas.getContentPane().add(btnNewButton);
		
		
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"De Reais para Dolares", "De Reais para Euros ", "De Reais para Libras", "De Reais para Pesos Argentinos", "De Dolares para Reais", "De Euros para Reais", "De Libras para Reias", "De Pesos Argentinos para Reais"}));
		comboBox.setBounds(485, 40, 225, 35);
		frmConversorDeMoedas.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Valor p/ Converter");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(193, 41, 138, 34);
		frmConversorDeMoedas.getContentPane().add(lblNewLabel);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtValor.setBounds(312, 41, 143, 34);
		frmConversorDeMoedas.getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(10, 86, 378, 32);
		frmConversorDeMoedas.getContentPane().add(lblResultado);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setBounds(10, 129, 173, 33);
		frmConversorDeMoedas.getContentPane().add(btnSair);
		
		
		
	}
}
