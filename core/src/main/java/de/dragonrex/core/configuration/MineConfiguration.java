package de.dragonrex.core.configuration;

import de.dragonrex.api.configuration.IMineConfiguration;
import de.dragonrex.api.exceptions.WrongFileEndingException;

import java.io.*;
import java.nio.file.Path;
import java.util.Properties;

/**
 * @created 05/12/2022 - 22:26
 * @project httpservice
 * @author  Dragonrex
 */

public class MineConfiguration implements IMineConfiguration {
    private Properties properties;
    private String fileName;
    private Path filePath;

    public MineConfiguration(Path filePath) {
        this.filePath = filePath;
        this.fileName = filePath.getFileName().toString();
    }

    @Override
    public void read(InputStream inputStream) throws FileNotFoundException, WrongFileEndingException {
        File file = new File(this.filePath.toFile().toURI());
        if(!file.exists())
            throw new FileNotFoundException("The File is not Found");

        if(!file.getName().endsWith(".lex"))
            throw new WrongFileEndingException("The selected File has a wrong File Ending. The only supported File Ending is .lex Please use it!");

        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            this.properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void read(Reader reader) {

    }

    @Override
    public void read(BufferedReader bufferedReader) {

    }

    @Override
    public void store() {

    }
}
