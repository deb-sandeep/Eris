package com.sandy.capitalyst.eris.dao.equity.repo;

import java.util.Date ;
import java.util.List ;

import org.springframework.data.jpa.repository.Query ;
import org.springframework.data.repository.query.Param ;

import com.sandy.capitalyst.eris.dao.ReadOnlyRepository ;
import com.sandy.capitalyst.eris.dao.equity.EquityHolding ;

public interface EquityHoldingRepo 
    extends ReadOnlyRepository<EquityHolding, Integer> {
    
    EquityHolding findByOwnerNameAndSymbolIcici( String ownerName, 
                                                 String symbolIcici ) ;
    
    List<EquityHolding> findByOwnerName( String ownername ) ;
    
    List<EquityHolding> findByIsin( String isin ) ;
    
    List<EquityHolding> findBySymbolNse( String symbolNse ) ;

    List<EquityHolding> findBySymbolIcici( String symbolIcici ) ;
    
    @Query( value =   
            "SELECT "
          + "    eh "
          + "FROM "
          + "    EquityHolding eh "
          + "WHERE "
          + "    eh.quantity >0 "
    )
    List<EquityHolding> findNonZeroHoldings() ;
    
    @Query( value =   
            "SELECT "
          + "    eh "
          + "FROM "
          + "    EquityHolding eh "
          + "WHERE "
          + "    eh.quantity >0 AND "
          + "    eh.symbolNse = :symbolNse "
    )
    List<EquityHolding> findNonZeroHoldingsForNSESymbol( 
                                      @Param( "symbolNse" ) String symbolNse ) ;

    @Query( nativeQuery = true,
            value =   
            "SELECT " +
            "    distinct( txn.holding_id ) " +
            "FROM  " +
            "    equity_txn txn " +
            "WHERE " +
            "    txn.action = 'Sell' AND " +
            "    txn.txn_date BETWEEN :startDate AND :endDate"
    )
    List<Integer> getHoldingsSold( @Param( "startDate" ) Date startDate,
                                   @Param( "endDate"   ) Date endDate ) ;
    
    @Query( nativeQuery = true,
            value =   
            "SELECT " +
            "    distinct( txn.holding_id ) " +
            "FROM  " +
            "    equity_txn txn " +
            "WHERE " +
            "    txn.action = 'Buy' AND " +
            "    txn.txn_date BETWEEN :startDate AND :endDate"
    )
    List<Integer> getHoldingsBought( @Param( "startDate" ) Date startDate,
                                     @Param( "endDate"   ) Date endDate ) ;
}
