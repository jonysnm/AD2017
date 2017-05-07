package controladores;

import org.hibernate.type.AnyType.ObjectTypeCacheEntry;

import dao.AdministracionDAO;
import dto.PedidoDTO;
import dto.SucursalDTO;
import entities.ClienteEntity;
import entities.EmpleadoEntity;
import entities.PedidoEntity;
import entities.SucursalEntity;
import negocio.Cliente;
import negocio.Sucursal;

public class ControladorPedido {
	private static ControladorPedido instancia;
	private ControladorPedido(){}
	public static ControladorPedido getInstancia(){
		if(instancia==null){
			instancia=new ControladorPedido();
		}
		return instancia;
	}
	public Integer nuevoPedido(Integer idSucursal){
		Sucursal s=new Sucursal(AdministracionDAO.getInstancia().getSucursal(idSucursal));
		
		
	}
	public PedidoEntity PedidoDTO2Entity(PedidoDTO p){
		PedidoEntity pedido=new PedidoEntity();
		pedido.setCliente(p.getCliente());
		
		
		
	}
	public ClienteEntity ClienteDTO2Entity(ClienteDTO c){
		C
	}
	public void agregarPedido(Integer id){
		return;
	}
	public void confirmarPedido(PedidoDTO pedido){
		return;
	}
	public String informarEstadoPedido(){
		return null;
	}
	public void cancelarPedido(Integer id){}

}
