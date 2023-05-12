package com.nt.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Employee;
import com.nt.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private List<Employee> employees = new ArrayList<>();

  @GetMapping("/taxes")
  public ResponseEntity<List<Employee>> getEmployeesTaxes() {
    LocalDate currentDate = LocalDate.now();
    int currentYear = currentDate.getYear();
    LocalDate financialYearStart = LocalDate.of(currentYear - 1, 4, 1);
    LocalDate financialYearEnd = LocalDate.of(currentYear, 3, 31);

    List<Employee> employeesTaxes = employees.stream()
      .filter(employee -> employee.getDoj().isBefore(financialYearEnd) && employee.getDoj().isAfter(financialYearStart))
      .map(employee -> {
        int numberOfMonths = Period.between(employee.getDoj(), financialYearEnd).getMonths() + 1;
        double salaryPerMonth = employee.getSalary() / 12;
        double totalSalary = numberOfMonths * salaryPerMonth;
        int tax = calculateTax(totalSalary);
        int cess = calculateCess(totalSalary);
        double lossOfPayPerDay = salaryPerMonth / 30;
        return new Employee(employee.getEmployeeID(), employee.getFirstName(), employee.getLastName(),
            totalSalary, tax, cess, lossOfPayPerDay);
      })
      .collect(Collectors.toList());

    return ResponseEntity.ok(employeesTaxes);
  }

  private int calculateTax(double totalSalary) {
    if (totalSalary <= 250000) {
      return 0;
    } else if (totalSalary > 250000 && totalSalary <= 500000) {
      return (int) Math.round((totalSalary - 250000) * 0.05);
    } else if (totalSalary > 500000 && totalSalary <= 1000000) {
      return (int) Math.round(12500 + (totalSalary - 500000) * 0.1);
    } else {
      return (int) Math.round(112500 + (totalSalary - 1000000) * 0.2);
    }
  }

  private int calculateCess(double totalSalary) {
    if (totalSalary > 2500000) {
      return (int) Math.round((totalSalary - 2500000) * 0.02);
    } else {
      return 0;
    }
  }

}













