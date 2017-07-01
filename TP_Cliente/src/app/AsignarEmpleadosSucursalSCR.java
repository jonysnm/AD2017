package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import businessDelegate.BusinessDelegate;
import dto.ColorDTO;
import dto.EmpleadoDTO;
import dto.SucursalDTO;

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
public class AsignarEmpleadosSucursalSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3374484918332110642L;
	private JList jListSucursales;
	private JButton jButtonAceptar;
	private JList jListEmpleadosActuales;
	private JButton jButtonQuitar;
	private JButton jButtonAgregar;
	private JLabel jLabelEmpleados;

	private JLabel jLabelGerenteActual;
	private JLabel jLabelIndicacion2;
	private JButton jButtonModificar;
	private JList jListEmpleados;
	private JLabel jLabelMensaje;
	private JLabel jLabelIndicacion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AsignarEmpleadosSucursalSCR inst = new AsignarEmpleadosSucursalSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public boolean noEsta(EmpleadoDTO e ,List<EmpleadoDTO>listae){
		for(EmpleadoDTO bus : listae){
			if(bus.getApellido().equals(e.getApellido()) && bus.getNombre().equals(e.getNombre()))
				return false;
		}
		return true;
	}
	
	public AsignarEmpleadosSucursalSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Asignar Empleados a Sucursal");
			final SucursalDTO editadodto = new SucursalDTO();
			final List<SucursalDTO>  listatdto = BusinessDelegate.getInstancia().getallSucursales();
			final List<EmpleadoDTO>  listaedto = BusinessDelegate.getInstancia().getallEmpleados();
			
			{
				if(listatdto != null){
					int i = 0;
					String[] descs = new String[80];
					for (SucursalDTO t : listatdto){
						
						descs[i] = t.getNombre();
						i++;
						
					}
					
					ListModel<String> jListTallesModel = new DefaultComboBoxModel<String>(descs);
				
				
				
				jListSucursales = new JList();
				jListSucursales.setModel(jListTallesModel);
				}
			}
			{
				jLabelIndicacion = new JLabel();
				jLabelIndicacion.setText("Elija la Sucursal a modificar y pulse Modificar:");
			}
			{
				jButtonQuitar = new JButton();
				jButtonQuitar.setText("Quitar");
				jButtonQuitar.setEnabled(false);
				jButtonQuitar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						//String emp = 	jListEmpleados.getSelectedValue().toString();
						
						DefaultComboBoxModel lm2 = (DefaultComboBoxModel) jListEmpleadosActuales.getModel();
						DefaultComboBoxModel lm1  = (DefaultComboBoxModel) jListEmpleados.getModel();
						  
						    lm1.addElement(jListEmpleadosActuales.getSelectedValue());
						    lm2.removeElement(jListEmpleadosActuales.getSelectedValue());  
						
												
					}
				});
			}
			{
				jListEmpleadosActuales = new JList();
			
				jListEmpleadosActuales.setSize(161, 82);
				
				jListEmpleadosActuales.setEnabled(false);
			}
			{
				jButtonAgregar = new JButton();
				jButtonAgregar.setText("Agregar");
				jButtonAgregar.setEnabled(false);
				jButtonAgregar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						//String emp = 	jListEmpleados.getSelectedValue().toString();
						
						DefaultComboBoxModel lm2 = (DefaultComboBoxModel) jListEmpleadosActuales.getModel();
						DefaultComboBoxModel lm1  = (DefaultComboBoxModel) jListEmpleados.getModel();
						  
						    lm2.addElement(jListEmpleados.getSelectedValue());
						    lm1.removeElement(jListEmpleados.getSelectedValue());  
						
												
					}
				});
			}
			{
				jLabelEmpleados = new JLabel();
				jLabelEmpleados.setText("Empleados: ");
				jLabelEmpleados.setVisible(false);
			}
			{
				jLabelGerenteActual = new JLabel();
				jLabelGerenteActual.setText("Empleados actuales: ");
				jLabelGerenteActual.setVisible(false);
			}
			
			{
				jListEmpleados = new JList();
				jListEmpleados.setEnabled(false);
			}
			{
				jButtonModificar = new JButton();
				jButtonModificar.setText("Modificar");
jButtonModificar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						
						String val = jListSucursales.getSelectedValue().toString();
						
						
						for(SucursalDTO busdto : listatdto){
							if(busdto.getNombre().equals(val)  ){
										jLabelIndicacion.setVisible(false);
										jLabelIndicacion2.setVisible(true);
										jButtonModificar.setEnabled(false);
										jButtonAceptar.setEnabled(true);
										jListSucursales.setEnabled(false);
										jLabelGerenteActual.setVisible(true);
										jLabelEmpleados.setVisible(true);
										jListEmpleados.setEnabled(true);
										jListEmpleadosActuales.setEnabled(true);
										jButtonAgregar.setEnabled(true);
										jButtonQuitar.setEnabled(true);
										editadodto.setId(busdto.getId());
									
														
					
										
										
										
									
								break;
							}
								
							
						}
						List<EmpleadoDTO>  listaesucdto = null;
						try {
						 listaesucdto= BusinessDelegate.getInstancia().getallEmpleadosbySucursal(editadodto.getId());
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//busco empleados 
						if(listaedto != null){
							int i = 0;
							String[] descs = new String[80];
							for (EmpleadoDTO t : listaedto){
								if(t.getFechaEgreso() == null && noEsta(t,listaesucdto)){
									
										descs[i] = t.getNombre()+ " "+ t.getApellido();
										i++;
										
									
								}
							}
							
							ListModel<String> jListEmpleadosModel = new DefaultComboBoxModel<String>(descs);
						
						
						
						
						jListEmpleados.setModel(jListEmpleadosModel);
						
						
//						ListModel jListEmpleadosActualesModel = 
//								new DefaultComboBoxModel(
//										new String[] { "Item One", "Item Two" });
//					
//						jListEmpleadosActuales.setModel(jListEmpleadosActualesModel);
						
						if(listaesucdto != null){
							int i2 = 0;
							String[] descs2 = new String[80];
							for (EmpleadoDTO t2 : listaedto){
								if(t2.getFechaEgreso() == null){
									
										descs[i2] = t2.getNombre()+ " "+ t2.getApellido();
										i2++;
										
									
								}
							}
							
							ListModel<String> jListEmpleadosActualesModel = new DefaultComboBoxModel<String>(descs2);
						
						
						
						
						jListEmpleadosActuales.setModel(jListEmpleadosActualesModel);
						
						}
						
					}
					}
				});
			}
			{
				jLabelIndicacion2 = new JLabel();
				jLabelIndicacion2.setText("Agregue los Empleados y pulse Aceptar:");
				jLabelIndicacion2.setVisible(false);
			}
			{
				jLabelMensaje = new JLabel();
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.setEnabled(false);
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.add(7)
				.add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jButtonModificar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(jLabelIndicacion2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				            .add(GroupLayout.BASELINE, jLabelGerenteActual, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.BASELINE, jLabelEmpleados, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.UNRELATED)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, jListEmpleadosActuales, 0, 219, Short.MAX_VALUE)
				            .add(GroupLayout.LEADING, jListEmpleados, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(50)
				                .add(jButtonAgregar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.UNRELATED)
				                .add(jButtonQuitar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .add(102))))
				    .add(GroupLayout.LEADING, jListSucursales, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.UNRELATED)
