package es.jpm.mule.extensions.amadeus.internal;

import io.swagger.client.api.DefaultApi;

/**
 * @author jose
 */
public class ApiFactory {

    private static final DefaultApi api = new DefaultApi();

    private ApiFactory() {
    }

    public static DefaultApi api() {
        return api;
    }

}
