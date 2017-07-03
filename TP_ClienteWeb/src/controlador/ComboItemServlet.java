package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BusinessDelegate;
import dto.ItemPrendaDTO;
import dto.PrendaDTO;

/**
 * Servlet implementation class ComboItem
 */
public class ComboItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doPost(request, response);
		String prenda = request.getParameter("prenda");
		System.out.println(prenda);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String prenda = request.getParameter("prenda");
		String talle = request.getParameter("talle");
		response.setContentType("text/plain");

		if (talle != null && !talle.equals("Seleccione una opcion")) {
			String buffer = "<select name='color'><option>Seleccione una opcion</option>";
			List<PrendaDTO> prendaDTOs = BusinessDelegate.getInstancia().obtenerPrendas();
			for (PrendaDTO prendaDTO : prendaDTOs) {
				if (prendaDTO.getDescripcion().equals(prenda)) {
					for (ItemPrendaDTO itemPrendaDTO : prendaDTO.getItemPrenda()) {
						if (itemPrendaDTO.getTalle().getDescripcion().equals(talle)) {
							buffer = buffer + "<option value='" + itemPrendaDTO.getColor().getDescripcion() + "'>"
									+ itemPrendaDTO.getColor().getDescripcion() + "</option>";
						}
					}

				}
			}
			buffer = buffer + "</select>";
			response.getWriter().println(buffer);

		} else {
			String buffer = "<select name='talle'><option>Seleccione una opcion</option>";
			List<PrendaDTO> prendaDTOs = BusinessDelegate.getInstancia().obtenerPrendas();
			for (PrendaDTO prendaDTO : prendaDTOs) {
				if (prendaDTO.getDescripcion().equals(prenda)) {
					for (ItemPrendaDTO itemPrendaDTO : prendaDTO.getItemPrenda()) {
						buffer = buffer + "<option value='" + itemPrendaDTO.getTalle().getDescripcion() + "'>"
								+ itemPrendaDTO.getTalle().getDescripcion() + "</option>";
					}

				}
			}
			buffer = buffer + "</select>";
			response.getWriter().println(buffer);

		}

	}

}
