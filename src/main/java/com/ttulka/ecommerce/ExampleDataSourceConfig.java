package com.ttulka.ecommerce;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration for sample data.
 * <p>
 * Some sample data to be filled into the database.
 */
@Configuration
//@ConditionalOnClass(name = "org.h2.Driver") // also enable driver in pom.xml
@ConditionalOnClass(name = "com.mysql.cj.jdbc.Driver")
@Profile("!test")
class ExampleDataSourceConfig {

	/*
	 * H2 Embedded
	 * import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
	 * import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
	 * // also enable driver in pom.xml
    @Bean
    DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("/schema.sql", "/example-data.sql")
                .build();
    }
    */
	
	/*
	 * MySQL
	 **/
    @Bean
    DataSource dataSource() {
    	return DataSourceBuilder.create()
    						 .url("jdbc:mysql://localhost:3306/ecommerce")
    						 .username("admin")
    						 .password("admin")
    						 .driverClassName("com.mysql.cj.jdbc.Driver")
    						 .build();
    }
}
