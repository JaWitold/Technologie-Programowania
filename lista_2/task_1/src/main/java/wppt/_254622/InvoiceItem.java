package wppt._254622;

import wppt._254622.exceptions.InvalidInvoiceItemName;
import wppt._254622.exceptions.InvalidInvoiceItemPrice;
import wppt._254622.exceptions.InvalidInvoiceItemQuantity;

public class InvoiceItem {

    /**
     * Minimal name length.
     */
    public static final int MIN_NAME_LENGTH = 3;

    /**
     * name.
     */
    private String name;
    /**
     * quantity.
     */
    private int quantity;
    /**
     * unit price.
     */
    private float unitPrice;

    /**
     * Show item.
     */
    public void show() {
        System.out.printf("|%12s|%8d|%.2f|%n", name, quantity, unitPrice);
    }

    /**
     * @param newName
     */
    public void setName(final String newName) throws InvalidInvoiceItemName {
        if (newName.length() < MIN_NAME_LENGTH) {
            throw new InvalidInvoiceItemName();
        }
        this.name = newName;
    }

    /**
     * @param newQuantity
     */
    public void setQuantity(final int newQuantity)
            throws InvalidInvoiceItemQuantity {
        if (newQuantity < 0) {
            throw new InvalidInvoiceItemQuantity();
        }
        this.quantity = newQuantity;
    }

    /**
     * @param newUnitPrice
     */
    public void setUnitPrice(final float newUnitPrice)
            throws InvalidInvoiceItemPrice {
        if (newUnitPrice < 0) {
            throw new InvalidInvoiceItemPrice();
        }
        this.unitPrice = (float) (Math.floor(newUnitPrice * 100) / 100);
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }
}
