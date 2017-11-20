package appPlanCali;
import processing.core.PApplet;
import processing.core.PImage;

public class Carita {
	private PImage[] images;

	public Carita(PApplet app) {
		// TODO Auto-generated constructor stub
		images = new PImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = app.loadImage("../data/c-"+i+".png");
		}
	}

}
