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
import dto.MateriaPrimaDTO;


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
public class AltaInsumoSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2885754997461801462L;
	private JLabel jLabelMensaje;
	private JButton jButtonAceptar;
	private JTextField jTextFieldCantidadPtoReposicionMP;
	private JLabel jLabelCantidadPtoReposicionMP;
	private JTextField jTextFieldCantidadAComprarMP;
	private JLabel jLabelCantidadAComprarMP;
	private JTextField jTextFieldNombreInsumo;
	private JLabel jLabelNombreInsumo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaInsumoSCR inst = new AltaInsumoSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaInsumoSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta Insumo");
			GroupLayout thisLayout1 = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout1);
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						String nom = jTextFieldNombreInsumo.getText();
						float cc = Float.parseFloat(jTextFieldCantidadAComprarMP.getText());
						float cr = Float.parseFloat(jTextFieldCantidadPtoReposicionMP.getText());
					
						MateriaPrimaDTO insumoDTO = new MateriaPrimaDTO();
						
						insumoDTO.setCantidadAComprar(cc);
						insumoDTO.setCantidadPtoReposicion(cr);
						insumoDTO.setNombre(nom);
						
						try {
						 BusinessDelegate.getInstancia().altaMP(insumoDTO);
							jLabelMensaje.setText("Se dio de alta el Insumo "+ nom);
							jTextFieldCantidadAComprarMP.setText("");
							jTextFieldCantidadPtoReposicionMP.setText("");
							jTextFieldNombreInsumo.setText("");
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
				jLabelNombreInsumo = new JLabel();
				jLabelNombreInsumo.setText("Nombre: ");
			}
			{
				jTextFieldNombreInsumo = new JTextField();
			}
			{
				jLabelCantidadAComprarMP = new JLabel();
				jLabelCantidadAComprarMP.setText("Cantidad a Comprar: ");
			}
			{
				jTextFieldCantidadAComprarMP = new JTextField();
			}
			{
				jLabelCantidadPtoReposicionMP = new JLabel();
				jLabelCantidadPtoReposicionMP.setText("Cantidad Punto de Reposición: ");
			}
			{
				jTextFieldCantidadPtoReposicionMP = new JTextField();
			}
			thisLayout1.setVerticalGroup(thisLayout1.createSequentialGroup()
				.addContainerGap(56, 56)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldNombreInsumo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelNombreInsumo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldCantidadAComprarMP, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelCantidadAComprarMP, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.UNRELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldCantidadPtoReposicionMP, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelCantidadPtoReposicionMP, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.add(20)
				.add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.add(20)
				.add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			thisLayout1.setHorizontalGroup(thisLayout1.createSequentialGroup()
				.addContainerGap(19, 19)
				.add(thisLayout1.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				        .add(thisLayout1.createParallelGroup()
				            .add(GroupLayout.LEADING, jLabelCantidadAComprarMP, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(jLabelNombreInsumo, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
				                .add(24)))
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(jTextFieldNombreInsumo, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
				    .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				        .add(jLabelCantidadPtoReposicionMP, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
				        .add(10)
				        .add(thisLayout1.createParallelGroup()
				            .add(GroupLayout.LEADING, jTextFieldCantidadAComprarMP, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, jTextFieldCantidadPtoReposicionMP, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
				    .add(thisLayout1.createSequentialGroup()
				        .add(21)
				        .add(thisLayout1.createParallelGroup()
				            .add(GroupLayout.LEADING, jLabelMensaje, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(130)
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				                .add(59)))
				        .add(58)))
				.addContainerGap(26, 26));
			
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
