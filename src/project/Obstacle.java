package project;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Obstacle {
	
	private double[]x;
	private double[]y;
	private double size = .1;
	
	private int num;
	
	
	
	public Obstacle(int n) {

		double[] xs = new double[n];
		double[] ys = new double[n];
		
		

		for(int i = 0; i <n; i++) {
			xs[i] = Math.random();
			ys[i] = .7*Math.random() + .3;
			
			
		}
		
		this.num = n;
		this.x = xs;
		this.y = ys;
		
		
	}
	
	public void draw() {
		for(int i = 0; i<this.num; ++i) {
			StdDraw.picture(x[i], y[i], "images/obstacle.png", size, size);
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

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
