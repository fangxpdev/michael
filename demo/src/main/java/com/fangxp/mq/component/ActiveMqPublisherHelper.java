/*
 * Project Name: payment-service-impl
 * File Name: ActiveMqPublisherHelper.java
 * Class Name: ActiveMqPublisherHelper
 *
 * Copyright 2016 Xinyunlian Software Inc
 *
 * Licensed under the Xinyunlian
 *
 * http://www.xinyunlian.com
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fangxp.mq.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component("activeMqPublisherHelper")
public class ActiveMqPublisherHelper {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private ExecutorService pool = Executors.newSingleThreadExecutor();

    public void convertAndSendAsync(Destination destination, Object payload) {
        if (payload == null) {
            return;
        }
        pool.execute(new Runnable() {
            @Override
            public void run() {
                jmsMessagingTemplate.convertAndSend(destination, payload);
            }

        });
    }

}
