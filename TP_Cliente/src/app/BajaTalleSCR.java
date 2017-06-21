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
import javax.swing.ListModel;
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
public class BajaTalleSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8510994581443154156L;
	private static BajaTalleSCR instancia = new BajaTalleSCR();
	private JList jListTalles;
	private JButton jButtonAceptar;
	private JLabel jLabelMensaje;
	private JLabel jLabelIndicacion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BajaTalleSCR inst = new BajaTalleSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BajaTalleSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Eliminar Talle");
			final List<TalleDTO>  listatdto = BusinessDelegate.getInstancia().getAllTalle();

			{
//				List<TalleDTO>  listatdto = BusinessDelegate.getInstancia().getAllTalle();
				if(listatdto != null){
					int i = 0;
					String[] descs = new String[10];
					for (TalleDTO t : listatdto){
						descs[i] = t.getDescripcion();
						i++;
					}
					
					ListModel<String> jListTallesModel = new DefaultComboBoxModel<String>(descs);
					jListTalles = new JList();
					jListTalles.setModel(jListTallesModel);
				}
				
			}
			{
				jLabelIndicacion = new JLabel();
				jLabelIndicacion.setText("Elija el Talle a eliminar y pulse Aceptar:");
			}
			{
				jLabelMensaje = new JLabel();
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						
						String val = jListTalles.getSelectedValue().toString();
						
						for(TalleDTO busdto : listatdto){
							if(busdto.getDescripcion().equals(val)){
								try {
									 BusinessDelegate.getInstancia().bajaTalle(busdto);
										jLabelMensaje.setText("Se dio de baja el Talle "+ val);
										jButtonAceptar.setEnabled(false);
										jListTalles.setEnabled(false);
									} catch (RemoteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								break;
							}
								
							
						}
						

						
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(18, 18)
				.add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, jListTalles, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(64)
				        .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .add(87)
				        .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(17, 17));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(30, 30)
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jListTalles, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.UNRELATED)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, jLabelMensaje, 0, 183, Short.MAX_VALUE)
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(0, 53, Short.MAX_VALUE)
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
				                .add(53))))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(29)
				        .add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(20, 20));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BajaTalleSCR getInstancia(){
		return instancia;
	}
	
}
