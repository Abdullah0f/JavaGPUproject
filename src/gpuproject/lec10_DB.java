package gpuproject;

import java.sql.*;

public class lec10_DB {
    private Connection conn;
    private Statement stmt;

    public lec10_DB() {
        try {
            // Consider using configuration files or environment variables for credentials
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaGUI", "root", "");
            System.out.println("Connected to database");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a query that returns a ResultSet (e.g., SELECT)
    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to execute update operations (e.g., INSERT, UPDATE, DELETE)
    public int executeUpdate(String query) {
        try {
            System.out.println("Executing query: " + query);
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String[] getColumnNames(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);
            }
            return columnNames;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
