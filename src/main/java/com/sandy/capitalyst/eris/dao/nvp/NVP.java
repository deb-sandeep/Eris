package com.sandy.capitalyst.eris.dao.nvp;

import java.text.ParseException ;
import java.text.SimpleDateFormat ;
import java.util.ArrayList ;
import java.util.Date ;

import javax.persistence.Entity ;
import javax.persistence.EntityListeners ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Table ;

import com.fasterxml.jackson.annotation.JsonIgnore ;
import com.sandy.capitalyst.eris.core.nvpconfig.NVPManager.NVPPersistCallback ;
import com.sandy.common.util.StringUtil ;

import lombok.Data ;

@Data
@Entity
@EntityListeners( NVPPersistCallback.class )
@Table( name = "nvp" )
public class NVP {
    
    public static final SimpleDateFormat SDF = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ) ;

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Integer id = null ;
    
    private String groupName = null ;
    private String configName  = null ;
    private String value = null ;
    private String description = null ;
    
    public NVP() {}
    
    public NVP( String name, String value ) {
        this( null, name, value ) ;
    }
    
    public NVP( String group, String name, String value ) {
        this.groupName  = group ;
        this.configName = name ;
        this.value      = value ;
    }
    
    @JsonIgnore
    public Integer getIntValue() {
        return Integer.valueOf( value ) ;
    }
    
    @JsonIgnore
    public Boolean getBooleanValue() {
        return Boolean.valueOf( value ) ;
    }
    
    public void setValue( Integer i ) {
        this.value = i.toString() ;
    }
    
    public void setValue( Boolean b ) {
        this.value = b.toString() ;
    }
    
    @JsonIgnore
    public Date getDateValue() {
        try {
            return SDF.parse( value ) ;
        }
        catch( ParseException e ) {
            e.printStackTrace() ;
        }
        return null ;
    }
    
    public void setValue( Date date ) {
        this.value = SDF.format( date ) ;
    }
    
    public void setValue( String[] values ) {
        this.value = String.join( ",", values ) ;
    }
    
    @JsonIgnore
    public String[] getArrayValue() {
        
        ArrayList<String> valuesList = new ArrayList<>() ;
        for( String val : this.value.split( "," ) ) {
            if( StringUtil.isNotEmptyOrNull( val ) ) {
                valuesList.add( val.trim() ) ;
            }
        }
        return valuesList.toArray( new String[valuesList.size()] ) ;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder( "NVP [\n" ) ; 
        builder.append( "   group = " + this.groupName   + "\n" ) ;
        builder.append( "   name  = " + this.configName  + "\n" ) ;
        builder.append( "   value = " + this.value       + "\n" ) ;
        builder.append( "   desc  = " + this.description + "\n" ) ;
        builder.append( "]" ) ;
        return builder.toString() ;
    }
}

