package za.co.digitalplatoon.invoiceservice.sercvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import za.co.digitalplatoon.invoiceservice.dao.LineItemDao;
import za.co.digitalplatoon.invoiceservice.model.LineItem;

@Service
public class LineItemService {
	
	@Autowired
	private LineItemDao lineItemDao;

	public LineItem create(LineItem lineItem) {	
		return lineItemDao.save(lineItem);
	}

	public Optional<LineItem> getLineItem(Long id) {
		return lineItemDao.findById(id);
	}

	public List<LineItem> getAllLineItems() {
		return (List<LineItem>) lineItemDao.findAll();
	}

}
