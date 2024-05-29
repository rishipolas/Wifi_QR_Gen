package com.qr.wifiqr.model;

import java.util.Objects;

public class WiFi {

	private String networkname;
	private String password;
	private String networktype;
	public String getNetworkname() {
		return networkname;
	}
	public void setNetworkname(String networkname) {
		this.networkname = networkname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNetworktype() {
		return networktype;
	}
	public void setNetworktype(String networktype) {
		this.networktype = networktype;
	}
	
	public WiFi(String networkname, String password, String networktype) {
		super();
		this.networkname = networkname;
		this.password = password;
		this.networktype = networktype;
	}
	@Override
	public String toString() {
		return "WiFi [networkname=" + networkname + ", password=" + password + ", networktype=" + networktype + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(networkname, networktype, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WiFi other = (WiFi) obj;
		return Objects.equals(networkname, other.networkname) && Objects.equals(networktype, other.networktype)
				&& Objects.equals(password, other.password);
	}
	
	
	
	
	
	
	
	
}
