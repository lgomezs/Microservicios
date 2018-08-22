package com.example.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@Configuration
@PropertySource(value = {"classpath:application.properties"})
@EnableCassandraRepositories(basePackages= {"com.example.springboot.repository"})
public class CassandraConfig  extends AbstractReactiveCassandraConfiguration{

	 	@Value("${cassandra.contactpoints}") private String contactPoints;
	    @Value("${cassandra.port}") private int port;
	    @Value("${cassandra.keyspace}") private String keyspace;
	  
	    @Override 
	    protected String getKeyspaceName() {
	        return keyspace;
	    }
	    
	    @Override 
	    protected String getContactPoints() {
	        return contactPoints;
	    }
	    
	    @Override 
	    protected int getPort() {
	        return port;
	    }
	    
	    @Override 
	    public SchemaAction getSchemaAction() {
	        return SchemaAction.CREATE_IF_NOT_EXISTS;
	    }	
	    
}
