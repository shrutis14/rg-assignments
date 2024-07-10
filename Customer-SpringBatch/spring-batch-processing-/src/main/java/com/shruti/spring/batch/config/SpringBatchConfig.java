package com.shruti.spring.batch.config;

import com.shruti.spring.batch.repository.CustomerRepository;
import com.shruti.spring.batch.entity.Customer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.AllArgsConstructor;

@Configuration
//@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {


	
	private CustomerRepository customerRepository;
	

	@Bean
	public FlatFileItemReader<Customer> reader() {
		FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new ClassPathResource("customers.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		itemReader.setStrict(false); // Set to false to avoid exceptions if file is not found
		return itemReader;
	}
	
	private LineMapper<Customer> lineMapper(){
		DefaultLineMapper<Customer> lineMapper=new DefaultLineMapper<>();
		
		DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id","firstName","lastName","email","gender","contactNo","country","dob");
		
		BeanWrapperFieldSetMapper<Customer> fieldSetMapper=new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Customer.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;	 
	}
	
	@Bean
	public CustomerProcessor processor() {
		return new CustomerProcessor();
	}
	
	@Bean
	public RepositoryItemWriter<Customer> writer(){
		RepositoryItemWriter<Customer> writer=new RepositoryItemWriter<>();
		writer.setRepository(customerRepository);
		writer.setMethodName("save");
		return writer;
	}
	
	
	@Bean
	public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("csv-step", jobRepository).
				<Customer,Customer>chunk(10, transactionManager)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.taskExecutor(taskExecutor())
				.build();
	}
	
	
	@Bean
	public Job runJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return (Job) new JobBuilder("importCustomers", jobRepository)
				.flow(step1(jobRepository,transactionManager)).end().build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
		asyncTaskExecutor.setConcurrencyLimit(10);
		return asyncTaskExecutor;
	}
}
