package jsons;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Products {
	
	private long product_id;
	private double iva_buy;
	private long vendor_nit;
	private String product_name;
	private double price_buy;
	private double price_sale;
	/*@OneToMany
	@JoinColumn(name = "product_id")
	private List<Detail_sells> details_sales;*/
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Products(long product_id, double iva_buy, long vendor_nit, String product_name, double price_buy,
			double price_sale) {
		super();
		this.product_id = product_id;
		this.iva_buy = iva_buy;
		this.vendor_nit = vendor_nit;
		this.product_name = product_name;
		this.price_buy = price_buy;
		this.price_sale = price_sale;
	}




	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public double getIva_buy() {
		return iva_buy;
	}
	public void setIva_buy(double iva_buy) {
		this.iva_buy = iva_buy;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice_buy() {
		return price_buy;
	}
	public void setPrice_buy(double price_buy) {
		this.price_buy = price_buy;
	}
	public double getPrice_sale() {
		return price_sale;
	}
	public void setPrice_sale(double price_sale) {
		this.price_sale = price_sale;
	}
	public long getVendor_nit() {
		return vendor_nit;
	}
	public void setVendor_nit(long vendor_nit) {
		this.vendor_nit = vendor_nit;
	}
	
	
	

}
