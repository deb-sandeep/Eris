package com.sandy.capitalyst.eris ;

import org.apache.log4j.Logger ;
import org.springframework.beans.BeansException ;
import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;
import org.springframework.context.ApplicationContext ;
import org.springframework.context.ApplicationContextAware ;

import com.sandy.capitalyst.eris.core.config.ErisConfig ;
import com.sandy.common.bus.EventBus ;

@SpringBootApplication
public class Eris implements ApplicationContextAware {

    static final Logger log = Logger.getLogger( Eris.class ) ;
    
    private static ApplicationContext APP_CTX   = null ;
    private static Eris   APP       = null ;
    
    public static EventBus GLOBAL_EVENT_BUS = new EventBus() ;
    
    public static ApplicationContext getAppContext() {
        return APP_CTX ;
    }

    public static ErisConfig getConfig() {
        if( APP_CTX == null ) return null ;
        return (ErisConfig) APP_CTX.getBean( "config" ) ;
    }
    
    public static <T> T getBean( Class<T> type ) {
        return APP_CTX.getBean( type ) ;
    }

    public static Eris getApp() {
        return APP ;
    }
    
    // ---------------- Instance methods start ------------------------------
    public Eris() {
        APP = this ;
    }
    
    public void initialize() throws Exception {
    }
    
    @Override
    public void setApplicationContext( ApplicationContext applicationContext )
            throws BeansException {
        APP_CTX = applicationContext ;
    }

    // --------------------- Main method ---------------------------------------

    public static void main( String[] args ) throws Exception {
        
        long startTime = System.currentTimeMillis() ;
        log.debug( "Starting Spring Booot..." ) ;
        SpringApplication.run( Eris.class, args ) ;

        log.debug( "Starting Eris.." ) ;
        Eris app = Eris.getAppContext().getBean( Eris.class ) ;
        app.initialize() ;
        long endTime = System.currentTimeMillis() ;
        
        int timeTaken = (int)(( endTime - startTime )/1000) ;
        
        log.debug( "" ) ;
        log.debug( "Eris open for business. "  + 
                   "Boot time = " + timeTaken + " secs." ) ;
        log.debug( "" ) ;
    }
}
