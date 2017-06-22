package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.time.LocalDate;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
public class AltaSucursalSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 676879079744349395L;
	private JLabel jLabelMensaje;
	private JButton jButtonAceptar;
	private JLabel jLabelTelefonoSucursal;
	private JTextField jTextFieldCPSucursal;
	private JLabel jLabelCPSucursal;
	private JTextField jTextFieldLocalidadSucursal;
	private JLabel jLabelLocalidadSucursal;
	private JComboBox jComboBoxProvinciaSucursal;
	private JLabel jLabelProvinciaSucursal;
	private JTextField jTextFieldDireccionSucursal;
	private JTextField jTextFieldTelefonoSucursal;
	private JLabel jLabelDireccionSucursal;
	private JTextField jTextFieldNombreSucursal;
	private JLabel jLabelNombreSucursal;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaSucursalSCR inst = new AltaSucursalSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaSucursalSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta Sucursal");
			GroupLayout thisLayout1 = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout1);
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						String nom = jTextFieldNombreSucursal.getText();
						String dir = jTextFieldDireccionSucursal.getText();
						String tel = jTextFieldTelefonoSucursal.getText();
						String loc = jTextFieldLocalidadSucursal.getText();
						String prov = jComboBoxProvinciaSucursal.getSelectedItem().toString();
						String cp = jTextFieldCPSucursal.getText();
						
				
					
						
					
						
						SucursalDTO	sucdto = new SucursalDTO();
						
						
						
			
						sucdto.setNombre(nom);
						sucdto.setTelefono(tel);
						sucdto.setDireccion(dir);
						sucdto.setLocalidad(loc);
						sucdto.setProvincia(prov);
						sucdto.setCodigoPostal(cp);
						
						try {
						 BusinessDelegate.getInstancia().crearSucursal(sucdto);
							jLabelMensaje.setText("Se creó Sucursal "+ nom );
							jTextFieldNombreSucursal.setText("");
							jTextFieldDireccionSucursal.setText("");
							jTextFieldLocalidadSucursal.setText("");
							jTextFieldTelefonoSucursal.setText("");
							jTextFieldCPSucursal.setText("");
							
							
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
			}
			{
				jLabelMensaje = new JLabel();
			}
			{
				jLabelNombreSucursal = new JLabel();
				jLabelNombreSucursal.setText("Nombre: ");
			}
			{
				jTextFieldNombreSucursal = new JTextField();
			}
			{
				jLabelDireccionSucursal = new JLabel();
				jLabelDireccionSucursal.setText("Dirección: ");
			}
			{
				jTextFieldDireccionSucursal = new JTextField();
			}
			{
				jLabelProvinciaSucursal = new JLabel();
				jLabelProvinciaSucursal.setText("Provincia: ");
			}
			{
				ComboBoxModel jComboBoxProvinciaSucursalModel = 
						new DefaultComboBoxModel(
								new String[] { "CABA", "Buenos Aires", "Cordoba", "San Juan", "San Luis", "Corrientes", "Neuquen", "Salta" });
				jComboBoxProvinciaSucursal = new JComboBox();
				jComboBoxProvinciaSucursal.setModel(jComboBoxProvinciaSucursalModel);
			}
			{
				jLabelLocalidadSucursal = new JLabel();
				jLabelLocalidadSucursal.setText("Localidad: ");
			}
			{
				jTextFieldLocalidadSucursal = new JTextField();
			}
			{
				jLabelCPSucursal = new JLabel();
				jLabelCPSucursal.setText("Código Postal: ");
			}
			{
				jTextFieldCPSucursal = new JTextField();
			}
			{
				jLabelTelefonoSucursal = new JLabel();
				jLabelTelefonoSucursal.setText("Teléfono: ");
			}
			{
				jTextFieldTelefonoSucursal = new JTextField();
			}
			thisLayout1.setVerticalGroup(thisLayout1.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldNombreSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelNombreSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldDireccionSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelDireccionSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jComboBoxProvinciaSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelProvinciaSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldLocalidadSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelLocalidadSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldCPSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelCPSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldTelefonoSucursal, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelTelefonoSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED, 12, Short.MAX_VALUE)
				.add(thisLayout1.createParallelGroup()
				    .add(GroupLayout.LEADING, jButtonAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				        .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				        .add(7)))
				.addContainerGap());
			thisLayout1.setHorizontalGroup(thisLayout1.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout1.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				        .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
				        .add(0, 24, Short.MAX_VALUE)
				        .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				    .add(thisLayout1.createSequentialGroup()
				        .addPreferredGap(jLabelMensaje, jLabelNombreSucursal, LayoutStyle.INDENT)
				        .add(thisLayout1.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(jLabelNombreSucursal, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				                .add(21))
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(jLabelDireccionSucursal, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				                .add(21))
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(jLabelProvinciaSucursal, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				                .add(35))
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(jLabelLocalidadSucursal, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				                .add(21))
				            .add(GroupLayout.LEADING, jLabelCPSucursal, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(jLabelTelefonoSucursal, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				                .add(21)))
				        .add(22)
				        .add(thisLayout1.createParallelGroup()
				            .add(GroupLayout.LEADING, jTextFieldNombreSucursal, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, jTextFieldDireccionSucursal, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, jComboBoxProvinciaSucursal, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, jTextFieldLocalidadSucursal, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, jTextFieldCPSucursal, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, jTextFieldTelefonoSucursal, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
				        .add(70)))
				.addContainerGap());
//			thisLayout1.setHorizontalGroup(thisLayout1.createSequentialGroup());
//			thisLayout1.setVerticalGroup(thisLayout1.createSequentialGroup());
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
