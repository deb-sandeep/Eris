package com.sandy.capitalyst.eris.dao.index.repo;

import com.sandy.capitalyst.eris.dao.ReadOnlyRepository ;
import com.sandy.capitalyst.eris.dao.index.HistoricIdxDataMeta ;
import com.sandy.capitalyst.eris.dao.index.IndexMaster ;

public interface HistoricIdxDataMetaRepo 
    extends ReadOnlyRepository<HistoricIdxDataMeta, Integer> {

    public HistoricIdxDataMeta findByIndex( IndexMaster im ) ;
}
