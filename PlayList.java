package ar.edu.uno.poo1.tp1;

public class PlayList {
	
	private static int maximo_canciones = 10000;
	private static Cancion lista_canciones[] =  new Cancion[maximo_canciones];
	private static int contador_canciones = 0;
	
	public void iniciarPrograma() {
		
		asignarMaximoPermitidoDeCanciones(5);

		for(int i = 0; i <maximo_canciones; i++) {
			if((dameNumeroAleatorio() % 2) == 0) {
				agregarCancionAlPlaylist("ACancion"+(dameNumeroAleatorio()), dameNumeroAleatorio());
			}
			else {
				agregarCancionAlPlaylist("BCancion"+(i+1), "Album"+(i+1), "Artista"+ (dameNumeroAleatorio()), dameNumeroAleatorio());
			}
		}

	    //MOSTRAR DATOS GENERALES POR CADA CANCION UTILIZANDO UN FOR [DESORDENADO] (OPCIONAL A MODO DE REALIZAR PRUEBAS)
		
		for( int i=0; i<contador_canciones; i++ ) {
			System.out.println(lista_canciones[i].dameDatosGeneralesDeCancion());
		}
		
		System.out.println("--------------------------------------------------------------");
	    
		//quitarCancionDelPlaylist("ACancion");
		//quitarCancionDelPlaylist(6);
		
		/*for( int i=0; i<contador_canciones; i++ ) {
			System.out.println(lista_canciones[i].dameDatosGeneralesDeCancion());
		}
		*/
		
		/*/consultarDuracionCancion("BCancion");//BUSCADOR CANCIONES POR NOMBRE
		System.out.println("--------------------------------------------------------------");
	    System.out.println("Duracion completa del PlayList: " + dameDuracionCompletaPlayList() + " segundos.");
	    System.out.println("Cantidad de canciones del PlayList: " + dameCantidadDeCancionesPlayList());
	    System.out.println("Canción mayor duracion de la PlayList: " + dameCancionMayorDuracionPlayList());
	    System.out.println("Canción menor duracion de la PlayList: " + dameCancionMenorDuracionPlayList());
	    */
	    //mostrarPlayListOrdenadoPorTituloCancion();
	    System.out.println("--------------------------------------------------------------");
	    
	    //mostrarPlayListOrdenadoPorTituloCancion();
	    System.out.println("--------------------------------------------------------------");
	    
	    //mostrarPlayListOrdenadoPorArtistaCancion();
	    
	}
	
		//METODO PARA GENERAR UN NUMERO ALEATORIO
		public static int dameNumeroAleatorio() {
			int numero_aleatorio = (int)((Math.random()*10)+1);
			return numero_aleatorio;
		}
		
		//METODO PARA ASIGNAR UN MAXIMO PERMITIDO DE CANCIONES AL PROGRAMA (NUEVO)
		public static void asignarMaximoPermitidoDeCanciones(int maximo_permitido) {
			if(maximo_permitido <= 10000) {
					maximo_canciones = maximo_permitido;
			}
		}
		//METODO 1 PARA AGREGAR CANCION AL PLAYLIST (NUEVO)
		public static void agregarCancionAlPlaylist(String titulo, int duracion){
			if(contador_canciones < maximo_canciones){
				lista_canciones[contador_canciones]= new Cancion(titulo,duracion);
				contador_canciones++;
			}
		}
			
		//METODO 2 PARA AGREGAR CANCION AL PLAYLIST (NUEVO)
		public static void agregarCancionAlPlaylist(String titulo, String album, String artista,int duracion){
			if(contador_canciones < maximo_canciones){
				lista_canciones[contador_canciones]= new Cancion(titulo, album, artista, duracion);
				contador_canciones++;
			}
		}
			
