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

import javax.swing.WindowConstants;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import businessDelegate.BusinessDelegate;
import dto.MateriaPrimaDTO;
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
public class BajaInsumoSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5682226552241436713L;
	private JList jListSucursales;
	private JButton jButtonAceptar;
	private JLabel jLabelMensaje;
	private JLabel jLabelIndicacion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BajaInsumoSCR inst = new BajaInsumoSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BajaInsumoSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Baja Insumo");
			final List<MateriaPrimaDTO>  listatdto = BusinessDelegate.getInstancia().getAllMP();
			{
				if(listatdto != null){
					int i = 0;
					String[] descs = new String[80];
					for (MateriaPrimaDTO t : listatdto){
						
						descs[i] = t.getNombre();
						i++;
						
					}
					
					ListModel<String> jListTallesModel = new DefaultComboBoxModel<String>(descs);
				
				
				
				jListSucursales = new JList();
				jListSucursales.setModel(jListTallesModel);
				}
				
				
			}
			{
				jLabelIndicacion = new JLabel();
				jLabelIndicacion.setText("Elija el Insumo a eliminar y pulse Aceptar:");
			}
			{
				jLabelMensaje = new JLabel();
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						
						String val = jListSucursales.getSelectedValue().toString();
						
						
						for(MateriaPrimaDTO busdto : listatdto){
							if(busdto.getNombre().equals(val)  ){
								try {
									 BusinessDelegate.getInstancia().bajaMP(busdto);
										jLabelMensaje.setText("Se dio de baja el Insumo "+ val);
										jButtonAceptar.setEnabled(false);
										jListSucursales.setEnabled(false);
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
				.addContainerGap(24, Short.MAX_VALUE)
				.add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.add(thisLayout.createParallelGroup()
				    .add(thisLayout.createSequentialGroup()
				        .add(0, 0, GroupLayout.PREFERRED_SIZE)
				        .add(jListSucursales, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(0, 64, GroupLayout.PREFERRED_SIZE)
				        .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .add(87)
				        .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(17, 17));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
				        .add(16))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(18)
				        .add(jListSucursales, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.UNRELATED)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, jLabelMensaje, 0, 183, Short.MAX_VALUE)
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(0, 53, Short.MAX_VALUE)
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				                .add(43)))))
				.addContainerGap(20, 20));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
