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
			if((itemColorTalleDTO.getIdEnPantalla())==idItemColorTalle)
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
	
	
	JTextField txtDescripcion;
	JRadioButton chkValidity;
	JTextField txtCantidadenOPC;
	JTextField txtCostoProdActual;
	
	private JPanel contentPane;
	private JComboBox lstColores;
	private JComboBox lstTalles;
	private JComboBox lstAreasProd;
	private JComboBox ddlMateriaPrima;
	private JButton btnAddItemPrenda;
	private JButton btnAddItemMaterialPrenda;
	private JButton btnAddItemAreaProd;
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
	    contentPane.add(scrollPaneMateriales);	    	    
	    //FIN TABLA materiales	
		
		
		//TABLA	Areas 
		myTableModelAreas = new MyTableModelModifAreas(lstAreasTiempos);	    
	    tableAreas = new JTable(myTableModelAreas);
	    tableAreas.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    JScrollPane scrollPaneAreas = new JScrollPane(tableAreas);
	    scrollPaneAreas.setBounds(470, 175, 400, 200);	   
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
		
		final JTextField txtPorcentajeGanancia = new JTextField("");
		txtPorcentajeGanancia.setBounds(330, 120, 80, altoControles);
		contentPane.add(txtPorcentajeGanancia);
		
		
		lstColores.setBounds(10, 150, 100, altoControles);
		contentPane.add(lstColores);
		
		lstTalles.setBounds(150, 150, 100, altoControles);
		contentPane.add(lstTalles);				
	 
	 
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
