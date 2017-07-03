package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.MateriaPrimaDTO;
import dto.ProveedorDTO;
import entities.ItemBultoPrendaEntity;
import entities.MateriaPrimaEntity;
import entities.PrendaEntity;
import entities.ProveedorEntity;
import hbt.HibernateUtil;
import negocio.Prenda;
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
	
	@SuppressWarnings("unchecked")
	public Proveedor obtenerMejorProveedor(){
		Proveedor proveedor = new Proveedor();
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "FROM ProveedorEntity P ";
        List<ProveedorEntity> query = session.createQuery(hql).list();
		for(ProveedorEntity proveedorEntity:query){
			if(proveedorEntity.getRanking()==1){
			proveedor.setCuit(proveedorEntity.getCuit());
			proveedor.setDireccion(proveedorEntity.getDireccion());
			proveedor.setRanking(proveedorEntity.getRanking());
			proveedor.setRazonSocial(proveedorEntity.getRazonSocial());
			proveedor.setTelefono(proveedorEntity.getTelefono());
			}
		}
		session.getTransaction().commit();
		session.flush();
		session.close();
		return proveedor;
	}
}

