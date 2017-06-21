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
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import businessDelegate.BusinessDelegate;
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
public class ModificarColorSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4175342192477128374L;
	private JList jListColores;
	private JButton jButtonAceptar;
	private JLabel jLabelIndicacion2;
	private JButton jButtonModificar;
	private JTextField jTextFieldNuevaDescripcion;
	private JLabel jLabelMensaje;
	private JLabel jLabelIndicacion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ModificarColorSCR inst = new ModificarColorSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModificarColorSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Modificar Color");
			
			
			
			final List<ColorDTO>  listatdto = BusinessDelegate.getInstancia().getAllColor();
			final ColorDTO editadodto = new ColorDTO();

			{
//				List<TalleDTO>  listatdto = BusinessDelegate.getInstancia().getAllTalle();
				if(listatdto != null){
					int i = 0;
					String[] descs = new String[10];
					for (ColorDTO t : listatdto){
						descs[i] = t.getDescripcion();
						i++;
					}
					
					ListModel<String> jListColoresModel = new DefaultComboBoxModel<String>(descs);
					jListColores = new JList();
					jListColores.setModel(jListColoresModel);
				}
				
			}
			{
				jLabelIndicacion = new JLabel();
				jLabelIndicacion.setText("Elija el Color a modificar y pulse Modificar:");
			}
			{
				jTextFieldNuevaDescripcion = new JTextField();
				jTextFieldNuevaDescripcion.setEnabled(false);
			}
			{
				jButtonModificar = new JButton();
				jButtonModificar.setText("Modificar");
				jButtonModificar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						
						String val = jListColores.getSelectedValue().toString();
						
						for(ColorDTO busdto : listatdto){
							if(busdto.getDescripcion().equals(val)){
										jLabelIndicacion.setVisible(false);
										jLabelIndicacion2.setVisible(true);
										jButtonModificar.setEnabled(false);
										jButtonAceptar.setEnabled(true);
										jListColores.setEnabled(false);
										jTextFieldNuevaDescripcion.setText(val);
										jTextFieldNuevaDescripcion.setEnabled(true);
										editadodto.setIdColor(busdto.getIdColor());
										editadodto.setDescripcion(val);
										
										
									
								break;
							}
								
							
						}
						

						
					}
				});
			}
			{
				jLabelIndicacion2 = new JLabel();
				jLabelIndicacion2.setText("Cambie y pulse Aceptar:");
				jLabelIndicacion2.setVisible(false);
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
									editadodto.setDescripcion(jTextFieldNuevaDescripcion.getText().toUpperCase());
									 BusinessDelegate.getInstancia().modificarColor(editadodto);
										jLabelMensaje.setText("Se actualizó el Color "+ editadodto.getDescripcion());
										jButtonAceptar.setEnabled(false);
										jTextFieldNuevaDescripcion.setEnabled(false);
									} catch (RemoteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							

						
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(17, 17)
				.add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jButtonModificar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .add(0, 46, Short.MAX_VALUE)
				        .add(jLabelIndicacion2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.UNRELATED)
				        .add(jTextFieldNuevaDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.UNRELATED)
				        .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				    .add(GroupLayout.LEADING, jListColores, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(18, 18));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jListColores, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .add(18)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jButtonModificar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                .add(111))
				            .add(GroupLayout.LEADING, jLabelIndicacion2, 0, 221, Short.MAX_VALUE)
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jLabelMensaje, 0, 189, Short.MAX_VALUE)
				                .add(32))
				            .add(thisLayout.createSequentialGroup()
				                .add(19)
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, jTextFieldNuevaDescripcion, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(0, 27, Short.MAX_VALUE)
				                        .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                        .add(30)))
				                .add(46))))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
				        .add(46))));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
