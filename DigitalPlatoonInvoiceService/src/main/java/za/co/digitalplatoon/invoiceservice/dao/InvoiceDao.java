package za.co.digitalplatoon.invoiceservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import za.co.digitalplatoon.invoiceservice.model.Invoice;

@Repository
public interface InvoiceDao extends CrudRepository<Invoice, Long> {

}
