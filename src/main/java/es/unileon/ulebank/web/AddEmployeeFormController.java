package es.unileon.ulebank.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.OfficeHandler;
import es.unileon.ulebank.service.AddEmployee;
import es.unileon.ulebank.service.OfficeManager;

@Controller
@RequestMapping(value="/addemployee.htm")
public class AddEmployeeFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private OfficeManager officeManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid AddEmployee addEmployee, BindingResult result) {
        if (result.hasErrors()) {
            return "addemployee";
        }
		
        String name = addEmployee.getName();
        String surnames = addEmployee.getSurnames();
        String address = addEmployee.getAddress();
        float salary = addEmployee.getSalary();
        String employeeId = addEmployee.getEmployeeId();
        String officeId = addEmployee.getOfficeId();
        
        Handler idOffice = new OfficeHandler(officeId);
        Office office = officeManager.searchOffice(idOffice);
        
        Employee employee = new Employee(office, employeeId, name, surnames, salary, address);
        
        if (officeManager.addEmployee(employee, office)) {
        	return "redirect:/startpage.htm";
        } else {
        	return "redirect:/errorAddEmployee.htm";
        }
        
    }

    @RequestMapping(method = RequestMethod.GET)
    protected AddEmployee formBackingObject(HttpServletRequest request) throws ServletException {
    	AddEmployee addEmployee = new AddEmployee();
    	addEmployee.setName("");
    	addEmployee.setSurnames("");
    	addEmployee.setAddress("");
    	addEmployee.setSalary(2053.62f);
    	addEmployee.setEmployeeId("");
    	addEmployee.setOfficeId("");
        return addEmployee;
    }

    public void setOfficeManager(OfficeManager officeManager) {
        this.officeManager = officeManager;
    }

    public OfficeManager getOfficeManager() {
        return officeManager;
    }

}