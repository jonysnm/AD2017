package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.MateriaPrimaDTO;
import dto.ProveedorDTO;
import entities.MateriaPrimaEntity;
import entities.ProveedorEntity;
import hbt.HibernateUtil;
import negocio.Proveedor;

public class ProveedorDAO {
	private static ProveedorDAO instancia;
	private static SessionFactory sf;

	public ProveedorDAO() {
		super();

	}

	public static ProveedorDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProveedorDAO();
		}
		return instancia;
	}
	
	public void alta(ProveedorDTO proveedorDTO) {
		try {
			
			Session session = sf.openSession();
			session.beginTransaction();
			ProveedorEntity pe =new ProveedorEntity();
			pe.setCuit(proveedorDTO.getCuit());
			pe.setDireccion(proveedorDTO.getDireccion());
			pe.setRanking(proveedorDTO.getRanking());
			pe.setRazonSocial(proveedorDTO.getRazonSocial());
			pe.setTelefono(proveedorDTO.getTelefono());
			
			session.save(pe);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error AlmacenDAO. Alta MateriaPrima");
		}
		
	}
	
	public Proveedor obtenerMejorProveedor(){
		Session session = sf.openSession();
		session.beginTransaction();
		ProveedorEntity proveedorEntity = (ProveedorEntity) session.createQuery("From ProveedorEntity pe where min(pe.ranking)").uniqueResult();
		Proveedor proveedor = new Proveedor();
		proveedor.setCuit(proveedorEntity.getCuit());
		proveedor.setDireccion(proveedorEntity.getDireccion());
		proveedor.setRanking(proveedorEntity.getRanking());
		proveedor.setRazonSocial(proveedorEntity.getRazonSocial());
		proveedor.setTelefono(proveedorEntity.getTelefono());
		return proveedor;
	}
	
	
}
