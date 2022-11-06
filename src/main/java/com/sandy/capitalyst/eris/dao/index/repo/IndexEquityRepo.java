package com.sandy.capitalyst.eris.dao.index.repo;

import java.util.List ;

import org.springframework.data.jpa.repository.Query ;
import org.springframework.data.repository.query.Param ;

import com.sandy.capitalyst.eris.dao.ReadOnlyRepository ;
import com.sandy.capitalyst.eris.dao.equity.EquityMaster ;
import com.sandy.capitalyst.eris.dao.index.IndexEquity ;
import com.sandy.capitalyst.eris.dao.index.IndexMaster ;

public interface IndexEquityRepo 
    extends ReadOnlyRepository<IndexEquity, Integer> {
    
    public List<IndexEquity> findByIdxMaster( IndexMaster idxMaster ) ;

    @Query( value =   
            "SELECT "
          + "    ie.eqMaster "
          + "FROM "
          + "    IndexEquity ie "
          + "WHERE "
          + "    ie.idxMaster.name = :idxName "
          + "ORDER BY "
          + "    ie.eqMaster.symbol ASC "
    )
    public List<EquityMaster> findByIndex( @Param( "idxName" ) String idxName ) ;

    @Query( nativeQuery = true,
            value =   
            "SELECT "
          + "    ie.equity_symbol "
          + "FROM "
          + "    index_equities ie "
          + "WHERE "
          + "    ie.idx_name = :idxName "
          + "ORDER BY "
          + "    ie.equity_symbol ASC "
    )
    public List<String> findEquitiesForIndex( @Param( "idxName" ) String idxName ) ;
}
