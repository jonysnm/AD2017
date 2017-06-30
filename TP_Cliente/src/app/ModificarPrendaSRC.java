package app;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;

class MyTableModelModif extends AbstractTableModel {
	
	  public void refresh() {		  
	        fireTableDataChanged();
	    }
	
	
	  public void SetLstItems(List<ItemColorTalleDTO> lstItemColorTalleGrid)
	  {
		  this.lstItemColorTalleGrid = lstItemColorTalleGrid;
	  }
	  
	public MyTableModelModif(List<ItemColorTalleDTO> lstItemColorTalleGrid){
		this.lstItemColorTalleGrid = lstItemColorTalleGrid;
	}
	
	List<ItemColorTalleDTO> lstItemColorTalleGrid = null;
	  private String[] columnNames = { "Color", "Talle", "OPC", "Costo", "Porcentaje" };

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
			if((itemColorTalleDTO.getIdEnPantalla())==idItemColorTalle)
			{
				switch (column) {
				case 0:
					returnValue = itemColorTalleDTO.getColorDTO(); 
					break;
					
				case 1:
					returnValue = itemColorTalleDTO.getTalleDTO();
					break;
				case 2:
					returnValue = itemColorTalleDTO.getCantidadenOPC();
					break;
				case 3:
					returnValue = itemColorTalleDTO.getCostroProduccionActual();
					break;	
				case 4:
					returnValue = itemColorTalleDTO.getPorcentajeGanancia();
					break;					
				default:
					break;
				}
				
			}				
		}
		
		return returnValue;
	}
	
}

class MyTableModelModifAreas extends AbstractTableModel {
	
	List<ItemAreaTiemposDTO> lstItemAreaTiemposGrid = null;
	
	  public void refresh() {		  
	        fireTableDataChanged();
	    }
	
	
	  public void SetLstItems(List<ItemAreaTiemposDTO> lstItemAreaTiemposGrid)
	  {
		  this.lstItemAreaTiemposGrid = lstItemAreaTiemposGrid;
	  }
	  
