package com.example.aliarslan.accountservice.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;

@Configuration
@EnableCassandraRepositories(basePackages = {"com.example.aliarslan.accountservice"})
public class CassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpace;

    @Value("${spring.data.cassandra.contact.point}")
    private String contactPoint;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.username}")
    private String username;

    @Value("${spring.data.cassandra.password}")
    private String password;

    @Value("${spring.data.cassandra.local.datacenter}")
    private String localDatacenter;

    @Bean
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean cqlSessionFactoryBean = new CqlSessionFactoryBean();
        cqlSessionFactoryBean.setUsername(username);
        cqlSessionFactoryBean.setPassword(password);
        cqlSessionFactoryBean.setKeyspaceName(keySpace);
        cqlSessionFactoryBean.setLocalDatacenter(localDatacenter);
        cqlSessionFactoryBean.setPort(port);
        cqlSessionFactoryBean.setContactPoints(contactPoint);
        cqlSessionFactoryBean.setKeyspaceCreations(Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(keySpace).ifNotExists()));
        return cqlSessionFactoryBean;
    }
}