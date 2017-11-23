package appPlanCali;
import processing.core.PApplet;

public class Usuario {

	private String email;
	private String nombre;
	private int edad;
	String barrio;
	
	private int[] categoriasUsu;
	private int h;
	private int r,g,b;
	private int posY, move;
	private int iniY, finY;
	private int select;

	public Usuario(String email, String nombre, int edad, String barrio, String likeAnimales, String likeNaturaleza, String likeHistoria, String likeCultural, String likeDeporte, String likeVerDeporte, String likeCine, String likeCocinar, String likeBeber, String likeMusica, String likeCantar, String likeMultitud) {
		this.email = email;
		this.nombre = nombre;
		this.edad = edad;
		this.barrio = barrio;
		categoriasUsu = new int[12];
		String[] categorias = new String[12];
		
		System.out.println(nombre);
		
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
		
		h = 40;
		move = 0;
		r = 255; g = 255; b = 255;
		select = 0;
	}
	
	public void pintar(PApplet app, int i, int y, int yF){
		posY = i*h + y + move;
		iniY = y;
		finY = yF;
		app.fill(r,g,b);
		app.rect(0, posY, app.width, h);
		app.fill(0);
		app.text(nombre, 20, posY+25);
	}
	
	public boolean validar(int x, int y){
		
		if(y > iniY && y < finY){
			if(y > posY && y < posY+h){
				if(b != 255){
					r = 255; g = 255; b = 255;
					select = 0;
				}else{
					r = 255; g = 58; b = 202;
					select = 1;
				}
				return true;
			}
		}
		
		return false;
	}
	
	public void moverLista(int y){
		move += y;
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

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getIniY() {
		return iniY;
	}

	public void setIniY(int iniY) {
		this.iniY = iniY;
	}

	public int getFinY() {
		return finY;
	}

	public void setFinY(int finY) {
		this.finY = finY;
	}
}
