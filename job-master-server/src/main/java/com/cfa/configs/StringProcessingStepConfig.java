package com.cfa.configs;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class StringProcessingStepConfig {

    @Bean
    public ItemReader<String> stringItemReader() {
        return new ItemReader<>() {
            private final List<String> data = Arrays.asList("one", "two", "three", "four", "five");
            private int index = 0;

            @Override
            public String read() {
                if (index < data.size()) {
                    return data.get(index++);
                }
                return null; // null indicates end of data
            }
        };
    }

    @Bean
    public ItemProcessor<String, String> stringItemProcessor() {
        return item -> "Processed " + item;
    }

    @Bean
    public ItemWriter<String> stringItemWriter() {
        return items -> items.forEach(System.out::println);
    }
}
