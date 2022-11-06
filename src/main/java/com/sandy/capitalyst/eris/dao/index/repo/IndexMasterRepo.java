package com.sandy.capitalyst.eris.dao.index.repo;

import java.util.List ;

import org.springframework.data.jpa.repository.Query ;

import com.sandy.capitalyst.eris.dao.ReadOnlyRepository ;
import com.sandy.capitalyst.eris.dao.index.IndexMaster ;

public interface IndexMasterRepo 
    extends ReadOnlyRepository<IndexMaster, Integer> {
    
    public IndexMaster findByName( String name ) ;
    
    @Query( value =   
        "SELECT "
      + "    im "
      + "FROM "
      + "    IndexMaster im "
      + "WHERE "
      + "    im.histEnabled = TRUE "
      + "ORDER BY "
      + "    im.id ASC "
    )
    public List<IndexMaster> findEodEnabledIndexes() ;
}
