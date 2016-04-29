package controlador;

import modelo.*;
import negocio.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class controladorRegistro
 */
@WebServlet("/controladorRegistro")
public class controladorRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorRegistro() {
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
		String campos[] = new String[4];
		campos[0] = request.getParameter("email");
		campos[1] = request.getParameter("boleta");
		campos[2] = request.getParameter("nombre");
		campos[3] = request.getParameter("password");
		
		QuerysBD mysql = new QuerysBD();
		
		mysql.registrarUsuario(campos);
		
		response.sendRedirect("login.html");
		
		
		

	}
}
