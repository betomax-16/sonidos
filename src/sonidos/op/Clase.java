package sonidos.op;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Clase {
	private String clase;
		
	public Clase(String clase) {
		this.clase = clase;
	}
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
	
	public static ArrayList<Clase> getAll(){
		ArrayList<Clase> clases = new ArrayList<Clase>();
		String query = "select * from clase";
		ConexionBD con = new ConexionBD();
		PreparedStatement ps;
		Clase newClass = null;
		try {
			ps = con.getConexion().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {	
				String clase = rs.getString("Tipo");
				newClass = new Clase(clase);
				clases.add(newClass);
			}
		} catch (Exception e) {
			System.out.println("Error al consultar sonidos " +  e.getMessage());
		}
						
		return clases;
	}
}
