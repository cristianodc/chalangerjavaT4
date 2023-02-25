package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class Conversor {

	private JFrame frmConversorDeMoedas;

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
		frmConversorDeMoedas.setBounds(100, 100, 450, 300);
		frmConversorDeMoedas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorDeMoedas.getContentPane().setLayout(null);
		JComboBox comboBox = new JComboBox();
		JButton btnNewButton = new JButton("Converter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			int index=	comboBox.getSelectedIndex();
			//JOptionPane.showMessageDialog(null, "Moeda retornada " + Util.getMoeda(index));	
			
			String numero = JOptionPane.showInputDialog("Digite O valor para conversão");
			 
			  String moeda = Util.getMoeda(index);
			  try {
				  
				//double cotacao = Util.getCotacao(moeda);
				
				//System.out.println("Cotaçao do dolar hoje :"+cotacao);
				Util.getMoedaJson(moeda);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		btnNewButton.setBounds(10, 120, 111, 23);
		frmConversorDeMoedas.getContentPane().add(btnNewButton);
		
		
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"De Reais para Dolares", "De Reais para Euros ", "De Reais para Libras", "De Dolares para Reais", "De Euros para Reais", "De Libras para Reias"}));
		comboBox.setBounds(131, 120, 241, 22);
		frmConversorDeMoedas.getContentPane().add(comboBox);
		
		
		
	}
	
}
