package com.sandy.capitalyst.eris.dao.nvp.repo;

import java.util.List ;

import org.springframework.data.jpa.repository.JpaRepository ;

import com.sandy.capitalyst.eris.dao.nvp.NVP ;

public interface NVPRepo extends JpaRepository<NVP, Integer> {
    
    public List<NVP> findByGroupName( String groupName ) ;
    
    public List<NVP> findByConfigName( String configName ) ;

    public NVP findByGroupNameAndConfigName( String groupName, 
                                             String configName ) ;
}
