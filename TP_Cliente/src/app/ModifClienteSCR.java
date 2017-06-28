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
public class ModifClienteSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2029284686394835719L;
	private static ModifClienteSCR instancia = new ModifClienteSCR();
	private JLabel jLabelcuit;
	private JTextField jTextFieldcuit;
	private JLabel jLabelnombre;
	private JTextField jTextFieldnombre;
	private JButton jButtonBuscar;
	private JComboBox jComboBoxTipoFact;
	private JTextField jTextFieldidcliente;
	private JButton jButtonAceptar;
	private JLabel jLabelidcliente;
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
				ModifClienteSCR inst = new ModifClienteSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModifClienteSCR() {
		super();
		initGUI();
	}
	
	public static ModifClienteSCR getInstancia(){
		return instancia;
	}
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			this.setTitle("Modificacion Cliente");
			{
				jLabelcuit = new JLabel();
				jLabelcuit.setText("CUIT:  ");
				
			}
			{
				jTextFieldcuit = new JTextField();
				jTextFieldcuit.setEnabled(false);
			}
			{
				jLabelnombre = new JLabel();
				jLabelnombre.setText("Nombre: ");
			}
			{
				jTextFieldnombre = new JTextField();
				jTextFieldnombre.setEnabled(false);
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.setEnabled(false);
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						
						
						String cu = jTextFieldcuit.getText();
						String nam = jTextFieldnombre.getText();
						String tip = jComboBoxTipoFact.getSelectedItem().toString();
						float lim = Float.parseFloat(jTextFieldlimitecredito.getText());
					
						ClienteDTO c = null;
						try {
							c = BusinessDelegate.getInstancia().buscarCliente(Integer.parseInt(jTextFieldidcliente.getText()));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						c.setCuit(cu);
						c.setLimiteCredito(lim);
						c.setNombre(nam);
						c.setTipoFacturacion(tip);
						
						try {
						
							BusinessDelegate.getInstancia().modificarCliente(c);
							jLabelmensaje.setText("Se Modifico el Cliente con Cuit: "+c.getCuit().toString());
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
				jComboBoxTipoFact.setEnabled(false);
			}
			{
				jButtonBuscar = new JButton();
				jButtonBuscar.setText("Buscar");
				jButtonBuscar.addActionListener(new ActionListener() {
					
					ClienteDTO c = null;
					public void actionPerformed(ActionEvent arg0) {
						try {
							c=BusinessDelegate.getInstancia().buscarCliente(Integer.parseInt(jTextFieldidcliente.getText()));
							
							
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						jTextFieldcuit.setText(c.getCuit());
						jTextFieldnombre.setText(c.getNombre());
						jComboBoxTipoFact.setSelectedItem(c.getTipoFacturacion());
					
						jTextFieldlimitecredito.setText(String.valueOf(c.getLimiteCredito())); 
						
						jTextFieldidcliente.setEnabled(false);
						jTextFieldcuit.setEnabled(true);
						jTextFieldlimitecredito.setEnabled(true);
						jTextFieldnombre.setEnabled(true);
						jComboBoxTipoFact.setEnabled(true);
						
						jLabelidcliente.setVisible(false);
						jButtonBuscar.setEnabled(false);
						jButtonAceptar.setEnabled(true);
					
					
						
					}
				});
			}
			{
				jLabelidcliente = new JLabel();
				jLabelidcliente.setText("Id Cliente: ");
			}
			{
				jTextFieldidcliente = new JTextField();
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
				jTextFieldlimitecredito.setEnabled(false);
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldidcliente, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelidcliente, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jButtonBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
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
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabeltipoFacturacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .add(8))
				    .add(thisLayout.createSequentialGroup()
				        .add(0, 0, Short.MAX_VALUE)
				        .add(jComboBoxTipoFact, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.RELATED)
				.add(jLabelmensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.add(6)
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabeltipoFacturacion, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jTextFieldidcliente, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
				                .add(19))
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .addPreferredGap(jTextFieldidcliente, jComboBoxTipoFact, LayoutStyle.INDENT)
				                .add(jComboBoxTipoFact, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(jButtonBuscar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				        .add(12))
				    .add(GroupLayout.LEADING, jLabelmensaje, 0, 362, Short.MAX_VALUE)
				    .add(thisLayout.createSequentialGroup()
				        .add(thisLayout.createParallelGroup()
				            .add(thisLayout.createSequentialGroup()
				                .add(46)
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, jLabelidcliente, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				                    .add(thisLayout.createSequentialGroup()
				                        .add(20)
				                        .add(thisLayout.createParallelGroup()
				                            .add(GroupLayout.LEADING, jLabelnombre, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
				                            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                                .add(20)
				                                .add(jLabelcuit, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				                        .add(14))))
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jLabellimiteCredito, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				                .add(8)))
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jTextFieldlimitecredito, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
				                .add(65))
				            .add(GroupLayout.LEADING, jTextFieldnombre, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jTextFieldcuit, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                .add(51))
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				                .add(57)))
				        .add(59)))
				.addContainerGap());
			pack();
			this.setSize(390, 262);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

