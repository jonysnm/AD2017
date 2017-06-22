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
import dto.TalleDTO;



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
public class AltaTalleSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2641597775436940889L;
	private static AltaTalleSCR instancia = new AltaTalleSCR();
	private JLabel jLabelDescripcion;
	private JTextField jTextFieldDescripcionTalle;
	private JLabel jLabelMensaje;
	private JButton jButtonAceptar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaTalleSCR inst = new AltaTalleSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaTalleSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta Talle");
			GroupLayout thisLayout1 = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout1);
			{
				jLabelDescripcion = new JLabel();
				jLabelDescripcion.setText("Descripción del Talle: ");
			}
			{
				jTextFieldDescripcionTalle = new JTextField();
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						String cu = jTextFieldDescripcionTalle.getText();
						
					
						TalleDTO talleDTO = new TalleDTO();
						
						talleDTO.setDescripcion(cu);
						
						try {
						 BusinessDelegate.getInstancia().altaTalle(talleDTO);
							jLabelMensaje.setText("Se dio de alta el Talle "+ cu.toUpperCase());
							jTextFieldDescripcionTalle.setText("");
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
			thisLayout1.setHorizontalGroup(thisLayout1.createSequentialGroup());
			thisLayout1.setVerticalGroup(thisLayout1.createSequentialGroup());
			thisLayout1.setVerticalGroup(thisLayout1.createSequentialGroup()
				.addContainerGap(66, 66)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldDescripcionTalle, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.add(33)
				.add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.add(22)
				.add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(64, 64));
			thisLayout1.setHorizontalGroup(thisLayout1.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout1.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				        .add(jLabelDescripcion, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(jTextFieldDescripcionTalle, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
				    .add(thisLayout1.createSequentialGroup()
				        .add(35)
				        .add(thisLayout1.createParallelGroup()
				            .add(GroupLayout.LEADING, jLabelMensaje, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(104)
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
				                .add(85)))
				        .add(23)))
				.addContainerGap(54, 54));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AltaTalleSCR getInstancia(){
		return instancia;
	}

}
