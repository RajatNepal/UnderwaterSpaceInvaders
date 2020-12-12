package project;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;


public class Main {
	public static void main(String[] args) {

		StdDraw.enableDoubleBuffering();

		double px = 0.5;  // x location of the demo point
		double py = 0.05;  // y location of the demo point
		double speed = .005;
		//
		// This song will play in the background allowing your other work
		//   to proceed. 
		// If annoyed, comment this out
		// If you want more, change playOnce() to playAlways()
		//
		BackgroundSong sbsp = new BackgroundSong("SpongeBobSquarePants.wav");
		//sbsp.playOnce();
		Bubbles b = new Bubbles(20);
		int seconds = 0;
		int points = 0;
		boolean mobile = true;
		int freezeCounter = 0;
		Obstacle o = new Obstacle(6);
		Treasure t = new Treasure(3);
		Shark s = new Shark(3);
		Bullet bs = new Bullet();
		boolean play = true;
		boolean canShoot = true;
		int shootTimer = 0;
		boolean win = false;
		while (play && !win) {
			StdDraw.clear();

			StdDraw.picture(0.5, 0.5, "images/underwater.jpg", 1.2, 1.2);

			if(mobile) {
				freezeCounter = 0;
			}
			else {
				freezeCounter ++;

				if(freezeCounter >100) {
					mobile = true;
					freezeCounter = 0;
				}
			}
			if(canShoot) {
				shootTimer = 0;
			}
			else {
				shootTimer ++;

				if(shootTimer >10) {
					canShoot = true;
					shootTimer = 0;
				}
			}

			if (checkFor(KeyEvent.VK_W) && canShoot && mobile) {
				bs.addBullet(px, py);
				canShoot = false;
			}

			//collision with obstacle
			for(int i = 0; i < o.getNum(); ++i) {
				if(px > o.getX()[i] - o.getSize()/1.35 && px < o.getX()[i]+ o.getSize()/1.35 &&
						py > o.getY()[i] - o.getSize()/1.35 && py < o.getY()[i]+ o.getSize()/1.35) {
					double[]xs = o.getX();
					xs[i] = 100;
					points -= 30;
					StdDraw.setPenColor(ColorUtils.transparent(Color.RED, 1));

					o.setX(xs);
					mobile = false;

				}
			}

			//bullet collision with shark
			for(int i = 0; i <bs.getX().length; ++i) {
				for(int j = 0; j <s.getNum(); ++j) {
					if(bs.getX()[i] > s.getX()[j] - s.getSize()/1.5 && bs.getX()[i] < s.getX()[j]+ s.getSize()/1.5 &&
							bs.getY()[i] > s.getY()[j] - s.getSize()/1.5 && bs.getY()[i] < s.getY()[j]+ s.getSize()/1.5) {
						double[]sharkY = s.getY();
						double[]bulletY = bs.getY();
						sharkY[j] = -100;
						s.setY(sharkY);
						bulletY[i] = 200;
						bs.setY(bulletY);
						points +=50;

					}
				}
			}


			//collision with shark
			for(int i = 0; i < s.getNum(); ++i) {
				if(px > s.getX()[i] - s.getSize()/1.5 && px < s.getX()[i]+ s.getSize()/1.5 &&
						py > s.getY()[i] - s.getSize()/1.5 && py < s.getY()[i]+ s.getSize()/1.5) {
					play = false;

				}
			}

			//collision with chest
			for(int i = 0; i < t.getNum(); ++i) {
				if(px > t.getX()[i] - t.getSize()/1.35 && px < t.getX()[i]+ t.getSize()/1.35 &&
						py > t.getY()[i] - t.getSize()/1.35 && py < t.getY()[i]+ t.getSize()/1.35) {


					double[]xs = t.getX();
					xs[i] = 100;
					points += 10;		
					t.setX(xs);

				}
			}
			//
			// Should we move?
			//
			if(mobile) {
				if (checkFor(KeyEvent.VK_A)) {
					px = px - speed;
				}
				if (checkFor(KeyEvent.VK_D)) {
					px = px + speed;
				}

				py = py + speed/3;
			}
			o.draw();
			t.draw();


			s.draw();
			s.move();

			b.draw();
			b.move();

			bs.draw();
			bs.move();

			//
			// The pirate
			//
			StdDraw.setPenColor(Color.BLACK);
			//StdDraw.filledCircle(px, py, .03);
			StdDraw.picture(px, py, "images/ship.png", .065, .065);

			//top rectangle stuff
			StdDraw.setPenColor(ColorUtils.transparent(Color.BLUE, .75));
			StdDraw.filledRectangle(.5, .9, .47, .07);
			StdDraw.setPenColor(ColorUtils.transparent(Color.white, 1));
			StdDraw.text(.5, .93, "Time elapsed: " + seconds/30 + " Seconds");
			StdDraw.text(.5, .87, "Score: " + points + " Points");

			if(!mobile) {
				StdDraw.setPenColor(ColorUtils.transparent(Color.RED, 1));
				StdDraw.text(.5, .5, "You are Frozen!!! (-30 points)");
			}

			if(py >1) {
				win = true;
			}


			StdDraw.show();  
			seconds ++;
			StdDraw.pause(10);   // 1/100 of a second
		}
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(.5, .5, 1, 1);
		if(win) {
			StdDraw.setPenColor(ColorUtils.transparent(Color.RED, 1));
			StdDraw.text(.5, .5, "You Won with " + points + " points!!");
		}
		else {
			StdDraw.setPenColor(ColorUtils.transparent(Color.RED, 1));
			StdDraw.text(.5, .5, "You Lost cus you hit a shark!!");
		}
		StdDraw.show();

	}

	/**
	 * Check to see if a given key is pressed at the moment.  This method does not
	 *   wait for a key to be pressed, so if nothing is pressed, it returns
	 *   false right away.
	 *   
	 * The event constants are found at:
	 *   https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
	 * @param key the integer code of the key
	 * @return true if that key is down, false otherwise
	 */
	private static boolean checkFor(int key) {
		if (StdDraw.isKeyPressed(key)) {
			return true;
		}
		else {
			return false;
		}
	}

}
