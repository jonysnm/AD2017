package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;


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
public class AltaEmpleadoSCR extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5765414515350828476L;
	private JLabel jLabelMensaje;
	private JButton jButtonAceptar;
	private JTextField jTextFieldFechaIngresoEmpleado;
	private JLabel jLabelFechaIngresoEmpleado;
	private JTextField jTextFieldTelefono;
	private JLabel jLabelTelefono;
	private JTextField jTextFieldApellidoEmpleado;
	private JLabel jLabelApellidoEmpleado;
	private JTextField jTextFieldNombreEmpleado;
	private JLabel jLabelNombreEmpleado;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaEmpleadoSCR inst = new AltaEmpleadoSCR();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaEmpleadoSCR() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			final LocalDate localDate = LocalDate.now();
			this.setTitle("Alta Empleado");
			GroupLayout thisLayout1 = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout1);
			{
				jButtonAceptar = new JButton();
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent arg0) {
						String nom = jTextFieldNombreEmpleado.getText();
						String ape = jTextFieldApellidoEmpleado.getText();
						String tel = jTextFieldTelefono.getText();
						String di = jTextFieldFechaIngresoEmpleado.getText();
				
					
						LocalDate datetemp = LocalDate.parse(di, dtf);
					
						
						EmpleadoDTO empleadodto = new EmpleadoDTO();
						
						
						
						empleadodto.setApellido(ape);
						empleadodto.setFechaIngreso(java.sql.Date.valueOf(datetemp));
						empleadodto.setNombre(nom);
						empleadodto.setTelefono(tel);
						
						try {
						 BusinessDelegate.getInstancia().altaEmpleado(empleadodto);
							jLabelMensaje.setText("Se creó Empleado "+ nom + " "+ape);
							jTextFieldNombreEmpleado.setText("");
							jTextFieldApellidoEmpleado.setText("");
							jTextFieldFechaIngresoEmpleado.setText(dtf.format(localDate));
							jTextFieldTelefono.setText("");
							
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
				jLabelNombreEmpleado = new JLabel();
				jLabelNombreEmpleado.setText("Nombre: ");
			}
			{
				jTextFieldNombreEmpleado = new JTextField();
			}
			{
				jLabelApellidoEmpleado = new JLabel();
				jLabelApellidoEmpleado.setText("Apellido: ");
			}
			{
				jTextFieldApellidoEmpleado = new JTextField();
			}
			{
				jLabelTelefono = new JLabel();
				jLabelTelefono.setText("Teléfono: ");
			}
			{
				jTextFieldTelefono = new JTextField();
			}
			{
				jLabelFechaIngresoEmpleado = new JLabel();
				jLabelFechaIngresoEmpleado.setText("Fecha ingreso: ");
				
			}
			{
				jTextFieldFechaIngresoEmpleado = new JTextField();
				
				jTextFieldFechaIngresoEmpleado.setText(dtf.format(localDate));
			}
			thisLayout1.setVerticalGroup(thisLayout1.createSequentialGroup()
				.addContainerGap(22, 22)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldNombreEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelNombreEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldApellidoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelApellidoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.UNRELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.RELATED)
				.add(thisLayout1.createParallelGroup(GroupLayout.BASELINE)
				    .add(GroupLayout.BASELINE, jTextFieldFechaIngresoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .add(GroupLayout.BASELINE, jLabelFechaIngresoEmpleado, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.add(21)
				.add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.UNRELATED)
				.add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(23, 23));
			thisLayout1.setHorizontalGroup(thisLayout1.createSequentialGroup()
				.addContainerGap(17, 17)
				.add(thisLayout1.createParallelGroup()
				    .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				        .add(jLabelFechaIngresoEmpleado, 0, 122, Short.MAX_VALUE)
				        .add(18)
				        .add(thisLayout1.createParallelGroup()
				            .add(GroupLayout.LEADING, jTextFieldNombreEmpleado, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, jTextFieldApellidoEmpleado, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, jTextFieldTelefono, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				            .add(GroupLayout.LEADING, jTextFieldFechaIngresoEmpleado, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				        .add(26))
				    .add(thisLayout1.createSequentialGroup()
				        .add(30)
				        .add(thisLayout1.createParallelGroup()
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(thisLayout1.createParallelGroup()
				                    .add(GroupLayout.LEADING, jLabelNombreEmpleado, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
				                    .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                        .add(jLabelApellidoEmpleado, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
				                        .add(8))
				                    .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                        .add(jLabelTelefono, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
				                        .add(8)))
				                .add(0, 30, Short.MAX_VALUE)
				                .add(jButtonAceptar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				                .add(87))
				            .add(GroupLayout.LEADING, thisLayout1.createSequentialGroup()
				                .add(20)
				                .add(jLabelMensaje, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(57, 57));
//			thisLayout1.setHorizontalGroup(thisLayout1.createSequentialGroup());
//			thisLayout1.setVerticalGroup(thisLayout1.createSequentialGroup());
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
