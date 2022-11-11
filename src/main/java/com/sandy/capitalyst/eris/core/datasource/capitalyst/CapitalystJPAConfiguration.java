package com.sandy.capitalyst.eris.core.datasource.capitalyst;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sandy.capitalyst.eris.dao.equity.Equity_JPAScanEnabler ;
import com.sandy.capitalyst.eris.dao.index.Index_JPAScanEnabler ;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackageClasses = { Equity_JPAScanEnabler.class, Index_JPAScanEnabler.class },
  entityManagerFactoryRef = "capitalystEntityManagerFactory",
  transactionManagerRef = "capitalystTransactionManager"
)
public class CapitalystJPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean capitalystEntityManagerFactory(
                              @Qualifier( "capitalystDataSource" ) DataSource ds,
                              EntityManagerFactoryBuilder builder ) {
        
        return builder.dataSource( ds )
                      .packages( Equity_JPAScanEnabler.class, Index_JPAScanEnabler.class )
                      .build() ;
    }

    @Bean
    public PlatformTransactionManager capitalystTransactionManager(
                            @Qualifier( "capitalystEntityManagerFactory" ) 
                            LocalContainerEntityManagerFactoryBean factory ) {
        
        return new JpaTransactionManager( 
                        Objects.requireNonNull( 
                                factory.getObject() ) ) ;
    }
}
