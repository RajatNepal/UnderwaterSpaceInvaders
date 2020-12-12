package project;
import java.awt.Color;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;


public class Bubbles {

	private double[]x;
	private double[]y;
	private Color[]color;
	private int numBubbles;
	private double radius = .04;
	private double[]speed;


	public Bubbles(int n) {

		double[] xs = new double[n];
		double[] ys = new double[n];
		Color[] colors = new Color[n];
		double[]speeds = new double[n];

		for(int i = 0; i <n; i++) {
			xs[i] = Math.random();
			ys[i] = .005;
			colors[i] = ColorUtils.transparent(ColorUtils.randomColor(),.3);
			speeds[i] = (Math.random() + .5)/90;
		}
		
		this.numBubbles = n;
		this.x = xs;
		this.y = ys;
		this.color = colors;
		this.speed = speeds;
	}

	public void draw() {
		for(int i = 0; i<this.numBubbles; ++i) {
			StdDraw.setPenColor(color[i]);
			StdDraw.filledCircle(x[i], y[i], radius);
		}
	}

	public void move() {
		for(int i = 0; i<this.numBubbles; ++i) {
			double random = Math.random();
			if(random>.4) {
				
			}
			else if (random >.2){
				this.x[i] += (y[i])/50;
				
			}
			else {
				this.x[i] -= (y[i])/50;
			}
			
			if(this.y[i]>1) {
				this.y[i] = .005;
			}
			else {
				this.y[i] += speed[i];
			}
			
		}

	}

}
