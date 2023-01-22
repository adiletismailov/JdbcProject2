package org.example;

import org.example.config.Util;
import org.example.model.Employee;
import org.example.model.Job;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;
import org.example.service.JobService;
import org.example.service.JobServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Util.getConnection();
        JobService jobService = new JobServiceImpl();
//        jobService.createJobTable();

//        jobService.addJob(new Job("Mentor","Java-8","Backend developer",1));
//        jobService.addJob(new Job("Mentor","Java-8","Backend developer",2));
//        jobService.addJob(new Job("Instructor","Java-8","Backend developer",3));
//        jobService.addJob(new Job("Mentor","JavaScript-8","fronted developer",1));
//        jobService.addJob(new Job("Mentor","JavaScript-8","fronted developer",2));
//        jobService.addJob(new Job("Instructor","JavaScript-8","fronted developer",3));

//        System.out.println(jobService.getJobById(3L));

//        System.out.println(jobService.sortByExperience("asc"));

//        System.out.println(jobService.getJobByEmployeeId(1L));

//        jobService.deleteDescriptionColumn();


        EmployeeService employeeService = new EmployeeServiceImpl();
//        employeeService.createEmployee();

//        employeeService.addEmployee(new Employee("Aijamal","Asangazieva",28,"aijamal@gmail.com",3));
//        employeeService.addEmployee(new Employee("Muhammed","Toichubai uulu",26,"muhammed@gmail.com",2));
//        employeeService.addEmployee(new Employee("Rahim","Bazarbai uulu",20,"rahim@gmail.com",1));
//        employeeService.addEmployee(new Employee("Jasmina","Isaeva",22,"jasmin@gmail.com",6));
//        employeeService.addEmployee(new Employee("Mavliuda","Baktiyar kyzy",20,"mavliuda@gmail.com",4));
//        employeeService.addEmployee(new Employee("Azamat","Abdigapyr uulu",20,"azamat@gmail.com",5));

//        employeeService.dropTable();

//        employeeService.cleanTable();

//        System.out.println(employeeService.getAllEmployees());

//        employeeService.updateEmployee(2L,new Employee("Adilet","Ismailov",23,"adilet@gmail.com",1));

//        System.out.println(employeeService.findByEmail("aijamal@gmail.com"));

//        System.out.println(employeeService.getEmployeeById(4L));

//        System.out.println(employeeService.getEmployeeByPosition("Instructor"));
    }
}
