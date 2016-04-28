package modelo;
import java.util.*;

public class Registro {

	private String nombre;
	private ArrayList operaciones;
	public Registro(String nombre) {
		
		this.nombre = nombre;
	}
	public void agregarOperacion(Operacion oper)
	{
		operaciones.add(oper);
	}
	public void eliminarOperacion(Operacion oper)
	{
		
	}
	
	public ArrayList getOperaciones()
	{
		return operaciones;
	}
	public String getNombre()
	{
		return nombre;
	}

}
