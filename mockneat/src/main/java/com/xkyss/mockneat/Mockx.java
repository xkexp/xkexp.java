package com.xkyss.mockneat;

import com.xkyss.mockneat.unit.Namex;
import com.xkyss.mockneat.util.Dictx;
import com.xkyss.mockneat.util.Formatterx;
import net.andreinc.mockneat.MockNeat;

/**
 * 入口
 */
public class Mockx extends MockNeat {
    public static Formatterx fmtx() {
        return new Formatterx();
    }

    private final Dictx _dictx;
    private final Namex _names;

    public Mockx() {
        super();
        _dictx = new Dictx(this);
        _names = new Namex(_dictx);
    }

    public Namex namex() {
        return _names;
    }
}
