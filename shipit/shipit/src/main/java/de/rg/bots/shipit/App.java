package de.rg.bots.shipit;

import de.rg.ai.shipit.model.Price;
import de.rg.bots.shipit.quotebots.StaticPriceBot;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		PaceMaker paceMaker = new PaceMaker();
		TransportService transportService = new TransportService();
		paceMaker.addClockListener(new StaticPriceBot(new Price(120d), transportService));
		paceMaker.addClockListener(new StaticPriceBot(new Price(90d), transportService));
		paceMaker.addClockListener(new StaticPriceBot(new Price(80d), transportService));
		new Thread(paceMaker).run();
	}
}
