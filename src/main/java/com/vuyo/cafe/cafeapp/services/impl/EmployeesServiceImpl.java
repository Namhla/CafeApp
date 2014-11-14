/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuyo.cafe.cafeapp.services.impl;


/*import com.cafeteria.system.app.factory.ContactFactory;
import com.cafeteria.system.app.factory.DemographyFactory;
import com.cafeteria.system.app.factory.EmployeeFactory;
import com.cafeteria.system.client.web.model.EmployeeModel;
import com.cafeteria.system.domain.Contact;
import com.cafeteria.system.domain.Demography;
import com.cafeteria.system.domain.Employee;
import com.cafeteria.system.services.EmployeeService;
import com.cafeteria.system.services.crud.EmployeeCrudService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;*/

/**
 *
 * @author Lynx
 */
//@Service
public class EmployeesServiceImpl /*implements EmployeeService*/
{
     /*@Autowired
    private EmployeeCrudService employeesCrudService;

   
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Employee> createEmployee(EmployeeModel model) 
    {
         String email = null;
         String cell = null;
         String office = null;
         //Contact
         Contact contact = ContactFactory.getContact(email, cell, office);
         contact.setEmail(model.getEmail());
         contact.setCellphone(model.getCellphone());
         contact.setOfficeNumber(model.getOfficeNumber());
        
         //Demography
         String gender =null;
         String race =null;
         Date dob = null;
         Demography demography = DemographyFactory.getDemography(gender, race, dob);
         
        demography.setGender(model.getGender());
        demography.setRace(model.getRace());
        demography.setDateOfBirth(model.getDob());
         //Employee
        Employee employee = new EmployeeFactory
                                .Builder(124)
                                .FirstName(model.getFirstName())
                                .LastName(model.getLastName())
                                .Demography(demography)
                                .JobId(model.getJobId())
                                .Contact(contact)
                                .build();
         
         
        employeesCrudService.persist(employee);
        return employeesCrudService.findAll();
    }
    
  
    
     @Override
     public List<Employee> deleteEmployee(Long id) {
        employeesCrudService.removeById(id);
        return employeesCrudService.findAll();
    }
     
     
     
     
     @Override
     public EmployeeModel getEmployeeToedit(Long id) 
     {
         EmployeeModel employeeModel = new EmployeeModel();
         Employee employee = employeesCrudService.findById(id);
         //Name
         employeeModel.setFirstName(employee.getFirstName());
         employeeModel.setLastName(employee.getLastName());
         //demography
         employeeModel.setDob(employee.getDemography().getDateOfBirth());
         employeeModel.setGender(employee.getDemography().getGender());
         employeeModel.setRace(employee.getDemography().getRace());
         //contact
         employeeModel.setCellphone(employee.getContact().getCellphone());
         employeeModel.setEmail(employee.getContact().getEmail());
         employeeModel.setOfficeNumber(employee.getContact().getOfficeNumber());
         
         
         employeeModel.setId(id);
       
        return employeeModel;
    }

    
     @Override
     public List<Employee> updateEmployee(EmployeeModel model, Long id) 
     {
          Map<String, String> details = new HashMap<String, String>(); 
         Employee employee = employeesCrudService.findById(id);
         String email = null;
         String cell = null;
         String office = null;
         
         Contact contact = ContactFactory.getContact(email, cell, office);
         
         
         Map<String, String> employeeValues = new HashMap<String, String>();
         employeeValues.put("firstName", model.getFirstName());
         employeeValues.put("lastName", model.getLastName());
         Map<String, String> employeeDemo = new HashMap<String, String>();
         Date dob = null;
         employeeDemo.put("gender", model.getGender());
         employeeDemo.put("race", model.getRace());
         Demography demo = DemographyFactory.getDemography(model.getGender(), model.getRace(), model.getDob());
         contact.setCellphone(model.getCellphone());
         contact.setEmail(model.getEmail());
         contact.setOfficeNumber(model.getOfficeNumber());
         
         
         
         employee.setContact(contact);
         employee.setFirstName(model.getFirstName());
         employee.setLastName(model.getLastName());
         employee.setDemography(demo);
         
         employeesCrudService.merge(employee);
         
         return null;
        
    }
    
     
     
     
     
     
     
     
     @Override
     public List<Employee> getEmployee() 
     {
        return employeesCrudService.findAll();
     }

    @Override
    public List<Employee> findAll()
    {
         return employeesCrudService.findAll();
    }*/
}