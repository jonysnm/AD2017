package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

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
				.addContainerGap(33, 33)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jTextFieldcuit, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabelcuit, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jTextFieldnombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabelnombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jTextFieldlimitecredito, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabellimiteCredito, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jTextFieldtipofacturacion, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabeltipoFacturacion, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				.addComponent(jLabelmensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGap(6)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabeltipoFacturacion, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
				        .addGap(204))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jLabellimiteCredito, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				            .addGroup(thisLayout.createSequentialGroup()
				                .addGap(66)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jLabelnombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addGap(20)
				                        .addComponent(jLabelcuit, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				                .addGap(6)))
				        .addGap(8)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jTextFieldtipofacturacion, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
				                .addGap(66))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jTextFieldlimitecredito, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
				                .addGap(65))
				            .addComponent(jTextFieldnombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(0, 0, Short.MAX_VALUE)
				                .addComponent(jTextFieldcuit, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                .addGap(51))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(0, 0, Short.MAX_VALUE)
				                .addComponent(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				                .addGap(57)))
				        .addGap(59))
				    .addComponent(jLabelmensaje, GroupLayout.Alignment.LEADING, 0, 362, Short.MAX_VALUE))
				.addContainerGap());
			pack();
			this.setSize(390, 262);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
