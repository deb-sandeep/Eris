package com.sandy.capitalyst.eris.core.datasource.eris;

import javax.sql.DataSource ;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties ;
import org.springframework.boot.context.properties.ConfigurationProperties ;
import org.springframework.context.annotation.Bean ;
import org.springframework.context.annotation.Configuration ;
import org.springframework.context.annotation.Primary ;

@Configuration
public class ErisDatasourceConfiguration {

    @Bean
    @ConfigurationProperties( "spring.datasource.eris" )
    public DataSourceProperties erisDSProps() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource erisDataSource() {
        return erisDSProps().initializeDataSourceBuilder()
                            .build() ;
    }
}
