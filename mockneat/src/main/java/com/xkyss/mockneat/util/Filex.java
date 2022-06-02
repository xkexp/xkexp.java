package com.xkyss.mockneat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class Filex {
    private static final Map<String, List<String>> MAP = new HashMap();

    private static final Filex filex = new Filex();
    private static final ClassLoader loader = Thread.currentThread().getContextClassLoader();

    public static Filex getInstance() {
        return filex;
    }

    public Filex() {

    }

    public List<String> getLines(String path) {
        if (!MAP.containsKey(path)) {
            try {
                List<String> lines = this.readSource(path);
                MAP.put(path, lines);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

        return (List)MAP.get(path);
    }

    public List<String> readSource(String internal) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader((InputStream) Objects.requireNonNull(loader.getResourceAsStream(internal)), Charset.defaultCharset()));

        List ret;
        try {
            ret = (List)buff.lines().collect(Collectors.toList());
        } catch (Throwable e) {
            try {
                buff.close();
            } catch (Throwable e1) {
                e.addSuppressed(e1);
            }

            throw e;
        }

        buff.close();
        return ret;
    }
}
