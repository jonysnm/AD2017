package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.ColorDTO;
import dto.EmpleadoDTO;
import dto.ItemBultoDTO;
import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import dto.PedidoDTO;
import dto.PrendaDTO;
import dto.SucursalDTO;
import dto.TalleDTO;
import dto.UbicacionDTO;

public class Cliente {
	BusinessDelegate businessDelegate;
	PedidoDTO pedido;
	ClienteDTO cliente;
	public static void main(String[] args) {
		new Cliente();
	}

	public Cliente() {
		try {
			businessDelegate = BusinessDelegate.getInstancia();
			//nuevoCliente();
			//nuevaSucursal();
			Integer id=nuevoPedido();
			//nuevaubicacion();
	System.out.println(("IDPedido: " + id));
			//businessDelegate.confirmarPedido(1);
			//businessDelegate.IniciarProcesamientoPedidoAprobado(1);
      	} catch (RemoteException e) {
			e.printStackTrace();
		}
		try{
			businessDelegate=BusinessDelegate.getInstancia();
			//nuevoCliente();
			//cliente=businessDelegate.buscarCliente(1);
			//System.out.println(cliente.getNombre());
			List<ClienteDTO> clientesDTO=businessDelegate.obtenerClientes();
			for (ClienteDTO cli : clientesDTO) {
		     	System.out.println(cli.getNombre());	
			}
			
    	}catch (RemoteException e){
    		e.printStackTrace();
    	}
	}

	private void nuevoCliente() throws RemoteException {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCuit("27111111111");
		clienteDTO.setLimiteCredito(12333);
		clienteDTO.setNombre("Jose Gonzales");
		clienteDTO.setTipoFacturacion("2");
		Integer nroCliente = BusinessDelegate.getInstancia().altaCliente(clienteDTO);
		System.out.println("Se dio de alta el Cliente nro: " + nroCliente);
	}

	/* Nueva Sucursal */
	/* Cargar primero un empleado por base y luego asociarlo a una sucursal */
	private void nuevaSucursal() throws RemoteException {

		EmpleadoDTO e = new EmpleadoDTO();
		e.setApellido("Perez");
		e.setNombre("Jose");
		e.setFechaEgreso(new Date());
		e.setFechaIngreso(new Date());
		

		SucursalDTO s = new SucursalDTO();
		s.setNombre("la sucursal");
		s.setCodigoPostal("1234");
		s.setDireccion("Pepiri 400");
		s.setIdGerente(1);
		s.setIdRecepcionPedidos(1);
		s.setLocalidad("CABA");
		s.setProvincia("CABA");
		s.setTelefono("44448888");

		businessDelegate.crearEmpleado(e);
		businessDelegate.crearSucursal(s);
	}

	/* Obtener Pedido */
	private void obtenerPedido() throws RemoteException {
		pedido = businessDelegate.obtenerPedido(12);
		System.out.println(("IDPedido: %d" + pedido.getId()));
	}
    private void nuevaubicacion()throws RemoteException {
    	UbicacionDTO ubicacionDTO=new UbicacionDTO();
    	ItemBultoDTO item=new ItemBultoDTO();
    	ItemPrendaDTO ip=new ItemPrendaDTO();
    	ip.setCantidad(5);
    	ip.setCantidadReservada(2);
    	ColorDTO colorDTO = new ColorDTO();
		colorDTO.setIdColor(1);
		ip.setColor(colorDTO);
		TalleDTO talleDTO = new TalleDTO();
		talleDTO.setIdTalle(1);
    	ip.setTalle(talleDTO);;
    	PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(1);
		
		item.setIpr(ip);		
		List<ItemBultoDTO> itemsbultos = new ArrayList<ItemBultoDTO>();
		itemsbultos.add(item);
		ubicacionDTO.setBulto(itemsbultos);		
		businessDelegate.altaUbicacion(ubicacionDTO);
    }
	/* Nuevo Pedido */
	private Integer nuevoPedido() throws RemoteException {
		PedidoDTO pedidoDTO = new PedidoDTO();
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCuit("27111111113");
		clienteDTO.setLimiteCredito(600);
		clienteDTO.setNombre("PEPE GOZALO");
		clienteDTO.setTipoFacturacion("2");
		Integer nroCliente = BusinessDelegate.getInstancia().altaCliente(clienteDTO);
		clienteDTO.setId(nroCliente);
		pedidoDTO.setCliente(clienteDTO);
		pedidoDTO.setFechaCreacion(new Date());
		pedidoDTO.setFechaprobableDespacho(new Date());
	    

		ItemPedidoDTO item = new ItemPedidoDTO();
		ItemPrendaDTO ipd=new ItemPrendaDTO();
		
		List<ItemPedidoDTO> itemsPedido = new ArrayList<ItemPedidoDTO>();
		List<ItemPrendaDTO> ip=new ArrayList<ItemPrendaDTO>();
		
		item.setCantidad(1);
		item.setImporte(500);
		ColorDTO colorDTO = new ColorDTO();
		colorDTO.setIdColor(1);
		colorDTO.setDescripcion("Rojo");
		item.setColor(colorDTO);
		TalleDTO talleDTO = new TalleDTO();
		talleDTO.setDescripcion("S");
		talleDTO.setIdTalle(1);
		item.setTalle(talleDTO);
		ipd.setColor(colorDTO);
		ipd.setTalle(talleDTO);
		ip.add(ipd);
	    PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(1);
		prendaDTO.setItemPrenda(ip);		
		item.setPrenda(prendaDTO);
		itemsPedido.add(item);
		pedidoDTO.setItems(itemsPedido);

		return businessDelegate.nuevoPedido(pedidoDTO, 1);
	
		}
}
