package wppt._254622.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import wppt._254622.InvoiceItem;

public interface DatabaseInterface {

    public Connection getConnection(String url, String database, String name, String password) throws SQLException;
    public void close() throws SQLException;
    void save(List<InvoiceItem> invoiceItems) throws SQLException;
}
