package ar.edu.uno.poo1.tp1;

public class Cancion {
	
	private String titulo;
	private String album;
	private String artista;
	private int duracion;


	public Cancion(String tit, String alb, String art, int dur) {
		titulo = tit;
		album = alb;
		artista = art;
		duracion = dur;
	}

	public Cancion(String tit, int dur) {
		titulo = tit;
		album = "Sin album";
		artista = "Sin artista";
		duracion = dur;
	}

	/* 
	//ESTE CONSTRUCTOR ES IGUAL AL DE ARRIBA PERO SIMPLIFICADO
	
	public Cancion(String tit, int dur) {

		this(tit, "Sin album", "Sin artista", dur);

	}*/

	//GETTER PARA OBTENER EL DATO DEL NOMBRE DEL ARTISTA
	public String dameArtista() { 
		return artista;
	}
	//GETTER PARA OBTENER EL DATO DEL NOMBRE DEL ALBUM
	public String dameAlbum() { 
		return album;
	}
	//GETTER PARA OBTENER EL DATO DE LA DURACION EN SEGUNDOS
	public int dameDuracion() { 
		return duracion;
	}
	//GETTER PARA OBTENER EL DATO DEL NOMBRE DEL TITULO
	public String dameTitulo() { 
		return titulo;
	}

	//GETTER PARA MOSTRAR DATOS GENERALES DE CADA CANCION (METODO OPCIONAL)
	public String dameDatosGeneralesDeCancion() {
		return "Titulo: " + titulo + " | " + "Duración: " + duracion + " | " +
				"Album: " + album + " | " + "Artista: " + artista;
	}

}
