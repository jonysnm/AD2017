package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;


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
public class AltaClienteSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2029284686394835719L;
	private static AltaClienteSCR instancia = new AltaClienteSCR();
	private JLabel jLabelcuit;
	private JTextField jTextFieldcuit;
	private JLabel jLabelnombre;
	private JTextField jTextFieldnombre;
	private JButton jButtonAceptar;
	private JComboBox jComboBoxTipoFact;
	private JLabel jLabelmensaje;
	private JLabel jLabeltipoFacturacion;
	private JTextField jTextFieldlimitecredito;
	private JLabel jLabellimiteCredito;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaClienteSCR inst = new AltaClienteSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaClienteSCR() {
		super();
		initGUI();
	}
	
	public static AltaClienteSCR getInstancia(){
		return instancia;
	}
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta Cliente");
			{
				jLabelcuit = new JLabel();
				jLabelcuit.setText("CUIT:  ");
			}
			{
				jTextFieldcuit = new JTextField();
			}
			{
				jLabelnombre = new JLabel();
				jLabelnombre.setText("Nombre: ");
			}
			{
				jTextFieldnombre = new JTextField();
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						String cu = jTextFieldcuit.getText();
						String nam = jTextFieldnombre.getText();
						String tip = jComboBoxTipoFact.getSelectedItem().toString();
							
						float lim = Float.parseFloat(jTextFieldlimitecredito.getText());
					
						ClienteDTO clienteDTO = new ClienteDTO();
						//clienteDTO.setId(1);
						clienteDTO.setCuit(cu);
						clienteDTO.setLimiteCredito(lim);
						clienteDTO.setNombre(nam);
						clienteDTO.setTipoFacturacion(tip);
						Integer nroCliente;
						try {
							nroCliente = BusinessDelegate.getInstancia().altaCliente(clienteDTO);
							jLabelmensaje.setText("Se dio de alta el Cliente nro: "+nroCliente.toString());
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
			}
			{
				jLabelmensaje = new JLabel();
			}
			{
				ComboBoxModel jComboBoxTipoFactModel = 
						new DefaultComboBoxModel(
								new String[] { "A", "B", "C" });
				jComboBoxTipoFact = new JComboBox();
				jComboBoxTipoFact.setModel(jComboBoxTipoFactModel);
			}
			{
				jLabeltipoFacturacion = new JLabel();
				jLabeltipoFacturacion.setText("Tipo de Facturación: ");
			}
			{
				jLabellimiteCredito = new JLabel();
				jLabellimiteCredito.setText("Límite de Crédito: ");
			}
			{
				jTextFieldlimitecredito = new JTextField();
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(29, 29)
				.add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldcuit, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelcuit, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldnombre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldlimitecredito, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabellimiteCredito, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jComboBoxTipoFact, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabeltipoFacturacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.UNRELATED)
				.add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.RELATED, 0, Short.MAX_VALUE)
				.add(jLabelmensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.add(6)
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabeltipoFacturacion, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
				        .add(jComboBoxTipoFact, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .add(109))
				    .add(thisLayout.createSequentialGroup()
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, jLabellimiteCredito, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				            .add(thisLayout.createSequentialGroup()
				                .add(66)
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, jLabelnombre, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(20)
				                        .add(jLabelcuit, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				                .add(6)))
				        .add(8)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jTextFieldlimitecredito, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
				                .add(65))
				            .add(GroupLayout.LEADING, jTextFieldnombre, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(0, 0, Short.MAX_VALUE)
				                .add(jTextFieldcuit, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                .add(51))
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				                .add(57)))
				        .add(59))
				    .add(GroupLayout.LEADING, jLabelmensaje, 0, 362, Short.MAX_VALUE))
				.addContainerGap());
			pack();
			this.setSize(390, 262);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
