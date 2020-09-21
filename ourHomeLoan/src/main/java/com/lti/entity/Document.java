package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_document_details")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docseq")
	@SequenceGenerator(name = "docseq", sequenceName = "doc_seq", initialValue = 1000, allocationSize = 1)
	private int documentId;
	

	private String PanCard;
	private String VoterIdCard;
	private String salarySlip;
	private String LOA;
	private String NOCFromBuilder;
	private String AgreementToSale;
	
	@OneToOne
	@JoinColumn(name="application_id")
	private Application application;

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getPanCard() {
		return PanCard;
	}

	public void setPanCard(String panCard) {
		PanCard = panCard;
	}

	public String getVoterIdCard() {
		return VoterIdCard;
	}

	public void setVoterIdCard(String voterIdCard) {
		VoterIdCard = voterIdCard;
	}

	public String getSalarySlip() {
		return salarySlip;
	}

	public void setSalarySlip(String salarySlip) {
		this.salarySlip = salarySlip;
	}

	public String getLOA() {
		return LOA;
	}

	public void setLOA(String lOA) {
		LOA = lOA;
	}

	public String getNOCFromBuilder() {
		return NOCFromBuilder;
	}

	public void setNOCFromBuilder(String nOCFromBuilder) {
		NOCFromBuilder = nOCFromBuilder;
	}

	public String getAgreementToSale() {
		return AgreementToSale;
	}

	public void setAgreementToSale(String agreementToSale) {
		AgreementToSale = agreementToSale;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
	
	
	
	
}
