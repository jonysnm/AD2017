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
import dto.EmpleadoDTO;

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
public class ModificarEmpleadoSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2632340069447033644L;
	private JList jListEmpleados;
	private JTextField jTextFieldNuevoTelefonoEmpleado;
	private JLabel jLabelTelefonoEmpleado;
	private JTextField jTextFieldNuevoApellidoEmpleado;
	private JLabel jLabelApellidoEmpleado;
	private JTextField jTextFieldNuevoNombreEmpleado;
	private JLabel jLabelNombreEmpleado;
	private JButton jButtonAceptar;
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
				ModificarEmpleadoSCR inst = new ModificarEmpleadoSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModificarEmpleadoSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Modificar Empleado");
			final EmpleadoDTO editadodto = new EmpleadoDTO();
			final List<EmpleadoDTO>  listatdto = BusinessDelegate.getInstancia().getallEmpleados();
			{
				
				if(listatdto != null){
					int i = 0;
					String[] descs = new String[80];
					for (EmpleadoDTO t : listatdto){
						if(t.getFechaEgreso() == null){
						descs[i] = t.getNombre()+ " "+ t.getApellido();
						i++;
						}
					}
					
					ListModel<String> jListTallesModel = new DefaultComboBoxModel<String>(descs);
				
				
				
				jListEmpleados = new JList();
				jListEmpleados.setModel(jListTallesModel);
				}
			}
			{
				jLabelIndicacion = new JLabel();
				jLabelIndicacion.setText("Elija el Empleado a modificar y pulse Modificar:");
			}
			{
				jLabelNombreEmpleado = new JLabel();
				jLabelNombreEmpleado.setText("Nombre: ");
				jLabelNombreEmpleado.setVisible(false);
			}
			{
				jTextFieldNuevoNombreEmpleado = new JTextField();
				jTextFieldNuevoNombreEmpleado.setEnabled(false);
			}
			{
				jLabelApellidoEmpleado = new JLabel();
				jLabelApellidoEmpleado.setText("Apellido: ");
				jLabelApellidoEmpleado.setVisible(false);
			}
			{
				jTextFieldNuevoApellidoEmpleado = new JTextField();
				jTextFieldNuevoApellidoEmpleado.setEnabled(false);
			}
			{
				jLabelTelefonoEmpleado = new JLabel();
				jLabelTelefonoEmpleado.setText("Teléfono: ");
				jLabelTelefonoEmpleado.setVisible(false);
			}
			{
				jTextFieldNuevoTelefonoEmpleado = new JTextField();
				jTextFieldNuevoTelefonoEmpleado.setEnabled(false);
			}
			{
				jButtonModificar = new JButton();
				jButtonModificar.setText("Modificar");
				jButtonModificar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						
						String val = jListEmpleados.getSelectedValue().toString();
						
						String[] splitStr = val.split("\\s+");
						
						for(EmpleadoDTO busdto : listatdto){
							if(busdto.getNombre().equals(splitStr[0])  && busdto.getApellido().equals(splitStr[1]) ){
										jLabelIndicacion.setVisible(false);
										jLabelIndicacion2.setVisible(true);
										jButtonModificar.setEnabled(false);
										jButtonAceptar.setEnabled(true);
										jListEmpleados.setEnabled(false);
										jTextFieldNuevoApellidoEmpleado.setText(busdto.getApellido());
										jTextFieldNuevoNombreEmpleado.setText(busdto.getNombre());
										jTextFieldNuevoTelefonoEmpleado.setText(busdto.getTelefono());
										jTextFieldNuevoApellidoEmpleado.setEnabled(true);
										jTextFieldNuevoTelefonoEmpleado.setEnabled(true);
										jTextFieldNuevoNombreEmpleado.setEnabled(true);
										jLabelTelefonoEmpleado.setVisible(true);
										jLabelApellidoEmpleado.setVisible(true);
										jLabelNombreEmpleado.setVisible(true);
										editadodto.setApellido(busdto.getApellido());
										editadodto.setNombre(busdto.getNombre());
										editadodto.setTelefono(busdto.getTelefono());
										editadodto.setFechaEgreso(busdto.getFechaEgreso());
										editadodto.setFechaIngreso(busdto.getFechaIngreso());
										editadodto.setId(busdto.getId());
										
										
									
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
									editadodto.setApellido(jTextFieldNuevoApellidoEmpleado.getText());
									editadodto.setNombre(jTextFieldNuevoNombreEmpleado.getText());
									editadodto.setTelefono(jTextFieldNuevoTelefonoEmpleado.getText());
									 BusinessDelegate.getInstancia().modificarEmpleado(editadodto);
										jLabelMensaje.setText("Se actualizó el Empleado "+ editadodto.getNombre()+ " "+ editadodto.getApellido());
										jButtonAceptar.setEnabled(false);
										jTextFieldNuevoApellidoEmpleado.setEnabled(false);
										jTextFieldNuevoTelefonoEmpleado.setEnabled(false);
										jTextFieldNuevoNombreEmpleado.setEnabled(false);
									} catch (RemoteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							

						
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jButtonModificar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(jLabelIndicacion2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				            .add(GroupLayout.BASELINE, jTextFieldNuevoNombreEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.BASELINE, jLabelNombreEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup(GroupLayout.BASELINE)
				            .add(GroupLayout.BASELINE, jTextFieldNuevoApellidoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.BASELINE, jLabelApellidoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.RELATED)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createParallelGroup(GroupLayout.BASELINE)
				                .add(GroupLayout.BASELINE, jTextFieldNuevoTelefonoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .add(GroupLayout.BASELINE, jLabelTelefonoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(0, 18, Short.MAX_VALUE)
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
				        .addPreferredGap(LayoutStyle.UNRELATED)
				        .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jListEmpleados, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.RELATED)))
				.addContainerGap(18, 18));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.add(thisLayout.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jListEmpleados, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .add(18)
				        .add(thisLayout.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, jButtonModificar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jLabelNombreEmpleado, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
				                        .add(20))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jLabelApellidoEmpleado, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				                        .add(10))
				                    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                        .add(jLabelTelefonoEmpleado, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
				                        .add(20)))
				                .addPreferredGap(LayoutStyle.RELATED)
				                .add(thisLayout.createParallelGroup()
				                    .add(GroupLayout.LEADING, jTextFieldNuevoNombreEmpleado, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, jTextFieldNuevoApellidoEmpleado, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, jTextFieldNuevoTelefonoEmpleado, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
				                .addPreferredGap(LayoutStyle.RELATED)
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                .add(11))
				            .add(GroupLayout.LEADING, jLabelIndicacion2, 0, 378, Short.MAX_VALUE)
				            .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				                .add(jLabelMensaje, 0, 351, Short.MAX_VALUE)
				                .add(27))))
				    .add(GroupLayout.LEADING, thisLayout.createSequentialGroup()
				        .add(jLabelIndicacion, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
				        .add(139))));
			pack();
			this.setSize(557, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
