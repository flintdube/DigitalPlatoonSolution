package za.co.digitalplatoon.invoiceservice.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="invoice_id")
	private Long id;
	
	@Column (name="client")
	private String client;
	
	@Column (name="vat_rate")
	private Long vatRate=15L;
	
	@Column (name="invoice_date")
	private Date InvoiceDate;
	
	@Column 
	@ElementCollection(targetClass=Long.class)
	private List<LineItem> lineItem;
	
	
	public List<LineItem> getLineItem() {
		return lineItem;
	}
	
	@OneToMany(mappedBy="lineItem", cascade=CascadeType.ALL)
	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}
    
	@Override
	public String toString() {
		String result = id+""+ client+""+vatRate+""+ InvoiceDate +""+ getSubTotal() +""+ getVat()+""+getTotal();
		if(lineItem!=null) {
			for(LineItem item : lineItem) {
			result+= item.getId()+""+item.getQuantity()+""+item.getUnitPrice()+" "+item.getLineItemTotal();
		}
	 }
	return result;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Long getVatRate() {
		return vatRate;
	}
	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}
	public Date getInvoiceDate() {
		return InvoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		InvoiceDate = invoiceDate;
	}
	
	
	public BigDecimal getSubTotal() {
		BigDecimal subTotal= BigDecimal.ZERO;
		if(lineItem!=null) {
			for(LineItem item : lineItem) {
				subTotal=subTotal.add(item.getLineItemTotal());
			}
		}
		return subTotal.setScale(2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getVat() { 
		return (getSubTotal().multiply(new BigDecimal(Long.toString(vatRate/100)))).setScale(2, RoundingMode.HALF_UP);
		}
		
	public BigDecimal getTotal() {
		return (getSubTotal().add(getVat())).setScale(2, RoundingMode.HALF_UP);
	}
	
}
