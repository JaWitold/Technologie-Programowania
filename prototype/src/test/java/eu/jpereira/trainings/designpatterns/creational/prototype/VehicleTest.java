/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.prototype;

import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CannotHaveZeroPartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CouldNotCloneLastObjectException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.NeedToPackLastVehicleException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.VehicleDoesNotHavePartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.*;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * @author jpereira
 *
 */

public class VehicleTest {

	@Test
	public void testClone() throws CloneNotSupportedException, VehicleDoesNotHavePartsException, NeedToPackLastVehicleException, CouldNotCloneLastObjectException, CannotHaveZeroPartsException {
		Client client = new Client();

		//create a bus car
		//Create props for tire
		Properties tiresProps = new Properties();
		tiresProps.put(VehiclePartPropertiesEnumeration.SIZE,10);

		//Create props for shell
		Properties shellProps = new Properties();
		shellProps.put(VehiclePartPropertiesEnumeration.COLOR,"blue");


		Properties windowProps = new Properties();
		windowProps.put(VehiclePartPropertiesEnumeration.WIDTH,20);
		windowProps.put(VehiclePartPropertiesEnumeration.WIDTH,20);

		Vehicle vehicle = client.vehicleBuilder().createVehicle().with(new Tire(tiresProps)).times(3).with(new Window(windowProps)).times(8).with(new Shell(shellProps)).times(1).packIt();

		Vehicle clonedVehicle = (Vehicle) vehicle.clone();

		assertArrayEquals(vehicle.getParts(VehiclePartEnumeration.TIRE).toArray(), clonedVehicle.getParts(VehiclePartEnumeration.TIRE).toArray());
		assertArrayEquals(vehicle.getParts(VehiclePartEnumeration.WINDOW).toArray(), clonedVehicle.getParts(VehiclePartEnumeration.WINDOW).toArray());
		assertArrayEquals(vehicle.getParts(VehiclePartEnumeration.SHELL).toArray(), clonedVehicle.getParts(VehiclePartEnumeration.SHELL).toArray());

		assertNotEquals(vehicle, clonedVehicle);
	}
}
