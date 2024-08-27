package com.ohgiraffers.mvcprojectgroup3.employee.controller;

import com.ohgiraffers.mvcprojectgroup3.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvcprojectgroup3.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeService();
        List<EmployeeDTO> empList = employeeService.selectAllemp();

        for (EmployeeDTO emp : empList) {
            System.out.println(emp);
        }

        String path = "";
        if (empList != null) {
            path = "/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("empList", empList);
        } else {
            path = "/WEB-INF/common/errorPage.jsp";
            req.setAttribute("message", "직원 목록 조회 실패!!");
        }

        req.getRequestDispatcher(path).forward(req,resp);
    }
}