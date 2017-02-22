package edu.cmu.mis.iccfb.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.model.Quote;


public class QuoteServiceImpl implements QuoteServiceCustom {

    Random random = new Random();
    
    @Autowired
    private QuoteService quoteService;
    
    @Override
    public Quote randomQuote() {
        ArrayList<Quote> quotes = new ArrayList<Quote>();
        
        for (Quote q: this.quoteService.findAll() ) {
            quotes.add(q);
        }
        Quote q = quotes.get(random.nextInt(quotes.size()));
        return q;
    }
    
    @Override
    public Quote[] getall() {

        ArrayList<Quote> quotes = new ArrayList<Quote>();
        
        for (Quote q: this.quoteService.findAll() ) {
                 quotes.add(q);
        }
        return quotes.toArray(new Quote[quotes.size()]);
 
    }
    
    public Quote[] listQuote(String id) {
        ArrayList<Quote> quotes = new ArrayList<Quote>();
        ArrayList<Quote> qs = new ArrayList<Quote>();
        String name = null;
        for (Quote q: this.quoteService.findAll() ) {
            quotes.add(q);
        }
        Quote[] quo = quotes.toArray(new Quote[quotes.size()]);
 
        for (int i=0; i<quo.length; i++) {

        	if (quo[i].getAuthor().getId() == Long.parseLong(id)) {
        		name = quo[i].getAuthor().getName();
        	}

}
        for (int i=0; i<quo.length; i++) {
        	Quote q = new Quote();
        	if (quo[i].getAuthor().getName().equals(name)) {
        		q.setSource(quo[i].getSource());
        		q.setText(quo[i].getText());
        		q.setAuthor(quo[i].getAuthor());
        		qs.add(q);
        	}        
        }
        return qs.toArray(new Quote[qs.size()]);
    }
    
}

