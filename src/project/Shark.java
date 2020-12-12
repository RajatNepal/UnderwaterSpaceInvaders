package project;

import edu.princeton.cs.introcs.StdDraw;

public class Shark {
	private double[]x;
	private double[]y;

	private int num;
	private double size = .1;
	private double[]speed;



	public Shark(int n) {

		double[] xs = new double[n];
		double[] ys = new double[n];
		double[]speeds = new double[n];


		for(int i = 0; i <n; i++) {
			xs[i] = Math.random();
			ys[i] = .5*Math.random() + .3;
			speeds[i] = (Math.random() + .5)/150;


		}

		this.num = n;
		this.x = xs;
		this.y = ys;
		this.speed = speeds;


	}
	
	public void move() {
		for(int i = 0; i <num; i ++) {
		if(this.x[i]>1) {
			this.x[i] = .005;
		}
		else {
			this.x[i] += speed[i];
		}}
	}

	public void draw() {
		for(int i = 0; i<this.num; ++i) {
			StdDraw.picture(x[i], y[i], "images/shark.png", size, size);

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
