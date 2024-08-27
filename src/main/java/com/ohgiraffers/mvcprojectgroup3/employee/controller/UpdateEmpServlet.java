package com.ohgiraffers.mvcprojectgroup3.employee.controller;

import com.ohgiraffers.mvcprojectgroup3.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvcprojectgroup3.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmpId(empId);
        employee.setEmail(email);
        employee.setPhone(phone);

        int result = new EmployeeService().updateEmp(employee);

        String path = "";
        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "updateEmp");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "회원 정보 수정 실패 :(");
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
