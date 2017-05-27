package utils;

import dto.ClienteDTO;
import negocio.Cliente;

public class ClienteToClienteDTO {
	
	public static ClienteDTO toDTO(Cliente cliente){
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCuit(String.valueOf(cliente.getCuit()));
		clienteDTO.setId(cliente.getId());
		clienteDTO.setLimiteCredito(cliente.getLimiteCredito());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setTipoFacturacion(cliente.getTipoFacturacion());
		return clienteDTO;
	}

}
