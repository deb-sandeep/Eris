package com.sandy.capitalyst.eris.dao.equity.repo;

import com.sandy.capitalyst.eris.dao.ReadOnlyRepository ;
import com.sandy.capitalyst.eris.dao.equity.EquityMaster ;

public interface EquityMasterRepo 
    extends ReadOnlyRepository<EquityMaster, Integer> {
    
    public EquityMaster findByIsin( String isin ) ;
    
    public EquityMaster findBySymbol( String symbol ) ;
    
    public EquityMaster findBySymbolIcici( String symbolIcici ) ;
}
