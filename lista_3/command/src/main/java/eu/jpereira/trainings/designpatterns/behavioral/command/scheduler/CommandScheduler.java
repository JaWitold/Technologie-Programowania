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
package eu.jpereira.trainings.designpatterns.behavioral.command.scheduler;


import eu.jpereira.trainings.designpatterns.behavioral.command.model.command.Command;

/**
 * A command scheduler will accept Commands and execute the at the time
 * specified by a {@link Schedule}
 * 
 * @author jpereira
 * 
 */
public interface CommandScheduler {

	//TODO: EXERCISE: Uncomment the public interface
	
	/**
	 * Schedules a command to execute
	 * 
	 * @param command
	 *            the instance of {@link Command} to execute
	 * @param schedule
	 *            the {@link Schedule} instance that will drive the scheduling
	 *            of command execution
	 */
	void schedule(Command command, Schedule schedule);



}
