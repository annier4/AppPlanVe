package appPlanCali;
import java.util.ArrayList;

public class Usuario {

	private String email;
	private String nombre;
	private int edad;
	String barrio;
	
	private int[] categoriasUsu;

	public Usuario(String email, String nombre, int edad, String barrio, String likeAnimales, String likeNaturaleza, String likeHistoria, String likeCultural, String likeDeporte, String likeVerDeporte, String likeCine, String likeCocinar, String likeBeber, String likeMusica, String likeCantar, String likeMultitud) {
		this.email = email;
		this.nombre = nombre;
		this.edad = edad;
		this.barrio = barrio;
		categoriasUsu = new int[12];
		String[] categorias = new String[12];
		
		categorias[0] = likeAnimales;
		categorias[1] = likeNaturaleza;
		categorias[2] = likeHistoria;
		categorias[3] = likeCultural;
		categorias[4] = likeDeporte;
		categorias[5] = likeVerDeporte;
		categorias[6] = likeCine;
		categorias[7] = likeCocinar;
		categorias[8] = likeBeber;
		categorias[9] = likeMusica;
		categorias[10] = likeCantar;
		categorias[11] = likeMultitud;
		
		for (int i = 0; i < categorias.length; i++) {
			if(categorias[i].contains("Me encanta")){ categoriasUsu[i] = 4;}
			if(categorias[i].contains("Me gusta")){ categoriasUsu[i] = 3;}
			if(categorias[i].contains("Me da igual")){ categoriasUsu[i] = 2;}
			if(categorias[i].contains("No me gusta")){ categoriasUsu[i] = 1;}
			if(categorias[i].contains("No me gusta para nada")){ categoriasUsu[i] = 0;}
		}
	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getBarrio() {
		return barrio;
	}

	public int[] getCategoriasUsu() {
		return categoriasUsu;
	}
}
