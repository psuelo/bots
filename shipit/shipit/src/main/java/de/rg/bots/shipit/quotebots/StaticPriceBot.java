package de.rg.bots.shipit.quotebots;

import de.rg.ai.shipit.model.Price;
import de.rg.ai.shipit.model.Quote;
import de.rg.ai.shipit.model.Transport;
import de.rg.bots.shipit.PaceMaker.ClockEvent;
import de.rg.bots.shipit.PaceMaker.Clockable;
import de.rg.bots.shipit.TransportService;

public class StaticPriceBot implements Clockable {

	private final TransportService transportService;

	private final Price priceLimit;

	public StaticPriceBot(Price priceLimit, TransportService transportService) {
		this.priceLimit = priceLimit;
		this.transportService = transportService;
	}

	@Override
	public void clock(ClockEvent clockEvent) {
		Quote quote = transportService.getQuote(new Transport());
		System.out.println(String.format("Got %s", quote));
		if (quote.hasLowerOrEqualPriceThan(priceLimit)) {
			transportService.bookTransport(quote.getKey());
			System.out.println("Jibbi, good price, booked!");
		} else {
			System.out.println(String.format("Damn, not enough money [%s] for that :/", priceLimit));
		}
	}
}
