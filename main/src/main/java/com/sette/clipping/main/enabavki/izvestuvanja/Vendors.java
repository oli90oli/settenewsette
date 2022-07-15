package com.sette.clipping.main.enabavki.izvestuvanja;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vendors {

	@JsonProperty("Name")
	private String name;

	@JsonProperty("VendorMb")
	private String vendorMb;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendorMb() {
		return vendorMb;
	}

	public void setVendorMb(String vendorMb) {
		this.vendorMb = vendorMb;
	}
	
	

}
