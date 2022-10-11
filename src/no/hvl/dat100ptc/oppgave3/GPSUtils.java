package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double [] lat = new double[gpspoints.length];
		
		
		for(int i = 0; i < gpspoints.length; i++) {
			
			String hent = String.valueOf(gpspoints[i]);
			String sub = hent.substring( hent.indexOf('(') + 1, hent.indexOf(','));
			lat [i] = Double.parseDouble(sub);
			
		}
		return lat;
		
		
		// TODO - START
		
		
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double [] lon = new double[gpspoints.length];
		
		
		for(int i = 0; i < gpspoints.length; i++) {
			
			String hent = String.valueOf(gpspoints[i]);
			String sub = hent.substring( hent.indexOf(',') + 1, hent.indexOf(')'));
			lon[i] = Double.parseDouble(sub);
			
		}
		return lon;
		
		// TODO - START

		
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
}
