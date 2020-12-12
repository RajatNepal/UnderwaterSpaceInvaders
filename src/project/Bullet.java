package project;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Bullet {
	private double[]x;
	private double[]y;

	private int num;
	private double size = .01;
	private double speed = .01;



	public Bullet() {

		double[] xs = new double[0];
		double[] ys = new double[0];

		this.num = 0;
		this.x = xs;
		this.y = ys;


	}

	public void draw() {
		for(int i = 0; i<this.num; ++i) {
			StdDraw.setPenColor(ColorUtils.transparent(Color.RED, 1));
			StdDraw.filledCircle(x[i], y[i], size);;

		}
	}
	
	public void addBullet(double xcoord, double ycoord) {
		double[]newX = new double[this.x.length +1];
		double[]newY = new double[this.y.length +1];
		for(int i = 0; i <this.x.length; ++i) {
			newX[i] = this.x[i];
			newY[i] = this.y[i];
		}
		newX[this.x.length] = xcoord;
		newY[this.y.length] = ycoord;
		this.setX(newX);
		this.setY(newY);
		this.num= newX.length;
	}
	
	public void move() {
		for(int i = 0; i<this.num; ++i) {
			y[i] += speed;
			if(y[i] >1) {
				y[i] = 200;
			}

		}
	}

	public double[] getX() {
		return x;
	}

	public void setX(double[] x) {
		this.x = x;
	}

	public double[] getY() {
		return y;
	}

	public void setY(double[] y) {
		this.y = y;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}
}
