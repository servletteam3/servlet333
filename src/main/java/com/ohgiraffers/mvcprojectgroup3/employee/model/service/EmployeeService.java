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

    public EmployeeDTO selectOneEmpById(String empId) {

        /* Connection 생성 */
        Connection con = getConnection();

        /* Connection과 함께 정보를 전달하여 조회한다. */
        EmployeeDTO selectedEmp = empDAO.selectEmpById(con, empId);

        /* connection 닫기 */
        close(con);

        /* 조회 결과를 반환한다. */
        return selectedEmp;

    }

    public int updateEmp(EmployeeDTO employee) {
        Connection con = getConnection();

        int result = empDAO.updateEmp(con, employee);

        if (result > 0) commit(con);
        else            rollback(con);

        close(con);

        return result;
    }

    public List<EmployeeDTO> selectAllemp() {

        Connection con = getConnection();

        List<EmployeeDTO> empList = empDAO.selectAllemp(con);

        close(con);

        return empList;

    }

    public int deleteEmp(String empId) {

        Connection con = getConnection();

        int result = empDAO.deleteEmp(con, empId);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

}



