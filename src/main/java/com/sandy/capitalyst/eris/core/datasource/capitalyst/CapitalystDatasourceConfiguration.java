package com.sandy.capitalyst.eris.core.datasource.capitalyst;

import javax.sql.DataSource ;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties ;
import org.springframework.boot.context.properties.ConfigurationProperties ;
import org.springframework.context.annotation.Bean ;
import org.springframework.context.annotation.Configuration ;

@Configuration
public class CapitalystDatasourceConfiguration {

    @Bean
    @ConfigurationProperties( "spring.datasource.capitalyst" )
    public DataSourceProperties capitalystDSProps() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource capitalystDataSource() {
        return capitalystDSProps().initializeDataSourceBuilder()
                                  .build() ;
    }
}
