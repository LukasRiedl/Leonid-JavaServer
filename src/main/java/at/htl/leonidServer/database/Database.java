package at.htl.leonidServer.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Lukas on 03.10.2017.
 */
public class Database {

    final String username="daluki"; //Enter in your db username
    final String password="luki05525252"; //Enter your password for the db
    final String url = "jdbc:mysql://db4free.net:3307/leonid_da"; //Enter URL w/db name

    static Connection connection;

    public void onEnable()
    {
        try { //We use a try catch to avoid errors, hopefully we don't get any.
            Class.forName("com.mysql.jdbc.Driver"); //this accesses Driver in jdbc.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("jdbc driver unavailable!");
            return;
        }
        try { //Another try catch to get any SQL errors (for example connections errors)
            connection = DriverManager.getConnection(url,username,password);
            //with the method getConnection() from DriverManager, we're trying to set
            //the connection's url, username, password to the variables we made earlier and
            //trying to get a connection at the same time. JDBC allows us to do this.
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


    public void insert() throws SQLException {


        String sql = "INSERT INTO messages(id,text) VALUES (?, ?);";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, 1);
        stmt.setString(2, "Something"); //I set the "?" to "Something"
        stmt.executeUpdate();
    }
}
