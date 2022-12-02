package eu.jpereira.trainings.designpatterns.creational.builder.html;

import eu.jpereira.trainings.designpatterns.creational.builder.model.Customer;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.List;

public class HTMLReportBuilder implements ReportBuilder {

    private final HTMLReportBody reportBody = new HTMLReportBody();

    @Override

    public void addCustomer(final Customer customer) {
        reportBody.putContent("<span class=\"customerName\">");
        reportBody.putContent(customer.getName());
        reportBody.putContent("</span><span class=\"customerPhone\">");
        reportBody.putContent(customer.getPhone());
        reportBody.putContent("</span>");
    }

    @Override
    public ReportBody getReport() {
        return reportBody;
    }

    @Override
    public void addItems(List<SoldItem> soldItems) {
        reportBody.putContent("<items>");
        for (SoldItem soldItem : soldItems) {
            reportBody.putContent("<item><name>");
            reportBody.putContent(soldItem.getName());
            reportBody.putContent("</name><quantity>");
            reportBody.putContent(soldItem.getQuantity());
            reportBody.putContent("</quantity><price>");
            reportBody.putContent(soldItem.getUnitPrice());
            reportBody.putContent("</price></item>");
        }
        reportBody.putContent("</items>");
    }
}
