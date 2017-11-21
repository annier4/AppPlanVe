package appPlanCali;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica {

	private Excel excel;
	private int pantalla;
	private PImage[] pantallasImg;
	private PImage iniS, iniS2, reg, reg2, quit;
	private PImage back, entrar, noacount, ask, back1;
	private PImage regback, photo, finish;
	private PImage instrucciones, next;

	private int index;
	private String name, user, email, pass, adress;
	private Analisis analisis;

	public Logica(PApplet app) {
		// TODO Auto-generated constructor stub
		excel = new Excel();
		analisis = new Analisis(excel.getLugares(), excel.getUsuarios());

		pantalla = 3;
		pantallasImg = new PImage[4];
		index = 6;
		name = "";
		user = "";
		email = "";
		pass = "";
		adress = "";

		// CARGAR BOTONES

		iniS = app.loadImage("../data/Recursos_Pantallas/Iniciar_sesion.png");
		iniS2 = app.loadImage("../data/Recursos_Pantallas/iniciar_sesion2.png");
		reg = app.loadImage("../data/Recursos_Pantallas/Registrate.png");
		reg2 = app.loadImage("../data/Recursos_Pantallas/Registrate2.png");
		quit = app.loadImage("../data/Recursos_Pantallas/quit.png");

		// pantalla 1 Iniciar Sesion

		back = app.loadImage("../data/Recursos_Pantallas/back.png");
		back1 = app.loadImage("../data/Recursos_Pantallas/back1.png");
		entrar = app.loadImage("../data/Recursos_Pantallas/Entrar.png");
		noacount = app.loadImage("../data/Recursos_Pantallas/noacount.png");
		ask = app.loadImage("../data/Recursos_Pantallas/ask.png");

		// pantalla 2 Registrate

		regback = app.loadImage("../data/Recursos_Pantallas/regback.png");
		photo = app.loadImage("../data/Recursos_Pantallas/photo.png");
		finish = app.loadImage("../data/Recursos_Pantallas/finish.png");

		// pantalla 3 Instrucciones

		next = app.loadImage("../data/Recursos_Pantallas/next.png");
		instrucciones = app.loadImage("../data/Recursos_Pantallas/instrucciones.png");

		// -----------------------------------------------------------------

		for (int i = 0; i < pantallasImg.length; i++) {
			if (i < 5) {
				pantallasImg[i] = app.loadImage("../data/p-0" + (i + 1) + ".jpg");
			} else {
				pantallasImg[i] = app.loadImage("../data/p-" + (i + 1) + ".jpg");
			}
		}
	}

	public void pintar(PApplet app) {
		// TODO Auto-generated method stub
		app.image(pantallasImg[pantalla], 0, 0, app.width, app.height);
		pintarCamposRegistro(app, index);

		if (pantalla == 0) {
			if (app.mouseX >= 10 && app.mouseX <= 190 && app.mouseY >= 580 && app.mouseY <= 630) {
				app.image(iniS2, 10, 580);

			} else {
				app.image(iniS, 10, 580);
			}

			if (app.mouseX >= 200 && app.mouseX <= 600 && app.mouseY >= 580 && app.mouseY <= 630) {
				app.image(reg2, 200, 580);
			} else {
				app.image(reg, 200, 580);

			}

			app.image(quit, 50, 650);

		} else if (pantalla == 1) {

			if (app.mouseX >= 45 && app.mouseX <= 394 && app.mouseY >= 20 && app.mouseY <= 60) {
				app.image(back1, 45, 20);
			} else {
				app.image(back, 45, 20);
			}
			// BOTON CUANDO NO TIENE CUENTA Y LE DA CLICK EN REGISTRARSE
			app.image(noacount, 70, 650);

			// BOTON PARA ENTRAR
			if (app.mouseX >= 70 && app.mouseX <= 332 && app.mouseY >= 500 && app.mouseY <= 573) {
				app.image(entrar, 69, 498, 265, 78);
			} else {
				app.image(entrar, 70, 500, 262, 73);
			}

			app.image(ask, 330, 435);

		} else if (pantalla == 2) {

			// BOTON PARA DEVOLVERSE
			if (app.mouseX >= 45 && app.mouseX <= 394 && app.mouseY >= 20 && app.mouseY <= 60) {
				app.image(back1, 45, 20);
			} else {
				app.image(regback, 45, 20);
			}

			/// BOTON PARA SUBIR FOTO
			if (app.mouseX >= 110 && app.mouseX <= 270 && app.mouseY >= 90 && app.mouseY <= 237) {
				app.image(photo, 109, 84, 165, 165);
			} else {
				app.image(photo, 110, 85, 162, 162);
			}

			// BOTON PARA FINALIZAR REGISTRO

			if (app.mouseX >= 60 && app.mouseX <= 331 && app.mouseY >= 600 && app.mouseY <= 674) {
				app.image(finish, 59, 599, 273, 77);
			} else {
				app.image(finish, 60, 600);
			}

		} else if (pantalla == 3) {

			// BOTON PARA DEVOLVERSE
			if (app.mouseX >= 45 && app.mouseX <= 394 && app.mouseY >= 20 && app.mouseY <= 60) {
				app.image(back1, 45, 20);
			} else {
				app.image(instrucciones, 45, 20);
			}

			// BOTON PARA EMPEZAR EL TEST
			if (app.mouseX >= 60 && app.mouseX <= 331 && app.mouseY >= 600 && app.mouseY <= 674) {
				app.image(next, 60, 609, 273, 78);
			} else {
				app.image(next, 60, 610, 270, 75);
			}

		}

	}

	public void mousePressed(PApplet app, int x, int y) {
		// TODO Auto-generated method stub

		switch (pantalla) {
		case 0:
			// Acciones Pagina Landingpage

			// Login
			if (x > 10 && x < 190 && y > 580 && y < 630) {
				pantalla = 1;
			}

			// Registro
			if (x > 200 && x < 600 && y > 580 && y < 630) {
				pantalla = 2;
			}

			break;
		case 1:
			// Acciones Página Login

			// btn Devolverse

			if (x > 45 && x < 394 && y > 20 && y < 60) {
				pantalla = 0;
			}

			// btn LOGIN - Página de Inicio
			if (x > 70 && x < 332 && y > 500 && y < 573) {
				pantalla = 3;
			}

			break;

		case 2:
			// Acciones Página Registro

			// btn Devolverse
			if (x > 45 && x < 394 && y > 20 && y < 60) {
				pantalla = 0;
			}

			// btn Registro - Página Explicación registro
			if (x > 71 && x < 317 && y > 609 && y < 671) {
				pantalla = 3;
			}

			camposRegistro(x, y);

			break;

		case 3:
			// Volver a iniciar sesion
			if (x > 45 && x < 394 && y >= 20 && y <= 60) {
			pantalla = 1;
			
			
			}
			
			if (x > 60 && x < 331 && y > 600 && y < 674) {
				pantalla = 4;
			}

			break;

		case 4:
			// Acciones Página Bienvenido

			
			// btn Ingresar - Página Inicio
			if (x > 62 && x < 334 && y > 520 && y < 580) {
				pantalla = 13;
			}

			break;

		case 5:
			// Acciones Página Menu

			// btn Recomendados -> Página Inicio
			if (x > 0 && x < 325 && y > 209 && y < 269) {
				pantalla = 13;
			}

			// btn Categorías -> Página Categorías
			if (x > 0 && x < 325 && y > 269 && y < 333) {
				pantalla = 14;
			}

			// btn Plan Grupal -> Página Plan Grupal
			if (x > 0 && x < 325 && y > 333 && y < 391) {
				pantalla = 6;
			}

			break;

		case 6:
			// Acciones Página Crear Plan Grupal

			// Btn Menu -> Página Menu
			if (x > 322 && x < 394 && y > 0 && y < 82) {
				pantalla = 5;
			}

			break;

		case 7:
			// Acciones Página Preferencias 1

			if (x > 0 && x < 394 && y > 628 && y < 700) {
				escala(x, y);
				pantalla = 9;
			}

			break;

		case 8:
			// Acciones Página Invitar Amigos

			if (x > 77 && x < 322 && y > 563 && y < 627) {
				pantalla = 13;
			}

			break;

		case 9:
			// Acciones Página Preferencias 2

			if (x > 0 && x < 394 && y > 628 && y < 700) {
				escala(x, y);
				pantalla = 10;
			}

			break;

		case 10:
			// Acciones Página Preferencias 3

			if (x > 0 && x < 394 && y > 628 && y < 700) {
				escala(x, y);
				pantalla = 11;
			}

			break;

		case 11:
			// Acciones Página Preferencias 4

			if (x > 0 && x < 394 && y > 628 && y < 700) {
				escala(x, y);
				pantalla = 12;
			}
			break;

		case 12:
			// Acciones Página Preferencias 5

			// Envia a la pagina de Invitar Amigos
			if (x > 0 && x < 394 && y > 628 && y < 700) {
				escala(x, y);
				pantalla = 8;
			}

			break;

		case 13:
			// Acciones Página Inicio

			// Btn Menu -> Página Menu
			if (x > 322 && x < 394 && y > 0 && y < 82) {
				pantalla = 5;
			}

			break;

		case 14:
			// Acciones Página Categorías

			// Btn Menu -> Página Menu
			if (x > 322 && x < 394 && y > 0 && y < 82) {
				pantalla = 5;
			}

			break;

		case 15:
			break;
		}
	}

	public void camposRegistro(int x, int y) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 5; i++) {

			// Imprimir cuadros para prueba de zona activa
			// app.fill(255);
			// app.rect(71, i*60+279, 280, 30);

			if (x > 71 && x < 350 && y > i * 60 + 280 && y < i * 60 + 310) {
				index = i;
				// System.out.println(index);
			} else {
				// index = 6;
			}
		}

	}

	public void pintarCamposRegistro(PApplet app, int index) {
		// TODO Auto-generated method stub
		// System.out.println(index);

		// Imprimir texto
		/*
		 * for (int i = 0; i < 5; i++) { app.fill(255); app.rect(71, i*60+279,
		 * 280, 30); app.fill(0); }
		 */

		if (pantalla == 2) {

			if (index == 0 || name != "") {
				app.text(name, 71, 0 * 60 + 300);
			} else {
				app.text("Nombre Completo", 71, 0 * 60 + 300);
			}

			if (index == 1 || user != "") {
				app.text(user, 71, 1 * 60 + 300);
			} else {
				app.text("Usuario", 71, 1 * 60 + 300);
			}

			if (index == 2 || email != "") {
				app.text(email, 71, 2 * 60 + 300);
			} else {
				app.text("Correo Electrónico", 71, 2 * 60 + 300);
			}

			if (index == 3 || pass != "") {
				app.text(pass, 71, 3 * 60 + 300);
			} else {
				app.text("Contraseña", 71, 3 * 60 + 300);
			}

			if (index == 4 || adress != "") {
				app.text(adress, 71, 4 * 60 + 300);
			} else {
				app.text("Barrio donde Reside", 71, 4 * 60 + 300);
			}
		}

	}

	public void escala(int x, int y) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			if (x > i * 75 && x < i * 75 + 75 && y > 628 && y < 698) {
				if (i == 0)
					System.out.println("love");
				if (i == 1)
					System.out.println("like");
				if (i == 2)
					System.out.println("ok");
				if (i == 3)
					System.out.println("no me gusta");
				if (i == 4)
					System.out.println("lo odio");
			}
		}
	}

	public void keyPressed(PApplet app) {
		// TODO Auto-generated method stub
		if (index != 6 && pantalla == 2) {

			switch (index) {
			case 0:

				if (app.keyCode == PConstants.BACKSPACE) {
					if (name.length() > 0) {
						name = name.substring(0, name.length() - 1);
					}
				} else {
					name += app.key;
				}

				break;

			case 1:

				if (app.keyCode == PConstants.BACKSPACE) {
					if (user.length() > 0) {
						user = user.substring(0, user.length() - 1);
					}
				} else {
					user += app.key;
				}

				break;

			case 2:

				if (app.keyCode == PConstants.BACKSPACE) {
					if (email.length() > 0) {
						email = email.substring(0, email.length() - 1);
					}
				} else {
					email += app.key;
				}

				break;

			case 3:

				if (app.keyCode == PConstants.BACKSPACE) {
					if (pass.length() > 0) {
						pass = pass.substring(0, pass.length() - 1);
					}
				} else {
					pass += app.key;
				}

				break;

			case 4:

				if (app.keyCode == PConstants.BACKSPACE) {
					if (adress.length() > 0) {
						adress = adress.substring(0, adress.length() - 1);
					}
				} else {
					adress += app.key;
				}

				break;
			}
		}
	}
}
