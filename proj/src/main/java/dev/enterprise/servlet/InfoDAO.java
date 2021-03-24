package dev.enterprise.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InfoDAO {

    public ArrayList<String> getAll() {
        ArrayList<String> things = new ArrayList<>();

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from ninja";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String s = rs.getString("name");
                things.add(s);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return things;
        }
    }

}
