package com.bf.JUC.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer =new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("so easy....");
			}}, new Date(System.currentTimeMillis()+3000), 2000);
	}

}
