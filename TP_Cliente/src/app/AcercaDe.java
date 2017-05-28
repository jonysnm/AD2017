package vista;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
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
public class AcercaDe extends javax.swing.JFrame {
	private static AcercaDe instancia = new AcercaDe();
	private JPanel jPanel1;
	private JLabel jLabelSubtitulo2;
	private JLabel jLabelLogo;
	private JLabel jLabelAlumnos;
	private JLabel jLabelSubtitulo;
	private JLabel jLabelTitulo;
	private JLabel jLabelAlumno7;
	private JLabel jLabelAlumno6;
	private JLabel jLabelAlumno5;
	private JLabel jLabelAlumno4;
	private JLabel jLabelAlumno3;
	private JLabel jLabelAlumno2;
	private JLabel jLabelAlumno1;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AcercaDe inst = new AcercaDe();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private AcercaDe() {
		super();
		initGUI();
	}
	
	public static AcercaDe getInstancia(){
		return instancia;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/TP.png")).getImage());
			this.setResizable(false);
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 11");
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				{
					jLabelAlumno1 = new JLabel();
					FlowLayout jLabelLogoLayout = new FlowLayout();
					jLabelAlumno1.setText("Cah, Mauricio Nicolas - LU:134454");
					jLabelAlumno1.setLayout(null);
				}
				{
					jLabelAlumno2 = new JLabel();
					jLabelAlumno2.setText("Iantorno, Franco Luciano - LU:132061");
					jLabelAlumno2.setLayout(null);
				}
				{
					jLabelAlumno3 = new JLabel();
					jLabelAlumno3.setText("Jamilis, Laura - LU:1034273");
					jLabelAlumno3.setLayout(null);
				}
				{
					jLabelAlumno4 = new JLabel();
					jLabelAlumno4.setText("Medina, Jonathan Oscar - LU:1019735");
					jLabelAlumno4.setLayout(null);
				}
				{
					jLabelAlumno5 = new JLabel();
					jLabelAlumno5.setText("Suarez, Arturo Gabriel - LU:1036021");
					jLabelAlumno5.setLayout(null);
				}
				{
					jLabelTitulo = new JLabel();
					jLabelTitulo.setText("Aplicaciones Distribuidas");
					jLabelTitulo.setLayout(null);
					jLabelTitulo.setFont(new java.awt.Font("Tahoma",1,20));
				}
				{
					jLabelSubtitulo2 = new JLabel();
					FlowLayout jLabelSubtitulo2Layout = new FlowLayout();
					jLabelSubtitulo2.setText("1° Cuatrimestre - Curso: Lunes Noche");
					jLabelSubtitulo2.setLayout(null);
					jLabelSubtitulo2.setFont(new java.awt.Font("Tahoma",1,14));
				}
				{
					jLabelLogo = new JLabel();
					FlowLayout jLabelLogoLayout = new FlowLayout();
					jLabelLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/uadePequeno.jpg")));
					jLabelLogo.setLayout(null);
				}
				{
					jLabelSubtitulo = new JLabel();
					jLabelSubtitulo.setText("Trabajo Practico Obligatorio");
					jLabelSubtitulo.setLayout(null);
					jLabelSubtitulo.setFont(new java.awt.Font("Tahoma",1,18));
				}
				{
					jLabelAlumnos = new JLabel();
					jLabelAlumnos.setText("Alumnos");
					jLabelAlumnos.setLayout(null);
					jLabelAlumnos.setFont(new java.awt.Font("Tahoma",1,11));
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 210, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 181, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 183, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 243, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumnos, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					        .addGap(16)
					        .addGroup(jPanel1Layout.createParallelGroup()
					            .addComponent(jLabelSubtitulo, GroupLayout.Alignment.LEADING, 0, 261, Short.MAX_VALUE)
					            .addComponent(jLabelTitulo, GroupLayout.Alignment.LEADING, 0, 261, Short.MAX_VALUE)
					            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                .addGap(32)
					                .addComponent(jLabelLogo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					                .addGap(0, 29, Short.MAX_VALUE)))
					        .addGap(54))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 254, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 219, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 182, Short.MAX_VALUE))
					    .addComponent(jLabelSubtitulo2, GroupLayout.Alignment.LEADING, 0, 382, Short.MAX_VALUE))
					.addContainerGap());
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addComponent(jLabelLogo, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addComponent(jLabelTitulo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelSubtitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelSubtitulo2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(jLabelAlumnos, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelAlumno1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelAlumno2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelAlumno3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelAlumno4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelAlumno5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel1, 0, 346, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel1, 0, 402, Short.MAX_VALUE));
			pack();
			this.setSize(408, 371);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
