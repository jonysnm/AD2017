package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.ColorDTO;
import dto.EmpleadoDTO;
import dto.ItemPedidoDTO;
import dto.ItemPrendaDTO;
import dto.PedidoDTO;
import dto.PrendaDTO;
import dto.SucursalDTO;
import dto.TalleDTO;

public class Cliente {
	BusinessDelegate businessDelegate;
	PedidoDTO pedido;

	public static void main(String[] args) {
		new Cliente();
	}

	public Cliente() {
		try {
			businessDelegate = BusinessDelegate.getInstancia();
//			nuevoCliente();
//			nuevaSucursal();
			nuevoPedido();
			// obtenerPedido();

		} catch (RemoteException e) {
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
		// e.setIdSucursal(1);

		SucursalDTO s = new SucursalDTO();
		s.setNombre("la sucursal");
		s.setCodigoPostal("1234");
		s.setDireccion("Pepiri 400");
		s.setIdGerente(1);
		s.setIdRecepcionPedidos(1);
		s.setLocalidad("CABA");
		s.setProvincia("CABA");
		s.setTelefono("44448888");

		businessDelegate.getInstancia().crearEmpleado(e);
		businessDelegate.getInstancia().crearSucursal(s);
	}

	/* Obtener Pedido */
	private void obtenerPedido() throws RemoteException {
		pedido = businessDelegate.getInstancia().obtenerPedido(12);
		System.out.println(("IDPedido: %d" + pedido.getId()));
	}

	/* Nuevo Pedido */
	private void nuevoPedido() throws RemoteException {
		PedidoDTO pedidoDTO = new PedidoDTO();
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCuit("27111111111");
		clienteDTO.setLimiteCredito(12333);
		clienteDTO.setNombre("Jose Gonzales");
		clienteDTO.setTipoFacturacion("2");
		Integer nroCliente = BusinessDelegate.getInstancia().altaCliente(clienteDTO);
		pedidoDTO.setCliente(clienteDTO);
		pedidoDTO.setFechaCreacion(new Date());
		pedidoDTO.setFechaprobableDespacho(new Date());
		ItemPedidoDTO item = new ItemPedidoDTO();
		List<ItemPedidoDTO> itemsPedido = new ArrayList<>();
		item.setCantidad(1);
		item.setImporte(12);
		PrendaDTO prendaDTO = new PrendaDTO();
		prendaDTO.setCodigo(1);
		ItemPrendaDTO itemPrenda = new ItemPrendaDTO();
		ColorDTO colorDTO = new ColorDTO();
		colorDTO.setDescripcion("Rojo");
		itemPrenda.setColor(colorDTO);
		TalleDTO talleDTO = new TalleDTO();
		talleDTO.setDescripcion("M");
		itemPrenda.setTalle(talleDTO);
		List<ItemPrendaDTO> itemsPrenda = new ArrayList<ItemPrendaDTO>();
		itemsPrenda.add(itemPrenda);
		prendaDTO.setItemPrenda(itemsPrenda);
		item.setPrenda(prendaDTO);
		pedidoDTO.setItems(itemsPedido);

		int nroPedido = businessDelegate.getInstancia().nuevoPedido(pedidoDTO, 1);
		System.out.println(("IDPedido: " + nroPedido));
	}
}
