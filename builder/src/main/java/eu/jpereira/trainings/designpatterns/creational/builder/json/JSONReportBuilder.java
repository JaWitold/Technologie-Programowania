package eu.jpereira.trainings.designpatterns.creational.builder.json;

import eu.jpereira.trainings.designpatterns.creational.builder.model.Customer;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.Iterator;
import java.util.List;

public class JSONReportBuilder implements ReportBuilder {

    private final JSONReportBody reportBody = new JSONReportBody();

    @Override
    public void addCustomer(final Customer customer) {
        reportBody.addContent("sale:{customer:{");
        reportBody.addContent("name:\"");
        reportBody.addContent(customer.getName());
        reportBody.addContent("\",phone:\"");
        reportBody.addContent(customer.getPhone());
        reportBody.addContent("\"}");
    }

    @Override
    public JSONReportBody getReport() {
        return reportBody;
    }

    @Override
    public void addItems(List<SoldItem> soldItems) {
        Iterator<SoldItem> itemIterator = soldItems.iterator();

        reportBody.addContent(",items:[");
        while (itemIterator.hasNext()) {
            SoldItem soldItem = itemIterator.next();
            reportBody.addContent("{name:\"");
            reportBody.addContent(soldItem.getName());
            reportBody.addContent("\",quantity:");
            reportBody.addContent(String.valueOf(soldItem.getQuantity()));
            reportBody.addContent(",price:");
            reportBody.addContent(String.valueOf(soldItem.getUnitPrice()));
            reportBody.addContent("}");
            if (itemIterator.hasNext()) {
                reportBody.addContent(",");
            }
        }
        reportBody.addContent("]}");
    }
}
