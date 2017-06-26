package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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
public class AsignarGerenteSucursalSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1016089346764199113L;
	private JList jListSucursales;
	private JButton jButtonAceptar;
	private JLabel jLabelNombreGerenteActual;
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
				AsignarGerenteSucursalSCR inst = new AsignarGerenteSucursalSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AsignarGerenteSucursalSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Asignar Gerente a Sucursal");
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
				jLabelGerenteActual = new JLabel();
				jLabelGerenteActual.setText("Gerente actual: ");
				jLabelGerenteActual.setVisible(false);
			}
			{
				jLabelNombreGerenteActual = new JLabel();

				jLabelNombreGerenteActual.setVisible(true);
			}
			{
//				if(listaedto != null){
//					int i = 0;
//					String[] descs = new String[80];
//					for (EmpleadoDTO t : listaedto){
//						if(t.getFechaEgreso() == null){
//						descs[i] = t.getNombre()+ " "+ t.getApellido();
//						i++;
//						}
//					}
//					
//					ListModel<String> jListEmpleadosModel = new DefaultComboBoxModel<String>(descs);
//				
				
				
				jListEmpleados = new JList();
//				jListEmpleados.setModel(jListEmpleadosModel);
//				}
			
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
									
														
															
										editadodto.setDireccion(busdto.getDireccion());
										editadodto.setNombre(busdto.getNombre());
										editadodto.setTelefono(busdto.getTelefono());
										editadodto.setLocalidad(busdto.getLocalidad());
										editadodto.setCodigoPostal(busdto.getCodigoPostal());
										editadodto.setIdGerente(busdto.getIdGerente());
										editadodto.setProvincia(busdto.getProvincia());		
										editadodto.setIdRecepcionPedidos(busdto.getIdRecepcionPedidos());
										editadodto.setId(busdto.getId());
										
										
										
										
									
								break;
							}
								
							
						}
						
						if(editadodto.getIdGerente() == null)
							jLabelNombreGerenteActual.setText("Sin Gerente");
						//busco empleados 
						if(listaedto != null){
							int i = 0;
							String[] descs = new String[80];
							for (EmpleadoDTO t : listaedto){
								if(t.getFechaEgreso() == null){
									if(t.getId().equals(editadodto.getIdGerente())){ 
										jLabelNombreGerenteActual.setText(t.getNombre()+ " "+ t.getApellido());
									}
									else{
										descs[i] = t.getNombre()+ " "+ t.getApellido();
										i++;
										
									}
								}
							}
							
							ListModel<String> jListEmpleadosModel = new DefaultComboBoxModel<String>(descs);
						
						
						
						
						jListEmpleados.setModel(jListEmpleadosModel);
						}
						
					}
				});
			}
			{
				jLabelIndicacion2 = new JLabel();
				jLabelIndicacion2.setText("Elija el Gerente y pulse Aceptar:");
				jLabelIndicacion2.setVisible(false);
			}
			{
				jLabelMensaje = new JLabel();
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.setEnabled(false);
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						
						String val = null;
							if(jListEmpleados.isSelectionEmpty()){
								editadodto.setIdGerente(null);
								try {
									
									
									 
									BusinessDelegate.getInstancia().modificarSucursal(editadodto);
									 
										jLabelMensaje.setText("Se eliminó el Gerente de la Sucursal ");
										jButtonAceptar.setEnabled(false);
										jListEmpleados.setEnabled(false);
									} catch (RemoteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							}
							
							else{
								val = jListEmpleados.getSelectedValue().toString();
								
							
						
						String[] splitStr = val.split("\\s+");
						
						for(EmpleadoDTO busedto : listaedto){
							if(busedto.getNombre().equals(splitStr[0])  && busedto.getApellido().equals(splitStr[1]) ){
						
								try {
																	
									editadodto.setIdGerente(busedto.getId());
									 
									BusinessDelegate.getInstancia().modificarSucursal(editadodto);
									 
										jLabelMensaje.setText("Se asignó el Gerente "+ busedto.getNombre()+ " "+ busedto.getApellido());
										jButtonAceptar.setEnabled(false);
										jListEmpleados.setEnabled(false);
									} catch (RemoteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								break;
							}

						} }
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jButtonModificar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(jLabelIndicacion2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				        .add(25)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, jListEmpleados, 0, 173, Short.MAX_VALUE)
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jLabelGerenteActual, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.UNRELATED)
				                .add(jLabelNombreGerenteActual, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				                .add(0, 89, Short.MAX_VALUE)
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				                .add(6)))
				        .add(19)
				        .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jListSucursales, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
				        .add(13)))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jListSucursales, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .add(18)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jLabelIndicacion2, 0, 259, Short.MAX_VALUE)
				                .add(113))
				            .add(GroupLayout.LEADING, jLabelMensaje, 0, 372, Short.MAX_VALUE)
				            .add(thisLayout.createSequentialGroup()
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .addPreferredGap(jButtonModificar, jListEmpleados, LayoutStyle.INDENT)
				                        .add(jListEmpleados, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jButtonModificar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                        .add(40)))
				                .addPreferredGap(LayoutStyle.UNRELATED)
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, jLabelNombreGerenteActual, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(0, 0, Short.MAX_VALUE)
				                        .add(jLabelGerenteActual, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				                        .add(51))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(0, 34, Short.MAX_VALUE)
				                        .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                        .add(57)))
				                .add(11))))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
				        .add(133)))
				.add(6));
			pack();
			this.setSize(557, 384);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
