package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import businessDelegate.BusinessDelegate;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import dto.PedidosPendientesAprobacionDTO;


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
	private JMenuItem jMenuItemBajaColor;
	private JMenuItem jMenuItemModifColor;
	private JMenuItem jMenuItemAltaColor;
	private JMenuItem jMenuItemBajaInsumo;
	private JMenuItem jMenuItemModifInsumo;
	private JMenuItem jMenuItemAltaInsumo;
	private JMenu jMenuInsumos;
	private JMenuItem jMenuItemBajaTalle;
	private JMenuItem jMenuItemModifTalle;
	private JMenuItem jMenuItemAltaTalle;
	private JSeparator jSeparatorTalles;
	private JSeparator jSeparatorColores;
	private JMenuItem jMenuItemBajaPrenda;
	private JMenuItem jMenuItemModifPrenda;
	private JMenuItem jMenuItemAltaPrenda;
	private JMenu jMenuPrenda;
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
					jMenu3.setText("Clientes  ");
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
						/*caCncelPedidoMenuItem.addActionListener(new ActionListener() {
							
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
//						listPedidoMenuItem.addActionListener(new ActionListener() {
//							
//							public void actionPerformed(ActionEvent e) {
//								try {
//							List<PedidosPendientesAprobacionDTO> pedidos = BusinessDelegate.getInstancia().obtenerPedidosPendientesdeAprobacion(1);
//							for (PedidosPendientesAprobacionDTO pedidoDTO : pedidos) {
//								for (ItemPedidoDTO iPedidoDTO : pedidoDTO.getItems()) {
//									System.out.println(pedidoDTO.getId() +" "+ pedidoDTO.getTotal() +" "+ 	iPedidoDTO.getTalle() +" "+  iPedidoDTO.getColor() +" "+  iPedidoDTO.getPrenda() +" "+  iPedidoDTO.getImporte());
//								}
//							}
//								} catch (RemoteException e1) {
//									e1.printStackTrace();
//								}
//							}
//						});
						
					}
				}

				{
					jMenuPrenda = new JMenu();
					jMenuBar1.add(jMenuPrenda);
					jMenuPrenda.setText("Prendas");
					{
						jMenuItemAltaPrenda = new JMenuItem();
						jMenuPrenda.add(jMenuItemAltaPrenda);
						jMenuItemAltaPrenda.setText("Nueva Prenda");
					}
					{
						jMenuItemModifPrenda = new JMenuItem();
						jMenuPrenda.add(jMenuItemModifPrenda);
						jMenuItemModifPrenda.setText("Modificar Prenda");
					}
					{
						jMenuItemBajaPrenda = new JMenuItem();
						jMenuPrenda.add(jMenuItemBajaPrenda);
						jMenuItemBajaPrenda.setText("Eliminar Prenda");
					}
					{
						jSeparatorColores = new JSeparator();
						jMenuPrenda.add(jSeparatorColores);
					}
					{
						jMenuItemAltaColor = new JMenuItem();
						jMenuPrenda.add(jMenuItemAltaColor);
						jMenuItemAltaColor.setText("Nuevo Color");
							jMenuItemAltaColor.addActionListener(new ActionListener() {
								
								public void actionPerformed(ActionEvent e) {
									AltaColorSCR tv = new AltaColorSCR();
									tv.setVisible(true);
//									AltaColorSCR.getInstancia().setVisible(true);
								}
							});
					}
					{
						jMenuItemModifColor = new JMenuItem();
						jMenuPrenda.add(jMenuItemModifColor);
						jMenuItemModifColor.setText("Modificar Color");
						jMenuItemModifColor.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								ModificarColorSCR tv = new ModificarColorSCR();
								tv.setVisible(true);
//								ModificarColorSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jMenuItemBajaColor = new JMenuItem();
						jMenuPrenda.add(jMenuItemBajaColor);
						jMenuItemBajaColor.setText("Eliminar Color");
						jMenuItemBajaColor.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								BajaColorSCR tv = new BajaColorSCR();
								tv.setVisible(true);
//								BajaColorSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jSeparatorTalles = new JSeparator();
						jMenuPrenda.add(jSeparatorTalles);
					}
					{
						jMenuItemAltaTalle = new JMenuItem();
						jMenuPrenda.add(jMenuItemAltaTalle);
						jMenuItemAltaTalle.setText("Nuevo Talle");
						jMenuItemAltaTalle.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								AltaTalleSCR tv = new AltaTalleSCR();
								tv.setVisible(true);
//								AltaTalleSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jMenuItemModifTalle = new JMenuItem();
						jMenuPrenda.add(jMenuItemModifTalle);
						jMenuItemModifTalle.setText("Modificar Talle");
						jMenuItemModifTalle.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								ModificarTalleSCR tv = new ModificarTalleSCR();
								tv.setVisible(true);
//								ModificarTalleSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jMenuItemBajaTalle = new JMenuItem();
						jMenuPrenda.add(jMenuItemBajaTalle);
						jMenuItemBajaTalle.setText("Eliminar Talle");
						jMenuItemBajaTalle.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								BajaTalleSCR tv = new BajaTalleSCR();
								tv.setVisible(true);
//								BajaTalleSCR.getInstancia().setVisible(true);
							}
						});
					}
				}
				{
					jMenuInsumos = new JMenu();
					jMenuBar1.add(jMenuInsumos);
					jMenuInsumos.setText("Insumos");
					{
						jMenuItemAltaInsumo = new JMenuItem();
						jMenuInsumos.add(jMenuItemAltaInsumo);
						jMenuItemAltaInsumo.setText("Nuevo");
					}
					{
						jMenuItemModifInsumo = new JMenuItem();
						jMenuInsumos.add(jMenuItemModifInsumo);
						jMenuItemModifInsumo.setText("Modificar");
					}
					{
						jMenuItemBajaInsumo = new JMenuItem();
						jMenuInsumos.add(jMenuItemBajaInsumo);
						jMenuItemBajaInsumo.setText("Eliminar");
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
