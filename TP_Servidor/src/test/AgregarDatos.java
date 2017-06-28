package test;

import java.util.ArrayList;
import java.util.List;

import dao.AlmacenDAO;
import dao.FacturaDAO;
import dao.PedidoDAO;
import dao.TallesyColoresDAO;
import negocio.Color;
import negocio.ItemBultoPrenda;
import negocio.ItemPedido;
import negocio.ItemPrenda;
import negocio.Pedido;
import negocio.Prenda;
import negocio.Talle;
import negocio.Ubicacion;
public class AgregarDatos {
	public static void guardarInfo(){
	
		Color c1 = new Color("Rojo");
	TallesyColoresDAO.getInstancia().altaColor(c1);
	Color c2 = new Color("Negro");
	TallesyColoresDAO.getInstancia().altaColor(c2);
	Color c3 = new Color("Azul");
	TallesyColoresDAO.getInstancia().altaColor(c3);
	Color c4 = new Color("Verde");
	TallesyColoresDAO.getInstancia().altaColor(c4);
	Color c5 = new Color("Blanco");
	TallesyColoresDAO.getInstancia().altaColor(c5);
	Color c6 = new Color("Amarillo");
	TallesyColoresDAO.getInstancia().altaColor(c6);
	
	Talle t1 = new Talle("S");
	TallesyColoresDAO.getInstancia().altaTalle(t1);
	Talle t2 = new Talle("M");
	TallesyColoresDAO.getInstancia().altaTalle(t2);
	Talle t3 = new Talle("L");
	TallesyColoresDAO.getInstancia().altaTalle(t3);
	Talle t4 = new Talle("XL");
	TallesyColoresDAO.getInstancia().altaTalle(t4);
	Talle t5 = new Talle("XXL");
	TallesyColoresDAO.getInstancia().altaTalle(t5);
	/*
    Prenda p1=new Prenda();
    p1.setDescripcion("BUFARRETA");
    p1.setVigente(true);
    
    
	List<ItemPrenda> ip=new ArrayList<ItemPrenda>();
	ItemPrenda ipp=new ItemPrenda();
	Talle talle=TallesyColoresDAO.getInstancia().getTalle(1);
	Color color=TallesyColoresDAO.getInstancia().getColor(1);
	
	ipp.setPrenda(p1);
	ipp.setColor(color);
	ipp.setTalle(talle);
	ipp.setCostoProduccionActual(100);
	ipp.setCantidadEnOPC(2);
	ipp.setPorcentajeGanancia(200);
	ip.add(ipp);
	p1.setItemPrendas(ip);
	PedidoDAO.getInstancia().AltaPrenda(p1);
	
	Ubicacion u=new Ubicacion();
	ItemBultoPrenda ibpr=new ItemBultoPrenda();
	ibpr.setCantidad(40);
	ibpr.setCantidadReservada(10);
	ibpr.setTipo("IBPRENDA");
	ibpr.setItemPrenda(PedidoDAO.getInstancia().getItemPrenda(1));
	//ibpr.setPrenda(PedidoDAO.getInstancia());
	u.setBulto(ibpr);
	AlmacenDAO.getInstancia().nuevaUbicacion(u);
	*/
	/*
	Pedido p=PedidoDAO.getInstancia().getPedido(1);
	float pp=0;
	for(ItemPedido it:p.getItems()){
		pp=AlmacenDAO.getInstancia().obtenerDisponiblePorPrenda(it);
		System.out.printf("Cantidad:%f", pp);
	}	
		*/
	
	}
}
