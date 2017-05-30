package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
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
	private JTextField jTextFieldidcliente;
	private JButton jButtonAceptar;
	private JLabel jLabelidcliente;
	private JLabel jLabelmensaje;
	private JTextField jTextFieldtipofacturacion;
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
				jButtonAceptar.setEnabled(false);
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						String cu = jTextFieldcuit.getText();
						String nam = jTextFieldnombre.getText();
						String tip = jTextFieldtipofacturacion.getText();
						float lim = Float.parseFloat(jTextFieldlimitecredito.getText());
					
						ClienteDTO clienteDTO = new ClienteDTO();
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
				jButtonBuscar = new JButton();
				jButtonBuscar.setText("Buscar");
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
				jTextFieldtipofacturacion = new JTextField();
			}
			{
				jLabellimiteCredito = new JLabel();
				jLabellimiteCredito.setText("Límite de Crédito: ");
			}
			{
				jTextFieldlimitecredito = new JTextField();
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
				.add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldtipofacturacion, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabeltipoFacturacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.UNRELATED)
				.add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.RELATED, 0, Short.MAX_VALUE)
				.add(jLabelmensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.add(6)
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabeltipoFacturacion, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
				        .add(jTextFieldidcliente, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
				        .add(116))
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
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jTextFieldnombre, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				                .add(51))
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, jTextFieldcuit, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jTextFieldtipofacturacion, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
				                        .add(15))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jTextFieldlimitecredito, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
				                        .add(14))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				                        .add(6)))
				                .add(25)
				                .add(jButtonBuscar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
				        .add(8)))
				.addContainerGap());
			pack();
			this.setSize(390, 262);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
