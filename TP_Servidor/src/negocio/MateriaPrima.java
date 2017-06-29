package negocio;

import dto.MateriaPrimaDTO;
import entities.MateriaPrimaEntity;
import estados.EstadoMP;

public class MateriaPrima {
	private int codigo;
	private float cantidadAComprar;
	private float cantidadPtoPedido; 
	private String nombre;

	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getCantidadAComprar() {
		return cantidadAComprar;
	}

	public void setCantidadAComprar(float cantidadAComprar) {
		this.cantidadAComprar = cantidadAComprar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	
	
	

	public float getCantidadPtoPedido() {
		return cantidadPtoPedido;
	}

	public void setCantidadPtoPedido(float cantidadPtoPedido) {
		this.cantidadPtoPedido = cantidadPtoPedido;
	}

	public MateriaPrima() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MateriaPrima(MateriaPrimaEntity materiaprima) {
		this.cantidadAComprar=materiaprima.getCantidadAComprar();
		this.codigo=materiaprima.getCodigo();
		this.nombre=materiaprima.getNombre();
		this.cantidadPtoPedido=materiaprima.getCantidadPtoPedido();
	}

	public MateriaPrima(int codigo, float cantidadAComprar, float cantidadPtoPedido, String nombre) {
		super();
		this.codigo = codigo;
		this.cantidadAComprar = cantidadAComprar;
		this.cantidadPtoPedido = cantidadPtoPedido;
		this.nombre = nombre;
		
	}

	public MateriaPrimaDTO toDTO() {
		MateriaPrimaDTO mate = new MateriaPrimaDTO();
		mate.setCodigo(this.getCodigo());
		mate.setCantidadAComprar(this.getCantidadAComprar());
		//mate.setCantidadPtoReposicion(this.get);
		mate.setNombre(this.getNombre());
		return mate;
	}
	
	


	
	
	
	
}