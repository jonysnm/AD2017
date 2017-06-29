package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import businessDelegate.BusinessDelegate;
import dto.MateriaPrimaDTO;
import dto.SucursalDTO;


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
public class ModificarInsumoSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3079332979776201L;
	private JList jListTalles;
	private JButton jButtonAceptar;
	private JTextField jTextFieldCantPtoReposcion;
	private JLabel jLabelCantPuntoReposicion;
	private JTextField jTextFieldCantidadAComprarInsumo;
	private JLabel jLabelCantidadaComprarInsumo;
	private JTextField jTextFieldNombreInsumo;
	private JLabel jLabelNombreInsumo;
	private JLabel jLabelIndicacion2;
	private JButton jButtonModificar;
	private JLabel jLabelMensaje;
	private JLabel jLabelIndicacion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ModificarInsumoSCR inst = new ModificarInsumoSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModificarInsumoSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Modificar Insumo");
			final MateriaPrimaDTO editadodto = new MateriaPrimaDTO();
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
				
				
				
					jListTalles = new JList();
				jListTalles.setModel(jListTallesModel);
				}
				
				
			}
			{
				jLabelIndicacion = new JLabel();
				jLabelIndicacion.setText("Elija el Insumo a modificar y pulse Modificar:");
			}
			{
				jTextFieldCantPtoReposcion = new JTextField();
				jTextFieldCantPtoReposcion.setEnabled(false);
			}
			{
				jLabelNombreInsumo = new JLabel();
				jLabelNombreInsumo.setText("Nombre: ");
			}
			{
				jTextFieldNombreInsumo = new JTextField();
				jTextFieldNombreInsumo.setEnabled(false);
			}
			{
				jLabelCantidadaComprarInsumo = new JLabel();
				jLabelCantidadaComprarInsumo.setText("Cantidad a Comprar:");
			}
			{
				jTextFieldCantidadAComprarInsumo = new JTextField();
				jTextFieldCantidadAComprarInsumo.setEnabled(false);
			}
			{
				jLabelCantPuntoReposicion = new JLabel();
				jLabelCantPuntoReposicion.setText("Cantidad Punto Reposición: ");
			}
			{
				jButtonModificar = new JButton();
				jButtonModificar.setText("Modificar");
jButtonModificar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						
						String val = jListTalles.getSelectedValue().toString();
						
						
						for(MateriaPrimaDTO busdto : listatdto){
							if(busdto.getNombre().equals(val)  ){
										jLabelIndicacion.setVisible(false);
										jLabelIndicacion2.setVisible(true);
										jButtonModificar.setEnabled(false);
										jButtonAceptar.setEnabled(true);
										jListTalles.setEnabled(false);
										jTextFieldCantidadAComprarInsumo.setText(busdto.getCantidadAComprar().toString());
										jTextFieldCantPtoReposcion.setText(busdto.getCantidadPtoReposicion().toString());
										jTextFieldNombreInsumo.setText(busdto.getNombre());
										
										jTextFieldCantidadAComprarInsumo.setEnabled(true);
										jTextFieldCantPtoReposcion.setEnabled(true);
										jTextFieldNombreInsumo.setEnabled(true);
										
										jLabelCantidadaComprarInsumo.setVisible(true);
										jLabelCantPuntoReposicion.setVisible(true);
										jLabelNombreInsumo.setVisible(true);
										
										
										editadodto.setCantidadAComprar(busdto.getCantidadAComprar());
										editadodto.setNombre(busdto.getNombre());
										editadodto.setCantidadPtoReposicion(busdto.getCantidadPtoReposicion());
										editadodto.setCodigo(busdto.getCodigo());
										
										
										
									
								break;
							}
								
							
						}
						

						
					}
				});
				
			}
			{
				jLabelIndicacion2 = new JLabel();
				jLabelIndicacion2.setText("Cambie y pulse Aceptar:");
			}
			{
				jLabelMensaje = new JLabel();
			}
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.setEnabled(false);
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						
						
								try {
									editadodto.setCantidadAComprar(Float.parseFloat(jTextFieldCantidadAComprarInsumo.getText()));
									editadodto.setCantidadPtoReposicion(Float.parseFloat(jTextFieldCantPtoReposcion.getText()));
									editadodto.setNombre(jTextFieldNombreInsumo.getText());
									
									 BusinessDelegate.getInstancia().modificarMP(editadodto);
										jLabelMensaje.setText("Se actualizó el Insumo "+ editadodto.getNombre());
										jButtonAceptar.setEnabled(false);
										jTextFieldCantidadAComprarInsumo.setEnabled(false);
										jTextFieldCantPtoReposcion.setEnabled(false);
										jTextFieldNombreInsumo.setEnabled(false);
				
									} catch (RemoteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							

						
					}
				});
				
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jButtonModificar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(jLabelIndicacion2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(jTextFieldNombreInsumo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jLabelNombreInsumo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(jTextFieldCantidadAComprarInsumo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jLabelCantidadaComprarInsumo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(jTextFieldCantPtoReposcion, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jLabelCantPuntoReposicion, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				    .addComponent(jListTalles, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addGap(26)
				.addComponent(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(25, 25));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jListTalles, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jLabelCantPuntoReposicion, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jLabelCantidadaComprarInsumo, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
				                        .addGap(60)))
				                .addGap(18)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jButtonAceptar, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jTextFieldCantPtoReposcion, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
				                        .addGap(11))
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jTextFieldCantidadAComprarInsumo, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
				                        .addGap(11)))
				                .addGap(37))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jLabelNombreInsumo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(jButtonModificar, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
				                .addGap(45)
				                .addComponent(jTextFieldNombreInsumo, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
				                .addGap(48))
				            .addComponent(jLabelIndicacion2, GroupLayout.Alignment.LEADING, 0, 381, Short.MAX_VALUE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(0, 18, Short.MAX_VALUE)
				                .addComponent(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
				                .addGap(109))))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
				        .addGap(166))));
			pack();
			this.setSize(529, 350);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
