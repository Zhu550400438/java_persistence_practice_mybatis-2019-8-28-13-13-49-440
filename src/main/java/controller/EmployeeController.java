package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import entity.Employee;
import tws.mapper.EmployeeMapper;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

 @Autowired
 private EmployeeMapper employeeMapper;
 
 @GetMapping("")
 public ResponseEntity<List<Employee>> getAllEmployee(){
  return ResponseEntity.ok(employeeMapper.getEmployeeList());
 }
 
 @GetMapping("/{id}")
 public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
  Employee e = employeeMapper.getEmployeeById(id);
  if(e == null) {
   return ResponseEntity.notFound().build();
  }
  return ResponseEntity.ok(e);
 }
 
 @PostMapping("")
 @ResponseStatus(HttpStatus.CREATED)
 public void insertEmployee(@RequestBody Employee employee) {
  employeeMapper.insertEmployee(employee);
 }
 
 @PutMapping("/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
  employeeMapper.updateEmployee(id, employee);
 }
 
 @DeleteMapping("/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void deleteEmployee(@PathVariable int id) {
  employeeMapper.deleteEmployee(id);
 }
}