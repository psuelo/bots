package de.rg.bots.shipit;

import java.util.List;

public class PaceMaker {

	public static class ClockEvent {

	}

	public interface Clockable {
		void clock(ClockEvent clockEvent);
	}

	private List<Clockable> clockListeners;

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
}
