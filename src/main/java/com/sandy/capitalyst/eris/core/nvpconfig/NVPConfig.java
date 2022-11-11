package com.sandy.capitalyst.eris.core.nvpconfig;

import java.util.Arrays ;
import java.util.Date ;
import java.util.List ;

import com.sandy.capitalyst.eris.Eris ;
import com.sandy.capitalyst.eris.dao.nvp.NVP ;
import com.sandy.capitalyst.eris.dao.nvp.repo.NVPRepo ;

public class NVPConfig {
    
    private NVP nvp = null ;
    private NVPRepo nvpRepo = null ;
    
    NVPConfig( NVP nvp ) {
        this.nvp = nvp ;
        this.nvpRepo = Eris.getBean( NVPRepo.class ) ;
    }
    
    public String getConfigName() {
        return this.nvp.getConfigName() ;
    }
    
    public String getDescription() {
        return this.nvp.getDescription() ;
    }
    
    public String getGroupName() {
        return this.nvp.getGroupName() ;
    }

    public Integer getIntValue() {
        return nvp.getIntValue() ;
    }
    
    public Boolean getBooleanValue() {
        return nvp.getBooleanValue() ;
    }
    
    public boolean isTrue() {
        return getBooleanValue() ;
    }
    
    public Date getDateValue() {
        return nvp.getDateValue() ;
    }
    
    public String[] getArrayValue() {
        return nvp.getArrayValue() ;
    }
    
    public List<String> getListValue() {
        return Arrays.asList( getArrayValue() ) ;
    }
    
    public String getValue() {
        return this.nvp.getValue() ;
    }
    
    public void setValue( Integer i ) {
        nvp.setValue( i ) ;
        save() ;
    }
    
    public void setValue( Boolean b ) {
        nvp.setValue( b ) ;
        save() ;
    }
    
    public void setValue( Date date ) {
        nvp.setValue( date ) ;
        save() ;
    }
    
    public void setValue( String[] values ) {
        nvp.setValue( values ) ;
        save() ;
    }
    
    void save() {
        this.nvpRepo.save( nvp ) ;
    }
}
