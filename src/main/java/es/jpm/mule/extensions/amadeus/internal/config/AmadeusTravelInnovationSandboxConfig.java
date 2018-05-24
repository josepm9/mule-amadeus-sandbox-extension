package es.jpm.mule.extensions.amadeus.internal.config;

import es.jpm.mule.extensions.amadeus.internal.operations.*;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.Configuration;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.Sources;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.RefName;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Operations({ CarShopping.class, Flights.class, HotelShopping.class, Poi.class, RailAndTrain.class,
    TravelIntelligence.class, TravelRecord.class })
@Sources({})
@ConnectionProviders({})
@Configuration(name = "config")
@DisplayName(value = "Config")
public class AmadeusTravelInnovationSandboxConfig {

    private static final Logger logger = LoggerFactory.getLogger(AmadeusTravelInnovationSandboxConfig.class);

    @RefName
    private String name;

    @Parameter
    @DisplayName("API Key")
    @Alias("apikey")
    private String apikey;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
