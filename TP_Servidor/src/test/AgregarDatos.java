package test;

import negocio.Color;
import negocio.Talle;
import dao.TallesyColoresDAO;
public class AgregarDatos {
	public static void guardarInfo(){
	Color c1 = new Color("Rojo");
	TallesyColoresDAO.getInstancia().altaColor(c1);
	Color c2 = new Color("Negro");
	TallesyColoresDAO.getInstancia().altaColor(c2);
	Color c3 = new Color("Azul");
	TallesyColoresDAO.getInstancia().altaColor(c3);
	Color c4 = new Color("Verde");
	TallesyColoresDAO.getInstancia().altaColor(c4);
	Color c5 = new Color("Blanco");
	TallesyColoresDAO.getInstancia().altaColor(c5);
	Color c6 = new Color("Amarillo");
	TallesyColoresDAO.getInstancia().altaColor(c6);
	
	Talle t1 = new Talle("S");
	TallesyColoresDAO.getInstancia().altaTalle(t1);
	Talle t2 = new Talle("M");
	TallesyColoresDAO.getInstancia().altaTalle(t2);
	Talle t3 = new Talle("L");
	TallesyColoresDAO.getInstancia().altaTalle(t3);
	Talle t4 = new Talle("XL");
	TallesyColoresDAO.getInstancia().altaTalle(t4);
	Talle t5 = new Talle("XXL");
	TallesyColoresDAO.getInstancia().altaTalle(t5);
	
	}
}
