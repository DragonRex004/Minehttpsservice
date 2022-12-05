package de.dragonrex.api.language;

import de.dragonrex.api.exceptions.FilesNotFoundException;
import de.dragonrex.api.exceptions.WrongFileEndingException;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @created 05/12/2022 - 22:26
 * @project httpservice
 * @author  Dragonrex
 */

public interface ILanguageConverter {

    void convertWithSelectedLang(String lang) throws FilesNotFoundException, WrongFileEndingException, FileNotFoundException;

    String getConvertedString(String key);

    String getSelectedLang();

    File getLangFolder();
}
