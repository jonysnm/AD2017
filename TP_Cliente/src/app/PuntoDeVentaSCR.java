package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class PuntoDeVentaSCR extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 980227260272687408L;
	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JMenuItem listPedidoMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem cancelPedidoMenuItem;
	private JMenuItem confirmPedidoMenuItem;
	private JMenuItem newPedidoMenuItem;
	private JMenu jMenu4;
	
	private JSeparator jSeparator2;
	private JMenuItem exitMenuItem;
	private JMenuItem delClienteMenuItem;
	private JMenuItem editClienteMenuItem;
	private JMenuItem newClienteMenuItem;
	private JMenu jMenu3;
	private JMenu jMenu6;
	private JMenuBar jMenuBar1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PuntoDeVentaSCR inst = new PuntoDeVentaSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PuntoDeVentaSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setSize(500, 400);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Clientes");
					{
						newClienteMenuItem = new JMenuItem();
						jMenu3.add(newClienteMenuItem);
						newClienteMenuItem.setText("Nuevo");
						newClienteMenuItem.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								AltaClienteSCR.getInstancia().setVisible(true);
							}
						});
						
					}
					{
						editClienteMenuItem = new JMenuItem();
						jMenu3.add(editClienteMenuItem);
						editClienteMenuItem.setText("Modificar");
						/*editClienteMenuItem.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								editClienteMenuItem.getInstancia().setVisible(true);
							}
						});*/
					}
					{
						delClienteMenuItem = new JMenuItem();
						jMenu3.add(delClienteMenuItem);
						delClienteMenuItem.setText("Eliminar");
						delClienteMenuItem.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								BajaClienteSCR.getInstancia().setVisible(true);
							}
						});
					}
					
					
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Pedidos");
					{
						newPedidoMenuItem = new JMenuItem();
						jMenu4.add(newPedidoMenuItem);
						newPedidoMenuItem.setText("Nuevo");
						/*newPedidoMenuItem.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								newPedidoMenuItem.getInstancia().setVisible(true);
							}
						});*/
					}
					{
						confirmPedidoMenuItem = new JMenuItem();
						jMenu4.add(confirmPedidoMenuItem);
						confirmPedidoMenuItem.setText("Confirmar");
						/*confirmPedidoMenuItem.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								confirmPedidoMenuItem.getInstancia().setVisible(true);
							}
						});*/
					}
					{
						cancelPedidoMenuItem = new JMenuItem();
						jMenu4.add(cancelPedidoMenuItem);
						cancelPedidoMenuItem.setText("Cancelar");
						/*cancelPedidoMenuItem.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								cancelPedidoMenuItem.getInstancia().setVisible(true);
							}
						});*/
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						listPedidoMenuItem = new JMenuItem();
						jMenu4.add(listPedidoMenuItem);
						listPedidoMenuItem.setText("Listar");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Ayuda");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Acerca de");
						helpMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								AcercaDe.getInstancia().setVisible(true);
							}
						});
					}
				}
				
				{
					jMenu6 = new JMenu();
					jMenuBar1.add(jMenu6);
					jMenu6.setText("Salir");
					
					exitMenuItem = new JMenuItem();
					jMenu6.add(exitMenuItem);
					exitMenuItem.setText("Salir");
					exitMenuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) 
						{
							System.exit(0);
						}
					});
					
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
