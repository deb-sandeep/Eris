package com.sandy.capitalyst.eris.dao.equity.repo;

import java.util.Date ;
import java.util.List ;

import org.springframework.data.jpa.repository.Query ;
import org.springframework.data.repository.query.Param ;

import com.sandy.capitalyst.eris.dao.ReadOnlyRepository ;
import com.sandy.capitalyst.eris.dao.equity.EquityTxn ;

public interface EquityTxnRepo 
    extends ReadOnlyRepository<EquityTxn, Integer> {
    
    List<EquityTxn> findByHoldingIdOrderByTxnDateAscActionAsc( int holdingId ) ;
    
    EquityTxn findByOrderIdAndTradeId( String orderId, String tradeId ) ;
    
    @Query( value =   
            "SELECT "
          + "    et "
          + "FROM "
          + "    EquityTxn et "
          + "WHERE "
          + "    et.action = 'Buy' AND "
          + "    et.holdingId = :holdingId AND "
          + "    et.txnDate BETWEEN :startDate AND :endDate "
          + "ORDER BY "
          + "    et.txnDate ASC "
    )
    List<EquityTxn> findBuyTxns( @Param( "holdingId" ) Integer holdingId,
                                 @Param( "startDate" ) Date startDate,
                                 @Param( "endDate"   ) Date endDate ) ;
    
    @Query( value =   
            "SELECT "
          + "    et "
          + "FROM "
          + "    EquityTxn et "
          + "WHERE "
          + "    et.action = :action AND "
          + "    et.holdingId = :holdingId AND "
          + "    et.quantity = :quantity AND "
          + "    et.txnDate BETWEEN :startDate AND :endDate AND "
          + "    et.orderId IS NULL "
    )
    List<EquityTxn> findMatchingTxns( @Param( "holdingId" ) Integer holdingId,
                                      @Param( "startDate" ) Date startDate,
                                      @Param( "endDate"   ) Date endDate,
                                      @Param( "action"    ) String action,
                                      @Param( "quantity"  ) int quantity ) ;
    
}