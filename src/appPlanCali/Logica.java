package appPlanCali;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica {

	private Excel excel;
	private int pantalla, mX, mY;;
	private PImage[] pantallasImg;
	private PImage iniS, iniS2, reg, reg2, quit, results;
	private PImage back, entrar, noacount, ask, back1;
	private PImage regback, photo, finish;
	private PImage instrucciones, next, volver, startnow, iconmenu, iconmenun, cpscreen, cpscreen2;
	private PImage crearplan, crearplans, topic, topics, topten, toptens, perfil, perfils;
	private PImage opmenup, opmenut, opmenuc, opmenucp, opmenucc, opmenua, opmenucs, opmenups, opmenuts, opmenucsel,
			opmenucpsel, opmenuccs, opmenuas, opmenucssel;
	private PImage likes, likessel, friends, friendsselect, planes, planesselect, btn_nature, btn_natures, btn_deporte,btn_deportes, btn_cultura, btn_culturas, btn_hobbie, btn_hobbies;
	private int index;
	private String name, user, email, pass, adress;
	private Analisis analisis;
	private Analisis analisisGrupal;
	private Carita caritas;
	private ArrayList<Usuario> usuarios;

	private ArrayList<Usuario> selUsu;

	private Object sel;

	public Logica(PApplet app) {
		// TODO Auto-generated constructor stub
		excel = new Excel();
		// analisis = new Analisis(excel.getLugares(), excel.getUsuarios());
		usuarios = excel.getUsuarios();

		pantalla = 24;
		pantallasImg = new PImage[26];

		index = 6;
		name = "";
		user = "";
		email = "";
		pass = "";
		adress = "";
		selUsu = new ArrayList<Usuario>();

		// CARGAR BOTONES

		iniS = app.loadImage("../data/Recursos_Pantallas/Iniciar_sesion.png");
		iniS2 = app.loadImage("../data/Recursos_Pantallas/iniciar_sesion2.png");
		reg = app.loadImage("../data/Recursos_Pantallas/Registrate.png");
		reg2 = app.loadImage("../data/Recursos_Pantallas/Registrate2.png");
		quit = app.loadImage("../data/Recursos_Pantallas/quit.png");
		results = app.loadImage("../data/Recursos_Pantallas/results.png");

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

		// pantalla 4 test

		volver = app.loadImage("../data/Recursos_Pantallas/volver.png");

		// pantalla 16

		startnow = app.loadImage("../data/Recursos_Pantallas/startnow.png");
		iconmenu = app.loadImage("../data/Recursos_Pantallas/Icon_menu.png");
		iconmenun = app.loadImage("../data/Recursos_Pantallas/iconmenun.png");

		// pantalla 17 inicio

		crearplan = app.loadImage("../data/Recursos_Pantallas/crearplan.png");
		crearplans = app.loadImage("../data/Recursos_Pantallas/crearplans.png");
		topic = app.loadImage("../data/Recursos_Pantallas/topic.png");
		topics = app.loadImage("../data/Recursos_Pantallas/topics.png");
		topten = app.loadImage("../data/Recursos_Pantallas/topten.png");
		toptens = app.loadImage("../data/Recursos_Pantallas/toptens.png");
		perfil = app.loadImage("../data/Recursos_Pantallas/perfil.png");
		perfils = app.loadImage("../data/Recursos_Pantallas/perfils.png");

		// pantalla 17 inicio

		opmenup = app.loadImage("../data/Recursos_Pantallas/opmenup.png");
		opmenucp = app.loadImage("../data/Recursos_Pantallas/opmenucp.png");
		opmenuc = app.loadImage("../data/Recursos_Pantallas/opmenuc.png");
		opmenucc = app.loadImage("../data/Recursos_Pantallas/opmenucc.png");
		opmenut = app.loadImage("../data/Recursos_Pantallas/opmenut.png");
		opmenua = app.loadImage("../data/Recursos_Pantallas/opmenua.png");
		opmenucs = app.loadImage("../data/Recursos_Pantallas/opmenucs.png");

		opmenups = app.loadImage("../data/Recursos_Pantallas/opmenups.png");
		opmenuts = app.loadImage("../data/Recursos_Pantallas/opmenuts.png");
		opmenucsel = app.loadImage("../data/Recursos_Pantallas/opmenucsel.png");
		opmenucpsel = app.loadImage("../data/Recursos_Pantallas/opmenucpsel.png");
		opmenuccs = app.loadImage("../data/Recursos_Pantallas/opmenuccs.png");
		opmenuas = app.loadImage("../data/Recursos_Pantallas/opmenuas.png");
		opmenucssel = app.loadImage("../data/Recursos_Pantallas/opmenucssel.png");

		// pantalla 19 crear plan

		cpscreen = app.loadImage("../data/Recursos_Pantallas/cp_screen.jpg");
		cpscreen2 = app.loadImage("../data/Recursos_Pantallas/cp_screen2.jpg");

		// PANTALLA 23 PERFIL BOTONES

		likes = app.loadImage("../data/Recursos_Pantallas/likes.png");
		likessel = app.loadImage("../data/Recursos_Pantallas/likessel.png");
		friends = app.loadImage("../data/Recursos_Pantallas/friends.png");
		friendsselect = app.loadImage("../data/Recursos_Pantallas/friendsselect.png");
		planes = app.loadImage("../data/Recursos_Pantallas/planes.png");
		planesselect = app.loadImage("../data/Recursos_Pantallas/planesselect.png");
		
		// PANTALLA 24 PERFIL BOTONES
		
		btn_nature = app.loadImage("../data/Recursos_Pantallas/btn_nature.png");
		btn_natures = app.loadImage("../data/Recursos_Pantallas/btn_natures.png");
		btn_cultura = app.loadImage("../data/Recursos_Pantallas/btn_culture.png");
		btn_culturas = app.loadImage("../data/Recursos_Pantallas/btn_cultures.png");
		btn_hobbie =  app.loadImage("../data/Recursos_Pantallas/btn_hobbie.png");
		btn_hobbies =  app.loadImage("../data/Recursos_Pantallas/btn_hobbies.png");
		btn_deporte =  app.loadImage("../data/Recursos_Pantallas/btn_deporte.png");
		btn_deportes =  app.loadImage("../data/Recursos_Pantallas/btn_deportes.png");

		// -----------------------------------------------------------------

		for (int i = 0; i < pantallasImg.length; i++) {
			if (i < 9) {
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
		listarUsuarios(app);

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

		} else if (pantalla > 3 && pantalla < 16) {

			// BOTON PARA DEVOLVERSE
			if (app.mouseX >= 45 && app.mouseX <= 394 && app.mouseY >= 20 && app.mouseY <= 60) {
				app.image(back1, 45, 20);
			} else {
				app.image(volver, 45, 20);
			}

		} else if (pantalla == 16) {

			if (app.mouseX >= 60 && app.mouseX <= 341 && app.mouseY >= 550 && app.mouseY <= 632) {
				app.image(startnow, 60, 549, 283, 85);
			} else {
				app.image(startnow, 60, 550);
			}

		} else if (pantalla == 17) {

			// BUTTON MENU DESPLEGABLE
			if (app.mouseX >= 340 && app.mouseX <= 380 && app.mouseY >= 23 && app.mouseY <= 60) {
				app.image(iconmenu, 330, 19, 62, 46);
			} else {
				app.image(iconmenu, 330, 20, 59, 43);
			}

			// BOTONES PRINCIPALES
			if (app.mouseX > 0 && app.mouseX < 200 && app.mouseY > 310 && app.mouseY < 510) {
				app.image(crearplans, 0, 310);
			} else {
				app.image(crearplan, 0, 310);
			}

			if (app.mouseX > 0 && app.mouseX < 200 && app.mouseY > 505 && app.mouseY < 705) {
				app.image(topics, 0, 505);
			} else {
				app.image(topic, 0, 505);
			}
			if (app.mouseX > 198 && app.mouseX < 400 && app.mouseY > 310 && app.mouseY < 510) {
				app.image(toptens, 198, 310);
			} else {
				app.image(topten, 198, 310);
			}

			if (app.mouseX > 198 && app.mouseX <= 400 && app.mouseY > 505 && app.mouseY < 705) {
				app.image(perfils, 198, 505);
			} else {
				app.image(perfil, 198, 505);
			}

		} else if (pantalla == 18) {

			// BUTTON MENU DESPLEGABLE
			if (app.mouseX > 340 && app.mouseX < 380 && app.mouseY > 23 && app.mouseY < 60) {
				app.image(iconmenun, 330, 19, 62, 46);
			} else {
				app.image(iconmenun, 330, 20, 59, 43);
			}

			if (app.mouseX > 0 && app.mouseX < 323 && app.mouseY > 140 && app.mouseY < 200) {
				app.image(opmenups, -3, 140);
			} else {
				app.image(opmenup, -3, 140);
			}
			if (app.mouseX > 0 && app.mouseX < 323 && app.mouseY > 200 && app.mouseY < 260) {
				app.image(opmenuts, -3, 200);
			} else {
				app.image(opmenut, -3, 200);
			}
			if (app.mouseX > 0 && app.mouseX < 323 && app.mouseY > 260 && app.mouseY < 320) {
				app.image(opmenucsel, -3, 260);
			} else {
				app.image(opmenuc, -3, 260);
			}
			if (app.mouseX > 0 && app.mouseX < 323 && app.mouseY > 320 && app.mouseY < 380) {
				app.image(opmenucpsel, -3, 320);
			} else {
				app.image(opmenucp, -3, 320);
			}
			if (app.mouseX > 0 && app.mouseX < 323 && app.mouseY > 380 && app.mouseY < 440) {
				app.image(opmenuccs, -3, 380);
			} else {
				app.image(opmenucc, -3, 380);
			}
			if (app.mouseX > 0 && app.mouseX < 323 && app.mouseY > 440 && app.mouseY < 500) {
				app.image(opmenuas, -3, 440);
			} else {
				app.image(opmenua, -3, 440);
			}
			if (app.mouseX > 0 && app.mouseX < 323 && app.mouseY > 620 && app.mouseY < 680) {
				app.image(opmenucssel, -3, 620);
			} else {
				app.image(opmenucs, -3, 620);
			}
		} else if (pantalla == 19) {

			/// CREAR PLAN
			app.image(cpscreen, 0, 0);

			app.image(cpscreen2, 0, 600);
			if (app.mouseX > 82 && app.mouseX < 638 && app.mouseY > 623 && app.mouseY < 685) {
				app.image(results, 75, 619, 260, 70);
			} else {
				app.image(results, 75, 620, 257, 67);
			}

			// BUTTON MENU DESPLEGABLE
			if (app.mouseX >= 340 && app.mouseX <= 380 && app.mouseY >= 23 && app.mouseY <= 60) {
				app.image(iconmenu, 330, 19, 62, 46);
			} else {
				app.image(iconmenu, 330, 20, 59, 43);
			}

		} else if (pantalla == 20) {

			// BUTTON MENU DESPLEGABLE
			if (app.mouseX >= 340 && app.mouseX <= 380 && app.mouseY >= 23 && app.mouseY <= 60) {
				app.image(iconmenu, 330, 19, 62, 46);
			} else {
				app.image(iconmenu, 330, 20, 59, 43);
			}
		} else if (pantalla == 21) {

			// BUTTON MENU DESPLEGABLE
			if (app.mouseX >= 340 && app.mouseX <= 380 && app.mouseY >= 23 && app.mouseY <= 60) {
				app.image(iconmenu, 330, 19, 62, 46);
			} else {
				app.image(iconmenu, 330, 20, 59, 43);
			}
		} else if (pantalla == 23) {
			// BUTTON MENU DESPLEGABLE
			if (app.mouseX > 340 && app.mouseX < 380 && app.mouseY > 23 && app.mouseY < 60) {
				app.image(iconmenu, 330, 19, 62, 46);
			} else {
				app.image(iconmenu, 330, 20, 59, 43);
			}

			if (app.mouseX > 38 && app.mouseX < 128 && app.mouseY > 302 && app.mouseY < 392) {
				app.image(friendsselect, 35, 300);
			} else {
				app.image(friends, 35, 300);
			}

			if (app.mouseX > 150 && app.mouseX < 241 && app.mouseY > 302 && app.mouseY < 392) {
				app.image(likessel, 150, 300);
			} else {
				app.image(likes, 150, 300);
			}

			if (app.mouseX > 266 && app.mouseX < 356 && app.mouseY > 302 && app.mouseY < 392) {

				app.image(planesselect, 265, 300);
			} else {
				app.image(planes, 265, 300);
			}
		} else if (pantalla == 24) {



			// BUTTON MENU DESPLEGABLE
			if (app.mouseX > 340 && app.mouseX < 380 && app.mouseY > 23 && app.mouseY < 60) {
				app.image(iconmenu, 330, 19, 62, 46);
			} else {
				app.image(iconmenu, 330, 20, 59, 43);
			}
			
			if(app.mouseX > 0 && app.mouseX<196 && app.mouseY >93 && app.mouseY <398 ){
				app.image(btn_natures, 0, 93);
			}else {
				app.image(btn_nature, 0, 93);
			}
			
			if(app.mouseX > 196 && app.mouseX<800 && app.mouseY >93 && app.mouseY <398){
			app.image(btn_deportes, 197, 93);
			}else {
				app.image(btn_deporte, 197, 93);	
			}
			
			
			if(app.mouseX > 0 && app.mouseX<196 && app.mouseY >398 && app.mouseY <700 ){
			app.image(btn_culturas, 0, 400);
			}else {
				app.image(btn_cultura, 0, 400);
			}
			
			if(app.mouseX > 196 && app.mouseX<800 && app.mouseY >398 && app.mouseY <700 ){
			app.image(btn_hobbies, 197, 400);
			}else {
				app.image(btn_hobbie, 197, 400);
			}

		
		
			

		} if (pantalla == 25) {}

	}

	public void mousePressed(PApplet app, int x, int y) {
		// TODO Auto-generated method stub

		System.out.println(pantalla);

		mX = x;
		mY = y; // Detectar coordenada inicial del mouse

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
			// INSTRUCCIONES
			// Volver a iniciar sesion
			if (x > 45 && x < 394 && y >= 20 && y <= 60) {
				pantalla = 1;

			}

			if (x > 60 && x < 331 && y > 600 && y < 674) {
				pantalla = 4;
			}

			break;

		case 4:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 3;
			} else {
				pantalla = 5;
			}

			break;

		case 5:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 4;
			} else {
				pantalla = 6;
			}

			break;

		case 6:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 5;
			} else {
				pantalla = 7;
			}

			break;

		case 7:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 6;
			} else {
				pantalla = 8;
			}

			break;

		case 8:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 7;
			} else {
				pantalla = 9;
			}
			break;

		case 9:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 8;
			} else {
				pantalla = 10;
			}

			break;

		case 10:

			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 9;
			} else {
				pantalla = 11;
			}

			break;

		case 11:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 10;
			} else {
				pantalla = 12;
			}

			break;

		case 12:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 11;
			} else {
				pantalla = 13;
			}

			break;

		case 13:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 12;
			} else {
				pantalla = 14;
			}

			break;

		case 14:
			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 13;
			} else {
				pantalla = 15;
			}

			break;

		case 15:

			// Devolverse
			if (x >= 45 && x <= 394 && y >= 20 && y <= 60) {
				pantalla = 14;
			} else {
				pantalla = 16;
			}

			break;

		case 16:

			pantalla = 17;
			break;

		case 17:

			// MENU

			if (x > 0 && x < 200 && y > 310 && y < 510) {
				// ARMAR PLAN
				pantalla = 19;
			} else if (x >= 320 && x <= 380 && y >= 20 && y <= 63) {
				pantalla = 18;

			} else if (x > 198 && x <= 400 && y > 505 && y < 705) {
				// IR A PERFIL
				pantalla = 23;
				// PERFIL
			} else if (x > 0 && x < 200 && y > 505 && y < 705) {

				pantalla = 24; // CATEGORIAS

			} else if (x > 198 && x < 400 && y > 310 && y < 510) {
				pantalla = 21; // top recomendados

			}

			break;

		case 18:

			if (x > 340 && x < 380 && y > 23 && y < 60) {
				pantalla = 17;

				// perfil
			} else if (x > 0 && x < 323 && y > 140 && y < 200) {
				pantalla = 23;
			} else if (x > 0 && x < 323 && y > 200 && y < 260) {
				pantalla = 21;
			} else if (x > 0 && x < 323 && y > 260 && y < 320) {
				pantalla = 24;

			} else if (x > 0 && x < 323 && y > 320 && y < 380) {
				pantalla = 19;
			}

			break;

		case 19:
			// ARMAR PLAN
			// btn Analisis Plan Grupal
			if (x > 82 && x < 638 && y > 623 && y < 685) {
				if (selUsu.size() != 0) {
					analisisGrupal = new Analisis(excel.getLugares(), selUsu);
					pantalla = 20;
				}
			}

			if (x > 340 && x < 380 && y > 23 && y < 60) {
				pantalla = 18;
			}

			break;
		case 20:

			// RESULTADOS

			if (x > 340 && x < 380 && y > 23 && y < 60) {
				pantalla = 18;
			}

			break;

		case 21:
			if (x >= 320 && x <= 380 && y >= 20 && y <= 63) {
				pantalla = 18;

			}

			break;

		case 23: // perfil
			if (x >= 320 && x <= 380 && y >= 20 && y <= 63) {
				pantalla = 18;
			}

			// BOTONES ADICIONALES

			break;

		case 24:
			// boton menu
			if (x >= 320 && x <= 380 && y >= 20 && y <= 63) {
				pantalla = 18;
			}
			break;
			
			
		case 25:
			
			break;
			

		}
	}

	private void listarUsuarios(PApplet app) {
		if (pantalla == 19) {
			for (int i = 0; i < usuarios.size(); i++) {
				usuarios.get(i).pintar(app, i, 0, 450);
			}
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

	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub

		// Usuario que selecciona
		if (pantalla == 19) {
			for (int i = 0; i < usuarios.size(); i++) {
				if (usuarios.get(i).validar(x, y)) {
					if (usuarios.get(i).getSelect() == 1) {
						selUsu.add(usuarios.get(i));
					} else {
						for (int j = 0; j < selUsu.size(); j++) {
							if (usuarios.get(i).getEmail() == selUsu.get(j).getEmail()) {
								selUsu.remove(j);
							}
						}
					}
				}
			}
		}
	}

	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub

		if (pantalla == 19) {
			for (int i = 0; i < usuarios.size(); i++) {
				if (mY < y) {
					usuarios.get(i).moverLista(-5);
				} else if (mY > y) {
					usuarios.get(i).moverLista(+5);
				}
			}
			mX = x;
			mY = y;
		}
	}
}
