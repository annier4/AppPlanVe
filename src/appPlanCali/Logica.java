package appPlanCali;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica {
	
	private Excel excel;
	private int pantalla;
	private PImage[] pantallasImg;
	private int index;
	private String name, user, email, pass, adress;
	private Analisis analisis;

	public Logica(PApplet app) {
		// TODO Auto-generated constructor stub
		excel = new Excel();
		analisis = new Analisis(excel.getLugares(), excel.getUsuarios());
		
		
		pantalla = 6;
		pantallasImg = new PImage[16];
		index = 6;
		name = "";
		user = "";
		email = "";
		pass = "";
		adress = "";
		
		for (int i = 0; i < pantallasImg.length; i++) {
			if(i < 9){
				pantallasImg[i] = app.loadImage("../data/p-0"+(i+1)+".png");
			}else{
				pantallasImg[i] = app.loadImage("../data/p-"+(i+1)+".png");
			}
		}
	}

	public void pintar(PApplet app) {
		// TODO Auto-generated method stub
		app.image(pantallasImg[pantalla],0,0, app.width, app.height);
		pintarCamposRegistro( app, index );
		
	}
	
	public void mousePressed(PApplet app, int x, int y) {
		// TODO Auto-generated method stub
		
		switch (pantalla) {
		case 0:
			//Acciones Pagina Landingpage
			
			//Login
			if(x > 28 && x < 197 && y > 562 && y < 608){
				pantalla = 1;
			}
			
			//Registro
			if(x > 207 && x < 381 && y > 562 && y < 608){
				pantalla = 2;
			}
			
			break;
		case 1:
			//Acciones Página Login
			
			//btn Devolverse
			if(x > 0 && x < 97 && y > 0 && y < 85){
				pantalla= 0;
			}
			
			//btn LOGIN - Página de Inicio
			if(x > 77 && x < 321 && y > 515 && y < 578){
				pantalla= 13;
			}
			
			break;
			
		case 2:
			//Acciones Página Registro
			
			//btn Devolverse
			if(x > 0 && x < 97 && y > 0 && y < 85){
				pantalla= 0;
			}
			
			//btn Registro - Página Explicación registro
			if(x > 71 && x < 317 && y > 609 && y < 671){
				pantalla= 3;
			}
			
			camposRegistro(x, y);
			
			break;
		
		case 3:
			//Acciones Página Explicación Registro
			
			//btn Siguiente - Página Preferencias 1
			if(x > 78 && x < 319 && y > 620 && y < 680){
				pantalla= 7;
			}
			
			
			break;
			
		case 4:
			//Acciones Página Bienvenido
			
			//btn Ingresar - Página Inicio
			if(x > 62 && x < 334 && y > 520 && y < 580){
				pantalla= 13;
			}
			
			break;
		
		case 5:
			// Acciones Página Menu
			
			//btn Recomendados -> Página Inicio
			if(x > 0 && x < 325 && y > 209 && y < 269){
				pantalla = 13;
			}
			
			//btn Categorías -> Página Categorías
			if(x > 0 && x < 325 && y > 269 && y < 333){
				pantalla = 14;
			}
			
			//btn Plan Grupal -> Página Plan Grupal
			if(x > 0 && x < 325 && y > 333 && y < 391){
				pantalla = 6;
			}
			
			break;
			
		case 6:
			// Acciones Página Crear Plan Grupal
			
			//Btn Menu -> Página Menu
			if(x > 322 && x < 394 && y > 0 && y < 82){
				pantalla = 5;
			}
			
			break;
			
		case 7:
			//Acciones Página Preferencias 1
			
			if(x > 0 && x < 394 && y > 628 && y < 700){
				escala(x,y);
				pantalla = 9;
			}
			
			break;
			
		case 8:
			//Acciones Página Invitar Amigos
			
			if(x > 77 && x < 322 && y > 563 && y < 627){
				pantalla = 13;
			}
			
			break;
			
		case 9:
			//Acciones Página Preferencias 2
			
			if(x > 0 && x < 394 && y > 628 && y < 700){
				escala(x,y);
				pantalla = 10;
			}
			
			break;
			
		case 10:
			//Acciones Página Preferencias 3
			
			if(x > 0 && x < 394 && y > 628 && y < 700){
				escala(x,y);
				pantalla = 11;
			}
			
			break;
			
		case 11:
			//Acciones Página Preferencias 4
			
			if(x > 0 && x < 394 && y > 628 && y < 700){
				escala(x,y);
				pantalla = 12;
			}
			break;
			
		case 12:
			//Acciones Página Preferencias 5
			
			//Envia a la pagina de Invitar Amigos
			if(x > 0 && x < 394 && y > 628 && y < 700){
				escala(x,y);
				pantalla = 8;
			}
			
			break;
			
		case 13:
			// Acciones Página Inicio
			
			//Btn Menu -> Página Menu
			if(x > 322 && x < 394 && y > 0 && y < 82){
				pantalla = 5;
			}
			
			break;
			
		case 14:
			//Acciones Página Categorías
			
			//Btn Menu -> Página Menu
			if(x > 322 && x < 394 && y > 0 && y < 82){
				pantalla = 5;
			}
			
			break;
			
		case 15:
			break;
		}
	}

	public void camposRegistro(int x, int y) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 5; i++){
			
			//Imprimir cuadros para prueba de zona activa
			//app.fill(255);
			//app.rect(71, i*60+279, 280, 30);
			
			if(x > 71 && x < 350 && y > i*60+280 && y < i*60+310){
				index = i;
				//System.out.println(index);
			}else{
				//index = 6;
			}
		}
		
	}
	
	public void pintarCamposRegistro(PApplet app, int index ) {
		// TODO Auto-generated method stub
		//System.out.println(index);
			
			//Imprimir texto
		/*for (int i = 0; i < 5; i++) {
			app.fill(255);
			app.rect(71, i*60+279, 280, 30);
			app.fill(0);
		}*/
		
		if(pantalla == 2){
				
				if(index==0 || name != ""){
					app.text(name,71,0*60+300);
			      }else{
			    	  app.text("Nombre Completo",71,0*60+300);
			      }

				
				if(index==1 || user != ""){
					app.text(user,71,1*60+300);
			      }else{
			    	  app.text("Usuario",71, 1*60+300);
			      }
				
				
				if(index==2 || email != ""){
					app.text(email,71,2*60+300);
			      }else{
			    	  app.text("Correo Electrónico",71, 2*60+300);
			      }
				
				
				if(index==3 || pass != ""){
					app.text(pass,71,3*60+300);
			      }else{
			    	  app.text("Contraseña",71, 3*60+300);
			      }
				
				
				if(index==4 || adress != ""){
					app.text(adress,71,4*60+300);
			      }else{
			    	  app.text("Barrio donde Reside",71, 4*60+300);
			      }
		}
		
	}

	public void escala(int x, int y) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			if(x > i*75 && x < i*75+75 && y > 628 && y < 698){
				if(i==0) System.out.println("love");
				if(i==1) System.out.println("like");
				if(i==2) System.out.println("ok");
				if(i==3) System.out.println("no me gusta");
				if(i==4) System.out.println("lo odio");
			}
		}
	}

	public void keyPressed(PApplet app) {
		// TODO Auto-generated method stub
		if(index != 6 && pantalla == 2){
		    	
		    switch (index) {
				case 0:
					
					if (app.keyCode == PConstants.BACKSPACE) {
						if (name.length() > 0) {
					       name = name.substring(0,name.length()-1);
					     }
				    }else{
				      name += app.key;
				    }
					
					break;

		    case 1:
		    	
		    	if (app.keyCode == PConstants.BACKSPACE) {
					if (user.length() > 0) {
						user = user.substring(0,user.length()-1);
				     }
			    }else{
			    	user += app.key;
			    }
				
				break;
			
			case 2:
				
				if (app.keyCode == PConstants.BACKSPACE) {
					if (email.length() > 0) {
						email = email.substring(0,email.length()-1);
				     }
			    }else{
			    	email += app.key;
			    }
				
				break;
			
			case 3:
				
				if (app.keyCode == PConstants.BACKSPACE) {
					if (pass.length() > 0) {
						pass = pass.substring(0,pass.length()-1);
				     }
			    }else{
			    	pass += app.key;
			    }
				
				break;
			
			case 4:
				
				if (app.keyCode == PConstants.BACKSPACE) {
					if (adress.length() > 0) {
						adress = adress.substring(0,adress.length()-1);
				     }
			    }else{
			    	adress += app.key;
			    }
				
				break;
		    }  
		}
	}
}
