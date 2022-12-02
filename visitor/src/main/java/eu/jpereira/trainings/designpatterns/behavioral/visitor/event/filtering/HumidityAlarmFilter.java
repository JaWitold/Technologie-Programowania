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
package eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering;

import java.util.ArrayList;
import java.util.List;

import eu.jpereira.trainings.designpatterns.behavioral.visitor.event.alarm.HumidityAlarm;

/**
 * @author windows
 * <p>
 *         TODO: Complete the class. You can see {@link TemperatureAlarmFilter}
 *         for ideas
 */
public class HumidityAlarmFilter implements EventFilter {


    private List<HumidityAlarm> results;
    private Float HumidityThreshold = 0F;

    public HumidityAlarmFilter() {
        this.results = new ArrayList<>();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * eu.jpereira.trainings.designpatterns.behavioral.visitor.event.filtering
     * .EventFilter
     * #filter(eu.jpereira.trainings.designpatterns.behavioral.visitor
     * .event.filtering.Filterable)
     */
    @Override
    public void filter(Filterable filterable) {
        // TODO See TemperatureAlarmFilter and complete this
        if (filterable instanceof HumidityAlarm) {
            HumidityAlarm humidityAlarm = (HumidityAlarm) filterable;
            if (humidityAlarm.getHumidityValue() > this.getHumidityThreshold()) {
                this.results.add(humidityAlarm);
            }

        }
    }

    /**
     * @param humidity
     */
    public void setHumidityThreshold(Float humidity) {
        HumidityThreshold = humidity;
    }

    public Float getHumidityThreshold() {

        return HumidityThreshold;
    }

    /**
     * @return
     */
    public List<HumidityAlarm> getResults() {
        return results;
    }

}
