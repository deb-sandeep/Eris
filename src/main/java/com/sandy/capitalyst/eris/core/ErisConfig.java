package com.sandy.capitalyst.eris.core;

import java.io.File ;

import org.springframework.boot.context.properties.* ;
import org.springframework.context.annotation.* ;

import lombok.Data ;

@Data
@Configuration( "config" )
@PropertySource( { "classpath:config/eris.properties" } )
@ConfigurationProperties( "eris" )
public class ErisConfig {

    private File workspaceDir = null ;
}
