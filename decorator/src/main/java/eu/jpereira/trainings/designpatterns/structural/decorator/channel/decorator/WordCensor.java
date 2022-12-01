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
package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

import java.util.List;



/**
 * @author jpereira
 *
 */
public class WordCensor extends SocialChannelDecorator {

    private List<String> disallowed;

    /**
     * @param disallowed
     */
    public WordCensor(List<String> disallowed) {
        this.disallowed = disallowed;
    }

    /**
     * @param disallowed
     * @param decoratedChannel
     */
    public WordCensor(List<String> disallowed, SocialChannel decoratedChannel) {
        this.disallowed = disallowed;
        this.delegate = decoratedChannel;
    }

    /*
     * (non-Javadoc)
     *
     * @see eu.jpereira.trainings.designpatterns.structural.decorator.channel.
     * SocialChannel#deliverMessage(java.lang.String)
     */
    @Override
    public void deliverMessage(String message) {
        for(String word: this.disallowed)
            if (message.contains(word)) {
                message = message.replace(word, "###");
            }
        delegate.deliverMessage(message);

    }

}
