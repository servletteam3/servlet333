package com.ohgiraffers.mvcprojectgroup3.employee.model.service;

import com.ohgiraffers.mvcprojectgroup3.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvcprojectgroup3.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.mvcprojectgroup3.common.jdbc.JDBCTemplate.*;

public class EmployeeService {

    private final EmployeeDAO empDAO;

    public EmployeeService() {
        empDAO = new EmployeeDAO();
    }

    /* 신규 사원 조회 */
    public String selectNewEmpId() {

        Connection con = getConnection();

        String newEmpId = empDAO.selectNewEmpId(con);

        close(con);

        return newEmpId;
    }

    /* 신규 사원 등록 */
    public int insertEmp(EmployeeDTO emp) {

        Connection con = getConnection();

        int result = empDAO.insertEmp(con, emp);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

    public int updateEmp(EmployeeDTO employee) {
        Connection con = getConnection();

        int result = empDAO.updateEmp(con, employee);

        close(con);

        return result;
    }


}



