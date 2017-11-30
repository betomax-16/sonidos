package sonidos.op;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Sonido {
	private Integer id;
	private String titulo;
	private String imagen;
	private String audio;
	private String tipo;
	private Cliente cliente;
	private PreparedStatement ps;
	private ConexionBD con;	
	
	public Sonido(String titulo, String imagen, String audio, String tipo, int idCLiente) {
		this.titulo = titulo;
		this.imagen = imagen;
		this.audio = audio;
		this.tipo = tipo;
		this.cliente = Cliente.buscarPorId(idCLiente);
		ps = null;
		con = new ConexionBD();
		//Get cliente
	}
	
	public Sonido(String titulo, String imagen, String audio, String tipo, Cliente cliente) {
		this.titulo = titulo;
		this.imagen = imagen;
		this.audio = audio;
		this.tipo = tipo;
		this.cliente = cliente;
		ps = null;
		con = new ConexionBD();
	}
	
	public int guardar(){
		int res = 0;
		String query;
		if (this.id == null) {
			query = "insert into sonidos (idSonido, Titulo, Imagen, Archivo, Tipo, Cliente) values (idSonido, ?, ?, ?, ?, ?)";
		}
		else{
			query = "update sonidos set Titulo = ?, Imagen = ?, Archivo = ?, Tipo = ?, Cliente = ? WHERE idSonido = ?";
		}
		
		try {
			ps = con.getConexion().prepareStatement(query);
			ps.setString(1, this.titulo);
			ps.setString(2, this.imagen);
			ps.setString(3, this.audio);
			ps.setString(4, this.tipo);
			ps.setInt(5, this.cliente.getId());
			if (this.id != null) { ps.setInt(6, this.id); }
			else{ps.setInt(5, this.cliente.getId());}
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
	
	public int eliminar(){
		int res = 0;
		String query = "delete from sonidos WHERE idSonido = ?";		
		
		try {
			if (this.id != null) { 
				ps = con.getConexion().prepareStatement(query);			
				ps.setInt(1, this.id); 			
				res = ps.executeUpdate();
			}
			else{ res = 0; }
		} catch (Exception e) {
			System.out.println("Error al eliminar " + e.getMessage());
		}
		finally {
			ps = null;
			con.close();
		}
		return res;
	}
	
	public static int eliminar(int id){
		int res = 0;
		Sonido newAudio = buscarPorId(id);
		if (newAudio != null) {
			res = newAudio.eliminar();
		}		
		return res;
	}
	
	public static Sonido buscarPorId(int id){		
		String query = "select * from sonidos WHERE idSonido = ?";
		ConexionBD con = new ConexionBD();
		PreparedStatement ps;
		Sonido newAudio = null;
		try {
			ps = con.getConexion().prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {	
				String titulo = rs.getString("Titulo");
				String imagen = rs.getString("Imagen");
				String audio = rs.getString("Archivo");
				String tipo = rs.getString("Tipo");
				Cliente cliente = Cliente.buscarPorId(rs.getInt("Cliente"));
				newAudio = new Sonido(titulo, imagen, audio, tipo, cliente);
				newAudio.setId(rs.getInt("idSonido"));
			}
		} catch (Exception e) {
			System.out.println("Error al consultar sonidos " +  e.getMessage());
		}
						
		return newAudio;
	}
	
	public static ArrayList<Sonido> buscarPorTipo(String tipo){
		ArrayList<Sonido> sonidos = new ArrayList<Sonido>();
		String query = "select * from sonidos WHERE tipo = ?";
		ConexionBD con = new ConexionBD();
		PreparedStatement ps;
		Sonido newAudio = null;
		try {
			ps = con.getConexion().prepareStatement(query);
			ps.setString(1, tipo);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {	
				String titulo = rs.getString("Titulo");
				String imagen = rs.getString("Imagen");
				String audio = rs.getString("Archivo");
				Cliente cliente = Cliente.buscarPorId(rs.getInt("Cliente"));
				newAudio = new Sonido(titulo, imagen, audio, tipo, cliente);
				newAudio.setId(rs.getInt("idSonido"));
				sonidos.add(newAudio);
			}
		} catch (Exception e) {
			System.out.println("Error al consultar sonidos " +  e.getMessage());
		}
						
		return sonidos;
	}
	
	public static ArrayList<Sonido> buscarPorIdCliente(int idCliente){
		ArrayList<Sonido> sonidos = new ArrayList<Sonido>();
		String query = "select * from sonidos WHERE cliente = ?";
		ConexionBD con = new ConexionBD();
		PreparedStatement ps;
		Sonido newAudio = null;
		try {
			ps = con.getConexion().prepareStatement(query);
			ps.setInt(1, idCliente);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {	
				String titulo = rs.getString("Titulo");
				String imagen = rs.getString("Imagen");
				String audio = rs.getString("Archivo");
				String tipo = rs.getString("Tipo");
				Cliente cliente = Cliente.buscarPorId(rs.getInt("Cliente"));
				newAudio = new Sonido(titulo, imagen, audio, tipo, cliente);
				newAudio.setId(rs.getInt("idSonido"));
				sonidos.add(newAudio);
			}
		} catch (Exception e) {
			System.out.println("Error al consultar sonidos " +  e.getMessage());
		}
						
		return sonidos;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
