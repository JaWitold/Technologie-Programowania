package eu.jpereira.trainings.designpatterns.creational.builder.model;

import java.util.List;

public interface ReportBuilder {

    void addCustomer(final Customer customer);

    ReportBody getReport();

    void addItems(List<SoldItem> soldItems);

}
