package no.hvl.dat100ptc.oppgave5;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import javax.swing.JOptionPane;

public class ShowProfile extends EasyGraphics {

	private static final int MARGIN = 50;  // margin on the sides 
	
	private static int MAXBARHEIGHT = 500; // assume no height above 500 meters
	
	private GPSPoint[] gpspoints;

	public ShowProfile() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		GPSComputer gpscomputer =  new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length; // number of data points

		makeWindow("Height profile", 2 * MARGIN + 3 * N, 2 * MARGIN + MAXBARHEIGHT);

		// top margin + height of drawing area
		showHeightProfile(MARGIN + MAXBARHEIGHT); 
	}

	public void showHeightProfile(int ybase) {

		// ybase indicates the position on the y-axis where the columns should start
		// 	drawLine(int startX, int startY, int endX, int endY)
		//  Tegner en rett linje med aktiv farge.
		int x = MARGIN,y = ybase;

		// TODO - START
		int x2 = MARGIN ;

		for (int i = 0; i < gpspoints.length -1; i++) {
			int y2 = (int)gpspoints[i].getElevation();
			if (y2  < 0) {
				y2 = y;
			}
			drawLine(x, y, x2, ybase - y2);
			setColor(0, 0, 225);
			
			x += 2;
			x2 += 2;
			//System.out.println("x1: " + x + ", y1: " + y + ", x2 :" + x2 + ", y2: " + y2);
		}
	
		// TODO - SLUTT
	}

}
