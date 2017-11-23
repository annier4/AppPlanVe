package appPlanCali;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel {

	// Workbook
	// Sheets[ ]
	// # Sheet
	// Cell (i,j)
	// Rows y Columns
	// Cell.type (Label, number)

	private String ruta_resp = "data/respuestas/respuestasUsu.xls";
	private String ruta_lugar = "data/respuestas/lugares.xls";

	private Workbook wk_respuestas;
	private Workbook wk_lugares;

	private Sheet[] st_resps;
	private Sheet st_resp;
	private Sheet st_lugar;

	private Cell actual_resp;
	private Cell actual_lugar;

	private int sheet_resp = 0;
	private int sheet_lugar = 0;

	private ArrayList<Lugar> lugares;
	private ArrayList<Usuario> usuarios;

	public Excel() {

		lugares = new ArrayList<>();

		try {
			wk_respuestas = Workbook.getWorkbook(new File("./" + ruta_resp));
			wk_lugares = Workbook.getWorkbook(new File("./" + ruta_lugar));

			st_resps = wk_respuestas.getSheets();
			st_resp = st_resps[sheet_resp];

			st_lugar = wk_lugares.getSheets()[sheet_lugar];

			System.out.println("-------{ INICIANDO LECTURA DE BASES DE DATOS }-------");
			System.out.println(".\n.\n.\n");
			System.out.println("\n<---LUGARES--->\n");
			leer_lugares(); 
			System.out.println("-------{ INICIANDO LECTURA DE RESPUESTAS }-------");
			System.out.println("\n<---RESPUESTAS--->\n");
			usuarios = leer_respuestas();

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// constructor

	private void leer_lugares() {

		NumberCell numero;
		LabelCell texto;

		ArrayList<String> info_txt = new ArrayList<>(5);
		ArrayList<Integer> info_num = new ArrayList<>(2);

		for (int j = 1; j < st_lugar.getRows(); j++) {// Lugar
			for (int i = 0; i < st_lugar.getColumns(); i++) {// info
				actual_lugar = st_lugar.getCell(i, j);

				if (actual_lugar.getType() == CellType.LABEL) {
					texto = (LabelCell) actual_lugar;

					String contenido = texto.getString();
					info_txt.add(contenido);
				} else if (actual_lugar.getType() == CellType.NUMBER) {
					numero = (NumberCell) actual_lugar;

					int contenido = (int) numero.getValue();
					info_num.add(contenido);
				}

			} // columnas

			if (!info_txt.isEmpty() && !info_num.isEmpty()) {
				/*System.out.println("<-------------------------- text --------------------->");
				for (int i = 0; i < info_txt.size(); i++) {
					System.out.println(i+": (" +info_txt.get(i) + ")");
				}
				System.out.println("<-------------------------- text --------------------->");
				System.out.println("<-------------------------- num --------------------->");
				for (int i = 0; i < info_num.size(); i++) {
					System.out.println(i+": (" +info_num.get(i) + ")");
				}
				System.out.println("<-------------------------- num --------------------->");*/
				
				
				
				Lugar rs_actual = new Lugar(info_txt.get(0), info_txt.get(1), info_txt.get(2),
						info_txt.get(3), info_num.get(0), info_txt.get(4), info_num.get(1));
				lugares.add(rs_actual);
			}

			info_txt.clear();
			info_num.clear();

		} // filas
	}// leer lugares

	private ArrayList<Usuario> leer_respuestas() {

		ArrayList<Usuario> usu = new ArrayList<>();

		NumberCell numero;
		LabelCell texto;

		ArrayList<String> info_txt = new ArrayList<>();
		ArrayList<Integer> info_num = new ArrayList<>();

		for (int j = 1; j < st_resp.getRows(); j++) {// lugar
			for (int i = 0; i < st_resp.getColumns(); i++) {// info
				actual_resp = st_resp.getCell(i, j);

				if (actual_resp.getType() == CellType.LABEL) {
					texto = (LabelCell) actual_resp;

					String contenido = texto.getString();
					info_txt.add(contenido);
				} else if (actual_resp.getType() == CellType.NUMBER) {
					numero = (NumberCell) actual_resp;

					int contenido = (int) numero.getValue();
					info_num.add(contenido);
				}

			} // columnas
			

			if (!info_txt.isEmpty() && !info_num.isEmpty()) {
				Usuario usuario_actual = new Usuario(info_txt.get(0), info_txt.get(1), info_num.get(0), info_txt.get(3),
						info_txt.get(4), info_txt.get(5), info_txt.get(6), info_txt.get(7), info_txt.get(8), info_txt.get(9), info_txt.get(10), info_txt.get(11), info_txt.get(12), info_txt.get(13), info_txt.get(14), info_txt.get(15));
				usu.add(usuario_actual);
			}

			info_txt.clear();
			info_num.clear();

		} // filas
		return usu;
	}// leer lugar

	public ArrayList<Lugar> getLugar() {
		return lugares;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<Lugar> getLugares() {
		return lugares;
	}

}// excel
