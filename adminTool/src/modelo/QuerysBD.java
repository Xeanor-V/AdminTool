package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.ConexionBD;


public class QuerysBD {
	public static String[] obtenerNombres() {
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String sentencia = "SELECT nombre FROM t00figuras";
			ResultSet tuplas = basedatos.consulta(sentencia);
			String aux = "";
			while (tuplas.next())
				aux += tuplas.getString(1) + ",HoLa";
			if(aux.equals(""))
				return null;
			return aux.split(",HoLa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String validarUsuario(String boleta, String pass) {
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String sentencia = "SELECT idusuario FROM usuario where nocuenta = '" + boleta + "' and contra = " + pass + "'";
			ResultSet tuplas = basedatos.consulta(sentencia);
			String aux = "";
			while (tuplas.next())
				return tuplas.getString(1);
			if(aux.equals(""))
				return "null";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String[] obtenerFechas() {
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String sentencia = "SELECT fecha FROM t00figuras";
			ResultSet tuplas = basedatos.consulta(sentencia);
			
			String aux = "";
			while (tuplas.next())
				aux += tuplas.getString(1) + ",EdGaR";
			
			if(aux.equals(""))
				return null;
			return aux.split(",EdGaR");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String[] obtenerIDs() {
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			
			String sentencia = "SELECT idt00figuras FROM t00figuras";
			
			ResultSet tuplas = basedatos.consulta(sentencia);
			String aux = "";
			while (tuplas.next())
				aux += tuplas.getString(1) + ",1234";
			if(aux.equals(""))
				return null;
			return aux.split(",1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String[] obtenerTupla(String id) {
		try {
			ConexionBD basedatos = new ConexionBD();

			basedatos.conectar(DatosBD.url, DatosBD.usuario, DatosBD.password);
			
			String sentencia = "SELECT * FROM t00figuras WHERE idt00figuras = " + id;
			
			ResultSet tuplas = basedatos.consulta(sentencia);
			String aux = "";
			while (tuplas.next()){
				for(int i = 1; i <= 8; i++)
					aux += tuplas.getString(i) + "CoMaAaAaAaA";
			}
			if(aux.equals(""))
				return null;
			return aux.split("CoMaAaAaAaA");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String obtenerColor(String id) {
		try {
			ConexionBD basedatos = new ConexionBD();

			basedatos.conectar(DatosBD.url, DatosBD.usuario, DatosBD.password);
			
			String sentencia = "SELECT extra3 FROM t00figuras WHERE idt00figuras = " + id;
			
			ResultSet tuplas = basedatos.consulta(sentencia);
			tuplas.next();
			return tuplas.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String obtenerXML(String id) {
		try {
			ConexionBD basedatos = new ConexionBD();

			basedatos.conectar(DatosBD.url, DatosBD.usuario, DatosBD.password);
			
			String sentencia = "SELECT xml FROM t00figuras WHERE idt00figuras = " + id;
			
			ResultSet tuplas = basedatos.consulta(sentencia);
			tuplas.next();
			return tuplas.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String obtenerID(int id) {
		try {
			ConexionBD basedatos = new ConexionBD();

			basedatos.conectar(DatosBD.url, DatosBD.usuario, DatosBD.password);
			
			String sentencia = "SELECT idt00figuras FROM t00figuras";
			
			ResultSet tuplas = basedatos.consulta(sentencia);
			for(int i = 0; i <= id; i++)
				tuplas.next();
			return tuplas.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void insert(String sentencia){
		ConexionBD basedatos = new ConexionBD();
		basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
		
		basedatos.insertar(sentencia);
	}
	
	public static void eliminar(String id){
		ConexionBD basedatos = new ConexionBD();
		basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
		
		String sentencia = "DELETE FROM t00figuras WHERE idt00figuras = " + id;	
		basedatos.insertar(sentencia);
	}
	
	public static void main(String[] args){
		String[] nombre = obtenerNombres();
		System.out.println(nombre);
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
	}
}
