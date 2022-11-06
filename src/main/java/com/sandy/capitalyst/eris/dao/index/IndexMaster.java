package com.sandy.capitalyst.eris.dao.index ;

import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Table ;

import lombok.Data ;

@Data
@Entity
@Table( name = "index_master" )
public class IndexMaster {
    
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Integer id = null ;
    
    private String name = null ;
    private Boolean histEnabled = Boolean.FALSE ;
    private String type = null ;
    private String includedStocksUrl = null ;
    private String description = null ;
}