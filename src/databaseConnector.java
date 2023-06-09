import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnector {
    String url;
    String database;
    String port;
    String username;
    String password;
    Connection connection;

    // constructor that initializes the class members to some default values
    databaseConnector() {

        // change this to whatever you have named the university dataset as
        this.database = "universityDataset";

        // change this to whatever port your postgresql server is working on
        this.port = "5432";

        this.url = "jdbc:postgresql://localhost:";

        // change this to your postgres username
        this.username = "postgres";

        // change this to your postgres master password
        this.password = "Thumbsup10";
    }

    // establishes the connection to database
    public void connect() {
        try {
            this.connection = DriverManager.getConnection(url + port + "/" + database, username, password);
            System.out.println("\nConnected to the university database in PostgreSQL!");
        } catch (SQLException e) {
            System.out.println("\nConnection failure: " + e.getMessage());
        }
    }

    // disconnects from the database
    public void disconnect(Connection connection){
        try{
            connection.close();
            System.out.println("\nDisconnected from the university database in PostgreSQL!");
        } catch (SQLException e){
            System.out.println("\nDisconnection failure: " + e.getMessage());
        }
    }
}
