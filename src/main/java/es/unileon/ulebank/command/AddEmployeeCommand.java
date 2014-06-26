package es.unileon.ulebank.command;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.handler.OfficeHandler;
import es.unileon.ulebank.repository.OfficeDao;

public class AddEmployeeCommand implements Command {
	
	protected final Log logger = LogFactory.getLog(getClass());

	private Office office;
	private Employee employee;
	private OfficeDao officeDao;
	private boolean added = false;
	
	public AddEmployeeCommand(Office office, Employee employee,
			OfficeDao officeDao) {
		this.office = office;
		this.employee = employee;
		this.officeDao = officeDao;
	}

	public void execute() {
		List<Employee> employees = officeDao.getOfficeEmployeeList(new OfficeHandler(office.getOfficeId()));
		office.setEmployees(employees);
		if (office.addEmployee(employee)) {
			officeDao.saveOffice(office);
	        logger.info("Adding employee " + employee.getEmployeeId() + ".");
	        added = true;
		} else {
			logger.info("Employee " + employee.getEmployeeId() + " already exits.");
		}
	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

}
