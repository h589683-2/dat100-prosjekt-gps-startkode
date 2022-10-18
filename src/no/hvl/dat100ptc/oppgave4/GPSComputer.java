package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import java.lang.Math;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
		

	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {

		throw new UnsupportedOperationException(TODO.method());

	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		
		// TODO - START		// OPPGAVE - START
		
		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO - START
		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

	public double averageSpeed() {

		double average = 0;
		
		// TODO - START
		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
  public double kcal(double weight, int secs, double speed) {

		double kcal = 0.0;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0.0;		
		double speedmph = speed * MS;
<<<<<<< HEAD
=======
		
		//Må ha int for at switch skal funke
//		int sw = (int) (speedmph);
//		
//		if (sw > 0) {
//		switch(sw) {
//		case 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9:
//			met = 4.0;
//			break;
//			
//		case 10 + 11:
//			met = 6.0;
//			break;
//		
//		case 12 + 13:
//			met = 8.0;
//			break;
//		
//		case 14 + 15:
//			met = 10.0;
//			break;
//		
//		case 16 + 17 + 18 + 19:
//			met = 12.0;
//			break;
//			
//		default:
//			met = 16.0;
//			break;
//		}
//		}
//		
//		kcal = met * weight * secs/3600;
//		
//		
//		return kcal;
>>>>>>> branch 'master' of https://github.com/h589683-2/dat100-prosjekt-gps-startkode.git

<<<<<<< HEAD
=======
	
>>>>>>> branch 'master' of https://github.com/h589683-2/dat100-prosjekt-gps-startkode.git
		
		// TODO - START
		
		if (speedmph < 10) {
			met = 4.0;
		} else if (speedmph >= 10 && speedmph < 12) {
			met = 6.0;
		} else if (speedmph >= 12 && speedmph < 14) {
			met = 8.0;
		} else if (speedmph >= 14 && speedmph < 16) {
			met = 10.0;
		} else if (speedmph >= 16 && speedmph < 20) {
			met = 12.0;
		} else if (speedmph >= 20) {
			met = 16.0;
		}
		
		
		kcal = weight * met * (secs/3600.0);
		
		return kcal;

		// TODO - SLUTT
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO - START
		
		
		for (int i = 0; i < gpspoints.length - 1; i++) {
			int secs = (int)GPSUtils.time(gpspoints[i], gpspoints[i+1]);
			double speed = GPSUtils.speed(gpspoints[i], gpspoints[i+1]) / 3.6;
			totalkcal += kcal(weight, secs, speed);
			
		}
		
		return totalkcal;

		// TODO - SLUTT
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("==============================================");

		System.out.println("Total Time\t:\t" + GPSUtils.formatTime(totalTime()));
<<<<<<< HEAD
		System.out.println("Total Distance\t:\t" + totalDistance());
		System.out.println("Total elevation\t:\t" + totalElevation());
		System.out.println("Max speed\t:\t" + maxSpeed());
		System.out.println("Average speed\t:\t" + averageSpeed());
		System.out.println("Energy\t:\t" + totalKcal());
=======
		System.out.println("Total Distance\t:\t  " + totalDistance());
		System.out.println("Total elevation\t:\t  " + totalElevation());
		System.out.println("Max speed\t:\t  " + maxSpeed());
		System.out.println("Average speed\t:\t  " + averageSpeed());
		System.out.println("Energy\t\t:\t  " + totalKcal(WEIGHT));
		System.out.println("==============================================");
>>>>>>> branch 'master' of https://github.com/h589683-2/dat100-prosjekt-gps-startkode.git
		// TODO - START

		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

}
