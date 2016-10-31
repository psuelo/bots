package de.rg.bots.shipit;

import java.util.ArrayList;
import java.util.List;

public class PaceMaker implements Runnable {

	private static final long CLOCK_SPEED_IN_MS = 1000L;

	public static class ClockEvent {

	}

	public interface Clockable {
		void clock(ClockEvent clockEvent);
	}

	private List<Clockable> clockListeners = new ArrayList<>();

	public void addClockListener(Clockable clockable) {
		this.clockListeners.add(clockable);
	}

	private void clock() {
		ClockEvent clockEvent = createClockEvent();
		for (Clockable clockable : clockListeners) {
			clockable.clock(clockEvent);
		}
	}

	private ClockEvent createClockEvent() {
		return new ClockEvent();
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(CLOCK_SPEED_IN_MS);
				clock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