	public MyTableModelModifAreas(List<ItemAreaTiemposDTO> lstItemAreaTiemposGrid){
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
			if(itemAreaTiempoDTO.getIdPantalla() ==idItem)
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


class MyTableModelModifMateriales extends AbstractTableModel {
	
	List<MaterialesPorPrendaDTO> lstItemMaterialPrendaGrid = null;
	
	  public void refresh() {		  
	        fireTableDataChanged();
	    }
	
	  public int getIndiceActual(){
		  if(this.lstItemMaterialPrendaGrid==null) this.lstItemMaterialPrendaGrid= new ArrayList<MaterialesPorPrendaDTO>();
		  return lstItemMaterialPrendaGrid.size();
	  }
	
	  public void SetLstItems(List<MaterialesPorPrendaDTO> lstItemMaterialPrendaGrid)
	  {
		  this.lstItemMaterialPrendaGrid = lstItemMaterialPrendaGrid;
	  }
	  
	public MyTableModelModifMateriales(List<MaterialesPorPrendaDTO> lstItemMaterialPrendaGrid){
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
			if((itemMaterialPrendaDTO.getIdEnPantalla()) ==idItem)
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




public class ModificarPrendaSRC extends JFrame{

	private static final long serialVersionUID = 1L;
	private ItemColorTalleDTO itemColorTalleSeleccionado = new ItemColorTalleDTO();
	private MaterialesPorPrendaDTO itemMaterialSeleccionado = new MaterialesPorPrendaDTO();
	private ItemAreaTiemposDTO itemAreaTiemposSeleccionada = new ItemAreaTiemposDTO();
	
	
	JTextField txtDescripcion;
	JTextField txtTiempoArea;
	JRadioButton chkValidity;
	JTextField txtCantidadenOPC;
	JTextField txtCostoProdActual;
	JTextField txtPorcentajeGanancia;
	JTextField txtCantidadMateriaPrima;
	JTextField txtDesperdicioMateriaPrima;
	
	private JPanel contentPane;
	private JComboBox lstColores;
	private JComboBox lstTalles;
	private JComboBox lstAreasProd;
	private JComboBox ddlMateriaPrima;
	private JButton btnAddItemPrenda;
	private JButton btnModtemPrenda;
	private JButton btnAddItemMaterialPrenda;
	private JButton btnModificarItemMaterialPrenda;
	private JButton btnAddItemAreaProd;
	private JButton btnModificarItemAreaProd;
	private JButton btnGuardar;
	private JButton btnABuscarPrenda;
	private int altoControles=16;
	private List<ItemColorTalleDTO> lstItemColorTalle;
	private List<ItemAreaTiemposDTO>lstAreasTiempos;
	private List<MaterialesPorPrendaDTO> lstMaterialesporPrenda;
	private PrendaDTO prendaDTO;
	
	private PrendaDTO getPrendaActual(){
		return prendaDTO!=null?prendaDTO:new PrendaDTO();
	}
	
	private MyTableModelModif myTableModel;	  
	private MyTableModelModifAreas myTableModelAreas;
	private MyTableModelModifMateriales myTableModelMateriales;
    private JTable table;
    private JTable tableAreas;
    private JTable tableMateriales;
    int contador = 0;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarPrendaSRC frame = new ModificarPrendaSRC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public ModificarPrendaSRC() throws RemoteException {
			

		DibujarPanelPantall();	
		InicializarListas();		
		CargarCombosPantalla();
		 		
		JLabel lblIngreseLosDatos = new JLabel("Codigo:");
		lblIngreseLosDatos.setBounds(10, 10, 200, altoControles);
		contentPane.add(lblIngreseLosDatos);
		
		final JTextField txtCodigo = new JTextField("");
		txtCodigo.setBounds(100, 10, 150, altoControles);
		contentPane.add(txtCodigo);
		
		
		//Tabla ItemMaterialPrenda
		//TABLA	    
	
	    myTableModel = new MyTableModelModif(lstItemColorTalle);	    
	    table = new JTable(myTableModel);
	    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 175, 400, 200);	   
	    
	     table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        table.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                initDetail(table.getSelectedRow());	                	                	                	                
	            }

				private void initDetail(int selectedRow) {
					
					int index = table.convertRowIndexToModel(selectedRow);
					
					itemColorTalleSeleccionado = lstItemColorTalle.get(index);
					
					txtCantidadenOPC.setText(String.valueOf(itemColorTalleSeleccionado.getCantidadenOPC()));					
					txtPorcentajeGanancia.setText(String.valueOf(itemColorTalleSeleccionado.getPorcentajeGanancia()));
					txtCostoProdActual.setText(String.valueOf(itemColorTalleSeleccionado.getCostroProduccionActual()));
					
					MyTableModelModifMateriales model = (MyTableModelModifMateriales)tableMateriales.getModel();
		        	model.SetLstItems(itemColorTalleSeleccionado.getLstMaterialesporPrendaDTO());
		        	model.refresh();	
				}
			});	    
	    
	    
	    contentPane.add(scrollPane);
		
		
		//TABLA	Materiales 
		myTableModelMateriales = new MyTableModelModifMateriales(lstMaterialesporPrenda);				
		tableMateriales = new JTable(myTableModelMateriales);
		tableMateriales.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    JScrollPane scrollPaneMateriales = new JScrollPane(tableMateriales);
	    scrollPaneMateriales.setBounds(10, 450, 400, 200);
	    
	    
	     tableMateriales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        tableMateriales.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                initDetailMateriales(tableMateriales.getSelectedRow());	                	                	                	                
	            }

