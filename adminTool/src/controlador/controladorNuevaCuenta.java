package controlador;
import negocio.*;
import modelo.*;
import negocio.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class controladorNuevaCuenta
 */
@WebServlet("/controladorNuevaCuenta")
public class controladorNuevaCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorNuevaCuenta() {
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
		
		/// agregar una nueva cuenta a la base de datos
		String nombre = request.getParameter("nombre");
		String Identificador = request.getParameter("identificador");
		String tipo = request.getParameter("tipo");
		String subTipo = request.getParameter("subTipo");
		Cuenta cuenta = new Cuenta(nombre,Identificador,tipo,subTipo);
		QuerysBD mysql = new QuerysBD();
		mysql.agregarCuenta(cuenta);
		response.sendRedirect("agregar.jsp");
		
		
	}

}
