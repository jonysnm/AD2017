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
			nuevoCliente();
			nuevaSucursal();
			Integer id=nuevoPedido();
			nuevaubicacion();
			System.out.println(("IDPedido: " + id));
			businessDelegate.confirmarPedido(id);
			businessDelegate.IniciarProcesamientoPedidoAprobado(id);
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
    	item.setCantidad(5);
    	item.setCantidadReservada(2);
    	PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(5);
		item.setPr(prendaDTO);
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
		
		List<ItemPedidoDTO> itemsPedido = new ArrayList<ItemPedidoDTO>();
		
		item.setCantidad(1);
		item.setImporte(500);
		ColorDTO colorDTO = new ColorDTO();
		colorDTO.setIdColor(1);
		colorDTO.setDescripcion("Rojo");
		item.setColor(colorDTO);
		TalleDTO talleDTO = new TalleDTO();
		talleDTO.setDescripcion("M");
		talleDTO.setIdTalle(1);
		item.setTalle(talleDTO);
		PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(5);
		itemsPedido.add(item);
		pedidoDTO.setItems(itemsPedido);

		return businessDelegate.nuevoPedido(pedidoDTO, 1);
	
		}
}
