package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door {

    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            this.unlock(code);
            if (this.getLockStatus() == LockStatus.UNLOCKED) {
                this.setState(DoorState.OPEN);
            }
        } catch (CannotUnlockDoorException | CannotChangeStateOfLockedDoor e) {
            throw new IncorrectDoorCodeException(e);
        }
    }

    @Override
    public void close() {
        try {
            this.setState(DoorState.CLOSED);
        } catch (CannotChangeStateOfLockedDoor ignored) {
        }
    }

    @Override
    public boolean isOpen() {
        return this.getState() == DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        try {
            this.unlock(oldCode);
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException(e);
        }
        if (!newCode.equals(newCodeConfirmation)) {
            throw new CodeMismatchException();
        }

        try {
            this.setNewLockCode(newCode);
        } catch (CannotChangeCodeForUnlockedDoor e) {
            throw new IncorrectDoorCodeException(e);
        }
    }

    @Override
    public boolean testCode(String code) {
        try {
            unlock(code);
            return true;
        } catch (CannotUnlockDoorException e) {
            return false;
        }
    }
}
