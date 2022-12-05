package de.dragonrex.api.exceptions;

import java.io.IOException;
import java.io.Serial;

/**
 * @created 05/12/2022 - 22:26
 * @project httpservice
 * @author  Dragonrex
 */

public class WrongFileEndingException extends IOException {
    @Serial
    private static final long serialVersionUID = -5648569655486465456L;

    public WrongFileEndingException() {
        super();
    }

    public WrongFileEndingException(String s) {
        super(s);
    }
}
