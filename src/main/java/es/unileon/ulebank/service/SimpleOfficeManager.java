package es.unileon.ulebank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.ulebank.command.AddEmployeeCommand;
import es.unileon.ulebank.command.Command;
import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.repository.EmployeeDao;
import es.unileon.ulebank.repository.OfficeDao;

@Component
public class SimpleOfficeManager implements OfficeManager {

	private static final long serialVersionUID = 1L;

	@Autowired
	private OfficeDao officeDao;

	@Autowired
	private EmployeeDao employeeDao;

	public void setOfficeDao(OfficeDao officeDao) {
		this.officeDao = officeDao;
	}

	public List<Office> getOffices() {
		return officeDao.getOfficeList();
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> getEmployees() {
		return officeDao.getEmployeeList();
	}

	public boolean addEmployee(Employee employee, Office office) {
		Command addEmployeeCommand = new AddEmployeeCommand(office, employee, officeDao);
		addEmployeeCommand.execute();
		return addEmployeeCommand.isAdded();
	}

	public Office searchOffice(Handler officeId) {
		Office office = officeDao.searchOffice(officeId);
		return office;
	}

	public List<Account> getAccountList(Handler officeID) {
		Office office = this.searchOffice(officeID);
		return office.getAccounts();
	}

}