package app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import dto.AreaProduccionDTO;
import dto.ColorDTO;
import dto.ItemAreaTiemposDTO;
import dto.ItemColorTalleDTO;
import dto.ItemPrendaDTO;
import dto.TalleDTO;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;



class MyTableModel extends AbstractTableModel {
	
	  public void refresh() {		  
	        fireTableDataChanged();
	    }
	
	
	  public void SetLstItems(List<ItemColorTalleDTO> lstItemColorTalleGrid)
	  {
		  this.lstItemColorTalleGrid = lstItemColorTalleGrid;
	  }
	  
	public MyTableModel(List<ItemColorTalleDTO> lstItemColorTalleGrid){
		this.lstItemColorTalleGrid = lstItemColorTalleGrid;
	}
	
	List<ItemColorTalleDTO> lstItemColorTalleGrid = null;
	  private String[] columnNames = { "Color", "Talle" };

    public String getColumnName(int col) {
        return columnNames[col];
      }
	
	public int getColumnCount() {				
		return columnNames.length;
	}

	public int getRowCount() {
		return lstItemColorTalleGrid.size();
	}

	public Object getValueAt(int idItemColorTalle, int column) {
		
		Object returnValue = null;
		for (ItemColorTalleDTO itemColorTalleDTO : lstItemColorTalleGrid) {
			if(itemColorTalleDTO.getIdItemColorTalle()==idItemColorTalle)
			{
				switch (column) {
				case 0:
					returnValue = itemColorTalleDTO.getColorDTO(); 
					break;
					
				case 1:
					returnValue = itemColorTalleDTO.getTalleDTO();
					break;

				default:
					break;
				}
				
			}				
		}
		
		return returnValue;
	}
	
}

class MyTableModelAreas extends AbstractTableModel {
	
	List<ItemAreaTiemposDTO> lstItemAreaTiemposGrid = null;
	
	  public void refresh() {		  
	        fireTableDataChanged();
	    }
	
	
	  public void SetLstItems(List<ItemAreaTiemposDTO> lstItemAreaTiemposGrid)
	  {
		  this.lstItemAreaTiemposGrid = lstItemAreaTiemposGrid;
	  }
	  
	public MyTableModelAreas(List<ItemAreaTiemposDTO> lstItemAreaTiemposGrid){
		this.lstItemAreaTiemposGrid = lstItemAreaTiemposGrid;
	}
		
	  private String[] columnNames = { "Area", "Tiempo" };

  public String getColumnName(int col) {
      return columnNames[col];
    }
	
	public int getColumnCount() {				
		return columnNames.length;
	}

	public int getRowCount() {
		return lstItemAreaTiemposGrid.size();
	}

	public Object getValueAt(int idItem, int column) {
		
		Object returnValue = null;
		for (ItemAreaTiemposDTO itemAreaTiempoDTO : lstItemAreaTiemposGrid) {
			if(itemAreaTiempoDTO.getId() ==idItem)
			{
				switch (column) {
				case 0:
					returnValue = itemAreaTiempoDTO.getAreaProduccionNombre(); 
					break;
					
				case 1:
					returnValue = itemAreaTiempoDTO.getTiempo();
					break;

				default:
					break;
				}
				
			}				
		}
		
		return returnValue;
	}
	
}


