package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemBultoPrendaEntity;
import entities.ItemPrendaEntity;
import entities.UbicacionEntity;
import hbt.HibernateUtil;
import negocio.ItemBultoPrenda;
import negocio.ItemPedido;
import negocio.Ubicacion;

public class AlmacenDAO {
	private static AlmacenDAO instancia;
	private static SessionFactory sf;

	public AlmacenDAO() {
		super();

	}

	public static AlmacenDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new AlmacenDAO();
		}
		return instancia;
	}

	public int gestionarReserva(ItemPedido i) {
		// dps va a seguir
		return 0;
	}

	public List<ItemBultoPrenda> reservarStockPrenda(ItemPedido ip) {
		Session s = sf.openSession();
		String consulta = "from ItemBultoPrendaEntity ib where ib.itemPrenda.IdItemPrenda= :id";
		float cantidad = 0;
		@SuppressWarnings("unchecked")
		List<ItemBultoPrendaEntity> lista = (ArrayList<ItemBultoPrendaEntity>) s.createQuery(consulta)
				.setParameter("id", ip.getItemprenda().getIditemPrenda()).list();
		return null;
	}

	public float obtenerDisponiblePorPrenda(ItemPedido ip) {
		Session s = sf.openSession();
		String consulta = "from ItemBultoPrendaEntity ib where ib.itemPrenda.IdItemPrenda= :id";
		float cantidad = 0;
		@SuppressWarnings("unchecked")
		ArrayList<ItemBultoPrendaEntity> lista = (ArrayList<ItemBultoPrendaEntity>) s.createQuery(consulta)
				.setParameter("id", ip.getItemprenda().getIditemPrenda()).list();
		for (ItemBultoPrendaEntity ib : lista) {
			cantidad = cantidad + (ib.getCantidad() - ib.getCantidadReservada());
		}
		return cantidad;
	}

	public void nuevaUbicacion(Ubicacion ubicacion) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			UbicacionEntity ub = new UbicacionEntity();
			ItemBultoPrenda ib = (ItemBultoPrenda) ubicacion.getBulto();
			ItemBultoPrendaEntity ibpre = new ItemBultoPrendaEntity();
			ItemPrendaEntity ip = (ItemPrendaEntity) session.get(ItemPrendaEntity.class,
					ib.getItemPrenda().getIditemPrenda());
			ibpre.setItemPrenda(ip);
			ibpre.setCantidad(ib.getCantidad());
			ibpre.setCantidadReservada(ib.getCantidadReservada());
			ub.setBulto(ibpre);
			session.save(ub);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error ALMACENDAO. Nueva Ubicacion");
		}
		return;
	}
}
