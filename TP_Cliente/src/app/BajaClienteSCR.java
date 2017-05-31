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
public class BajaClienteSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2029284686394835719L;
	private static BajaClienteSCR instancia = new BajaClienteSCR();
	private JLabel jLabelcuit;
	private JTextField jTextFieldcuit;
	private JButton jButtonAceptar;
	private JLabel jLabelmensaje;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BajaClienteSCR inst = new BajaClienteSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BajaClienteSCR() {
		super();
		initGUI();
	}
	
	public static BajaClienteSCR getInstancia(){
		return instancia;
	}
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Baja Cliente");
			{
				jLabelcuit = new JLabel();
				jLabelcuit.setText("ID:  ");
			}
			{
				jTextFieldcuit = new JTextField();
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						int nroCliente = Integer.parseInt(jTextFieldcuit.getText());
						
				
						try {
							BusinessDelegate.getInstancia().bajaCliente(nroCliente);
							jLabelmensaje.setText("Se dio de baja el Cliente nro: "+ Integer.toString(nroCliente));
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
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.add(6)
				.add(thisLayout.createParallelGroup()
				    .add(thisLayout.createSequentialGroup()
				        .add(86, 86, GroupLayout.PREFERRED_SIZE)
				        .add(jLabelcuit, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .add(0, 14, Short.MAX_VALUE)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jTextFieldcuit, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                .add(51))
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				                .add(57)))
				        .add(59))
				    .add(GroupLayout.LEADING, jLabelmensaje, 0, 362, Short.MAX_VALUE))
				.addContainerGap());
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(33, 33)
				.add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldcuit, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelcuit, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED, 102, GroupLayout.PREFERRED_SIZE)
				.add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.RELATED, 0, Short.MAX_VALUE)
				.add(jLabelmensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			pack();
			this.setSize(390, 262);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
