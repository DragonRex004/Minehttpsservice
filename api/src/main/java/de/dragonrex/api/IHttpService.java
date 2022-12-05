package de.dragonrex.api;

import de.dragonrex.api.configuration.IMineConfiguration;

/**
 * @created 05/12/2022 - 22:26
 * @project httpservice
 * @author  Dragonrex
 */

public interface IHttpService {

    void setup(IMineConfiguration configuration);

    void start(int port);

    void stop(int code);
}
