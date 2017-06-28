package interfazRemota;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.AreaProduccionDTO;
import dto.MateriaPrimaDTO;
import dto.PedidoaDespacharDTO;
import dto.PedidosCompletosPendientesDespacharDTO;
import dto.PrendaDTO;
import dto.UbicacionDTO;

public interface ILogistica extends Remote{
	public void altaUbicacion(UbicacionDTO ubicacion) throws RemoteException;

	public List<PedidosCompletosPendientesDespacharDTO> ObtenerListaPedidosCompletosPendientesDespachar() throws RemoteException;

	public PedidoaDespacharDTO obtenerPedidoaDespachar(int idPedidoaDespachar) throws RemoteException;

	public List<AreaProduccionDTO> getAllAreaDeProduccion() throws RemoteException;

	public List<MateriaPrimaDTO> getAllMateriaPrima()throws RemoteException;

	public void AltaPrenda(PrendaDTO prendaDTO)throws RemoteException;

}
