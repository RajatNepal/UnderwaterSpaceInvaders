package project;

import edu.princeton.cs.introcs.StdDraw;

public class Treasure {
	private double[]x;
	private double[]y;

	private int num;
	private double size = .1;



	public Treasure(int n) {

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
			StdDraw.picture(x[i], y[i], "images/chest.png", size, size);

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
