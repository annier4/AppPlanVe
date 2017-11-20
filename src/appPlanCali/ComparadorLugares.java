package appPlanCali;

import java.util.Comparator;

public class ComparadorLugares implements Comparator<Lugar> {

	public ComparadorLugares() {
		// TODO Auto-generated constructor stub
	}
	
	public int compare(Lugar o1, Lugar o2) {
		int valor = 0;
		int diferencia = (o1.getPuntaje() - o2.getPuntaje());
		
		if(diferencia< 0){
			valor = 1;
		}else if(diferencia > 0){
			valor = -1;
		} else if (diferencia == 0){
			valor = 0;
		}
		return valor;
	}

}
