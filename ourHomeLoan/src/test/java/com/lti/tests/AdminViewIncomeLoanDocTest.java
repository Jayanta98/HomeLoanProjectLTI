package com.lti.tests;

import java.util.List;

import org.junit.Test;

import com.lti.dao.AdminIncomeLoanDocViewDao;
import com.lti.entity.Document;
import com.lti.entity.Income;
import com.lti.entity.Loan;

public class AdminViewIncomeLoanDocTest {

	@Test
	public void showIncomeDetailsOfEveryone() {
		AdminIncomeLoanDocViewDao dao = new AdminIncomeLoanDocViewDao();
		List<Income> list = dao.showIncomeDetails();
		for(Income income : list) {
			System.out.println(income.getEmployerName() + "\t" + income.getRetirementAge());
		}
	}
	
	@Test
	public void showIncomeDetailsByAppId() {
		AdminIncomeLoanDocViewDao dao = new AdminIncomeLoanDocViewDao();
		Income income = dao.searchIncomeDetailsByApplicationId(10020);
		System.out.println(income.getEmployerName() + "\t" + income.getRetirementAge());
	}
	
	@Test
	public void showAllLoanDetails() {
		AdminIncomeLoanDocViewDao dao = new AdminIncomeLoanDocViewDao();
		List<Loan> list = dao.showLoanDetails();
		for(Loan l : list) {
			System.out.println(l.getLoanAmount() + "\t" + l.getInterestRate());
		}
	}
	
	@Test
	public void showLoanDetailsByAppId() {
		AdminIncomeLoanDocViewDao dao = new AdminIncomeLoanDocViewDao();
		Loan loan = dao.searchLoanDetailsByApplicationId(10020);
		System.out.println(loan.getLoanAmount() + "\t" + loan.getInterestRate());
	}
	
	@Test
	public void showAllDocumentDetails() {
		AdminIncomeLoanDocViewDao dao = new AdminIncomeLoanDocViewDao();
		List<Document> list = dao.showDocumentDetails();
		for(Document doc : list) {
			System.out.println(doc.getAgreementToSale() + "\t" + doc.getNOCFromBuilder());
		}
	}
	
	@Test
	public void showDocumentByAppId() {
		AdminIncomeLoanDocViewDao dao = new AdminIncomeLoanDocViewDao();
		Document doc = dao.searchDocumentDetailsByApplicationId(10020);
		System.out.println(doc.getAgreementToSale() + "\t" + doc.getNOCFromBuilder());
	}
	
	@Test
	public void isEligibleToApply() {
		AdminIncomeLoanDocViewDao dao = new AdminIncomeLoanDocViewDao();
		boolean eligible = dao.isEligibleToApply("11223344");
		System.out.println(eligible);
	}
}
