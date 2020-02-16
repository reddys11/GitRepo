package com.OAuth.SpringOAuthExample.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class BatchWriter implements ItemWriter<Object>{

	private static final Logger LOGGER=LoggerFactory.getLogger(BatchWriter.class);

	@Override
	public void write(List<? extends Object> items) throws Exception {
      LOGGER.info("**Batch Writer**");
      LOGGER.info("Batch Output::"+items);
     // System.out.println("items====="+items);
	}

}
