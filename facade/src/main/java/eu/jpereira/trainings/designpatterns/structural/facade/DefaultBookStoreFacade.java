package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.*;

public class DefaultBookStoreFacade implements BookstoreFacade{

    private BookDBService bs;
    private CustomerDBService cs;
    private CustomerNotificationService cns;
    private OrderingService os;
    private WarehouseService ws;

    public void setServices(BookDBService bs, CustomerDBService cs, CustomerNotificationService cns, OrderingService os, WarehouseService ws) {
        this.bs = bs;
        this.cs = cs;
        this.cns = cns;
        this.os = os;
        this.ws = ws;
    }
    @Override
    public void placeOrder(String customerId, String isbn) {
        Book book = bs.findBookByISBN(isbn);
        Customer customer = cs.findCustomerById(customerId);
        Order order = os.createOrder(customer, book);
        DispatchReceipt receipt = ws.dispatch(order);
        cns.notifyClient(receipt);
    }
}
