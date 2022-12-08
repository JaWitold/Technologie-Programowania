package wppt._254622;

import wppt._254622.database.DatabaseInterface;
import wppt._254622.exceptions.AbstractInvoiceItemException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Invoice {
    /**
     * List of invoice items.
     */
    private final List<InvoiceItem> invoiceItems = new ArrayList<>();
    private final DatabaseInterface db;
    public Invoice(DatabaseInterface db) {
        this.db = db;
    }
    /**
     * @param scanner
     */
    public void addItem(final Scanner scanner) {
        InvoiceItem item = new InvoiceItem();
        try {
            System.out.print("Item name: ");
            item.setName(scanner.nextLine());
            System.out.print("Item quantity: ");

            item.setQuantity(Integer.parseInt(scanner.nextLine()));
            System.out.print("Item unit price: ");

            item.setUnitPrice(Float.parseFloat(scanner.nextLine()));

            Optional<InvoiceItem> inInvoiceItem = invoiceItems
                    .stream()
                    .filter(iItem -> iItem.getName().equals(item.getName()))
                    .findFirst();
            if (inInvoiceItem.isPresent()) {
                item.setQuantity(
                        item.getQuantity() + inInvoiceItem.get().getQuantity()
                );
                invoiceItems.remove(inInvoiceItem.get());
            }
            invoiceItems.add(item);
        } catch (AbstractInvoiceItemException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid user input provided");
        }
    }

    /**
     * show invoice.
     */
    public void show() {
        System.out.println("|        Name|Quantity|Price |");
        for (InvoiceItem item : invoiceItems) {
            item.show();
        }
    }

    public void save() {
        try {
            this.db.save(invoiceItems);
        } catch (SQLException e) {
            System.out.println("Unable to save invoice. code: " + e.getErrorCode());
        }
    }
}
