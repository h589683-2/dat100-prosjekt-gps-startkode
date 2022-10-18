package no.hvl.dat100ptc.oppgave5;


import javax.swing.JOptionPane;

import no.hvl.dat100ptc.oppgave3.GPSUtils;
import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 
		
		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		// TODO - START
		
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		
		ystep = MAPYSIZE / (Math.abs(maxlat-minlat));
		
		return ystep;
		

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

	
		int x = 0;
		int y = 0;
		int xp = 0;
		int yp = 0;
		
		double minLon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		double minLat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
			
		for(int i = 0; i < gpspoints.length; i++) {
			
			x = (int) (gpspoints[i].getLongitude() - minLon * xstep());
			
			y = (int) (gpspoints[i].getLatitude() - ybase * ystep()); 
			
			
			if(i == 0) {
				xp = x;
				yp = y;
			}
			setColor(0,255,0);
			
			drawLine(x,y,xp,yp);
			xp = x;
			yp = y;
			fillCircle(xp,yp,3);	
		}
		// TODO - START
		
	
		
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START

		drawString("=========================================",TEXTDISTANCE,20 );
		drawString("Total Time"+"\t\t\t\t\t\t\t"+":"+ GPSUtils.formatTime(gpscomputer.totalTime()),TEXTDISTANCE,30 );
		drawString("Total distance"+"\t\t\t"+":"+"\t\t"+String.format("%.2f", gpscomputer.totalDistance()/1000)+" km",TEXTDISTANCE,40 );
		drawString("Total elevation"+"\t\t"+":"+"\t\t"+String.format("%.2f", gpscomputer.totalElevation())+" m",TEXTDISTANCE,50 );
		drawString("Max speed"+"\t\t\t\t\t\t\t\t"+":"+"\t\t"+String.format("%.2f", gpscomputer.maxSpeed())+" km/t",TEXTDISTANCE,60 );
		drawString("Average speed"+"\t\t\t\t"+":"+"\t\t"+String.format("%.2f", gpscomputer.averageSpeed())+" km/t",TEXTDISTANCE,70 );
		drawString("Energy"+"\t\t\t\t\t\t\t\t\t\t\t"+":"+"\t\t"+String.format("%.2f", gpscomputer.totalKcal(80))+" kcal",TEXTDISTANCE,80 );
		drawString("=========================================",TEXTDISTANCE,90 );
		
		// TODO - SLUTT;
	}

}
