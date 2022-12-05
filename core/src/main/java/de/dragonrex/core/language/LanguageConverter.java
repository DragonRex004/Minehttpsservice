package de.dragonrex.core.language;

import de.dragonrex.api.exceptions.FilesNotFoundException;
import de.dragonrex.api.exceptions.WrongFileEndingException;
import de.dragonrex.api.language.ILanguageConverter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @created 05/12/2022 - 22:26
 * @project httpservice
 * @author  Dragonrex
 */

public class LanguageConverter implements ILanguageConverter {
    private final File langFolder = new File("lang");
    private final String selectedLang;
    private Properties propertiesFile;

    public LanguageConverter(String selectedLang) {
        this.selectedLang = selectedLang;
        try {
            convertWithSelectedLang(this.selectedLang);
        } catch (FilesNotFoundException | WrongFileEndingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void convertWithSelectedLang(String lang) throws FilesNotFoundException, WrongFileEndingException, FileNotFoundException {
        if(!langFolder.exists())
            langFolder.mkdirs();

        if(langFolder.listFiles() == null)
            throw new FilesNotFoundException("You have no Lang Files in the lang Folder");

        propertiesFile = new Properties();

        File langFile = new File(langFolder, selectedLang);

        if(!langFile.getName().endsWith(".lang"))
            throw new WrongFileEndingException("You use the wrong File Ending for the Lang Files. The Supported File Ending is .lang Please use it!");

        if(!langFile.exists())
            throw new FileNotFoundException("The targeted File doesn't exists!");

        try (BufferedReader reader = new BufferedReader(new FileReader(langFile, StandardCharsets.UTF_8))) {
            propertiesFile.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getConvertedString(String key) {
        return propertiesFile.getProperty(key);
    }

    @Override
    public String getSelectedLang() {
        return selectedLang;
    }

    @Override
    public File getLangFolder() {
        return langFolder;
    }
}
