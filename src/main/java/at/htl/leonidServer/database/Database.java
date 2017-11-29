package at.htl.leonidServer.database;

import at.htl.leonidServer.Message;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukas on 03.10.2017.
 */
public class Database {

    final String username="daluki"; //Enter in your db username
    final String password="luki05525252"; //Enter your password for the db
    final String url = "jdbc:mysql://db4free.net:3307/leonid_da?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //Enter URL w/db name

    static Connection connection;

    public void onEnable()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //this accesses Driver in jdbc.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("jdbc driver unavailable!");
            return;
        }
        try {
            connection = DriverManager.getConnection(url,username,password);

        } catch (SQLException e) { //catching errors)
            e.printStackTrace(); //prints out SQLException errors to the console (if any)
        }
    }

    public void onDisable() {
        // invoke on disable.
        try { //using a try catch to catch connection errors (like wrong sql password...)
            if (connection!=null && !connection.isClosed()){ //checking if connection isn't null to
                //avoid receiving a nullpointer
                connection.close(); //closing the connection field variable.
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Database() {
    }

    public int insert(Message message) throws SQLException {
        deleteDatabase();
        onEnable();
        String sql = "INSERT INTO Message(id,text) VALUES (?, ?);";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, message.getId());
        stmt.setString(2, message.getText()); //I set the "?" to "Something"
        stmt.executeUpdate();

        onDisable();
        return message.getId();
    }

    public String getAllMessages() throws SQLException
    {

        onEnable();
        String sql = "select * from Message;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        List<String> list= new LinkedList<>();
        String x = "";
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            list.add(rs.getString(2));
        }
        onDisable();
       return list.get(0);
    }

    public void deleteDatabase() throws SQLException {
        onEnable();
        String sql = "DELETE FROM Message;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.executeUpdate();
        onDisable();
    }
}
