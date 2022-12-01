package eu.jpereira.trainings.designpatterns.structural.proxy;

import eu.jpereira.trainings.designpatterns.structural.proxy.fakes.FakeResilientTrafficLightFactory;
import eu.jpereira.trainings.designpatterns.structural.proxy.testconfig.TestConfiguration;

public class ResilientTrafficLightsManagerTest extends TrafficLightsManagerTest {

    @Override
    public void setUp() {
        TestConfiguration.fakeFailuresInController = true;
    }

    @Override
    protected TrafficLightsManager createTrafficLightsManager() {
        return new TrafficLightsManager(new FakeResilientTrafficLightFactory());
    }
}
