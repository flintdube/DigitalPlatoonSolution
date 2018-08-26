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
import za.co.digitalplatoon.invoiceservice.model.LineItem;
import za.co.digitalplatoon.invoiceservice.sercvice.LineItemService;

@RestController
@RequestMapping(value="/api/lineItems")
public class LineItemController {
	
	@Autowired
	private LineItemService lineItemService;
	
	@PostMapping(value="/createLineItem")
	public LineItem createLineItem(@RequestBody LineItem lineItem) {
		return lineItemService.create(lineItem);
	}
	
	@GetMapping(value="/lineItem/{id}")
	public Optional<LineItem> getLineItem(@PathVariable("id") Long id) {
		return lineItemService.getLineItem(id);
	}
	
@GetMapping(value="/lineItems")
public List<LineItem> allLineIntems(){
	return lineItemService.getAllLineItems();
}

}
