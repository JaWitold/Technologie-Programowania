/**
 * Copyright 2011 Joao Miguel Pereira
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.builder;

import java.util.Iterator;

import eu.jpereira.trainings.designpatterns.creational.builder.html.HTMLReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBuilder;

/**
 * @author jpereira
 */
public class ReportAssembler {

    private SaleEntry saleEntry;

    /**
     * @param saleEntry
     */
    public void setSaleEntry(final SaleEntry saleEntry) {
        this.saleEntry = saleEntry;

    }

    /**
     * @param type
     * @return
     */
    public Report getReport(final String type) {
        Report report = new Report();

        ReportBuilder reportBuilder;
        // Algorithms to build the body objects are different
        switch (type) {
            case "JSON":
                reportBuilder = new JSONReportBuilder();
                break;
            case "XML":
                reportBuilder = new XMLReportBuilder();
                break;
            default:
            case "HTML":
                reportBuilder = new HTMLReportBuilder();
                break;
        }
        reportBuilder.addCustomer(saleEntry.getCustomer());
        reportBuilder.addItems(saleEntry.getSoldItems());
        report.setReportBody(reportBuilder.getReport());
        return report;
    }

}
