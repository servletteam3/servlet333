package com.ohgiraffers.mvcprojectgroup3.employee.controller;

import com.ohgiraffers.mvcprojectgroup3.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvcprojectgroup3.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String empName = req.getParameter("empName");
        String empNo = req.getParameter("empNo");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String deptCode = req.getParameter("deptCode");
        String jobCode = req.getParameter("jobCode");
        String salLevel = req.getParameter("salLevel");
        int salary = Integer.parseInt(req.getParameter("salary"));
        double bonus = Double.parseDouble(req.getParameter("bonus"));
        String manageId = req.getParameter("managerId");
        java.sql.Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate"));

        EmployeeService empService = new EmployeeService();
//        String newEmpId = empService.selectNewEmpId();        // selectNewEmpId 생성 후 주석 풀기

        EmployeeDTO emp  = new EmployeeDTO();
//        if(newEmpId !=null) emp.setEmpId(newEmpId);           // selectNewEmpId 생성 후 주석 풀기
        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDeptCode(deptCode);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setManagerId(manageId);
        emp.setHireDate(hireDate);

        System.out.println("insert request emp : " + emp);

        int result = empService.insertEmp(emp);

        String path = "";
        if(result > 0) {
            path = ""
        }







    }
}