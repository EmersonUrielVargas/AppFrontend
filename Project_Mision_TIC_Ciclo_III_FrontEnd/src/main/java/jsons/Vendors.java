package jsons;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendors {

	@Id
	private long vendor_nit;
	private String vendor_city;
	private String vendor_address;
	private String vendor_name;
	private String vendor_phone;

	public Vendors() {
	}

	public long getVendor_nit() {
		return vendor_nit;
	}

	public void setVendor_nit(long vendor_nit) {
		this.vendor_nit = vendor_nit;
	}

	public String getVendor_city() {
		return vendor_city;
	}

	public void setVendor_city(String vendor_city) {
		this.vendor_city = vendor_city;
	}

	public String getVendor_address() {
		return vendor_address;
	}

	public void setVendor_address(String vendor_address) {
		this.vendor_address = vendor_address;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getVendor_phone() {
		return vendor_phone;
	}

	public void setVendor_phone(String vendor_phone) {
		this.vendor_phone = vendor_phone;
	}

}