public class AltaPrendaSRC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox lstColores;
	private JComboBox lstTalles;
	private JComboBox lstAreasProd;
	private JButton btnAddItemPrenda;
	private JButton btnAddItemAreaProd;
	private JButton btnGuardar;
	private int altoControles=16;
	private List<ItemColorTalleDTO> lstItemColorTalle;
	private List<ItemAreaTiemposDTO>lstAreasTiempos;
	
	private MyTableModel myTableModel;	  
	private MyTableModelAreas myTableModelAreas;
    private JTable table;
    private JTable tableAreas;
    int contador = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPrendaSRC frame = new AltaPrendaSRC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AltaPrendaSRC() {
		if(lstItemColorTalle==null)
			lstItemColorTalle = new ArrayList<ItemColorTalleDTO>();
				
		if(lstAreasTiempos==null)
			lstAreasTiempos = new ArrayList<ItemAreaTiemposDTO>();
		
		//Carga de Colores		
		 List<ColorDTO> itemColorList = new ArrayList<ColorDTO>();
		 itemColorList.add(new ColorDTO(1,"Rojo"));
		 itemColorList.add(new ColorDTO(2,"Azul"));
		 itemColorList.add(new ColorDTO(3,"Amarillo"));		
		//Fin Carga de Colores
		 
		//Carga de Colores		
		 List<TalleDTO> itemTalleList = new ArrayList<TalleDTO>();
		 itemTalleList.add(new TalleDTO(1,"Small"));
		 itemTalleList.add(new TalleDTO(2,"Medium"));
		 itemTalleList.add(new TalleDTO(3,"Large"));		
		//Fin Carga de Colores
		 
		 
		 //Carga area de Produccion
		 List<AreaProduccionDTO> lstAreaProduccion = new ArrayList<AreaProduccionDTO>();
		 lstAreaProduccion.add(new AreaProduccionDTO(1,"Estampado"));
		 lstAreaProduccion.add(new AreaProduccionDTO(2,"Tintura"));
		 lstAreaProduccion.add(new AreaProduccionDTO(3,"Planchado"));
		 lstAreaProduccion.add(new AreaProduccionDTO(4,"Otra"));		 
		 //fin Carga Area de Produccion
		 			
		lstColores = new JComboBox(itemColorList.toArray());
		lstTalles = new JComboBox(itemTalleList.toArray());
		lstAreasProd = new JComboBox(lstAreaProduccion.toArray());
		
		setTitle("Alta de Prenda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 70, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos de la nueva prenda");
		lblIngreseLosDatos.setBounds(10, 10, 200, altoControles);
		contentPane.add(lblIngreseLosDatos);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 48, 100, altoControles);
		contentPane.add(lblDescripcion);
		
		final JTextField txtDescripcion = new JTextField("");
		txtDescripcion.setBounds(100, 48, 200, altoControles);
		contentPane.add(txtDescripcion);
		
		
		JLabel lblValidity = new JLabel("Vigente:");
		lblValidity.setBounds(10, 78, 100, altoControles);
		contentPane.add(lblValidity);
		
		JRadioButton chkValidity = new JRadioButton("");
		chkValidity.setBounds(100, 78, 200, altoControles);
		contentPane.add(chkValidity);
		
		
		JSeparator separator = new JSeparator();		
		separator.setBounds(10, 110, 850, 10);
		contentPane.add(separator);
		
		JLabel lblIngreseAreasProduccion = new JLabel("Seleccionar Colores y Tales:");
		lblIngreseAreasProduccion.setBounds(10, 125, 200, altoControles);
		contentPane.add(lblIngreseAreasProduccion);
	
		lstColores.setBounds(10, 150, 100, altoControles);
		contentPane.add(lstColores);
		
		lstTalles.setBounds(150, 150, 100, altoControles);
		contentPane.add(lstTalles);
				
		//TABLA	    
	    myTableModel = new MyTableModel(lstItemColorTalle);	    
	    table = new JTable(myTableModel);
	    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 175, 400, 200);	   
	    contentPane.add(scrollPane);	    	    
	    //FIN TABLA
			
	    btnAddItemPrenda = new JButton("Agregar");
	    btnAddItemPrenda.setBounds(310, 150, 100, altoControles);
	    contentPane.add(btnAddItemPrenda);		
	    btnAddItemPrenda.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {   
	        	
					ColorDTO colorSeleccionado = (ColorDTO)lstColores.getSelectedItem();				
					TalleDTO talleSeleccionado = (TalleDTO)lstTalles.getSelectedItem();
					
					ItemColorTalleDTO itemColorTalleDTO = new ItemColorTalleDTO();				
					itemColorTalleDTO.setIdItemColorTalle(lstItemColorTalle.size());
					itemColorTalleDTO.setColorDTO(colorSeleccionado);
					itemColorTalleDTO.setTalleDTO(talleSeleccionado);
					lstItemColorTalle.add(itemColorTalleDTO);
					 										
					MyTableModel model = (MyTableModel)table.getModel();
					model.SetLstItems(lstItemColorTalle);
					model.refresh();
					
										
	        	
	        }
	    });
	    			    
	    lstAreasProd.setBounds(470, 150, 100, altoControles);
		contentPane.add(lstAreasProd);
		
		final JTextField txtTiempoArea = new JTextField("");
		txtTiempoArea.setBounds(580, 150, 100, altoControles);
		contentPane.add(txtTiempoArea);
					
	    
		
		//TABLA	Areas 
		myTableModelAreas = new MyTableModelAreas(lstAreasTiempos);	    
	    tableAreas = new JTable(myTableModelAreas);
	    tableAreas.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    JScrollPane scrollPaneAreas = new JScrollPane(tableAreas);
	    scrollPaneAreas.setBounds(470, 175, 400, 200);	   
	    contentPane.add(scrollPaneAreas);	    	    
	    //FIN TABLA Areas
		
		
		
		btnAddItemAreaProd = new JButton("Agregar");
		btnAddItemAreaProd.setBounds(685, 150, 100, altoControles);
	    contentPane.add(btnAddItemAreaProd);	
	    btnAddItemAreaProd.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {   	        
	        	AreaProduccionDTO AreaSeleccionada = (AreaProduccionDTO)lstAreasProd.getSelectedItem();				
					
				ItemAreaTiemposDTO itemAreaTiemposDTO = new ItemAreaTiemposDTO();
				itemAreaTiemposDTO.setId(lstAreasTiempos.size());
				itemAreaTiemposDTO.setAreaProduccionNombre(AreaSeleccionada.getDescripcion());
				itemAreaTiemposDTO.setTiempo(Float.parseFloat(txtTiempoArea.getText()));				
				lstAreasTiempos.add(itemAreaTiemposDTO);					
				 										
				MyTableModelAreas model = (MyTableModelAreas)tableAreas.getModel();
				model.SetLstItems(lstAreasTiempos);
				model.refresh();														
	        	
	        }
	    });
		

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(750, 400, 100, altoControles);
	    contentPane.add(btnGuardar);	
	    btnGuardar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {   	        
	        															
	        	
	        }
	    });

		
		
		
		
		
		
		
	}


	
	
}
