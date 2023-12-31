package org.example.dao;

import org.example.Student;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 */
public class StudentDao implements IDAO<Student>{
    @Override
    public String insert(Student student) {
        String result = "NG";
        DBUntil until = new DBUntil();
        Connection connection = until.getConn();
        String query = "INSERT INTO student\n" +
                "(name, dob, email, mark, address)\n" +
                "VALUES(?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setDate(2, student.getDob());
            ps.setString(3, student.getEmail());
            ps.setDouble(4, student.getMark());
            ps.setString(5, student.getAddress());
            int row = ps.executeUpdate();
            result = "OK";
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public void insert(Student student, Connection connection) throws SQLException {
        String query = "INSERT INTO student\n" +
                "(name, dob, email, mark, address)\n" +
                "VALUES(?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setDate(2, student.getDob());
            ps.setString(3, student.getEmail());
            ps.setDouble(4, student.getMark());
            ps.setString(5, student.getAddress());
            int row = ps.executeUpdate();

    }

    @Override
    public String update(Student student) {
        return null;
    }

    @Override
    public String delete(Student student) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public ArrayList<Student> selectAll() {
        ArrayList<Student> result = new ArrayList<>();

        try {
            DBUntil dbUntil = new DBUntil();
            // tạo câu query
            String query = "SELECT * FROM " + dbUntil.getDatabaseName()+ ".student";
            // tạo Statement
            Connection connection = dbUntil.getConn();
            Statement statement = connection.createStatement();
            // thực thi câu query
            ResultSet rs = statement.executeQuery(query);
            // Đọc dữ liệu trả về
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Double mark = rs.getDouble("mark");
                Student temp = new Student(id, name, dob, email, mark, address);
                result.add(temp);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This is overview
     * @param address
     * @param id
     * @return
     */
    public String updateAddressByStored(String address, int id) {
        String result = "NG";
        DBUntil dbUntil = new DBUntil();
        Connection connection = dbUntil.getConn();
        String query = "CALL Rocket34DB.update_address_by_id(?, ?)";
        try {
            CallableStatement cs = connection.prepareCall(query);
            cs.setString(1, address);
            cs.setInt(2, id);
            int rowEffect = cs.executeUpdate();
            result = rowEffect + " records updated";
            connection.close();
        } catch (SQLException e) {
            result = e.getMessage();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public void testTransaction(ArrayList<Student> students) {
        DBUntil dbUntil = new DBUntil();
        Connection connection = dbUntil.getConn();
        try {
            connection.setAutoCommit(false);
            for (Student s: students) {
                insert(s, connection);
            }
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
