package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;

import entities.ClienteEntity;
import entities.FacturaEntity;
import entities.ItemFacturaEntity;
import entities.PedidoEntity;
import hbt.HibernateUtil;
import negocio.Factura;
import negocio.ItemFactura;

public class FacturaDAO {
	private static FacturaDAO instancia = null;
	private static SessionFactory sf = null;

	public static FacturaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new FacturaDAO();
		} 
		return instancia;
	}	
	// ALTAS
	public Integer grabarFactura(Factura factura){
		Session session = sf.openSession();
		session.beginTransaction();
		FacturaEntity f=new FacturaEntity();
		f.setCliente((ClienteEntity)session.get(ClienteEntity.class, (factura.getCliente().getId())));
		f.setEstado(factura.getEstado());
		f.setFechaEmision(factura.getFechaEmision());
		//f.setFechaVencimiento(factura.getFechaVencimiento());
		List<ItemFacturaEntity> itemsFactura=new ArrayList<ItemFacturaEntity>();
 			for (ItemFactura itemf : factura.getItemsFactura()) {
				ItemFacturaEntity item=new ItemFacturaEntity();
				item.setCantidad(itemf.getCantidad());
				PedidoEntity ip =  (PedidoEntity) session.get(PedidoEntity.class, itemf.getPedido().getId());
				item.setPedido(ip);
				item.setPrecioUnitario(itemf.getPrecioUnitario());
				
				itemsFactura.add(item);
			}
		    f.setItemsFactura(itemsFactura);
			f.setTotal(factura.getTotal());			
		Integer idfactura =(Integer) session.save(f);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return idfactura;
	}
	
	// BUSCAR
	public Factura buscarFactura (int nro){
		FacturaEntity factura = null;
		try {
			Session session = sf.openSession();
			
			String hql = "FROM FacturaEntity F " +
						 "WHERE F.nro = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", nro);
			query.setMaxResults(1);
			
			if(query.uniqueResult() != null){
				factura = (FacturaEntity) query.uniqueResult();
	        	session.close();
	        }else{
	        	session.close();
	        }
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en FacturaDAO: buscarFactura");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Factura(factura);
	}

	public List<Factura> buscarFacturas(int codigoCliente) {

			List<Factura> facturas = new ArrayList<Factura>();
			Session session = sf.openSession();
			try{
			String hql = "FROM FacturaEntity F " +
						 "WHERE F.cliente = :codigoCliente and (F.pago=false or F.pago is null)";
			
			@SuppressWarnings("unchecked")
			List<FacturaEntity> query = (List<FacturaEntity>) session.createQuery(hql).setInteger("codigoCliente", codigoCliente).list();
			          
        	for (FacturaEntity pr : query) {
				Factura f=new Factura(pr);
				facturas.add(f);
			}				
        	session.close();

		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en FacturaDAO: buscarFacturas");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return facturas;
	}
	
}
