import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseHelper {
    private static String CLASS_NAME;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    static {
        try {
            Scanner scanner = new Scanner(new File(Main.class.getClassLoader().getResource("database.config").getFile()));
            JSONObject json = new JSONObject();
            CLASS_NAME = json.getString("class_name");
            URL = json.getString("url");
            USERNAME = json.getString("username");
            PASSWORD = json.getString("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean next() {
        boolean result = false;
        try {
            result = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void setString(int index, String value) {
        try {
            preparedStatement.setString(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setInt(int index, int value) {
        try {
            preparedStatement.setInt(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setLong(int index, long value) {
        try {
            preparedStatement.setLong(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getString(String key) {
        String value = null;
        try {
            value = resultSet.getString("key");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
    public Integer getInt(String key) {
        Integer value = null;
        try {
            value = resultSet.getInt(key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
    public Long getLong(String key) {
        Long value = null;
        try {
            value = resultSet.getLong(key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
    public void close() {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
