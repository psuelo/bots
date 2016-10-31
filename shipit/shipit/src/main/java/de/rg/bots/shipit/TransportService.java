package de.rg.bots.shipit;

import de.rg.ai.shipit.BookingService;
import de.rg.ai.shipit.IQuotationGenerator;
import de.rg.ai.shipit.model.Quote;
import de.rg.ai.shipit.model.Transport;
import de.rg.ai.shipit.quotation.SimpleAdaptiveQuoteGenerator;
import de.rg.ai.shipit.model.Quote.Key;

public class TransportService {

	private final IQuotationGenerator quotationGenerator = new SimpleAdaptiveQuoteGenerator();

	private final BookingService bookingService = new BookingService();
	
	public Quote getQuote(Transport transport) {
		return quotationGenerator.getQuote(transport);
	}

	public void bookTransport(Key quoteKey) {
		bookingService.book(quoteKey);
	}
}
