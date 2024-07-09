package com.cfa.configs;
import com.cfa.tasklet.SimpleTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public StepConfig(StepBuilderFactory stepBuilderFactory){
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step simpleStep(SimpleTasklet simpleTasklet) {
        TaskletStep simpleStep = stepBuilderFactory.get("simpleStep")
                .tasklet(simpleTasklet)
                .build();
        return simpleStep;
    }

}
