package appPlanCali;
import processing.core.PApplet;

public class Main extends PApplet {
	
	static PApplet app;
	Logica log;
	
	public static void main(String[] args) {
		PApplet.main("appPlanCali.Main");
		System.out.println("Ejecutando");
	}
	
	public void settings() {
		size(394,700);
	}
	
	public void setup() {
		app = this;
		log = new Logica(app);
	}
	
	public void draw() {
		background(255);
		log.pintar(app);
	}
	
	public void mousePressed() {
		System.out.println(mouseX+" "+mouseY);
		log.mousePressed(app, mouseX, mouseY);
	}
	
	@Override
	public void mouseClicked() {
		log.mouseClicked(mouseX, mouseY);
	}
	
	@Override
	public void mouseDragged(){
		log.mouseDragged(mouseX, mouseY);
	}
	
	public void keyPressed(){
		log.keyPressed(app);
	}
}
