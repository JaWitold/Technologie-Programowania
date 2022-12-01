package eu.jpereira.trainings.designpatterns.behavioral.command.model.command;

import eu.jpereira.trainings.designpatterns.behavioral.command.model.DBServerInstanceStatus;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.command.results.DBServerInstanceResult;
import eu.jpereira.trainings.designpatterns.behavioral.command.model.exceptions.CouldNotConnectException;

public interface Command {
    void execute() throws CouldNotConnectException;

    DBServerInstanceResult<DBServerInstanceStatus> getResult();
}
