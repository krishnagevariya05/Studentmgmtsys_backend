package in.ac.charusat.controller;

import in.ac.charusat.model.Employee20it051;
import in.ac.charusat.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class EmployeeContoller
{
   @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("listEmployees")
    public List<Employee20it051> getAllStudents()
    {
        return employeeRepository.findAll();
    }
    @GetMapping("/emp/{id}")
    public Employee20it051 getStudent(@PathVariable Integer id) {
        return employeeRepository.findById(id).get();
    }
    @PostMapping("/employee")
    public List<Employee20it051> addStudent(@RequestBody Employee20it051 emp)
    {
        employeeRepository.save(emp);
        return employeeRepository.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public List<Employee20it051> deleteEmployee(@PathVariable Integer id)
    {
        employeeRepository.delete(employeeRepository.findById(id).get());
        return employeeRepository.findAll();
    }
    @PutMapping("/update/{id}")
    public List<Employee20it051> updateEmployee(@RequestBody Employee20it051 emp ,@PathVariable Integer id)
    {
        Employee20it051 empobj=employeeRepository.findById(id).get();
        empobj.setName(emp.getName());
        empobj.setAddress(emp.getAddress());
        employeeRepository.save(empobj);
        return employeeRepository.findAll();
    }




}
