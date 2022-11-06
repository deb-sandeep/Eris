package com.sandy.capitalyst.eris.core.log;

public class ErisConsoleLogLayout extends ErisLogLayout {

    public static String MDC_KEY = "ErisConsoleLogLayout-MDCKey" ;

    public ErisConsoleLogLayout() {
        super( MDC_KEY ) ;
    }
}
