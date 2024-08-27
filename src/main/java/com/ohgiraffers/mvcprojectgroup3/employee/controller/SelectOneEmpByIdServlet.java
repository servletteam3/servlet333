package com.ohgiraffers.mvcprojectgroup3.employee.controller;

import com.ohgiraffers.mvcprojectgroup3.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvcprojectgroup3.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        /* 필기. 전달한 파라미터 꺼내기 */
        String empId = req.getParameter("empId");

        System.out.println("empId : " + empId);

        /* 필기. 사번을 이용해 사원 정보를 조회하는 비지니스 로직 호출 */
        EmployeeService empService = new EmployeeService();
        EmployeeDTO selectedEmp = empService.selectOneEmpById(empId);

        System.out.println("selectedEmp : " + selectedEmp);

        /* 필기. 비지니스 로직 실행 결과에 따라 뷰 연결 */
        String path = "";
        if(selectedEmp != null) {
            path = "/WEB-INF/views/employee/showEmpInfo.jsp";
            req.setAttribute("selectedEmp", selectedEmp);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 정보 조회 실패!");
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
