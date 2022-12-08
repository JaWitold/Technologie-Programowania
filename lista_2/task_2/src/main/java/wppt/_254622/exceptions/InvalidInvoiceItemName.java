package wppt._254622.exceptions;

import wppt._254622.InvoiceItem;

public class InvalidInvoiceItemName extends AbstractInvoiceItemException {
    /**
     * @return
     * @{inheritDoc}
     */
    @Override
    public String getMessage() {
        return String.format(
                "Name should be longer than %d characters",
                InvoiceItem.MIN_NAME_LENGTH
        );
    }
}
