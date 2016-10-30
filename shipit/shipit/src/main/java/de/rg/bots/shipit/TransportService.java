package de.rg.bots.shipit;

import java.util.UUID;

import de.rg.bots.shipit.model.Quote;
import de.rg.bots.shipit.model.Quote.Key;
import de.rg.bots.shipit.model.Transport;

public class TransportService {

	public Quote getQuote() {
		return new Quote(new Key(UUID.randomUUID().toString()), new Transport());
	}

	public void bookTransport(Key quoteKey) {

	}
}