//				.add(jLabelNombreGerenteActual, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jButtonAceptar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(16, 16));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout.createParallelGroup()
				    .add(thisLayout.createSequentialGroup()
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, jListSucursales, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .addPreferredGap(jListSucursales, jButtonAceptar, LayoutStyle.INDENT)
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                .add(28)))
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
				                .add(191))
				            .add(thisLayout.createSequentialGroup()
				                .addPreferredGap(jLabelMensaje, jListEmpleados, LayoutStyle.INDENT)
				                .add(thisLayout.createParallelGroup()
				                    .add(thisLayout.createSequentialGroup()
				                        .add(thisLayout.createParallelGroup()
				                            .add(GroupLayout.LEADING, jListEmpleados, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
				                            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                                .add(jLabelEmpleados, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
				                                .add(31))
				                            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                                .add(jButtonModificar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                                .add(51)))
				                        .addPreferredGap(LayoutStyle.RELATED)
				                        .add(thisLayout.createParallelGroup()
				                            .add(GroupLayout.LEADING, jButtonAgregar, 0, 101, Short.MAX_VALUE)
				                            .add(GroupLayout.LEADING, jButtonQuitar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
				                        .add(17)
				                        .add(thisLayout.createParallelGroup()
				                            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                                .add(jListEmpleadosActuales, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
				                                .add(11))
				                            .add(GroupLayout.LEADING, jLabelGerenteActual, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
				                        .add(127))
				                    .add(GroupLayout.LEADING, jLabelIndicacion2, 0, 588, Short.MAX_VALUE)))))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
				        .add(16)
//				        .add(jLabelNombreGerenteActual, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
				        .add(134))));
			pack();
			this.setSize(649, 465);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
