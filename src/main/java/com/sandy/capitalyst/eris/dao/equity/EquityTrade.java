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
@Table( name = "equity_trade" )
public class EquityTrade {

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Integer id = null ;
    
    private String ownerName   = null ;
    private int    holdingId   = 0 ;
    private Date   tradeDate   = null ;
    private String symbolIcici = null ;
    private String action      = null ;
    private int    quantity    = 0 ;
    private String orderId     = null ;
    
    @Column( precision=16, scale=2 )
    private float valueAtCost = 0.0f ;
    
    @Column( precision=16, scale=2 )
    private float brokerage = 0.0f ;
    
    @Column( precision=16, scale=2 )
    private float tax = 0.0f ;
    
    public EquityTrade() {}
    
    public String toString() {
        
        StringBuilder builder = new StringBuilder( "EquityTxn [\n" ) ; 
        
        builder.append( "   id         = " + id         + "\n" ) ;
        builder.append( "   ownerName  = " + ownerName  + "\n" ) ;
        builder.append( "   holdingId  = " + holdingId  + "\n" ) ;
        builder.append( "   tradeDate  = " + tradeDate  + "\n" ) ;
        builder.append( "   symbolIcici= " + symbolIcici+ "\n" ) ;
        builder.append( "   action     = " + action     + "\n" ) ;
        builder.append( "   quantity   = " + quantity   + "\n" ) ;
        builder.append( "   orderId    = " + orderId    + "\n" ) ;
        builder.append( "   valueAtCost= " + valueAtCost+ "\n" ) ;
        builder.append( "   brokerage  = " + brokerage  + "\n" ) ;
        builder.append( "   tax        = " + tax        + "\n" ) ;
        builder.append( "]" ) ;

        return builder.toString() ;
    }
}