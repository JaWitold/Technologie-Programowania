package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class ReportFactory {
    public Report getReport(final String reportType) {
        if (reportType.equalsIgnoreCase("JSON")) {
            return new JSONReport();
        } else if (reportType.equalsIgnoreCase("XML")) {
            return new XMLReport();
        } else if (reportType.equalsIgnoreCase("HTML")) {
            return new HTMLReport();
        } else if (reportType.equalsIgnoreCase("PDF")) {
            return new PDFReport();
        }
        return null;
    }
}