		//METODO 1 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO DURACION (NUEVO)
		public static int buscarCancionPorDuracion(int duracion) {
				
			int bandera = 0;
			for(int i=0;i<contador_canciones;i++){
			     if(lista_canciones[i].dameDuracion() == duracion){
			     System.out.println("La duración " + duracion + " se encuentra en la posición " + i);
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
		public static void quitarCancionDelPlaylist(int ingrese_duracion) {
			int numero_pocision;
			for(int i = 0; i < contador_canciones; i++){
				numero_pocision = buscarCancionPorDuracion(ingrese_duracion);
				if(numero_pocision != -1) {
			    	for(int j = numero_pocision; j<contador_canciones-1; j++){
			        		lista_canciones[j] = lista_canciones[j+1];
			    	}
			    	i--;
			    	contador_canciones--;
			    	maximo_canciones--;
				}
			}
		}
		
		//METODO 2 PARA QUITAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO (NUEVO)
		public static void quitarCancionDelPlaylist(String ingrese_titulo) {
				
			int numero_pocision;
			for(int i = 0; i < contador_canciones;i++){
				numero_pocision = buscarCancionPorTitulo(ingrese_titulo);
				if(numero_pocision != -1) {
					for(int j = numero_pocision; j<contador_canciones-1; j++){
						lista_canciones[j] = lista_canciones[j+1];
					}
					contador_canciones--;
					maximo_canciones--;
					i--;
			    	
				}
			}
		}
		
		//METODO 2 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO (NUEVO)
		public static int buscarCancionPorTitulo(String titulo) {
			int bandera = 0;
			for(int i=0;i<contador_canciones; i++){
				if(titulo.equalsIgnoreCase(lista_canciones[i].dameTitulo())){ //BUSQUEDA POR NOMBRE
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


			
		//METODO 3 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO E INDICANDO EL INICIO DE LA POSICION DE BUSQUEDA (NUEVO)
		public static int buscarCancionPorTitulo(String titulo, int inicio) {
			
			int bandera = 0; // SE BORRAN LOS SYSTEM Y SE BORRA BANDERA
			
			for(;inicio<contador_canciones;inicio++){
				if(titulo.equalsIgnoreCase(lista_canciones[inicio].dameTitulo())){//BUSQUEDA POR NOMBRE
					System.out.println(titulo + " se encuentra en la posición " + inicio); // BORRAR
					bandera = 1; // BORRAR
					return inicio;
				}

			}
			
			if(bandera != 1){//BORRAR
				System.out.println("No se encontro el titulo.");//BORRAR
			}
			return -1;
		}
			
		//METODO PARA CONSULTAR LA DURACION DE UNA CANCION INGRESANDO TITULO(NUEVO)
		public static void consultarDuracionCancion(String titulo) {
			
			int vect_duraciones[] = new int[contador_canciones];
			int contador = 1;
			int j = 0;
			int numero_posicion = 0;
			    
			for(int i = 0; i < contador_canciones; i++) {
			    		
			    numero_posicion = buscarCancionPorTitulo(titulo, j);
			    
			    
			    if (numero_posicion != -1) {
			    	vect_duraciones[j] = lista_canciones[i].dameDuracion();
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
			    contador++;	
			}
				
		}
			
		//METODO PARA OBTENER LA DURACION COMPLETA DEL PLAYLIST (NUEVO)
		public static int dameDuracionCompletaPlayList() {
			int acumulador = 0;
			for(int i = 0; i < contador_canciones; i++) {
				acumulador += lista_canciones[i].dameDuracion();
			}
			
			return acumulador;
		}
		
		//METODO PARA OBTENER LA CANTIDAD DE CANCIONES INGRESADAS AL PLAYLIST (NUEVO)
		public static int dameCantidadDeCancionesPlayList() {
			return contador_canciones;
		}
		
		//METODO PARA OBTENER LA CANCION CON MAYOR DURACION DEL PLAYLIST (NUEVO)
		public static int dameCancionMayorDuracionPlayList() {
			int mayor_duracion = 0;
			int posicion_mayor = 0;
			for(int i = 0; i < contador_canciones; i++) {
				if(mayor_duracion < lista_canciones[i].dameDuracion()) {
					mayor_duracion = lista_canciones[i].dameDuracion();
					posicion_mayor = i;
				}
			}
				
			return lista_canciones[posicion_mayor].dameDuracion();
			
		}
		
		//METODO PARA OBTENER LA CANCION CON MENOR DURACION DEL PLAYLIST (NUEVO)
		public static int dameCancionMenorDuracionPlayList() {
			int menor_duracion = 0;
			int posicion_menor = 0;
			int bandera = 0;// boolean
			for(int i = 0; i < contador_canciones; i++) {
				if(bandera == 0) {
					menor_duracion = lista_canciones[i].dameDuracion();
					posicion_menor = i;
					bandera = 1;
				}
					
				if(menor_duracion > lista_canciones[i].dameDuracion()) {
					menor_duracion = lista_canciones[i].dameDuracion();
					posicion_menor = i;
					
				}
			}
				
			return lista_canciones[posicion_menor].dameDuracion();
			
		}
			
		//METODO PARA MOSTRAR EL PLAYSLIST ORDENADO POR TITULO DE CANCION (NUEVO)
		public static void mostrarPlayListOrdenadoPorTituloCancion(){
			int min = 0;
			int j = 0;
			Cancion aux = new Cancion(" ", 0);
				
			//INICIAMOS EL ORDENAMIENTO POR SELECCION
			for(int i=0; i < contador_canciones; i++) {
				min = i;
				for(j = i + 1; j < contador_canciones; j++) {
					if((lista_canciones[j].dameTitulo().compareToIgnoreCase(lista_canciones[min].dameTitulo())) < 0) {
						min = j;
					}
				}
					
				aux = lista_canciones[i];
				lista_canciones[i] = lista_canciones[min];
				lista_canciones[min] = aux;
			}
			
			//INICIAMOS EL ORDENAMIENTO METODO BURBUJA (OPCIONAL)
			/*for(int i=1; i<=contador_canciones; i++) {  
		        for(j = 0; j <contador_canciones-i; j++) { 
		            if( lista_canciones[j].dameArtista().compareTo( lista_canciones[j+1].dameArtista() ) > 0 ) { 
		                aux   = lista_canciones[j]; 
		                lista_canciones[j]  = lista_canciones[j+1]; 
		                lista_canciones[j+1]= aux; 
		            }    
		        } 
		    }
				*/
			//AHORA MOSTRAMOS LA LISTA ORDENADA
				
			for(int i = 0; i < contador_canciones; i ++) {
				System.out.println(lista_canciones[i].dameDatosGeneralesDeCancion());
			}
				
		}
			
		//METODO PARA MOSTRAR EL PLAYSLIST ORDENADO POR ARTISTA DE CANCION (NUEVO)
		public static void mostrarPlayListOrdenadoPorArtistaCancion(){
			int min = 0;
			int j = 0;
			Cancion aux = new Cancion(" ", 0);
				
			//INICIAMOS EL ORDENAMIENTO POR SELECCION
			for(int i=0; i < contador_canciones; i++) {
				min = i;
				for(j = i + 1; j < contador_canciones; j++) {
					if((lista_canciones[j].dameTitulo().compareToIgnoreCase(lista_canciones[min].dameTitulo())) < 0) {
						min = j;
					}
				}
					
				aux = lista_canciones[i];
				lista_canciones[i] = lista_canciones[min];
				lista_canciones[min] = aux;
			}
			
			//INICIAMOS EL ORDENAMIENTO METODO BURBUJA (OPCIONAL)
			for(int i=1; i<=contador_canciones; i++) {  
		        for(j = 0; j <contador_canciones-i; j++) { 
		            if( lista_canciones[j].dameArtista().compareTo( lista_canciones[j+1].dameArtista() ) > 0 ) { 
		                aux   = lista_canciones[j]; 
		                lista_canciones[j]  = lista_canciones[j+1]; 
		                lista_canciones[j+1]= aux; 
		            }    
		        } 
		    }
				
			//AHORA MOSTRAMOS LA LISTA ORDENADA
				
			for(int i = 0; i < contador_canciones; i ++) {
				System.out.println(lista_canciones[i].dameDatosGeneralesDeCancion());
			}
				
		}

	}


