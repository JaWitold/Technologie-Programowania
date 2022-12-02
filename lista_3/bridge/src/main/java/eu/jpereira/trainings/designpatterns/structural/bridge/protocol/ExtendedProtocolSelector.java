package eu.jpereira.trainings.designpatterns.structural.bridge.protocol;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class ExtendedProtocolSelector extends ProtocolSelector {

    @Override
    protected Collection<Protocol> createAdditionalProtocols() {
        return Collections.singletonList((Protocol) new BluetoothProtocol());
    }
}
