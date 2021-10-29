package ru.moore.AISUchetTehniki.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    @Bean
//    public BeanPostProcessor beanPostProcessor() {
//        return new BeanPostProcessor() {
//            @Override
//            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//                if (bean instanceof WebSocketMessageBrokerStats) {
//                    WebSocketMessageBrokerStats webSocketMessageBrokerStats = (WebSocketMessageBrokerStats) bean;
//                    webSocketMessageBrokerStats.setLoggingPeriod(30 * 1000); // your customization
//                }
//                return bean;
//            }
//
//            @Override
//            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//                return bean;
//            }
//        };
//    }

    //    настраиваем брокер сообщений, который будет использоваться
    //    для направления сообщений от одного клиента к другому.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //    говорим, что  сообщения, чей адрес начинается с  “/topic“,
        //    должны быть направлены в брокер сообщений. Брокер перенаправляет
        //    сообщения всем клиентам, подписанным на тему.
        config.enableSimpleBroker( "/topic");

        //    говорим, что сообщения, чей адрес (куда отправлены) начинается с  “/app“,
        //    должны быть направлены в методы, занимающиеся обработкой сообщений.
        //    методы, аннотированные @MessageMapping.
        config.setApplicationDestinationPrefixes("/app");

//        config.setUserDestinationPrefix("/user");
    }

    //    регистрируем конечную точку, которую клиенты будут использовать,
    //    чтобы подключиться к нашему Websocket-серверу.
    //    SockJS – для браузеров, которые не поддерживают Websocket.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/gs-guide-websocket")
                .setAllowedOrigins("http://localhost:3000")
                .withSockJS();
    }

//    @Override
//    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
//        DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
//        resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//        converter.setObjectMapper(new ObjectMapper());
//        converter.setContentTypeResolver(resolver);
//        messageConverters.add(converter);
//        return false;
//    }


}
