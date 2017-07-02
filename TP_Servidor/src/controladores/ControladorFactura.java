package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ClienteDAO;
import dao.FacturaDAO;
import dao.MovimientoDAO;
import dao.PedidoDAO;
import dao.RemitoDAO;
import estados.EstadoFactura;
import estados.EstadoRemito;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.Factura;
import negocio.ItemFactura;
import negocio.ItemMovimientoCtaCte;
import negocio.ItemPedido;
import negocio.ItemRemito;
import negocio.Pedido;
import negocio.Remito;
import tipos.TipoMovimientoCtaCte;

public class ControladorFactura {
	private static ControladorFactura instancia;

	public static ControladorFactura getInstancia(){
		if(instancia==null){
			instancia=new ControladorFactura();
		}
		return instancia;
	}
	public int grabarFactura (Integer idPedido){
		Pedido p=PedidoDAO.getInstancia().getPedido(idPedido);
		if (p != null){
			Factura factura = new Factura();
			Cliente cliente =ClienteDAO.getInstancia().getCliente(p.getCliente().getId());
			if (cliente != null){
				factura.setCliente(cliente);
			}else{
				System.out.println("Error al grabar la factura (No existe el cliente)");
				return 0;
			}
			Date fechaAct = new java.sql.Date((new Date()).getTime());
			factura.setFechaEmision(fechaAct);
			
			
			
			List<ItemFactura> itemsFactura=new ArrayList<ItemFactura>();
 			for (ItemPedido itemPedido : p.getItems()) {
				ItemFactura item=new ItemFactura();
				item.setCantidad(itemPedido.getCantidad());
				item.setPedido(p);
				item.setPrecioUnitario(itemPedido.getImporte());
				itemsFactura.add(item);
			}
		    factura.setItemsFactura(itemsFactura);
			float total = factura.calcularTotal();
			factura.setTotal(total);
			factura.setEstado(EstadoFactura.EMITIDA);
			Integer id=FacturaDAO.getInstancia().grabarFactura(factura);
//			FacturaDAO.getInstancia().grabarMovimiento(id);//ver aca
			System.out.println("La factura se grabó con éxito");
			
			return id;
		}
		return 0;
	}
	public void grabarMovimiento(Integer idFactura) {
		Factura factura = FacturaDAO.getInstancia().buscarFactura(idFactura);
		CuentaCorriente cuentaCorriente = factura.getCliente().getCtacte();
		List<ItemMovimientoCtaCte> itemsMovimientoCtaCte = new ArrayList<ItemMovimientoCtaCte>();
			ItemMovimientoCtaCte itemMovimientoCtaCte = new ItemMovimientoCtaCte();
			itemMovimientoCtaCte.setDetalle("Factura " + String.valueOf(factura.getNro()));
			itemMovimientoCtaCte.setFecha(factura.getFechaEmision());	
			itemMovimientoCtaCte.setImporte(factura.getTotal());
			itemMovimientoCtaCte.setTipo(TipoMovimientoCtaCte.DEBITO); //COMPLETAR
			itemsMovimientoCtaCte.add(itemMovimientoCtaCte);
			cuentaCorriente.setItems(itemsMovimientoCtaCte);

			MovimientoDAO.getInstancia().grabarMovimiento(cuentaCorriente);
		
	}
	
	public int grabarRemito(Integer idPedido,EstadoRemito estadoR){
		try {
			Pedido p=PedidoDAO.getInstancia().getPedidoComp(idPedido);
			Remito remito = new Remito();
			remito.setCliente(p.getCliente());
			remito.setFecha(new Date());
			remito.setEstado(estadoR);
			
			List<ItemRemito> itemsRemito=new ArrayList<ItemRemito>();
 			for (ItemPedido itemPedido : p.getItems()) {
 				ItemRemito item=new ItemRemito();
 				item.setPrenda(itemPedido.getItemprenda().getPrenda());
				item.setCantidad((int)itemPedido.getCantidad());
				itemsRemito.add(item);
			}
 			remito.setItemsRemito(itemsRemito);
			int idRemito =(int) RemitoDAO.getInstancia().grabarRemito(remito);
			System.out.println("El remito se grabó con éxito");
			
		return idRemito;
		} catch (Exception e) {
			//ver esta excepcion
			e.printStackTrace();
			e.getCause();
		}
		return 0;
	
	}
	
}