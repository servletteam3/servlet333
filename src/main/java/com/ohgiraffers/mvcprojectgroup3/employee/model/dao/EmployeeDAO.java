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
}