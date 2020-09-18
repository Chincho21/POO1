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
	public String DameArtista() { 
		return artista;
	}
	//GETTER PARA OBTENER EL DATO DEL NOMBRE DEL ALBUM
	public String DameAlbum() { 
		return album;
	}
	//GETTER PARA OBTENER EL DATO DE LA DURACION EN SEGUNDOS
	public int DameDuracion() { 
		return duracion;
	}
	//GETTER PARA OBTENER EL DATO DEL NOMBRE DEL TITULO
	public String DameTitulo() { 
		return titulo;
	}

	//GETTER PARA MOSTRAR DATOS GENERALES DE CADA CANCION (METODO OPCIONAL)
	public String MostrarDatosGeneralesDeCancion() {
		return "Titulo: " + titulo + " | " + "Duración: " + duracion + " | " +
				"Album: " + album + " | " + "Artista: " + artista;
	}

}
