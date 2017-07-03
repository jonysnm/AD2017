package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.ItemOCMP;
import negocio.MateriaPrima;
import negocio.OCMP;
import negocio.Proveedor;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.OCMPDTO;
import entities.ItemOCMPEntity;
import entities.MateriaPrimaEntity;
import entities.OCMPEntity;
import entities.OrdenProduccionEntity;
import entities.ProveedorEntity;
import estados.EstadoOCMP;

public class OCMPDAO {

	private static OCMPDAO instancia;
	private static SessionFactory sf;

	

	public OCMPDAO() {
		super();

	}


	public static OCMPDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new OCMPDAO();
		}
		return instancia;
	}
	
	
	public void informarFechaEntregaMP(int idOcmp, Date fechaEntrega){
		Session session = sf.openSession();
		// TODO Auto-generated method stub
		

	}

	public void seleccionarProveedor(int idOcmp, int idProveedor) {
		Session session = sf.openSession();
		// TODO Auto-generated method stub
		
		
	}

	public List<OCMPDTO> obtenerOCMPPendientesdeProcesar() {
		Session session = sf.openSession();
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizarestadoOCMP(int idOCMP, EstadoOCMP estado) {
		Session session = sf.openSession();
		// TODO Auto-generated method stub
		
	}

	public void informarInsumosRecibidos(int idOCMP) {
		// TODO Auto-generated method stub
		
	}


	public int createOCMP(OCMP ocmp) {
		return this.altaOCMP(ocmp);
	}


	public int altaOCMP(OCMP ocmp) {
		Session session = sf.openSession();
		session.beginTransaction();
		OCMPEntity opp=new OCMPEntity();
		opp.setEstado(ocmp.getEstado());
		opp.setFecha(ocmp.getFecha());
		opp.setFechaEntrega(ocmp.getFechaEntrega());
		ProveedorEntity prove=new ProveedorEntity();
		prove.setCuit(ocmp.getProveedor().getCuit());
		prove.setDireccion(ocmp.getProveedor().getDireccion());
		prove.setRanking(ocmp.getProveedor().getRanking());
		prove.setRazonSocial(ocmp.getProveedor().getRazonSocial());
		prove.setTelefono(ocmp.getProveedor().getTelefono());
		opp.setProveedor(prove);
		List<ItemOCMPEntity> ordenescompra=new ArrayList<ItemOCMPEntity>();
		for (ItemOCMP ordencompra : ocmp.getItemsOcmp()) {
			ItemOCMPEntity iordenCompra = new ItemOCMPEntity();
			iordenCompra.setCantidadComprada(ordencompra.getCantidadComprada());
			iordenCompra.setCantidadSolicitada(ordencompra.getCantidadSolicitada());
			MateriaPrimaEntity mp=new MateriaPrimaEntity();
			mp.setCantidadAComprar(ordencompra.getMateriaPrima().getCantidadAComprar());
			mp.setCantidadPtoPedido(ordencompra.getMateriaPrima().getCantidadPtoPedido());
			mp.setCodigo(ordencompra.getMateriaPrima().getCodigo());
			mp.setNombre(ordencompra.getMateriaPrima().getNombre());
			iordenCompra.setMateriaPrima(mp);
			ordenescompra.add(iordenCompra);			
		}
		opp.setItemsOcmp(ordenescompra);
		int id = (int )session.save(opp);
		session.getTransaction().commit();
		session.flush();
		session.close();	
		return id;
	
	}
	

	public void modificarOCMP(OCMP ocmp) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(ocmp);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error OCMPDAO. Modificar OCMP");
		}
	}

	public void bajaOCMP(OCMP ocmp) {
		try {
			Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.delete(ocmp);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error OCMPDAO. Baja OCMP");
		}
	}

	public OCMP getOCMP(int idOCMP) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			OCMP ocmp = (OCMP) session.get(OCMP.class, idOCMP);
			session.getTransaction().commit();
			session.close();
			return ocmp;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error OCMPDAO. Get OCMP");
		}
		return null;
	}

	
}
