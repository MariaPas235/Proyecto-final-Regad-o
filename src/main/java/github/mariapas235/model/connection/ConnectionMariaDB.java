package github.mariapas235.model.connection;

import github.mariapas235.utils.XMLManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class ConnectionMariaDB {
        private final static String FILE="connection.xml";
        private static ConnectionMariaDB _instance;
        private static Connection conn;

        /**
         * Private constructor to prevent external instantiation.
         * Reads the connection properties from the XML file and tries to establish a database connection.
         */
        private ConnectionMariaDB(){
            ConnectionProperties properties = (ConnectionProperties) XMLManager.readXML(new ConnectionProperties(),FILE);

            try {
                conn = DriverManager.getConnection(properties.getURL(),properties.getUser(),properties.getPassword());
            } catch (SQLException e) {
                e.printStackTrace();
                conn=null;
            }
        }
        /**
         * Public method to get the database connection.
         * If the instance is null, create a new one and return the database connection.
         * @return the database connection
         */
        public static Connection getConnection(){
            if(_instance==null){
                _instance = new ConnectionMariaDB();
            }
            return conn;
        }

        /**
         * Public method to close the database connection.
         * If the connection is not null, attempt to close it.
         */
        public static void closeConnection(){
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

