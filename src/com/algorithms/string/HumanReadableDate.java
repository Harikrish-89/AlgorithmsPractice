package com.algorithms.string;

public class HumanReadableDate {
	public static void main(String[] args) {
		int seconds =  359999;
		int sec = seconds%60;
		int mins =  ((seconds) % 3600)/60;
		int	hours = (seconds / 3600)%24;
		int days = (seconds / (3600 * 24) );
	    String hoursString = hours <=9 ? "0" +hours : String.valueOf(hours);
	    String minsString = mins <=9 ? "0"+ mins : String.valueOf(mins);
	    String secString = sec <=9 ? "0" + sec : String.valueOf(sec);
	    String daysString = days <= 9 ? "0" + days : String.valueOf(days);
		String humanReadable =   daysString + ":" + hoursString+":" + minsString +":"+secString;
				
		System.out.println(humanReadable);
		
	}
}
