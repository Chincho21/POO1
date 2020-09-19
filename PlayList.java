package ar.edu.uno.poo1.tp1;

import org.junit.Before;
import org.junit.Test;

public class PlayList {
	
	private static int maximo_canciones = 10000;
	private static Cancion lista_canciones[] =  new Cancion[maximo_canciones];
	private static int contador_canciones = 0;

	@Before
	public void setUp () throws Exception {
		 lista_canciones =  new Cancion[maximo_canciones];
		}
	
	
	public static void main(String[] args) {
		
			AsignarMaximoPermitidoDeCanciones(GenerarNumeroAleatorio());

			for(int i = 0; i <maximo_canciones; i++) {
				if((GenerarNumeroAleatorio() % 2) == 0) {
					AgregarCancionAlPlaylist("CancionA"+(i+1), GenerarNumeroAleatorio());
				}
				else {
					AgregarCancionAlPlaylist("CancionB"+(i+1), "Album"+(i+1), "Artista"+ (i+1), GenerarNumeroAleatorio());
				}
			}

		    //MOSTRAR DATOS GENERALES POR CADA CANCION UTILIZANDO UN FOR [DESORDENADO] (OPCIONAL A MODO DE REALIZAR PRUEBAS)
		    
			for( int i=0; i<contador_canciones; i++ ) {
				System.out.println(lista_canciones[i].MostrarDatosGeneralesDeCancion());
			}
		    
			QuitarCancionDelPlaylist("Cancion4");
			QuitarCancionDelPlaylist(6);
			
			for( int i=0; i<contador_canciones; i++ ) {
				System.out.println(lista_canciones[i].MostrarDatosGeneralesDeCancion());
			}
			
		    ConsultarDuracionCancion("Cancion1");//BUSCADOR CANCIONES POR NOMBRE
		    
		    System.out.println("Duracion completa del PlayList: " + DameDuracionCompletaPlayList() + " segundos.");
		    System.out.println("Cantidad de canciones del PlayList: " + DameCantidadDeCanciones());
		    System.out.println("Canción mayor duracion de la PlayList: " + DameCancionMayorDuracion());
		    System.out.println("Canción menor duracion de la PlayList: " + DameCancionMenorDuracion());
		    
	//	    MostrarPlayListOrdenadoPorTituloCancion();
		    System.out.println("--------------------------------------------------------------");
	//	    MostrarPlayListOrdenadoPorArtistaCancion();
		    
		
	}
	
	//METODO PARA GENERAR UN NUMERO ALEATORIO

	private static int GenerarNumeroAleatorio() {
		int numero_aleatorio = (int)((Math.random()*10)+1);
		return numero_aleatorio;
	}
	
	//METODO PARA ASIGNAR UN MAXIMO PERMITIDO DE CANCIONES AL PROGRAMA (NUEVO)
	
	private static void AsignarMaximoPermitidoDeCanciones(int maximo_permitido) {
		if(maximo_permitido <= 10000) {
				maximo_canciones = maximo_permitido;
		}
	}
	//METODO 1 PARA AGREGAR CANCION AL PLAYLIST (NUEVO)
	
	private static void AgregarCancionAlPlaylist(String titulo, int duracion){
		if(contador_canciones < maximo_canciones){
			lista_canciones[contador_canciones]= new Cancion(titulo,duracion);
			contador_canciones++;
		}
	}
		
	//METODO 2 PARA AGREGAR CANCION AL PLAYLIST (NUEVO)
	
	private static void AgregarCancionAlPlaylist(String titulo, String album, String artista,int duracion){
		if(contador_canciones < maximo_canciones){
			lista_canciones[contador_canciones]= new Cancion(titulo, album, artista, duracion);
			contador_canciones++;
		}
	}
		
	//METODO 1 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO DURACION (NUEVO)
	private static int BuscarCancionPorDuracion(int duracion) {
			
		int bandera = 0;
		for(int i=0;i<contador_canciones;i++){
		     if(lista_canciones[i].DameDuracion() == duracion){
		     System.out.println("La duración " + duracion + " se encuentra en la posición " + (i+1));
		     bandera = 1;
		     return i;
		     }
		}
		
		if(bandera != 1){
		    System.out.println("No se encontro la duracion: " + duracion);
		}
		
		return -1;
	}
		
