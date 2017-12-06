package sonidos.op;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cliente {
	private String id;
	private String usuario;
	private String nombre;
	private String apellidos;
	private String contrasena;
	private String email;
	private PreparedStatement ps;
	private ConexionBD con;
	
	public Cliente(String usuario, String nombre, String apellidos, String contrasena, String email) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.email = email;
		ps = null;
		con = new ConexionBD();
	}
	public Cliente(String id, String usuario, String nombre, String apellidos, String contrasena, String email) {
		this.id = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.email = email;
		ps = null;
		con = new ConexionBD();
	}
	
	public Cliente(){
		ps = null;
		con = new ConexionBD();
	}
	
	public int guardar(){
		int res = 0;
		String query = "insert into clientes (Usuario, Nombre, Apellidos, Contrasena, Correo) values (?, ?, ?, ?, ?)";
		try {
			ps = con.getConexion().prepareStatement(query);
			ps.setString(1, this.usuario);
			ps.setString(2, this.nombre);
			ps.setString(3, this.apellidos);
			ps.setString(4, this.contrasena);
			ps.setString(5, this.email);
			res = ps.executeUpdate();
		} catch (Exception e) {			
			System.out.println("Error al insertar " + e.getMessage());
		}
		finally {
			ps = null;
			con.close();
		}
		return res;
	}
	
	public boolean login(String usuario, String password){
		ResultSet rs;
		String query = "select * from clientes where Usuario=? and Contrasena=? ";
		try{
			ps = con.getConexion().prepareStatement(query);
			ps.setString(1, usuario);
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			if(rs.next()){
				System.out.println("Logueo Exitoso");
				return true;
			}
			else{
				System.out.println("Los datos son incorrectos");
				return false;
			}
		}catch (Exception e) {			
			System.out.println("Error al insertar " + e.getMessage());
			return false;
		}
		finally {
			ps = null;
			con.close();
		}
	}
	
	public Cliente getDatos(String usuario, String pass){
		Cliente objeto = new Cliente();
		ResultSet rs;
		String query = "select * from clientes where Usuario=? and Contrasena=? ";
		try{
			ps = con.getConexion().prepareStatement(query);
			ps.setString(1, usuario);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			if(rs.next()){
				objeto.setId(rs.getString("idCliente"));
				objeto.setUsuario(usuario);
				objeto.setNombre(rs.getString("Nombre"));
				objeto.setApellidos(rs.getString("Apellidos"));
				objeto.setContrasena(rs.getString("Contrasena"));
				objeto.setEmail(rs.getString("Correo"));
			}
		}catch (Exception e) {			
			System.out.println("Error al regresar objeto " + e.getMessage());
		}
		finally {
			ps = null;
			con.close();
		}
		return objeto;
	}
	
	public void eliminar(){
		
	}
	
	public static Cliente buscarPorId(String id){
		String usuario = "";
		String nombre = "";
		String apellidos = "";
		String contrasena = "";
		String email = "";
		Cliente cl = new Cliente(usuario, nombre, apellidos, contrasena, email);
		cl.setId(id);
		return cl;
	}
	
	public static void buscarPorTipo(String tipo){
		
	}
	
	public static void buscarPorIdCliente(int idCliente){
		
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}
	
	private void setId(String id) {
		this.id = id;
	}
	
	
	public static void main( String[] args ){
	//Cliente c = new Cliente("romulo", "Romulo", "Mcginnis", "123456", "mcinnis68@hotmail.com");
	//c.guardar();
		Cliente c= new Cliente();
		Cliente obj = new Cliente();
		obj = c.getDatos("romulo", "123456");
		System.out.println(obj.getApellidos());
	
	}
}
