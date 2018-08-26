package za.co.digitalplatoon.invoiceservice.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="line_Item")
public class LineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="line_item_id")
	private Long id;
	
	@Column(name="quantity")
	private Long quantity;
	
	@Column(name="description")
	private String description;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	/*@Column 
	@E(targetClass=Long.class)
	private Invoice invoice;
	
	
	@ManyToOne
	@JoinColumn(name="invoice_lineitem_id")
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}*/

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public BigDecimal getLineItemTotal() {
	return  unitPrice.multiply(new BigDecimal(Long.toString(quantity)).setScale(2, RoundingMode.HALF_UP));
	}

}
