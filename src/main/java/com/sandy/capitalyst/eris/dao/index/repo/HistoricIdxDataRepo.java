package com.sandy.capitalyst.eris.dao.index.repo;

import java.util.Date ;

import org.springframework.data.jpa.repository.Query ;
import org.springframework.data.repository.query.Param ;

import com.sandy.capitalyst.eris.dao.ReadOnlyRepository ;
import com.sandy.capitalyst.eris.dao.index.HistoricIdxData ;
import com.sandy.capitalyst.eris.dao.index.IndexMaster ;

public interface HistoricIdxDataRepo 
    extends ReadOnlyRepository<HistoricIdxData, Integer> {
    
    @Query( value = 
            "SELECT COUNT(h) "
          + "FROM HistoricIdxData h "
          + "WHERE "
          + "   h.index = :index "
    )
    int getNumRecords( @Param( "index" ) IndexMaster index ) ;

    @Query( value = 
            "SELECT h "
          + "FROM HistoricIdxData h "
          + "WHERE "
          + "   h.index = :index AND "
          + "   h.date = :date "
          + "ORDER BY "
          + "   h.date ASC "
    )
    HistoricIdxData findByIndexAndDate( @Param( "index" ) IndexMaster index,
                                        @Param( "date" ) Date date ) ;
}