	//METODO 1 PARA QUITAR UNA CANCION DEL PLAYLIST INGRESANDO LA DURACION (NUEVO)
	private static void QuitarCancionDelPlaylist(int ingrese_duracion) {
		int numero_pocision;
		for(int i = 0; i < contador_canciones; i++){
			numero_pocision = BuscarCancionPorDuracion(ingrese_duracion);
			if(numero_pocision != -1) {
		    	for(int j = numero_pocision; j<contador_canciones-1; j++){
		        		lista_canciones[j] = lista_canciones[j+1];
		    	}
		    	i--;
		    	contador_canciones--;
			}
		}
	}
	
	//METODO 2 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO (NUEVO)
	private static int BuscarCancionPorTitulo(String titulo) {
		int bandera = 0;
		for(int i=0;i<contador_canciones; i++){
			if(titulo.equalsIgnoreCase(lista_canciones[i].DameTitulo())){ //BUSQUEDA POR NOMBRE
				System.out.println(titulo + " se encuentra en la posición " + (i));
				bandera = 1;
				return i;
			}
		}
		
		if(bandera != 1){
			System.out.println("No se encontro el titulo.");
		}
		
		return -1;
	}

	//METODO 2 PARA QUITAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO (NUEVO)
	
	private static void QuitarCancionDelPlaylist(String ingrese_titulo) {
			
		int numero_pocision;
		for(int i = 0; i < contador_canciones;i++){
			numero_pocision = BuscarCancionPorTitulo(ingrese_titulo);
			if(numero_pocision != -1) {
				for(int j = numero_pocision; j<contador_canciones-1; j++){
					lista_canciones[j] = lista_canciones[j+1];
				}
				contador_canciones--;
				i--;
		    	
			}
		}
	}
		
	//METODO 3 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO E INDICANDO EL INICIO DE LA POSICION DE BUSQUEDA (NUEVO)
	private static int BuscarCancionPorTitulo(String titulo, int inicio) {
		int bandera = 0;
		for(;inicio<contador_canciones;inicio++){
			if(titulo.equalsIgnoreCase(lista_canciones[inicio].DameTitulo())){//BUSQUEDA POR NOMBRE
				System.out.println(titulo + " se encuentra en la posición " + (inicio));
				bandera = 1;
				return inicio;
			}
		}
		
		if(bandera != 1){
			System.out.println("No se encontro el titulo.");
		}
		return -1;
	}
		
	//METODO PARA CONSULTAR LA DURACION DE UNA CANCION INGRESANDO TITULO(NUEVO)
	
	private static void ConsultarDuracionCancion(String titulo) {
		
		int vect_duraciones[] = new int[contador_canciones];
		int contador = 0;
		int j = 0;
		int numero_posicion = 0;
		    
		for(int i = 0; i < contador_canciones; i++) {
		    		
		    numero_posicion = BuscarCancionPorTitulo(titulo, j);
		    contador++;
		    		
		    if (numero_posicion != -1) {
		    	vect_duraciones[j] = lista_canciones[i].DameDuracion();
		    	j++;
		    }
		    		
		    if(contador == contador_canciones) {
		    	if(j != 0) {
		    		for(int k = 0; k < j; k++) {
		    			System.out.println(vect_duraciones[k]);
		    		}
		    	}
		    	else {
		    		System.out.println("-1");
		    	}
		    			
		    }
		    	
		}
			
	}
		
	//METODO PARA OBTENER LA DURACION COMPLETA DEL PLAYLIST (NUEVO)
	private static int DameDuracionCompletaPlayList() {
		int acumulador = 0;
		for(int i = 0; i < contador_canciones; i++) {
			acumulador += lista_canciones[i].DameDuracion();
		}
		
		return acumulador;
	}
	
