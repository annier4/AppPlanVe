package appPlanCali;

import java.util.ArrayList;

public class Analisis {
	
	private ArrayList<Lugar> lugares;
	private ArrayList<Usuario> usuarios;
	private Conteo contador;

	public Analisis(ArrayList<Lugar> lugares, ArrayList<Usuario> usuarios) {
		this.lugares = (ArrayList<Lugar>) lugares.clone();
		this.usuarios = (ArrayList<Usuario>) usuarios.clone();
		
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
			
			if(ubicacion.contains(lugares.get(i).getBarrio())){
				lugares.get(i).sumarPuntaje(1);
			}
			
			for (int j = 0; j < parts.length; j++) {
				
				if(parts[j].contains("animales")){
					lugares.get(i).sumarPuntaje(categorias[0]);
				}
				
				if(parts[j].contains("naturaleza")){
					lugares.get(i).sumarPuntaje(categorias[1]);
				}
				
				if(parts[j].contains("historia")){
					lugares.get(i).sumarPuntaje(categorias[2]);
				}
				
				if(parts[j].contains("evento cultural")){
					lugares.get(i).sumarPuntaje(categorias[3]);
				}
				
				if(parts[j].contains("deporte")){
					lugares.get(i).sumarPuntaje(categorias[4]);
				}
				
				if(parts[j].contains("ver deporte")){
					lugares.get(i).sumarPuntaje(categorias[5]);
				}
				
				if(parts[j].contains("cine")){
					lugares.get(i).sumarPuntaje(categorias[6]);
				}
				
				if(parts[j].contains("restaurante") || parts[j].contains("evento cocina")){
					if(categorias[7] > 2 && parts[j].contains("restaurante")){
						lugares.get(i).sumarPuntaje(categorias[7]);
					}else{
						lugares.get(i).sumarPuntaje(categorias[7]);
					}
				}
				
				if(parts[j].contains("bar")){
					lugares.get(i).sumarPuntaje(categorias[8]);
				}
				
				if(parts[j].contains("musica")){
					lugares.get(i).sumarPuntaje(categorias[9]);
				}
				
				if(parts[j].contains("cantar")){
					lugares.get(i).sumarPuntaje(categorias[10]);
				}
				
				if(categorias[11] > 1){
					lugares.get(i).sumarPuntaje(categorias[11]);
				}else if(lugares.get(i).getConcurrencia() < 150 && categorias[11] == 1){
					lugares.get(i).sumarPuntaje(categorias[11]);
				}else if(lugares.get(i).getConcurrencia() < 100 && categorias[11] == 0){
					lugares.get(i).sumarPuntaje(1);
				}
			}
			
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
