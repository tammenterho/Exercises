package com.mikko.vaestotieto.entities;

public class Permits {
	private boolean customerRegisterPermit; //Customer register update restriction - This means that an individual has requested that their information should not be updated or changed in the customer register. This restriction is often used when someone wants to freeze the data that a company or organization has about them.
	private boolean personalDataPermit; // Personal data registry restriction - This refers to a request from an individual to restrict access to or use of their personal information in the registry. It typically involves limiting who can view or use their personal data.
	private boolean genealogyResearchPermit; // Genealogy research restriction - This indicates that an individual does not want their personal information to be used for genealogical research purposes. Genealogy researchers often rely on historical records, including population registers, to trace family histories.
	private boolean directMarketingPermit; // Direct marketing restriction - This implies that an individual has requested not to receive direct marketing communications. Direct marketing includes advertising and promotional materials sent directly to an individual, such as emails, phone calls, or physical mail.
	private boolean contactInformationPermit; // Contact information disclosure restriction - This means that an individual has requested that their contact information, such as their address or phone number, should not be disclosed or shared with third parties. It is a privacy measure to prevent unsolicited contact.
	
	
	public Permits(boolean customerRegisterPermit, boolean personalDataPermit, boolean genealogyResearchPermit,
			boolean directMarketingPermit, boolean contactInformationPermit) {
		
		this.customerRegisterPermit = customerRegisterPermit;
		this.personalDataPermit = personalDataPermit;
		this.genealogyResearchPermit = genealogyResearchPermit;
		this.directMarketingPermit = directMarketingPermit;
		this.contactInformationPermit = contactInformationPermit;
	}


	public boolean isCustomerRegisterPermit() {
		return customerRegisterPermit;
	}


	public void setCustomerRegisterPermit(boolean customerRegisterPermit) {
		this.customerRegisterPermit = customerRegisterPermit;
	}


	public boolean isPersonalDataPermit() {
		return personalDataPermit;
	}


	public void setPersonalDataPermit(boolean personalDataPermit) {
		this.personalDataPermit = personalDataPermit;
	}


	public boolean isGenealogyResearchPermit() {
		return genealogyResearchPermit;
	}


	public void setGenealogyResearchPermit(boolean genealogyResearchPermit) {
		this.genealogyResearchPermit = genealogyResearchPermit;
	}


	public boolean isDirectMarketingPermit() {
		return directMarketingPermit;
	}


	public void setDirectMarketingPermit(boolean directMarketingPermit) {
		this.directMarketingPermit = directMarketingPermit;
	}


	public boolean isContactInformationPermit() {
		return contactInformationPermit;
	}


	public void setContactInformationPermit(boolean contactInformationPermit) {
		this.contactInformationPermit = contactInformationPermit;
	}
	
	
	
}
