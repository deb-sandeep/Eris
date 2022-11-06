package com.sandy.capitalyst.eris.core.log;

public class ErisFileLogLayout extends ErisLogLayout {
    
    public static String MDC_KEY = "ErisFileLogLayout-MDCKey" ;

    public ErisFileLogLayout() {
        super( MDC_KEY ) ;
    }
}
