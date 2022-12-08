package wppt._254622.database;

import static java.lang.System.exit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import wppt._254622.InvoiceItem;

public class SQLConnection implements DatabaseInterface {

    private Connection connection;

    public SQLConnection(String url, String database, String name, String password) {
        try {
            this.connection = getConnection(url, database, name, password);
        } catch (SQLException e) {
            System.out.println("Unable to connect database. Code: " + e.getErrorCode());
            exit(1);
        }
    }

    @Override
    public Connection getConnection(String url, String database, String name, String password) throws SQLException {
        return DriverManager.getConnection("jdbc:" + url + ":" + database, name, password);
    }

    @Override
    public void close() throws SQLException {
        this.connection.close();
    }

    @Override
    public void save(List<InvoiceItem> invoiceItems) throws SQLException {
        Statement statement = this.connection.createStatement();
        for (InvoiceItem item : invoiceItems) {
            statement.executeQuery("INSERT INTO InvoiceItems VALUES (" + item.getName() + "," + item.getQuantity() + "," + item.getUnitPrice() + ")");
        }
    }
}
