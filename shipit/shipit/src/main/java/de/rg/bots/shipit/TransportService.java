package de.rg.bots.shipit;

import de.rg.ai.shipit.BookingService;
import de.rg.ai.shipit.IBookingListener;
import de.rg.ai.shipit.IQuotationGenerator;
import de.rg.ai.shipit.model.Quote;
import de.rg.ai.shipit.model.Quote.Key;
import de.rg.ai.shipit.model.Transport;
import de.rg.ai.shipit.quotation.SimpleAdaptiveQuoteGenerator;

public class TransportService {

	private final IQuotationGenerator quotationGenerator;

	private final BookingService bookingService;

	public TransportService() {
		quotationGenerator = new SimpleAdaptiveQuoteGenerator();
		bookingService = new BookingService();
		bookingService.addBookingListener((IBookingListener) quotationGenerator);
	}

	public Quote getQuote(Transport transport) {
		return quotationGenerator.getQuote(transport);
	}

	public void bookTransport(Key quoteKey) {
		bookingService.book(quoteKey);
	}
}
