package za.co.digitalplatoon.invoiceservice.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.digitalplatoon.invoiceservice.model.Invoice;
import za.co.digitalplatoon.invoiceservice.sercvice.InvoiceService;


@RestController
@RequestMapping(value="api/invoices")
public class InvoiceController {

@Autowired
private InvoiceService invoiceService;

@PostMapping(value="/createInvoice")
public Invoice createInvoice(@RequestBody Invoice invoice) {
	return invoiceService.createInvoice(invoice);
}

@GetMapping(value="/invoice/{id}")
public Optional<Invoice> getInvoice(@PathVariable("id") Long id) {
return invoiceService.getInvoice(id);	
}


@GetMapping(value="/invoices")
public List<Invoice> getInvoices() {
return invoiceService.getInvoices();	
}


  
}
