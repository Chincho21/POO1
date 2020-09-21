package ar.edu.uno.poo1.tp1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class PlayListTest {
	
	PlayList objeto; //SE DECLARA EL objetoETO GLOBAL
	
	@Before
	public void beforeEjemplo() { // LA OPCION BEFORE PERMITE QUE SIEMPRE SE INICIALICE ESTE METODO ANTES DE ENTRAR EN EN CADA UNO DE LOS METODOS @TEST
		PlayList objeto = new PlayList(); //SE INICIALIZA EL objetoETO Y CON ESTO LOGRAMOS COMPARTIR UN UNICO objetoETO CON TODAS LOS METODOS A TRABAJAR
	}
	
	@After
	public void afterEjemplo() {
		
	}
	
	@Test 
	public void testNumeroAleatorio() {
		int resultado = objeto.dameNumeroAleatorio();
		
	}
	
	@Test
	public void testAsignarMaximoPermitido() {
		
		objeto.asignarMaximoPermitidoDeCanciones(10);
	}
	
	@Test
	//METODO 1 PARA AGREGAR CANCION AL PLAYLIST (NUEVO)
	//METODO 2 PARA AGREGAR CANCION AL PLAYLIST (NUEVO)
	public void testAgregarCancionAlPlaylist(){
		objeto.agregarCancionAlPlaylist("Titulo 1", 5);
		objeto.agregarCancionAlPlaylist("Titulo 2", "Album 2", "Artista 2", 10);
	}
	
	@Test
	//METODO 1 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO DURACION (NUEVO)
	public void testBuscarCancionPorDuracion() {
			
		int resultado = objeto.buscarCancionPorDuracion(5);
		
	}
	@Test
	//METODO 1 PARA QUITAR UNA CANCION DEL PLAYLIST INGRESANDO LA DURACION (NUEVO)
	//METODO 2 PARA QUITAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO (NUEVO)
	public void testQuitarCancionDelPlaylist() {
		
		objeto.quitarCancionDelPlaylist(5);
		objeto.quitarCancionDelPlaylist("Titulo");
	}
	@Test
	//METODO 1 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO (NUEVO)
	//METODO 2 PARA BUSCAR UNA CANCION EN EL PLAYLIST INGRESANDO TITULO E INDICANDO EL INICIO DE LA POSICION DE BUSQUEDA (NUEVO)
	public void testBuscarCancionPorTitulo() {
		int resultado1 = objeto.buscarCancionPorTitulo("Titulo 1");
		int resultado2 = objeto.buscarCancionPorTitulo("Titulo 1", 5);
	}

	@Test	
	//METODO PARA CONSULTAR LA DURACION DE UNA CANCION INGRESANDO TITULO (NUEVO)
	public void testConsultarDuracionCancion() {
		objeto.consultarDuracionCancion("Titulo");
			
	}
	@Test
	//METODO PARA OBTENER LA DURACION COMPLETA DEL PLAYLIST (NUEVO)
	public void testDameDuracionCompletaPlayList() {
		int resultado = objeto.dameDuracionCompletaPlayList();
	}
	@Test
	//METODO PARA OBTENER LA CANTIDAD DE CANCIONES INGRESADAS AL PLAYLIST (NUEVO)
	public void testDameCantidadDeCancionesPlayList() {
		int resultado = objeto.dameCantidadDeCancionesPlayList();
	}
	@Test
	//METODO PARA OBTENER LA CANCION CON MAYOR DURACION DEL PLAYLIST (NUEVO)
	public void testDameCancionMayorDuracionPlayList() {
		
		int resultado = objeto.dameCancionMayorDuracionPlayList();
	}
	@Test
	//METODO PARA OBTENER LA CANCION CON MENOR DURACION DEL PLAYLIST (NUEVO)
	public void testDameCancionMenorDuracionPlayList() {
		int resultado = objeto.dameCancionMenorDuracionPlayList();
		
	}
	@Test
	//METODO PARA MOSTRAR EL PLAYSLIST ORDENADO POR TITULO DE CANCION (NUEVO)
	public void mostrarPlayListOrdenadoPorTituloCancion(){
		objeto.mostrarPlayListOrdenadoPorTituloCancion();	
	}
	
	@Test	
	//METODO PARA MOSTRAR EL PLAYSLIST ORDENADO POR ARTISTA DE CANCION (NUEVO)
	public void testMostrarPlayListOrdenadoPorArtistaCancion(){

		objeto.mostrarPlayListOrdenadoPorArtistaCancion();
			
	}

}

	