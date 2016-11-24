package com.example.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile("batch")
public class TodoBatch {
    /**
     * The Logger for this Class.
     */
    private static final Logger logger = LoggerFactory.getLogger(TodoBatch.class);

    private static final String MESSAGE_FORMAT = "There are {} greetings in the data store.";

    @Scheduled(
            cron = "${batch.todo.start.cron}")
    public void cronJob() {
        logger.info("> cronJob");



        logger.info("< cronJob");
    }
}
