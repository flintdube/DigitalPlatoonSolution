package za.co.digitalplatoon.invoiceservice.sercvice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.digitalplatoon.invoiceservice.dao.InvoiceDao;
import za.co.digitalplatoon.invoiceservice.model.Invoice;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceDao invoiceDao;
	
	public Invoice createInvoice(Invoice invoice) {
		return invoiceDao.save(invoice);
	}

	public Optional<Invoice> getInvoice(Long id) {
		return invoiceDao.findById(id);
	}

	public List<Invoice> getInvoices() {
		return (List<Invoice>) invoiceDao.findAll();
	}



}
