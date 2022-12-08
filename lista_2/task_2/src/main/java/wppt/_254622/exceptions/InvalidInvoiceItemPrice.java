package wppt._254622.exceptions;

public class InvalidInvoiceItemPrice extends AbstractInvoiceItemException {
    /**
     * @return
     * @{inheritDoc}
     */
    @Override
    public String getMessage() {
        return "Unit price should be positive rational number";
    }
}
