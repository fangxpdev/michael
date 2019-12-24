/*
 * Project Name: payment-service-impl
 * File Name: ActiveMQ4Config.java
 * Class Name: ActiveMQ4Config
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
package com.fangxp.mq.config;

import com.fangxp.mq.constant.QueueConstant;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;


@EnableJms
@Configuration
public class ActiveMQConfig {

    @Bean
    @ConditionalOnMissingBean
    public Queue adVisitLogQueue() {
       return new ActiveMQQueue(QueueConstant.AD_VISIT_LOG_QUEUE);
    }
    
}
