package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.ColorDTO;

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
public class AltaColorSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2641597775436940889L;
	private static AltaColorSCR instancia = new AltaColorSCR();
	private JLabel jLabelDescripcion;
	private JTextField jTextFieldDescripcionColor;
	private JLabel jLabelMensaje;
	private JButton jButtonAceptar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaColorSCR inst = new AltaColorSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaColorSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta Color");
			GroupLayout thisLayout1 = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout1);
			{
				jLabelDescripcion = new JLabel();
				jLabelDescripcion.setText("Descripción del Color: ");
			}
			{
				jTextFieldDescripcionColor = new JTextField();
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						String cu = jTextFieldDescripcionColor.getText();
						
					
						ColorDTO colorDTO = new ColorDTO();
						
						colorDTO.setDescripcion(cu);
						
						try {
						 BusinessDelegate.getInstancia().altaColor(colorDTO);
							jLabelMensaje.setText("Se dio de alta el Color "+ cu.toUpperCase());
							jTextFieldDescripcionColor.setText("");
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
				    .add(GroupLayout.BASELINE, jTextFieldDescripcionColor, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
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
				        .add(jTextFieldDescripcionColor, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
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

	public static AltaColorSCR getInstancia(){
		return instancia;
	}

}