	//METODO PARA OBTENER LA CANTIDAD DE CANCIONES INGRESADAS AL PLAYLIST (NUEVO)
	private static int DameCantidadDeCanciones() {
		return contador_canciones;
	}
	
	//METODO PARA OBTENER LA CANCION CON MAYOR DURACION DEL PLAYLIST (NUEVO)
	private static int DameCancionMayorDuracion() {
		int mayor_duracion = 0;
		int posicion_mayor = 0;
		for(int i = 0; i < contador_canciones; i++) {
			if(mayor_duracion < lista_canciones[i].DameDuracion()) {
				mayor_duracion = lista_canciones[i].DameDuracion();
				posicion_mayor = i;
			}
		}
			
		return lista_canciones[posicion_mayor].DameDuracion();
		
	}
	
	//METODO PARA OBTENER LA CANCION CON MENOR DURACION DEL PLAYLIST (NUEVO)
	private static int DameCancionMenorDuracion() {
		int menor_duracion = 0;
		int posicion_menor = 0;
		int bandera = 0;
		for(int i = 0; i < contador_canciones; i++) {
			if(bandera == 0) {
				menor_duracion = lista_canciones[i].DameDuracion();
				posicion_menor = i;
				bandera = 1;
			}
				
			if(menor_duracion > lista_canciones[i].DameDuracion()) {
				menor_duracion = lista_canciones[i].DameDuracion();
				posicion_menor = i;
				bandera = 1;
			}
		}
			
		return lista_canciones[posicion_menor].DameDuracion();
		
	}
		
	//METODO PARA MOSTRAR EL PLAYSLIST ORDENADO POR TITULO DE CANCION (NUEVO)
	@Test
	public void MostrarPlayListOrdenadoPorTituloCancion(){
		int min = 0;
		int j = 0;
		Cancion aux = new Cancion(" ", 0);
			
		//INICIAMOS EL ORDENAMIENTO POR SELECCION
		for(int i=0; i < contador_canciones; i++) {
			min = i;
			for(j = i + 1; j < contador_canciones; j++) {
				if((lista_canciones[j].DameTitulo().compareToIgnoreCase(lista_canciones[min].DameTitulo())) < 0) {
					min = j;
				}
			}
				
			aux = lista_canciones[i];
			lista_canciones[i] = lista_canciones[min];
			lista_canciones[min] = aux;
		}
		
		/*//INICIAMOS EL ORDENAMIENTO METODO BURBUJA (OPCIONAL)
		for(int i=1; i<=contador_canciones; i++) {  
	        for(j = 0; j <contador_canciones-i; j++) { 
	            if( lista_canciones[j].DameTitulo().compareTo( lista_canciones[j+1].DameTitulo() ) > 0 ) { 
	                aux   = lista_canciones[j]; 
	                lista_canciones[j]  = lista_canciones[j+1]; 
	                lista_canciones[j+1]= aux; 
	            }    
	        } 
	    }*/
			
		//AHORA MOSTRAMOS LA LISTA ORDENADA
			
		for(int i = 0; i < contador_canciones; i ++) {
			System.out.println(lista_canciones[i].MostrarDatosGeneralesDeCancion());
		}
			
	}
		
	//METODO PARA MOSTRAR EL PLAYSLIST ORDENADO POR ARTISTA DE CANCION (NUEVO)
	@Test
	public void MostrarPlayListOrdenadoPorArtistaCancion(){
		int min = 0;
		int j = 0;
		Cancion aux = new Cancion(" ", 0);
			
		for(int i=0; i < contador_canciones; i++) {
			min = i;
			for(j = i + 1; j < contador_canciones; j++) {
				if((lista_canciones[j].DameArtista().compareToIgnoreCase(lista_canciones[min].DameArtista())) < 0) {
					min = j;
				}
			}
				
			aux = lista_canciones[i];
			lista_canciones[i] = lista_canciones[min];
			lista_canciones[min] = aux;
		}
			
		for(int i = 0; i < contador_canciones; i ++) {
			System.out.println(lista_canciones[i].MostrarDatosGeneralesDeCancion());
		}
			
	}

}
