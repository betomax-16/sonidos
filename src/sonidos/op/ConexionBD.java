package sonidos.op;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	
	private static Connection conexion;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String pass = "1234";
	private static final String url = "jdbc:mysql://localhost:3306/sonidos";
	
	public ConexionBD() {
		conexion = null;
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, pass);
			if (conexion != null) {
				System.out.println("Conexion establecida!!!");
			}
		} catch (Exception e) {
			System.out.println("Error al conectar " + e.getMessage());
		}
	}
	
	public Connection getConexion(){
		return conexion;
	}
	
	public void close(){
		conexion = null;
		if (conexion == null) {
			System.out.println("Conexion terminada.");			
		}
	}
}
