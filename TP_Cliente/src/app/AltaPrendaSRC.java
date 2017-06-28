package app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
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

import businessDelegate.BusinessDelegate;
import dto.AreaProduccionDTO;
import dto.AreaProduccionInvolucradaDTO;
import dto.ColorDTO;
import dto.ItemAreaTiemposDTO;
import dto.ItemColorTalleDTO;
import dto.ItemMaterialPrendaDTO;
import dto.ItemPrendaDTO;
import dto.MateriaPrimaDTO;
import dto.MaterialesPorPrendaDTO;
import dto.PrendaDTO;
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


class MyTableModelMateriales extends AbstractTableModel {
	
	List<MaterialesPorPrendaDTO> lstItemMaterialPrendaGrid = null;
	
	  public void refresh() {		  
	        fireTableDataChanged();
	    }
	
	
	  public void SetLstItems(List<MaterialesPorPrendaDTO> lstItemMaterialPrendaGrid)
	  {
		  this.lstItemMaterialPrendaGrid = lstItemMaterialPrendaGrid;
	  }
	  
	public MyTableModelMateriales(List<MaterialesPorPrendaDTO> lstItemMaterialPrendaGrid){
		this.lstItemMaterialPrendaGrid = lstItemMaterialPrendaGrid;
	}
		
	  private String[] columnNames = { "Material", "Cantidad", "Desperdicio" };

  public String getColumnName(int col) {
      return columnNames[col];
    }
	
	public int getColumnCount() {				
		return columnNames.length;
	}

	public int getRowCount() {
		return lstItemMaterialPrendaGrid.size();
	}

