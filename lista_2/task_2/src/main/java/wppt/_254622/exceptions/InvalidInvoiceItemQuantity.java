package wppt._254622.exceptions;

public class InvalidInvoiceItemQuantity extends AbstractInvoiceItemException {
    /**
     * @return
     * @{inheritDoc}
     */
    @Override
    public String getMessage() {
        return "Quantity should be positive integer number";
    }
}
