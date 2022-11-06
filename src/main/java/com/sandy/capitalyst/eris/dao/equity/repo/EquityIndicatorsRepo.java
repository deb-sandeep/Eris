package com.sandy.capitalyst.eris.dao.equity.repo;

import java.util.List ;

import org.springframework.data.jpa.repository.Query ;

import com.sandy.capitalyst.eris.dao.ReadOnlyRepository ;
import com.sandy.capitalyst.eris.dao.equity.EquityIndicators ;

public interface EquityIndicatorsRepo 
    extends ReadOnlyRepository<EquityIndicators, Integer> {
 
    EquityIndicators findByIsin( String isin ) ;
    
    EquityIndicators findBySymbolNse( String symbolNse ) ;
    
    @Query( value = 
            "SELECT ei.symbolNse "
          + "FROM EquityIndicators ei "
          + "ORDER BY "
          + "   ei.symbolNse ASC "
    )
    List<String> findSymbols() ;
}
