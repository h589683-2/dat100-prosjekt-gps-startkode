package no.hvl.dat100ptc.oppgave3;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

import java.util.Locale;

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
			
			String hent = String.valueOf(gpspoints[i]);		//henter ut infoen i gpspoint [i] og gjør om til string
			String sub = hent.substring( hent.indexOf('(') + 1, hent.indexOf(','));		//plukker ut infoen som ligger mellom ( og , som er latituden
			lat [i] = Double.parseDouble(sub); //gjør latitude til double og putter i ny tabell
			
		}
		return lat;
		
		
		// TODO - START
		
		
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double [] lon = new double[gpspoints.length];
		
		
		for(int i = 0; i < gpspoints.length; i++) {
			
			//se getLatitudes
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

		double d = 0.0;
		double lat1, lon1, lat2, lon2;
		
//		GPSPoint [] p1 = new GPSPoint[1];
//		p1[0] = gpspoint1;
//		lat1 = getLatitudes(p1)[0];
		lat1 = gpspoint1.getLatitude();
		
//		GPSPoint [] p2 = new GPSPoint[1];
//		p2[0] = gpspoint2;
//		lat2 = getLatitudes(p2)[0];
		lat2 = gpspoint2.getLatitude();
		
//		GPSPoint [] p3 = new GPSPoint[1];
//		p3[0] = gpspoint1;
//		lon1 = getLongitudes(p3)[0];
		lon1 = gpspoint1.getLongitude();
		
//		GPSPoint [] p4 = new GPSPoint[1];
//		p4[0] = gpspoint2;
//		lon2 = getLongitudes(p4)[0];
		lon2 = gpspoint2.getLongitude();
		
		//Følger formelene gitt i oppgaven
		double radLat = toRadians(lat2 - lat1);
		double radLon = toRadians(lon2 - lon1);
		
		double a = pow(sin(radLat/2),2) + cos(toRadians(lat1)) * cos(toRadians(lat2)) * pow(sin(radLon/2),2);
		double c = 2 * atan2(sqrt(a),sqrt(1-a));
		d = R * c;
		
		return d;

		// TODO - START

	

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		//Distanse i meter og tid i sekunder. 
		double b = distance(gpspoint1,gpspoint2)/1000;
		
		//tid fra point 2 - 1 gir tiden mellom
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		//m/s * 3600 = km/t
		speed = (b/secs)*3600;
		
		return speed;
		

		// TODO - START

		

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
	
		int timer = (secs/3600);
		int minutter = ((secs%3600)/60);
		int sekunder = (secs%60);
		
//		String timers = String.format("%02d", timer);
//		String minutters = String.format("%02d", minutter);
//		String sekunders = String.format("%02d", sekunder);
		
//		timestr = String.format("%1$s %4$s  %2$s' '%4$s' '%02d %3$s'",timers,minutters,sekunders,TIMESEP);
		
		//%02d gir at det skal være minst 2 tall og %4$s sier at den skal ta fjerde string (her TIMESEP)
		timestr = String.format("  " + "%02d" + "%4$s" + "%02d" + "%4$s" + "%02d",timer,minutter,sekunder,TIMESEP);
		
		
		
		
//		System.out.println(timestr);
		

		
		return timestr;

		// TODO - START

		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {
		
		String str;
		
		str = String.format(Locale.ROOT, "%10.2f", d);
		
//		System.out.println(str);
		
		return str;
		
		// TODO - START


		// TODO - SLUTT
		
	}
	
	public static double elevation(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		double e;
		
		double ele1 = gpspoint1.getElevation();
		double ele2 = gpspoint2.getElevation();
		e = ele2 - ele1;
		
		return e;
	}
	
	public static double time(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		double t;
		
		double time1 = gpspoint1.getTime();
		double time2 = gpspoint2.getTime();
		t = time2 - time1;
		
		return t;
	}
}
