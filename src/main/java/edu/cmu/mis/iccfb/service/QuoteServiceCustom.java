package edu.cmu.mis.iccfb.service;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.model.Quote;

public interface QuoteServiceCustom {
    public Quote randomQuote();
    public Quote[] listQuote(String id);
	public Quote[] getall();

}
