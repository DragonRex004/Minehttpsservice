package de.dragonrex.api.configuration;

import de.dragonrex.api.exceptions.WrongFileEndingException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @created 05/12/2022 - 22:28
 * @project httpservice
 * @author  Dragonrex
 */

public interface IMineConfiguration {

    void read(InputStream inputStream) throws FileNotFoundException, WrongFileEndingException;

    void read(Reader reader);

    void read(BufferedReader bufferedReader);

    void store();
}
