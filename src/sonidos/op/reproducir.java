package sonidos.op;

public class reproducir {
	
	public static String son;
	public static String son2;
	
	public reproducir(String sonidoR) {
		this.son = sonidoR;
	}
	
	public static String sonar() {
		String cadena = son;
		String busqueda = son;
		String idAudio = cadena.substring(59,70);
		String reemplazo = "/recursos/audio/"+idAudio+".mp3";
		return cadena.replace(busqueda, reemplazo);
	}
}