				private void initDetailMateriales(int selectedRow) {													
					int index = table.convertRowIndexToModel(selectedRow);										  		
					itemMaterialSeleccionado = itemColorTalleSeleccionado.getLstMaterialesporPrendaDTO().get(index); 
									
					txtCantidadMateriaPrima.setText(String.valueOf(itemMaterialSeleccionado.getCantidad()));
					txtDesperdicioMateriaPrima.setText(String.valueOf(itemMaterialSeleccionado.getDesperdicio()));
					ddlMateriaPrima.setSelectedItem(itemMaterialSeleccionado.getMateriaPrimaDTO());										
				}
	            
	        });	  
	    
	    contentPane.add(scrollPaneMateriales);	    	    
	    //FIN TABLA materiales	
		
		
		//TABLA	Areas 
		myTableModelAreas = new MyTableModelModifAreas(lstAreasTiempos);	    
	    tableAreas = new JTable(myTableModelAreas);
	    tableAreas.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    JScrollPane scrollPaneAreas = new JScrollPane(tableAreas);
	    scrollPaneAreas.setBounds(470, 175, 400, 200);	   
	    
	    
	    
		tableAreas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableAreas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                initDetailMateriales(tableAreas.getSelectedRow());	                	                	                	                
            }

			private void initDetailMateriales(int selectedRow) {													
				int index = table.convertRowIndexToModel(selectedRow);					
				itemAreaTiemposSeleccionada = lstAreasTiempos.get(index);				
				txtTiempoArea.setText(String.valueOf(itemAreaTiemposSeleccionada.getTiempo()));				
			}
            
        });	    	    	    	    
	    contentPane.add(scrollPaneAreas);
	    	    	    	    		    
	    //FIN TABLA Areas			
				
		
		
	    btnABuscarPrenda = new JButton("Buscar");
	    btnABuscarPrenda.setBounds(250, 10, 100, altoControles);
	    contentPane.add(btnABuscarPrenda);		
	    btnABuscarPrenda.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {
	        	try {
	        		boolean prendaEncontrada = false;
					List<PrendaDTO>lstAllPrendas = BusinessDelegate.getInstancia().obtenerPrendas();
					for (PrendaDTO prendaActual : lstAllPrendas) {
						if(prendaActual.getCodigo().equals(Integer.parseInt(txtCodigo.getText())))
						{
							prendaDTO = prendaActual;
							prendaEncontrada= true;
						}						
					}
					if(!prendaEncontrada)
					{
						JOptionPane.showMessageDialog(null, "No se encontro la Prenda", "Error", JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						txtDescripcion.setText(getPrendaActual().getDescripcion());
						chkValidity.setSelected(getPrendaActual().isVigente());
						
						ItemColorTalleDTO itemColoreTalleDTO = null;
						for (ItemPrendaDTO itemPrendaDTO : prendaDTO.getItemPrenda()) {
							itemColoreTalleDTO = new ItemColorTalleDTO();
							
							itemColoreTalleDTO.setIdEnPantalla(lstItemColorTalle.size());
							itemColoreTalleDTO.setCantidadenOPC(itemPrendaDTO.getCantidadenOPC());
							itemColoreTalleDTO.setColorDTO(itemPrendaDTO.getColor());
							itemColoreTalleDTO.setCostroProduccionActual(itemPrendaDTO.getCostoProduccionActual());
							itemColoreTalleDTO.setIdItemColorTalle(itemPrendaDTO.getIditemPrenda());
							itemColoreTalleDTO.setPorcentajeGanancia(itemPrendaDTO.getPorcentajedeGanancia());
							itemColoreTalleDTO.setTalleDTO(itemPrendaDTO.getTalle());
							
							MaterialesPorPrendaDTO item=null;
							int indice = 0;
							for (ItemMaterialPrendaDTO itemMaterialPrenda : itemPrendaDTO.getLstItemMaterialPrendaDTO()) {
								item = new MaterialesPorPrendaDTO();
								item.setNombreMaterial(itemMaterialPrenda.getMateriaprima().getNombre());
								
								item.setIdEnPantalla(indice);																													        									
											
								item.setId(itemMaterialPrenda.getIdItemMaterialPrenda());
								item.setCantidad(itemMaterialPrenda.getCantidadutilizada());
								item.setDesperdicio(itemMaterialPrenda.getDespedicio());
								item.setMateriaPrimaDTO(itemMaterialPrenda.getMateriaprima());								
								itemColoreTalleDTO.AgregarItemMaterialPorPrenda(item);
								indice=indice+1;
							}
							
							lstItemColorTalle.add(itemColoreTalleDTO);													
						}		
						
						MyTableModelModif model = (MyTableModelModif)table.getModel();
						model.SetLstItems(lstItemColorTalle);
						model.refresh();
						
						ItemAreaTiemposDTO itemAreaTiempos = null;
						for (AreaProduccionInvolucradaDTO areaInvolucrada : prendaDTO.getLstAreasInvolucradas()) {
							itemAreaTiempos = new ItemAreaTiemposDTO();
							itemAreaTiempos.setAreaProduccionDTO(areaInvolucrada.getArea());
							itemAreaTiempos.setAreaProduccionNombre(areaInvolucrada.getArea().getDescripcion());
							itemAreaTiempos.setId(areaInvolucrada.getCodigo());
							itemAreaTiempos.setTiempo(areaInvolucrada.getTiempoEnSegundos());
							itemAreaTiempos.setIdPantalla(lstAreasTiempos.size());
							
							lstAreasTiempos.add(itemAreaTiempos);
							
							MyTableModelModifAreas model1 = (MyTableModelModifAreas)tableAreas.getModel();
							model1.SetLstItems(lstAreasTiempos);
							model1.refresh();	
						}
						
						
					}

	        	} catch (RemoteException e) {
					e.printStackTrace();
				}
	        }
			
	    });
			     	   	
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 48, 100, altoControles);				
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextField("");
		txtDescripcion.setBounds(100, 48, 200, altoControles);		
		contentPane.add(txtDescripcion);
		
		
		JLabel lblValidity = new JLabel("Vigente:");
		lblValidity.setBounds(10, 78, 100, altoControles);
		contentPane.add(lblValidity);
				
		chkValidity = new JRadioButton("");
		chkValidity.setBounds(60, 78, 50, altoControles);
		chkValidity.setSelected(true);
		contentPane.add(chkValidity);
	
		JSeparator separator = new JSeparator();		
		separator.setBounds(10, 110, 850, 10);
		contentPane.add(separator);
		
		JLabel lblCantidadenOPC = new JLabel("Cant OPC:");
		lblCantidadenOPC.setBounds(10, 120 , 100, altoControles);
		contentPane.add(lblCantidadenOPC);
		
		txtCantidadenOPC = new JTextField("");
		txtCantidadenOPC.setBounds(70, 120, 50, altoControles);
		contentPane.add(txtCantidadenOPC);
				
		JLabel lblCostoProdActual = new JLabel("Costo Prod");
		lblCostoProdActual.setBounds(125, 120 , 100, altoControles);
		contentPane.add(lblCostoProdActual);
		
		txtCostoProdActual = new JTextField("");
		txtCostoProdActual.setBounds(190, 120, 80, altoControles);
		contentPane.add(txtCostoProdActual);		
		
		
		JLabel lblPorcentajeGanancia = new JLabel("Gcia %:");
		lblPorcentajeGanancia.setBounds(280, 120 , 100, altoControles);
		contentPane.add(lblPorcentajeGanancia);
		
		txtPorcentajeGanancia = new JTextField("");
		txtPorcentajeGanancia.setBounds(330, 120, 80, altoControles);
		contentPane.add(txtPorcentajeGanancia);
		
		
		lstColores.setBounds(10, 150, 100, altoControles);
		contentPane.add(lstColores);
		
		lstTalles.setBounds(120, 150, 70, altoControles);
		contentPane.add(lstTalles);			
		
	    btnModtemPrenda = new JButton("Modificar");
	    btnModtemPrenda.setBounds(300, 150, 90, altoControles);
	    btnModtemPrenda.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {
	        	for (ItemColorTalleDTO item : lstItemColorTalle) {
					if(item.getIdItemColorTalle()==itemColorTalleSeleccionado.getIdItemColorTalle())
					{
						item.setCantidadenOPC(Float.parseFloat(txtCantidadenOPC.getText()));
						item.setCostroProduccionActual(Float.parseFloat(txtCostoProdActual.getText()));
						item.setPorcentajeGanancia(Float.parseFloat(txtPorcentajeGanancia.getText()));
						
						ColorDTO colorSeleccionado = (ColorDTO)lstColores.getSelectedItem();				
						TalleDTO talleSeleccionado = (TalleDTO)lstTalles.getSelectedItem();
						item.setColorDTO(colorSeleccionado);
						item.setTalleDTO(talleSeleccionado);																			
						
					for (ItemPrendaDTO itemPrendaDTO : prendaDTO.getItemPrenda()) {
						if(itemPrendaDTO.getIditemPrenda().intValue()==item.getIdItemColorTalle())
						{
							itemPrendaDTO.setCantidadenOPC(Float.parseFloat(txtCantidadenOPC.getText()));
							itemPrendaDTO.setCostoProduccionActual(Float.parseFloat(txtCostoProdActual.getText()));
							itemPrendaDTO.setPorcentajedeGanancia(Float.parseFloat(txtPorcentajeGanancia.getText()));
							itemPrendaDTO.setTalle(talleSeleccionado);
							itemPrendaDTO.setColor(colorSeleccionado);
						}							
					}
					
																																															
						MyTableModelModif model = (MyTableModelModif)table.getModel();
						model.SetLstItems(lstItemColorTalle);
						model.refresh();					
						
						txtCantidadenOPC.setText("");
						txtPorcentajeGanancia.setText("");
						txtCostoProdActual.setText("");		
					}
				}	        		        	
	        }});   
	    
	    
	    contentPane.add(btnModtemPrenda);
		
		
	    btnAddItemPrenda = new JButton("Agregar");
	    btnAddItemPrenda.setBounds(205, 150, 85, altoControles);
	    contentPane.add(btnAddItemPrenda);		
	    btnAddItemPrenda.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {   
	        	if(txtCantidadMateriaPrima.getText()==""||txtDesperdicioMateriaPrima.getText()=="")
	        	{
	        	
					ColorDTO colorSeleccionado = (ColorDTO)lstColores.getSelectedItem();				
					TalleDTO talleSeleccionado = (TalleDTO)lstTalles.getSelectedItem();
					
					ItemColorTalleDTO itemColorTalleDTO = new ItemColorTalleDTO();				
					itemColorTalleDTO.setIdEnPantalla(lstItemColorTalle.size());

					itemColorTalleDTO.setIdItemColorTalle(-1);//le pongo un numero negativo para saber que son los items nuevos
					
					itemColorTalleDTO.setColorDTO(colorSeleccionado);
					itemColorTalleDTO.setTalleDTO(talleSeleccionado);
					itemColorTalleDTO.setCantidadenOPC(Float.parseFloat(txtCantidadenOPC.getText()));
					itemColorTalleDTO.setPorcentajeGanancia(Float.parseFloat(txtPorcentajeGanancia.getText()));
					itemColorTalleDTO.setCostroProduccionActual(Float.parseFloat(txtCostoProdActual.getText()));
					
					lstItemColorTalle.add(itemColorTalleDTO);
					 										
					MyTableModelModif model = (MyTableModelModif)table.getModel();
					model.SetLstItems(lstItemColorTalle);
					model.refresh();					
					
					txtCantidadenOPC.setText("");
					txtPorcentajeGanancia.setText("");
					txtCostoProdActual.setText("");
	        	}
	        	else
	        	{
	        		JOptionPane.showMessageDialog(null, "Verificar los datos ingresados", "Alerta", JOptionPane.PLAIN_MESSAGE);
	        	}
	        }
	    });
		
	    lstAreasProd.setBounds(470, 150, 100, altoControles);
		contentPane.add(lstAreasProd);
		
		txtTiempoArea = new JTextField("");
		txtTiempoArea.setBounds(580, 150, 100, altoControles);
		contentPane.add(txtTiempoArea);
		
		btnAddItemAreaProd = new JButton("Agregar");
		btnAddItemAreaProd.setBounds(685, 150, 100, altoControles);
	    contentPane.add(btnAddItemAreaProd);	
	    btnAddItemAreaProd.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {   	        
	        	
	        	if(txtTiempoArea.getText()=="")
	        	{
	        	AreaProduccionDTO AreaSeleccionada = (AreaProduccionDTO)lstAreasProd.getSelectedItem();				
					
				ItemAreaTiemposDTO itemAreaTiemposDTO = new ItemAreaTiemposDTO();
				
				itemAreaTiemposDTO.setIdPantalla(lstAreasTiempos.size());
				itemAreaTiemposDTO.setId(-1);//le pongo -1 para saber que es una linea nueva
				
				itemAreaTiemposDTO.setAreaProduccionNombre(AreaSeleccionada.getDescripcion());
				itemAreaTiemposDTO.setTiempo(Float.parseFloat(txtTiempoArea.getText()));
				itemAreaTiemposDTO.setAreaProduccionDTO(AreaSeleccionada);
				lstAreasTiempos.add(itemAreaTiemposDTO);					
				 										
				MyTableModelModifAreas model = (MyTableModelModifAreas)tableAreas.getModel();
				model.SetLstItems(lstAreasTiempos);
				model.refresh();														
				txtTiempoArea.setText("");
	        	}
	        	else
				{
					JOptionPane.showMessageDialog(null, "Verificar los datos ingresados", "Alerta", JOptionPane.PLAIN_MESSAGE);
				}
	        }
	    });
	 
	    
		btnModificarItemAreaProd = new JButton("Modificar");
		btnModificarItemAreaProd.setBounds(785, 150, 100, altoControles);
	    contentPane.add(btnModificarItemAreaProd);	
	    btnModificarItemAreaProd.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {  
	        		
	        	for (ItemAreaTiemposDTO itemAreaTiemposDTO : lstAreasTiempos) {
					if(itemAreaTiemposDTO.getId()==itemAreaTiemposSeleccionada.getId())
					{
						AreaProduccionDTO AreaSeleccionada = (AreaProduccionDTO)lstAreasProd.getSelectedItem();
						itemAreaTiemposDTO.setAreaProduccionNombre(AreaSeleccionada.getDescripcion());
						itemAreaTiemposDTO.setTiempo(Float.parseFloat(txtTiempoArea.getText()));
						itemAreaTiemposDTO.setAreaProduccionDTO(AreaSeleccionada);
																										
						MyTableModelModifAreas model = (MyTableModelModifAreas)tableAreas.getModel();
						model.SetLstItems(lstAreasTiempos);
						model.refresh();														
						txtTiempoArea.setText("");				
					}
				}
	        }
	    });
	    
	    
	    
	    ddlMateriaPrima.setBounds(10, 430, 100, altoControles);
		contentPane.add(ddlMateriaPrima);
	    
		JLabel lblCantidadMateriaPrima = new JLabel("Cantidad: ");
		lblCantidadMateriaPrima.setBounds(120, 430, 80, altoControles);
		contentPane.add(lblCantidadMateriaPrima);
	
		txtCantidadMateriaPrima = new JTextField("");
		txtCantidadMateriaPrima.setBounds(180, 430, 80, altoControles);
		contentPane.add(txtCantidadMateriaPrima);
		
		JLabel lblDesperdicioMateriaPrima = new JLabel("Desperdicio: ");
		lblDesperdicioMateriaPrima.setBounds(280, 430, 80, altoControles);
		contentPane.add(lblDesperdicioMateriaPrima);
		
		txtDesperdicioMateriaPrima = new JTextField("");
		txtDesperdicioMateriaPrima.setBounds(360, 430, 80, altoControles);
		contentPane.add(txtDesperdicioMateriaPrima);
		
		btnAddItemMaterialPrenda = new JButton("Agregar");
		btnAddItemMaterialPrenda.setBounds(450, 430, 100, altoControles);
	    contentPane.add(btnAddItemMaterialPrenda);	
	    btnAddItemMaterialPrenda.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {   	        
	        	if(txtCantidadMateriaPrima.getText()==""||txtDesperdicioMateriaPrima.getText()=="")
	        	{
	        	MateriaPrimaDTO materiaPrimaDTO = (MateriaPrimaDTO)ddlMateriaPrima.getSelectedItem();
	        	
	        	MaterialesPorPrendaDTO materialporPrendaDTO = new MaterialesPorPrendaDTO();
	        	materialporPrendaDTO.setNombreMaterial(materiaPrimaDTO.getNombre());
	        	//materialporPrendaDTO.setId(lstMaterialesporPrenda.size());
	        	
	        	materialporPrendaDTO.setId(-1);//le pongo negativo para saber que es nuevo
	        	
	        	materialporPrendaDTO.setIdEnPantalla(itemColorTalleSeleccionado.getLstMaterialesporPrendaDTO().size());
	        		        	
	        	materialporPrendaDTO.setCantidad(Float.parseFloat(txtCantidadMateriaPrima.getText()));
	        	materialporPrendaDTO.setDesperdicio(Float.parseFloat(txtDesperdicioMateriaPrima.getText()));
	        	materialporPrendaDTO.setIdMaterial(materiaPrimaDTO.getCodigo());
	        	materialporPrendaDTO.setMateriaPrimaDTO(materiaPrimaDTO);
	        		        		            		     
	        	itemColorTalleSeleccionado.agregarMaterialesporPrenda(materialporPrendaDTO);
	        		        	
	        	
	        	MyTableModelModifMateriales model = (MyTableModelModifMateriales)tableMateriales.getModel();
	        	model.SetLstItems(itemColorTalleSeleccionado.getLstMaterialesporPrendaDTO());
	        	model.refresh();	        														
	        	
	        	txtCantidadMateriaPrima.setText("");
	        	txtDesperdicioMateriaPrima.setText("");
	        	}
	        	else
				{
					JOptionPane.showMessageDialog(null, "Verificar los datos ingresados", "Alerta", JOptionPane.PLAIN_MESSAGE);
				}
	        }
	    });
	    
	    
		btnModificarItemMaterialPrenda = new JButton("Modificar");
	    btnModificarItemMaterialPrenda.setBounds(555, 430, 100, altoControles);
	    contentPane.add(btnModificarItemMaterialPrenda);	
	    btnModificarItemMaterialPrenda.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {
	        	
	        	for (MaterialesPorPrendaDTO materialPorPrenda : itemColorTalleSeleccionado.getLstMaterialesporPrendaDTO()) {
				
	        		if(materialPorPrenda.getId()==itemMaterialSeleccionado.getId())
	        		{
	        			materialPorPrenda.setCantidad(Float.parseFloat(txtCantidadMateriaPrima.getText()));
	        			materialPorPrenda.setDesperdicio(Float.parseFloat(txtDesperdicioMateriaPrima.getText()));
	        	
	        			
	        			
	        			for (ItemPrendaDTO itemPrendaDTO : prendaDTO.getItemPrenda()) {
							if(itemPrendaDTO.getIditemPrenda()==materialPorPrenda.getId())
							{
								for (ItemMaterialPrendaDTO itemMaterial : itemPrendaDTO.getLstItemMaterialPrendaDTO()) {
									if(itemMaterial.getIdItemMaterialPrenda()==materialPorPrenda.getId())
									{
										itemMaterial.setCantidadutilizada(Integer.parseInt(txtCantidadMateriaPrima.getText()));
										itemMaterial.setDespedicio(Float.parseFloat(txtDesperdicioMateriaPrima.getText()));
										itemMaterial.setMateriaprima((MateriaPrimaDTO)ddlMateriaPrima.getSelectedItem());
									}									
								}
							}
						}
	        			
	        			
	        			
	        			
	        			
	    	        	MyTableModelModifMateriales model = (MyTableModelModifMateriales)tableMateriales.getModel();
	    	        	model.SetLstItems(itemColorTalleSeleccionado.getLstMaterialesporPrendaDTO());
	    	        	model.refresh();
	        		}
	        		
				}	        		        		        		        		       	        		        														        	
	        	txtCantidadMateriaPrima.setText("");
	        	txtDesperdicioMateriaPrima.setText("");
	        	
	        }
	    });
	 
	    
	    
	    //Guardar
	    
	    
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(750, 400, 100, altoControles);
	    contentPane.add(btnGuardar);	
	    btnGuardar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {   	  	        		        		        		        	
	        	prendaDTO = getPrendaActual();
	        	prendaDTO.setDescripcion(txtDescripcion.getText());
	        	prendaDTO.setVigente(chkValidity.isSelected());	        		        	
	        	
	        	try {
					BusinessDelegate.getInstancia().ModificarPrenda(prendaDTO);
					
					JOptionPane.showMessageDialog(null, "Modificacion Prenda Finalizada", "Terminado", JOptionPane.PLAIN_MESSAGE);
					txtDescripcion.setText("");
					
			    	MyTableModelMateriales model = (MyTableModelMateriales)tableMateriales.getModel();
		        	model.SetLstItems(new ArrayList<MaterialesPorPrendaDTO>());
		        	model.refresh();	
					
					MyTableModelAreas model1 = (MyTableModelAreas)tableAreas.getModel();
					model1.SetLstItems(new ArrayList<ItemAreaTiemposDTO>());
					model1.refresh();	
								
					
					MyTableModel model2 = (MyTableModel)table.getModel();
					model2.SetLstItems(new ArrayList<ItemColorTalleDTO>());
					model2.refresh();	
					
		        	
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    });
	    
	    
	    
	    //FIN GuARDAR
	    
	    
	    
	}

	private void CargarCombosPantalla() throws RemoteException {
		//Carga de Combos							
	 List<ColorDTO> itemColorList = BusinessDelegate.getInstancia().getAllColor();		 		
	 List<TalleDTO> itemTalleList = BusinessDelegate.getInstancia().getAllTalle();
	 List<AreaProduccionDTO> lstAreaProduccion = BusinessDelegate.getInstancia().getAllAreaDeProduccion(); 		 					 
	 List<MateriaPrimaDTO> lstMateriaPrimaDTO = BusinessDelegate.getInstancia().getAllMateriaPrima();		 
	
	 lstColores = new JComboBox(itemColorList.toArray());
	 lstTalles = new JComboBox(itemTalleList.toArray());
	 lstAreasProd = new JComboBox(lstAreaProduccion.toArray());
	 ddlMateriaPrima = new JComboBox(lstMateriaPrimaDTO.toArray());
		
	}

	private void InicializarListas() {
		if(lstItemColorTalle==null)
			lstItemColorTalle = new ArrayList<ItemColorTalleDTO>();
				
		if(lstAreasTiempos==null)
			lstAreasTiempos = new ArrayList<ItemAreaTiemposDTO>();
		
		if(lstMaterialesporPrenda == null)
			lstMaterialesporPrenda = new ArrayList<MaterialesPorPrendaDTO>();
		
	}

	private void DibujarPanelPantall() {
		setTitle("Modificar Prenda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 70, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
	}
}
