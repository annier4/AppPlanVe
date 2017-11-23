package appPlanCali;

import java.util.ArrayList;

public class Lugar {
	
	private int puntaje;
	
	private String nombre;
	private String categorias;
	private String descripcion;
	private String barrio;
	private String zona;
	private int precio;
	private String horaConcurrencia;
	private int concurrencia;
	
	private String info_txt;
	
	private ArrayList<Object> info;

	public Lugar( String nombre, String categorias, String descripcion, String barrio, int precio, String horaConcurrencia, int concurrencia) {
		this.nombre = nombre;
		this.categorias = categorias;
		this.descripcion = descripcion;
		
		String[] ubicacion = barrio.split(", ");
		
		this.barrio = ubicacion[0];
		this.zona = ubicacion[1];
		this.precio = precio;
		this.horaConcurrencia = horaConcurrencia;
		this.concurrencia = concurrencia;
		puntaje = 0;
		
		info = new ArrayList<>();
		info.add(nombre);
		info.add(categorias);
		info.add(descripcion);
		info.add(barrio);
		info.add(precio);
		info.add(horaConcurrencia);
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getCategorias() {
		return categorias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getBarrio() {
		return barrio;
	}

	public String getZona() {
		return zona;
	}

	public int getPrecio() {
		return precio;
	}

	public String getHoraConcurrencia() {
		return horaConcurrencia;
	}

	public int getConcurrencia() {
		return concurrencia;
	}
	
	public void imprimir_info() {
		System.out.println("\n");
		for (int i = 0; i < info.size(); i++) {
			System.out.println(info.get(i));
		}
	}//
	
	public void sumarPuntaje(int p) {
		puntaje = puntaje + p;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public String getInfo_txt() {
		return info_txt;
	}

	public void setInfo_txt(String info_txt) {
		this.info_txt = info_txt;
	}

	public ArrayList<Object> getInfo() {
		return info;
	}
}
