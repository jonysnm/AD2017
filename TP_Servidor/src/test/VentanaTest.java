package test;

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import server.Server;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTest window = new VentanaTest(Server.getInstancia().getMensaje());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** 
	 * Create the application.
	 */
	public VentanaTest(String msje) {
		initialize(msje);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String msje) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 224);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 230, 20);
		textPane.setText(msje);
		frame.getContentPane().add(textPane);
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Server.getInstancia().cerrar();
				System.exit(WindowConstants.EXIT_ON_CLOSE);
			}
		});
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCerrar.setBounds(250, 104, 174, 60);
		frame.getContentPane().add(btnCerrar);
		
		JLabel lblParaCerrarLiberando = new JLabel("Para cerrar liberando el Registry 1099... --->");
		lblParaCerrarLiberando.setBounds(10, 135, 237, 14);
		frame.getContentPane().add(lblParaCerrarLiberando);
	}
	
}