	public Object getValueAt(int idItem, int column) {
		
		Object returnValue = null;
		for (MaterialesPorPrendaDTO itemMaterialPrendaDTO : lstItemMaterialPrendaGrid) {
			if(itemMaterialPrendaDTO.getId() ==idItem)
			{
				switch (column) {
				case 0:
					returnValue = itemMaterialPrendaDTO.getNombreMaterial(); 
					break;
					
				case 1:
					returnValue = itemMaterialPrendaDTO.getCantidad();
					break;
				case 2:
					returnValue = itemMaterialPrendaDTO.getDesperdicio();
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
	private JComboBox ddlMateriaPrima;
	private JButton btnAddItemPrenda;
	private JButton btnAddItemMaterialPrenda;
	private JButton btnAddItemAreaProd;
	private JButton btnGuardar;
	private int altoControles=16;
	private List<ItemColorTalleDTO> lstItemColorTalle;
	private List<ItemAreaTiemposDTO>lstAreasTiempos;
	private List<MaterialesPorPrendaDTO> lstMaterialesporPrenda;
	
	private MyTableModel myTableModel;	  
	private MyTableModelAreas myTableModelAreas;
	private MyTableModelMateriales myTableModelMateriales;
    private JTable table;
    private JTable tableAreas;
    private JTable tableMateriales;
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
	
	public AltaPrendaSRC() throws RemoteException {
		if(lstItemColorTalle==null)
			lstItemColorTalle = new ArrayList<ItemColorTalleDTO>();
				
		if(lstAreasTiempos==null)
			lstAreasTiempos = new ArrayList<ItemAreaTiemposDTO>();
		
		if(lstMaterialesporPrenda==null)
			lstMaterialesporPrenda = new ArrayList<MaterialesPorPrendaDTO>();
		
		//Carga de Colores							
		 List<ColorDTO> itemColorList = BusinessDelegate.getInstancia().getAllColor();		 
		//Fin Carga de Colores
		 
		//Carga de Colores		
		 List<TalleDTO> itemTalleList = BusinessDelegate.getInstancia().getAllTalle();
		//Fin Carga de Colores
		 
		 
		 //Carga area de Produccion
		 List<AreaProduccionDTO> lstAreaProduccion = BusinessDelegate.getInstancia().getAllAreaDeProduccion(); 		 			
		 //fin Carga Area de Produccion
		 
		//Carga Materia Prima
		 List<MateriaPrimaDTO> lstMateriaPrimaDTO = BusinessDelegate.getInstancia().getAllMateriaPrima();		 
		//Fin Carga Materia Prima
		 
		 			
		lstColores = new JComboBox(itemColorList.toArray());
		lstTalles = new JComboBox(itemTalleList.toArray());
		lstAreasProd = new JComboBox(lstAreaProduccion.toArray());
		ddlMateriaPrima = new JComboBox(lstMateriaPrimaDTO.toArray());
		
		setTitle("Alta de Prenda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 70, 900, 800);
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
				
		final JRadioButton chkValidity = new JRadioButton("");
		chkValidity.setBounds(60, 78, 50, altoControles);
		contentPane.add(chkValidity);
		
		JLabel lblCantidadenOPC = new JLabel("Cantidad en OPC:");
		lblCantidadenOPC.setBounds(150, 78 , 100, altoControles);
		contentPane.add(lblCantidadenOPC);
		
		final JTextField txtCantidadenOPC = new JTextField("");
		txtCantidadenOPC.setBounds(270, 78, 100, altoControles);
		contentPane.add(txtCantidadenOPC);
		
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
				itemAreaTiemposDTO.setAreaProduccionDTO(AreaSeleccionada);
				lstAreasTiempos.add(itemAreaTiemposDTO);					
				 										
				MyTableModelAreas model = (MyTableModelAreas)tableAreas.getModel();
				model.SetLstItems(lstAreasTiempos);
				model.refresh();														
	        	
	        }
	    });
	    
	    
	    ddlMateriaPrima.setBounds(10, 430, 100, altoControles);
		contentPane.add(ddlMateriaPrima);
	    
		JLabel lblCantidadMateriaPrima = new JLabel("Cantidad: ");
		lblCantidadMateriaPrima.setBounds(120, 430, 80, altoControles);
		contentPane.add(lblCantidadMateriaPrima);
	
		final JTextField txtCantidadMateriaPrima = new JTextField("");
		txtCantidadMateriaPrima.setBounds(180, 430, 80, altoControles);
		contentPane.add(txtCantidadMateriaPrima);
		
		JLabel lblDesperdicioMateriaPrima = new JLabel("Desperdicio: ");
		lblDesperdicioMateriaPrima.setBounds(280, 430, 80, altoControles);
		contentPane.add(lblDesperdicioMateriaPrima);
		
		final JTextField txtDesperdicioMateriaPrima = new JTextField("");
		txtDesperdicioMateriaPrima.setBounds(360, 430, 80, altoControles);
		contentPane.add(txtDesperdicioMateriaPrima);
		
				
		
		//TABLA	Materiales 
		myTableModelMateriales = new MyTableModelMateriales(lstMaterialesporPrenda);  
		tableMateriales = new JTable(myTableModelMateriales);
		tableMateriales.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    JScrollPane scrollPaneMateriales = new JScrollPane(tableMateriales);
	    scrollPaneMateriales.setBounds(10, 450, 400, 200);	   
	    contentPane.add(scrollPaneMateriales);	    	    
	    //FIN TABLA Areas	
		
									
		btnAddItemMaterialPrenda = new JButton("Agregar");
		btnAddItemMaterialPrenda.setBounds(450, 430, 100, altoControles);
	    contentPane.add(btnAddItemMaterialPrenda);	
	    btnAddItemMaterialPrenda.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {   	        
				
	        	MateriaPrimaDTO materiaPrimaDTO = (MateriaPrimaDTO)ddlMateriaPrima.getSelectedItem();
	        	
	        	MaterialesPorPrendaDTO materialporPrendaDTO = new MaterialesPorPrendaDTO();
	        	materialporPrendaDTO.setNombreMaterial(materiaPrimaDTO.getNombre());
	        	materialporPrendaDTO.setId(lstMaterialesporPrenda.size());
	        	materialporPrendaDTO.setCantidad(Float.parseFloat(txtCantidadMateriaPrima.getText()));
	        	materialporPrendaDTO.setDesperdicio(Float.parseFloat(txtDesperdicioMateriaPrima.getText()));
	        	materialporPrendaDTO.setIdMaterial(materiaPrimaDTO.getCodigo());
	        	materialporPrendaDTO.setMateriaPrimaDTO(materiaPrimaDTO);
	        	
	        	
	        	lstMaterialesporPrenda.add(materialporPrendaDTO);
       	
	        	MyTableModelMateriales model = (MyTableModelMateriales)tableMateriales.getModel();
	        	model.SetLstItems(lstMaterialesporPrenda);
	        	model.refresh();	        														
	        	
	        }
	    });
					    	   								

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(750, 400, 100, altoControles);
	    contentPane.add(btnGuardar);	
	    btnGuardar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {   	        
	        	PrendaDTO prendaDTO = new PrendaDTO();
	        	prendaDTO.setDescripcion(txtDescripcion.getText());
	        	prendaDTO.setVigente(chkValidity.isSelected());
	        	
	        	for (ItemColorTalleDTO itemColorTalleDTO : lstItemColorTalle) {
	        		ItemPrendaDTO itemPrendadto = new ItemPrendaDTO();
	        		itemPrendadto.setColor(itemColorTalleDTO.getColorDTO());
	        		itemPrendadto.setTalle(itemColorTalleDTO.getTalleDTO());
	        		itemPrendadto.setPrendaDTO(prendaDTO);	        			        		
	        		prendaDTO.AgregarItemPrenda(itemPrendadto);
	        			        	
				}
	        		
	        	
	        	for (MaterialesPorPrendaDTO materiaPrimaDTO : lstMaterialesporPrenda) {
				
	        		ItemMaterialPrendaDTO itemMaterialPrendaDTO = null;
	        		for (ItemPrendaDTO itemPrendaDTO : prendaDTO.getItemPrenda()) {
						
	        			itemMaterialPrendaDTO = new ItemMaterialPrendaDTO();
	        			itemMaterialPrendaDTO.setCantidadutilizada((int)materiaPrimaDTO.getCantidad());
	        			itemMaterialPrendaDTO.setDespedicio(materiaPrimaDTO.getDesperdicio());
	        			itemMaterialPrendaDTO.setPrenda(prendaDTO);
	        			itemMaterialPrendaDTO.setMateriaprima(materiaPrimaDTO.getMateriaPrimaDTO());	        				        				        			
	        			itemPrendaDTO.AgregarItemMaterialPrenda(itemMaterialPrendaDTO);												
					}
				}
	        	
	        	for (ItemAreaTiemposDTO itemAreaTiemposDTO : lstAreasTiempos) {
	        		AreaProduccionInvolucradaDTO areaDTO = new AreaProduccionInvolucradaDTO();
	        		areaDTO.setArea(itemAreaTiemposDTO.getAreaProduccionDTO());
	        		areaDTO.setTiempoEnSegundos(Integer.parseInt(txtTiempoArea.getText()));
	        		prendaDTO.AgregarAreaProduccionInvolucrada(areaDTO);
				}
	        	
	        	try {
					BusinessDelegate.getInstancia().AltaPrenda(prendaDTO);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    });
	}	
}
