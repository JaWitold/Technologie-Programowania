package eu.jpereira.trainings.designpatterns.structural.proxy;

import eu.jpereira.trainings.designpatterns.structural.proxy.fakes.FakeProxyTrafficLightFactory;
import eu.jpereira.trainings.designpatterns.structural.proxy.fakes.FakeResilientTrafficLightFactory;
import eu.jpereira.trainings.designpatterns.structural.proxy.testconfig.TestConfiguration;

public class ProxyTrafficLightsManagerTest extends TrafficLightsManagerTest {

    @Override
    public void setUp() {
        TestConfiguration.fakeFailuresInController = true;
    }

    @Override
    protected TrafficLightsManager createTrafficLightsManager() {
        return new TrafficLightsManager(new FakeProxyTrafficLightFactory());
    }
}
