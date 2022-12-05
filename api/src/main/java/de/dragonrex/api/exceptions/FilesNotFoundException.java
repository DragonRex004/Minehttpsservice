package de.dragonrex.api.exceptions;

import java.io.IOException;

/**
 * @created 05/12/2022 - 22:26
 * @project httpservice
 * @author  Dragonrex
 */

public class FilesNotFoundException extends IOException {
    @java.io.Serial
    private static final long serialVersionUID = -7657640878756756233L;

    public FilesNotFoundException() {
        super();
    }

    public FilesNotFoundException(String s) {
        super(s);
    }
}
