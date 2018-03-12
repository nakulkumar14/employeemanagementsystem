package com.springboot.springbootservices.controller;

import com.springboot.springbootservices.enums.Gender;
import com.springboot.springbootservices.model.CustomObject;
import com.springboot.springbootservices.model.Employee;
import com.springboot.springbootservices.request.SaveEmployeeDTO;
import com.springboot.springbootservices.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final String CLASS = EmployeeController.class.getSimpleName();

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/getEmployeeById/{id}",method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") Long id){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("[{}][getEmployeeById] id : {}", CLASS, id);
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/getAllEmployees",method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/getEmployees/{pageNo}/{limit}", method = RequestMethod.GET)
    public Page<Employee> getEmployees(@PathVariable("pageNo") Integer pageNo, @PathVariable("limit") Integer limit){
        log.info("[{}][getEmployees] pageNo : {}, limit :{}",CLASS, pageNo, limit);
        return employeeService.getEmployees(new PageRequest(pageNo,limit));
    }

    @RequestMapping(value = "/findByGender/{gender}/{pageNo}/{limit}", method = RequestMethod.GET)
    public Page<Employee> findByGender(@PathVariable("gender") String gender, @PathVariable("pageNo") Integer pageNo, @PathVariable("limit") Integer limit){
        log.info("[{}][findByGender] gender : {}, pageNo :{}, limit : {}", CLASS, gender, pageNo, limit);
        return employeeService.findByGender(Gender.valueOf(gender),new PageRequest(pageNo, limit));
    }

    @RequestMapping(value = "/findByDobBetween/{startDate}/{endDate}", method = RequestMethod.GET)
    public List<Employee> findByDobBetween(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) throws Exception{
        log.info("[{}][findByDobBetween] startDate : {}, endDate : {}", CLASS, startDate, endDate);
        return employeeService.findByDobBetween(new SimpleDateFormat("yyyy-MM-dd").parse(startDate), new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
    }

    @RequestMapping(value = "/findTopByGender/{gender}", method = RequestMethod.GET)
    public List<Employee> findTopByGender(@PathVariable("gender") Gender gender){
        log.info("[{}][findTopByGender] gender : {}", CLASS, gender);
        return employeeService.findTopByGender(gender);
    }

    @RequestMapping(value = "/findTop5ByLastname/{lastname}", method = RequestMethod.GET)
    public List<Employee> findTop5ByLastname(String lastname){
        log.info("[{}][findTop5ByLastname] lastname : {}", CLASS, lastname);
        return employeeService.findTop5ByLastname(lastname);
    }

    @RequestMapping(value = "/findTop5ByLastnameOrderByEmpNoDesc",method = RequestMethod.GET)
    public List<Employee> findTop5ByLastnameOrderByEmpNoDesc(String lastname){
        log.info("[{}][findTop5ByLastnameOrderByEmpNoDesc] lastname : {}", CLASS, lastname);
        return employeeService.findTop5ByLastnameOrderByEmpNoDesc(lastname);
    }

    @RequestMapping(value = "/findByFirstnameLikeAndGender/{firstname}/{gender}",method = RequestMethod.GET)
    public List<Employee> findByFirstnameLikeAndGender(@PathVariable("firstname") String firstname, @PathVariable("gender") Gender gender){
        return employeeService.findByFirstnameLikeAndGender(firstname, gender);
    }

    @RequestMapping(value = "/countDistinctByGender/{gender}",method = RequestMethod.GET)
    public Long countDistinctByGender(@PathVariable("gender") Gender gender){
        log.info("[{}][countDistinctByGender] gender : {}", CLASS, gender);
        return employeeService.countDistinctByGender(gender);
    }

    @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee){
        log.info("[{}][addEmployee] employee : {}", CLASS, employee);
        employeeService.addEmployee(employee);
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public void saveEmployee(@RequestBody SaveEmployeeDTO employeeDTO){
        log.info("[{}][saveEmployee] employee : {}", CLASS, employeeDTO);
        employeeService.saveEmployee(employeeDTO);
    }

    @RequestMapping(value = "/deleteEmployeeById",method = RequestMethod.POST)
    public void deleteEmployeeById(@RequestBody Long id){
        log.info("[{}][deleteEmployeeById] id : {}", CLASS, id);
        employeeService.deleteEmployeeById(id);
    }

    @RequestMapping(value = "/getEmployeeByName/{firstname}/{lastname}", method = RequestMethod.GET)
    public List<Employee> getEmployeeByName(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname){
        log.info("[{}][getEmployeeByName] firstname : {}, lastname : {}",CLASS, firstname, lastname);
        return employeeService.findByFirstNameAndLastName(firstname, lastname);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public List<CustomObject> test(){
        return employeeService.test();
    }
}
