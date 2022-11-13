package com.sandy.capitalyst.eris.core.config;

import java.io.File ;

import org.springframework.boot.context.properties.ConfigurationProperties ;
import org.springframework.context.annotation.Configuration ;
import org.springframework.context.annotation.PropertySource ;

import lombok.Data ;

@Data
@Configuration( "config" )
@ConfigurationProperties( prefix = "eris" )
@PropertySource( value = "classpath:config/eris.properties" )
public class ErisConfig {

    private File workspaceDir = null ;
}
