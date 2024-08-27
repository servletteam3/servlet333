package com.ohgiraffers.mvcprojectgroup3.employee.model.dao;

import com.ohgiraffers.mvcprojectgroup3.common.config.ConfigLocation;
import com.ohgiraffers.mvcprojectgroup3.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.mvcprojectgroup3.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {

    private final Properties prop;

    public EmployeeDAO() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "employee-mapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String selectNewEmpId(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String newEmpId = null;

        String query = prop.getProperty("selectNewEmpId");

        try {
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                newEmpId = rset.getString("EMP_ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return newEmpId;
    }

    public int insertEmp(Connection con, EmployeeDTO emp) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, emp.getEmpId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpNo());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getDeptCode());
            pstmt.setString(7, emp.getJobCode());
            pstmt.setString(8, emp.getSalLevel());
            pstmt.setInt(9, emp.getSalary());
            pstmt.setDouble(10, emp.getBonus());
            pstmt.setString(11, emp.getManagerId());
            pstmt.setDate(12, emp.getHireDate());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int updateEmp(Connection con, EmployeeDTO employee) {
        PreparedStatement ps = null;
        int result = 0;

        String query = prop.getProperty("updateEmp");

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, employee.getEmail());
            ps.setString(2, employee.getPhone());
            ps.setString(3, employee.getEmpId());
            result = ps.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }

        return result;
    }

    public List<EmployeeDTO> selectAllemp(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;

        List<EmployeeDTO> empList = null;

        String query = prop.getProperty("selectAllEmpList");


        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            empList = new ArrayList<>();

            while (rset.next()) {
                EmployeeDTO emp = new EmployeeDTO();
                emp.setEmpId(rset.getString("EMP_ID"));
                emp.setEmpName(rset.getString("EMP_NAME"));
                emp.setEmail(rset.getString("EMAIL"));
                emp.setEmpNo(rset.getString("EMP_NO"));
                emp.setPhone(rset.getString("PHONE"));
                emp.setDeptCode(rset.getString("DEPT_CODE"));
                emp.setJobCode(rset.getString("JOB_CODE"));
                emp.setSalLevel(rset.getString("SAL_LEVEL"));
                emp.setSalary(rset.getInt("SALARY"));
                emp.setBonus(rset.getDouble("BONUS"));
                emp.setManagerId(rset.getString("MANAGER_ID"));
                emp.setHireDate(rset.getDate("HIRE_DATE"));
                emp.setEntDate(rset.getDate("ENT_DATE"));
                emp.setEntYn(rset.getString("ENT_YN"));

                empList.add(emp);
            }



        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {
            close(rset);
            close(stmt);
        }
        return empList;
    }

    public int deleteEmp(Connection con, String empId) {
        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("deleteEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
}