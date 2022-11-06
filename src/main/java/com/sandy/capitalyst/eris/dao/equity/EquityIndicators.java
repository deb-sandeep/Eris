package com.sandy.capitalyst.eris.dao.equity;

import java.util.Date ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Table ;

import lombok.Data ;

@Data
@Entity
@Table( name = "equity_indicators" )
public class EquityIndicators {

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Integer id = null ;
    
    private String isin           = null ;
    private String symbolNse      = null ;
    private String sector         = null ;
    private float  beta           = 0 ;
    private float  high52         = 0 ;
    private float  low52          = 0 ;
    private float  eps            = 0 ;
    private float  pe             = 0 ;
    private float  pb             = 0 ;
    private float  dividendYeild  = 0 ;
    private float  cagrRevenue    = 0 ;
    private float  cagrNetProfit  = 0 ;
    private float  cagrEbit       = 0 ;    
    private int    marketCap      = 0 ;
    private int    piotroskiScore = 0 ;
    private float  currentPrice   = 0 ;
    private Date   asOnDate       = null ;
    
    private float sma5   = 0 ;
    private float sma10  = 0 ;
    private float sma20  = 0 ;
    private float sma50  = 0 ;
    private float sma100 = 0 ;
    private float sma200 = 0 ;
    
    @Column( name = "sector_pe" )
    private float sectorPE = 0 ;

    @Column( name = "price_perf_1d" )
    private Float pricePerf1D = null ;

    @Column( name = "price_perf_1w" )
    private float pricePerf1W = 0 ;

    @Column( name = "price_perf_1m" )
    private float pricePerf1M = 0 ;

    @Column( name = "price_perf_3m" )
    private float pricePerf3M = 0 ;

    @Column( name = "price_perf_1y" )
    private float pricePerf1Y = 0 ;

    @Column( name = "price_perf_3y" )
    private float pricePerf3Y = 0 ;

    @Column( name = "price_perf_ytd" )
    private float pricePerfYTD = 0 ;
    
    private String trend = null ;
    private String prevTrend = null ;
    private int    mcEssentialScore = 0 ;
    private String mcInsightShort = null ;
    private String mcInsightLong = null ;
    
    private int communitySentimentBuy  = 0 ;
    private int communitySentimentSell = 0 ;
    private int communitySentimentHold = 0 ;
    
    public EquityIndicators() {}
}