package appPlanCali;

import java.util.ArrayList;

public class Analisis {
	
	private ArrayList<Lugar> lugares;
	private ArrayList<Usuario> usuarios;
	private int presupuesto;
	private Conteo contador;

	public Analisis(ArrayList<Lugar> lugares, ArrayList<Usuario> usuarios, int presupuesto) {
		this.lugares = (ArrayList<Lugar>) lugares.clone();
		this.usuarios = (ArrayList<Usuario>) usuarios.clone();
		this.presupuesto = presupuesto;
		contador = new Conteo();
		
		System.out.println("\n\n\n\n\n\n");
		System.out.println("<<<<<< calificar >>>>>>");
		calificar();
		
		ArrayList<Lugar> result = ordener_x_puntaje(lugares);
		ganadores(result);
	}
	
	private void calificar(){
		for (int i = 0; i < usuarios.size(); i++) {
			Usuario actual = usuarios.get(i);
			sumar_puntaje_lugar(actual.getBarrio(), actual.getCategoriasUsu());
		}
	}
	
	private ArrayList<Lugar> ordener_x_puntaje(ArrayList<Lugar> desordenado) {
		System.out.println("\n\n\n\n");
		System.out.println(" <-------------- SORT -------------->");

		ArrayList<Lugar> result = new ArrayList<Lugar>();
		result.addAll(desordenado);
		result.sort(new ComparadorLugares());
		imprimir_resultados(result);
		return result;
	}// ordenar por puntaje
	
	private void sumar_puntaje_lugar(String ubicacion, int[] categorias){
		
		for (int i = 0; i < lugares.size(); i++) {
			String[] parts = lugares.get(i).getCategorias().split(", ");
			
			
			System.out.println("NOMBRE LUGAR: "+ lugares.get(i).getNombre()+ "-----------------------------");
			
			System.out.println("UBICACION USUARIO: "+ ubicacion);
			
			if(presupuesto >= lugares.get(i).getPrecio()){
				lugares.get(i).sumarPuntaje(2);
				System.out.println("PRESUPUESTO: "+presupuesto);
				System.out.println("PRECIO: "+lugares.get(i).getPrecio());
				System.out.println("precio" + 2);
			}else{
				lugares.get(i).sumarPuntaje(-5);
				System.out.println("PRESUPUESTO: "+presupuesto);
				System.out.println("PRECIO: "+lugares.get(i).getPrecio());
				System.out.println("precio" + -5);
			}
			
			
			System.out.println("ZONA: "+lugares.get(i).getZona());
			
			
			if(ubicacion.contains(lugares.get(i).getBarrio())){
				lugares.get(i).sumarPuntaje(5);
				System.out.println("barrio" + 5);
			}else if(ubicacion.contains(lugares.get(i).getZona()) || ubicacion.contains("Centro")){
				lugares.get(i).sumarPuntaje(2);
				System.out.println("zona" + 2);
			}
			
			System.out.println("<---------------- puntaje categorias ------------->");
			
			for (int j = 0; j < parts.length; j++) {
				
				if(parts[j].contains("animales")){
					if(categorias[0] != 0){
						lugares.get(i).sumarPuntaje(categorias[0]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					System.out.println("animales" + categorias[0]);
				}
				
				if(parts[j].contains("naturaleza")){
					if(categorias[1] != 0){
						lugares.get(i).sumarPuntaje(categorias[1]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					
					System.out.println("naturaleza" + categorias[1]);
				}
				
				if(parts[j].contains("historia")){
					if(categorias[2] != 0){
						lugares.get(i).sumarPuntaje(categorias[2]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					System.out.println("historia" + categorias[2]);
				}
				
				if(parts[j].contains("evento cultural")){
					if(categorias[3] != 0){
						lugares.get(i).sumarPuntaje(categorias[3]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					System.out.println("evento cultural" + categorias[3]);
				}
				
				if(parts[j].contains("deporte")){
					if(categorias[4] != 0){
						lugares.get(i).sumarPuntaje(categorias[4]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					System.out.println("deporte" + categorias[4]);
				}
				
				if(parts[j].contains("ver deport")){
					if(categorias[5] != 0){
						lugares.get(i).sumarPuntaje(categorias[5]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					System.out.println("ver deport" + categorias[5]);
				}
				
				if(parts[j].contains("cine")){
					if(categorias[6] != 0){
						lugares.get(i).sumarPuntaje(categorias[6]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					System.out.println("cine" + categorias[6]);
				}
				
				if(parts[j].contains("restaurante") || parts[j].contains("evento cocina")){
					if(categorias[7] > 2 && parts[j].contains("restaurante")){
						lugares.get(i).sumarPuntaje(categorias[7]);
						System.out.println("restaurante o evento cocina" + categorias[7]);
					}else{
						lugares.get(i).sumarPuntaje(categorias[7]);
					}
				}
				
				if(parts[j].contains("bar")){
					if(categorias[8] != 0){
						lugares.get(i).sumarPuntaje(categorias[8]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					System.out.println("bar" + categorias[8]);
				}
				
				if(parts[j].contains("musica")){
					if(categorias[9] != 0){
						lugares.get(i).sumarPuntaje(categorias[9]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					System.out.println("musica" + categorias[9]);
				}
				
				if(parts[j].contains("cantar")){
					if(categorias[10] != 0){
						lugares.get(i).sumarPuntaje(categorias[10]);
					}else{
						lugares.get(i).sumarPuntaje(-5);
					}
					System.out.println("musica" + categorias[10]);
				}
				
				if(categorias[11] > 1 && lugares.get(i).getConcurrencia() < 200){
					lugares.get(i).sumarPuntaje(categorias[11]);
					System.out.println("concurrencia MAYOR A 1 = " + categorias[11]);
				}
				
			}
			
			System.out.println("<---------------- fin puntaje categorias ------------->");
			
		}
		
	}
	
	private void ganadores(ArrayList<Lugar> result) {
		System.out.println("\n\n\n\n");
		System.out.println(" <---- GANADORES: LUGARES IDEALES ---->");
		System.out.println("\n");
		System.out.println(result.size());
		for (int i = 0; i < 3; i++) {
			System.out.println("\nGANADOR " + (1 + i) + " ...Puntaje... = " + result.get(i).getPuntaje());
			result.get(i).imprimir_info();
		}

		System.out.println("\n------------------------------");
		System.out.println("------------------------------");
		System.out.println("------------------------------");

		System.out.println("\n\n\n\n");
		System.out.println(" <----  OTROS LUGARES ACEPTABLES---->");
		for (int i = 3; i < result.size(); i++) {
			System.out.println("\nGANADOR " + (1 + i) + " ...Puntaje... = " + result.get(i).getPuntaje());
			result.get(i).imprimir_info();
		}

		contador.imprimir_puntos();
	}
	
	private void imprimir_resultados(ArrayList<Lugar> result) {
		System.out.println(" <-------------- result -------------->");
		for (int i = 0; i < result.size(); i++) {
			System.out.println(
					"Lugar: " + result.get(i).getNombre() + " ...Puntaje... = " + result.get(i).getPuntaje());
		}
	}

	public ArrayList<Lugar> getLugares() {
		return lugares;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

}
