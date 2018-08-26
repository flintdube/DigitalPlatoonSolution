package za.co.digitalplatoon.invoiceservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import za.co.digitalplatoon.invoiceservice.model.Invoice;
import za.co.digitalplatoon.invoiceservice.model.LineItem;
import za.co.digitalplatoon.invoiceservice.sercvice.InvoiceService;
import za.co.digitalplatoon.invoiceservice.sercvice.LineItemService;


@SpringBootApplication
public class InvoiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =SpringApplication.run(InvoiceApplication.class, args);
	
		InvoiceService  invoiceService =applicationContext.getBean("invoiceService",  InvoiceService.class);
		LineItemService  lineItemService =applicationContext.getBean("lineItemService",  LineItemService.class);
		
		LineItem lineItem = new LineItem();
		lineItem.setQuantity(5L);
		lineItem.setDescription("Consumables");
		lineItem.setUnitPrice(new BigDecimal(9.99));
		List<LineItem> items = new ArrayList<LineItem>();
		
		items.add(lineItem);
		
		Invoice invoice = new Invoice();
		invoice.setClient("Milton");
		invoice.setVatRate(15L);
		invoice.setInvoiceDate(new Date());
	
		//invoice.setLineItem(items);
		
		lineItemService.create(lineItem);
		invoiceService.createInvoice(invoice);
	}
}
