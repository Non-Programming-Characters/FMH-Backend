package ru.fmh.app.configuration;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.webmvc.autoconfigure.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.JacksonJsonHttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Configuration
public class WebConfig extends DelegatingWebMvcConfiguration {


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        List<ContentNegotiationStrategy> strategies = new ArrayList<>();

        Map<String, MediaType> mediaTypes = new HashMap<>();
        mediaTypes.put("pdf", MediaType.APPLICATION_PDF);
        mediaTypes.put("json", APPLICATION_JSON);
        mediaTypes.put("zip", MediaType.APPLICATION_OCTET_STREAM);

        strategies.add(new ParameterContentNegotiationStrategy(mediaTypes));

        strategies.add(new HeaderContentNegotiationStrategy());

        configurer.strategies(strategies);
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new SafeByteArrayHttpMessageConverter());

        // 2. JSON конвертер - ЗАПРЕЩАЕМ ему byte[]
        JacksonJsonHttpMessageConverter jsonConverter = new JacksonJsonHttpMessageConverter() {
            @Override
            public boolean canWrite(Class<?> clazz, MediaType mediaType) {
                // КЛЮЧЕВОЕ: запрещаем byte[] для JSON

                System.out.println(clazz);
                if (clazz == byte[].class) {
                    System.out.println("❌ JSON конвертер: отказ от byte[] или иного типа");
                    return false;
                }
                // Для всех остальных типов - стандартная логика
                return super.canWrite(clazz, mediaType);
            }
        };
        jsonConverter.setSupportedMediaTypes(List.of(APPLICATION_JSON));
        converters.add(jsonConverter);

//        // 3. String конвертер
//        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter() {
//            @Override
//            public boolean canWrite(Class<?> clazz, MediaType mediaType) {
//                System.out.println(clazz);
//                if (clazz == byte[].class) {
//                    System.out.println("❌ JSON конвертер: отказ от byte[] или иного типа");
//                    return false;
//                }
//                return super.canWrite(clazz, mediaType);
//            }
//        }
//        stringHttpMessageConverter.setSupportedMediaTypes(List.of(APPLICATION_JSON));
//        converters.add(stringHttpMessageConverter);
    }
}