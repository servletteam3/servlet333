package com.ohgiraffers.mvcprojectgroup3.employee.model.service;

import com.ohgiraffers.mvcprojectgroup3.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvcprojectgroup3.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.mvcprojectgroup3.common.jdbc.JDBCTemplate.*;

public class EmployeeService {

/* 사원 등록 */
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

}



