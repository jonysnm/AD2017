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
public class SucursalesSCR extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 980227260273687408L;
	private JMenu jMenuEmpleados;
	private JMenuItem jMenuItemAsignarJefePedidos;
	private JMenuItem jMenuItemAsignarGerenteSucursal;
	private JMenuItem jMenuItemAsignarEmpleados;
	private JSeparator jSeparatorAsignar;
	private JMenuItem jMenuItemEliminarSucursal;
	private JMenuItem jMenuItemElminarEmpleado;
	private JMenuItem jMenuItemModificarEmpleado;
	private JMenuItem jMenuItemNuevoEmpleado;
	private JMenuItem jMenuItemModificarSucursal;
	private JMenuItem jMenuItemNuevaSucursal;
	private JMenu jMenuSucursales;
	private JMenuItem helpMenuItem;
	private JMenu jMenu5;

	private JMenuItem exitMenuItem;
	private JMenu jMenu6;
	private JMenuBar jMenuBar1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SucursalesSCR inst = new SucursalesSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public SucursalesSCR() {
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
					jMenuSucursales = new JMenu();
					jMenuBar1.add(jMenuSucursales);
					jMenuSucursales.setText("Sucursales");
					jMenuSucursales.setSize(103, 29);
					{
						jMenuItemNuevaSucursal = new JMenuItem();
						jMenuSucursales.add(jMenuItemNuevaSucursal);
						jMenuItemNuevaSucursal.setText("Nueva");
						jMenuItemNuevaSucursal.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								AltaSucursalSCR tv = new AltaSucursalSCR();
								tv.setVisible(true);
//								AltaSucursalSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jMenuItemModificarSucursal = new JMenuItem();
						jMenuSucursales.add(jMenuItemModificarSucursal);
						jMenuItemModificarSucursal.setText("Modificar");
						jMenuItemModificarSucursal.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								ModificarSucursalSCR tv = new ModificarSucursalSCR();
								tv.setVisible(true);
//								ModificarSucursalSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jMenuItemEliminarSucursal = new JMenuItem();
						jMenuSucursales.add(jMenuItemEliminarSucursal);
						jMenuItemEliminarSucursal.setText("Eliminar");
						jMenuItemEliminarSucursal.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								BajaSucursalSCR tv = new BajaSucursalSCR();
								tv.setVisible(true);
//								BajaSucursalSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jSeparatorAsignar = new JSeparator();
						jMenuSucursales.add(jSeparatorAsignar);
					}
					{
						jMenuItemAsignarEmpleados = new JMenuItem();
						jMenuSucursales.add(jMenuItemAsignarEmpleados);
						jMenuItemAsignarEmpleados.setText("Asignar Empleados");
						jMenuItemAsignarEmpleados.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								AsignarEmpleadosSucursalSCR tv = new AsignarEmpleadosSucursalSCR();
								tv.setVisible(true);
//								AsignarEmpleadosSucursalSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jMenuItemAsignarGerenteSucursal = new JMenuItem();
						jMenuSucursales.add(jMenuItemAsignarGerenteSucursal);
						jMenuItemAsignarGerenteSucursal.setText("Asignar Gerente");
						jMenuItemAsignarGerenteSucursal.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								AsignarGerenteSucursalSCR tv = new AsignarGerenteSucursalSCR();
								tv.setVisible(true);
//								AsignarGerenteSucursalSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jMenuItemAsignarJefePedidos = new JMenuItem();
						jMenuSucursales.add(jMenuItemAsignarJefePedidos);
						jMenuItemAsignarJefePedidos.setText("Asignar Jefe Pedidos");
						jMenuItemAsignarJefePedidos.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								AsignarJefePedidosSucursalSCR tv = new AsignarJefePedidosSucursalSCR();
								tv.setVisible(true);
//								AsignarJefePedidosSucursalSCR.getInstancia().setVisible(true);
							}
						});
					}
				}
				{
					jMenuEmpleados = new JMenu();
					jMenuBar1.add(jMenuEmpleados);
					jMenuEmpleados.setText("Empleados");
					{
						jMenuItemNuevoEmpleado = new JMenuItem();
						jMenuEmpleados.add(jMenuItemNuevoEmpleado);
						jMenuItemNuevoEmpleado.setText("Nuevo");
						jMenuItemNuevoEmpleado.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								AltaEmpleadoSCR tv = new AltaEmpleadoSCR();
								tv.setVisible(true);
//								AltaEmpleadoSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jMenuItemModificarEmpleado = new JMenuItem();
						jMenuEmpleados.add(jMenuItemModificarEmpleado);
						jMenuItemModificarEmpleado.setText("Modificar");
						jMenuItemModificarEmpleado.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								ModificarEmpleadoSCR tv = new ModificarEmpleadoSCR();
								tv.setVisible(true);
//								ModificarEmpleadoSCR.getInstancia().setVisible(true);
							}
						});
					}
					{
						jMenuItemElminarEmpleado = new JMenuItem();
						jMenuEmpleados.add(jMenuItemElminarEmpleado);
						jMenuItemElminarEmpleado.setText("Eliminar");
						jMenuItemElminarEmpleado.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								BajaEmpleadoSCR tv = new BajaEmpleadoSCR();
								tv.setVisible(true);
//								BajaEmpleadoSCR.getInstancia().setVisible(true);
							}
						});
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
