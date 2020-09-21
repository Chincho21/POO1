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


	public String dameArtista() { 
		return artista;
	}

	public String dameAlbum() { 
		return album;
	}

	public int dameDuracion() { 
		return duracion;
	}

	public String dameTitulo() { 
		return titulo;
	}

	public String dameDatosGeneralesDeCancion() {
		return "Titulo: " + titulo + " | " + "Duración: " + duracion + " | " +
				"Album: " + album + " | " + "Artista: " + artista;
	}

}
