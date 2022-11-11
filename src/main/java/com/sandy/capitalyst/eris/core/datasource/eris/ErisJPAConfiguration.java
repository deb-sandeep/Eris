package com.sandy.capitalyst.eris.core.datasource.eris;

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

import com.sandy.capitalyst.eris.dao.nvp.NVP_JPAScanEnabler ;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackageClasses = NVP_JPAScanEnabler.class,
  entityManagerFactoryRef = "erisEntityManagerFactory",
  transactionManagerRef = "erisTransactionManager"
)
public class ErisJPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean erisEntityManagerFactory(
                                  @Qualifier( "erisDataSource" ) DataSource ds,
                                  EntityManagerFactoryBuilder builder ) {
        
        return builder.dataSource( ds )
                      .packages( NVP_JPAScanEnabler.class )
                      .build() ;
    }

    @Bean
    public PlatformTransactionManager erisTransactionManager(
                            @Qualifier( "erisEntityManagerFactory" ) 
                            LocalContainerEntityManagerFactoryBean factory ) {
        
        return new JpaTransactionManager( 
                        Objects.requireNonNull( 
                                factory.getObject() ) ) ;
    }
}
