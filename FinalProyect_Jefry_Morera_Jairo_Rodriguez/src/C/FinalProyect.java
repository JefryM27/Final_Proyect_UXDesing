package C;
import M.DBConnectionJava;
import java.sql.Connection;
/**
 *
 * @author jefry
 */
public class FinalProyect {


    public static void main(String[] args, Connection connection) {
        DBConnectionJava con = new DBConnectionJava();
        con.setConnection(connection);

    }
    
}
