package com.sandy.capitalyst.eris.dao.equity.repo;

import java.util.Date ;
import java.util.List ;

import org.springframework.data.jpa.repository.Query ;
import org.springframework.data.repository.query.Param ;

import com.sandy.capitalyst.eris.dao.ReadOnlyRepository ;
import com.sandy.capitalyst.eris.dao.equity.HistoricEQData ;

public interface HistoricEQDataRepo 
    extends ReadOnlyRepository<HistoricEQData, Integer> {
    
    @Query( nativeQuery = true,
            value = 
            "SELECT date "
          + "FROM historic_eq_data h "
          + "WHERE "
          + "   symbol = 'NIFTYBEES' "
          + "ORDER BY "
          + "   date DESC "
          + "LIMIT 1 "
    )
    Date findLatestRecordDate() ;
    
    List<HistoricEQData> findBySymbolAndDate( String symbol, Date date ) ;
    
    @Query( nativeQuery = true,
            value = 
              "SELECT "
            + "    * "
            + "FROM "
            + "    historic_eq_data "
            + "WHERE "
            + "    date = ( "
            + "       SELECT date "
            + "       FROM historic_eq_data "
            + "       WHERE date > :date "
            + "       ORDER BY date ASC "
            + "       LIMIT 1 "
            + "    ) "
            + "ORDER BY "
            + "    symbol ASC"
    )
    List<HistoricEQData> getHistoricDataClosestInFutureToDate( @Param("date") Date date ) ;
    
    @Query( nativeQuery = true,
            value = 
              "SELECT "
            + "    * "
            + "FROM "
            + "    historic_eq_data "
            + "WHERE "
            + "    date = ( "
            + "       SELECT date "
            + "       FROM historic_eq_data "
            + "       WHERE date <= :date "
            + "       ORDER BY date DESC "
            + "       LIMIT 1 "
            + "    ) "
            + "ORDER BY "
            + "    symbol ASC"
    )
    List<HistoricEQData> getHistoricDataClosestInPastToDate( @Param("date") Date date ) ;
    
    @Query( nativeQuery = true,
            value = 
            "SELECT * "
          + "FROM historic_eq_data "
          + "WHERE symbol = :symbol "
          + "ORDER BY date ASC "
          + "LIMIT 1 "
    )
    HistoricEQData getEarliestRecord( @Param("symbol") String symbol ) ;
    
    @Query( value = 
            "SELECT h "
          + "FROM HistoricEQData h "
          + "WHERE "
          + "   h.symbol = :symbol AND "
          + "   h.date BETWEEN :fromDate AND :toDate "
          + "ORDER BY "
          + "   h.date ASC "
    )
    List<HistoricEQData> getHistoricData( @Param( "symbol"   ) String symbol,
                                          @Param( "fromDate" ) Date fromDate,
                                          @Param( "toDate"   ) Date toDate ) ;
    
    @Query( value = 
            "SELECT COUNT(h) "
          + "FROM HistoricEQData h "
          + "WHERE "
          + "   h.symbol = :symbol "
    )
    int getNumRecords( @Param( "symbol" ) String symbol ) ;
}
