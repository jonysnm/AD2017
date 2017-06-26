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
public class ModificarSucursalSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2767010232258321472L;
	private JList jListSucursales;
	private JTextField jTextFieldNuevoTelefonoSucursal;
	private JLabel jLabelTelefonoSucursal;
	private JTextField jTextFieldNuevoNombreSucursal;
	private JLabel jLabelNombreSucursal;
	private JButton jButtonAceptar;
	private JLabel jLabelLocalidadSucursal;
	private JTextField jTextFieldNuevaDireccionSucursal;
	private JLabel jLabelDireccionSucursal;
	private JLabel jLabelIndicacion2;
	private JButton jButtonModificar;
	private JTextField jTextFieldNuevoCPSucursal;
	private JLabel jLabelCPSucursal;
	private JTextField jTextFieldNuevaLocalidadSucursal;
	private JLabel jLabelMensaje;
	private JLabel jLabelIndicacion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ModificarSucursalSCR inst = new ModificarSucursalSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModificarSucursalSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Modificar Sucursal");
			
			final SucursalDTO editadodto = new SucursalDTO();
			final List<SucursalDTO>  listatdto = BusinessDelegate.getInstancia().getallSucursales();
			
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
				jLabelDireccionSucursal = new JLabel();
				jLabelDireccionSucursal.setText("Dirección: ");
				jLabelDireccionSucursal.setVisible(false);
			}
			{
				jTextFieldNuevaDireccionSucursal = new JTextField();
				jTextFieldNuevaDireccionSucursal.setEnabled(false);
			}
			{
				jLabelLocalidadSucursal = new JLabel();
				jLabelLocalidadSucursal.setText("Localidad: ");
				jLabelLocalidadSucursal.setVisible(false);
			}
			{
				jTextFieldNuevaLocalidadSucursal = new JTextField();
				jTextFieldNuevaLocalidadSucursal.setEnabled(false);
			}
			{
				jLabelCPSucursal = new JLabel();
				jLabelCPSucursal.setText("Código Postal: ");
				jLabelCPSucursal.setVisible(false);
			}
			{
				jTextFieldNuevoCPSucursal = new JTextField();
				jTextFieldNuevoCPSucursal.setEnabled(false);
			}
			{
				jLabelIndicacion = new JLabel();
				jLabelIndicacion.setText("Elija la Sucursal a modificar y pulse Modificar:");
			}
			{
				jLabelNombreSucursal = new JLabel();
				jLabelNombreSucursal.setText("Nombre: ");
				jLabelNombreSucursal.setVisible(false);
			}
			{
				jTextFieldNuevoNombreSucursal = new JTextField();
				jTextFieldNuevoNombreSucursal.setEnabled(false);
			}
			{
				jLabelTelefonoSucursal = new JLabel();
				jLabelTelefonoSucursal.setText("Teléfono: ");
				jLabelTelefonoSucursal.setVisible(false);
			}
			{
				jTextFieldNuevoTelefonoSucursal = new JTextField();
				jTextFieldNuevoTelefonoSucursal.setEnabled(false);
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
										jTextFieldNuevaDireccionSucursal.setText(busdto.getDireccion());
										jTextFieldNuevoNombreSucursal.setText(busdto.getNombre());
										jTextFieldNuevoTelefonoSucursal.setText(busdto.getTelefono());
										jTextFieldNuevaLocalidadSucursal.setText(busdto.getLocalidad());
										jTextFieldNuevoCPSucursal.setText(busdto.getCodigoPostal());
										
										
										jTextFieldNuevaDireccionSucursal.setEnabled(true);
										jTextFieldNuevoNombreSucursal.setEnabled(true);
										jTextFieldNuevoTelefonoSucursal.setEnabled(true);
										jTextFieldNuevaLocalidadSucursal.setEnabled(true);
										jTextFieldNuevoCPSucursal.setEnabled(true);
										
										jLabelDireccionSucursal.setVisible(true);
										jLabelNombreSucursal.setVisible(true);
										jLabelTelefonoSucursal.setVisible(true);
										jLabelLocalidadSucursal.setVisible(true);
										jLabelCPSucursal.setVisible(true);
										
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
						

						
					}
				});
			}
			{
				jLabelIndicacion2 = new JLabel();
				jLabelIndicacion2.setText("Cambie y pulse Aceptar:");
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
						
						
								try {
									editadodto.setDireccion(jTextFieldNuevaDireccionSucursal.getText());
									editadodto.setNombre(jTextFieldNuevoNombreSucursal.getText());
									editadodto.setTelefono(jTextFieldNuevoTelefonoSucursal.getText());
									editadodto.setLocalidad(jTextFieldNuevaLocalidadSucursal.getText());
									editadodto.setCodigoPostal(jTextFieldNuevoCPSucursal.getText());
									
									 BusinessDelegate.getInstancia().modificarSucursal(editadodto);
										jLabelMensaje.setText("Se actualizó la Sucursal "+ editadodto.getNombre());
										jButtonAceptar.setEnabled(false);
										jTextFieldNuevaDireccionSucursal.setEnabled(false);
										jTextFieldNuevoNombreSucursal.setEnabled(false);
										jTextFieldNuevoTelefonoSucursal.setEnabled(false);
										jTextFieldNuevaLocalidadSucursal.setEnabled(false);
										jTextFieldNuevoCPSucursal.setEnabled(false);
									} catch (RemoteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							

						
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
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				            .add(GroupLayout.BASELINE, jTextFieldNuevoNombreSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.BASELINE, jLabelNombreSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				            .add(GroupLayout.BASELINE, jTextFieldNuevaDireccionSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.BASELINE, jLabelDireccionSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				            .add(GroupLayout.BASELINE, jTextFieldNuevaLocalidadSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.BASELINE, jLabelLocalidadSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				            .add(GroupLayout.BASELINE, jTextFieldNuevoCPSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.BASELINE, jLabelCPSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.UNRELATED)
				        .add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				            .add(GroupLayout.BASELINE, jTextFieldNuevoTelefonoSucursal, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.BASELINE, jLabelTelefonoSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.UNRELATED)
				        .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jListSucursales, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
				        .add(13)))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
				        .add(15)
				        .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				        .add(52))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jListSucursales, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jLabelMensaje, 0, 378, Short.MAX_VALUE)
				                .add(33))
				            .add(GroupLayout.LEADING, jLabelIndicacion2, 0, 300, Short.MAX_VALUE)
				            .add(thisLayout.createSequentialGroup()
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, jLabelCPSucursal, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jLabelNombreSucursal, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
				                        .add(26))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jLabelTelefonoSucursal, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
				                        .add(26))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jButtonModificar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                        .add(6))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jLabelDireccionSucursal, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
				                        .add(21))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jLabelLocalidadSucursal, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
				                        .add(21)))
				                .addPreferredGap(LayoutStyle.RELATED)
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, jTextFieldNuevoTelefonoSucursal, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, jTextFieldNuevoNombreSucursal, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, jTextFieldNuevaDireccionSucursal, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, jTextFieldNuevaLocalidadSucursal, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, jTextFieldNuevoCPSucursal, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
				                .add(85))))));
			pack();
			this.setSize(557, 384);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
