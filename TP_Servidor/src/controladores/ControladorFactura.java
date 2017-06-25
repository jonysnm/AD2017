package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ClienteDAO;
import dao.FacturaDAO;
import dao.PedidoDAO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import negocio.Cliente;
import negocio.Factura;
import negocio.ItemFactura;
import negocio.ItemPedido;
import negocio.Pedido;

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
			Integer id=FacturaDAO.getInstancia().grabarFactura(factura);
			System.out.println("La factura se grabó con éxito");
			return id;
		}
		return 0;
	}
}