package com.stech.spring_opencsv.controller;


import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.stech.spring_opencsv.entity.Employee;
import com.stech.spring_opencsv.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/csvexport")
    public void exportCSV(HttpServletResponse response) throws Exception{

        // set file name and content type

        String fileName = "Employee-data.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileName + "\"");

        //create a csv writer

        StatefulBeanToCsv<Employee> writer = new StatefulBeanToCsvBuilder<Employee>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();

        writer.write(employeeService.findAll());
    }


}
