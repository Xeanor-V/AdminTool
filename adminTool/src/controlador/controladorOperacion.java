package controlador;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class controladorOperacion
 */
@WebServlet("/controladorOperacion")
public class controladorOperacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorOperacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//manda el nombre del registro en la url para que no haya pedos y sea mas rapido el asunto
		//esta cosa agarra lo que esta despues del & donde van los parametros atraves de la url
		String Query = URLDecoder.decode(request.getQueryString(), "UTF-8");
		//y agarramos el nombre a usar
		String nombreRegistro = Query.substring(Query.indexOf('=') + 1, Query.length());
		
		HttpSession session = request.getSession();
		
		HashMap registros = (HashMap) session.getAttribute("registros");
		
		
		if(registros.containsKey(nombreRegistro))
		{
			Registro registroUsar = registros.get(nombreRegistro);
		}
		else
		{
			Registro registroUsar = new Registro(nombreRegistro);
		}
		
		
	}

}
