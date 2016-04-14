package com.bornstone.stonehenge.core.filesystem;

/**
 * Created by King.Tang on 14-6-4.
 */
public interface IFileNameGenerator<F> {
    String generate(F originalFile);
}
