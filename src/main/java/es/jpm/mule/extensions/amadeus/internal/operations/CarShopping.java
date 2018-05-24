package es.jpm.mule.extensions.amadeus.internal.operations;

import es.jpm.mule.extensions.amadeus.internal.ApiFactory;
import es.jpm.mule.extensions.amadeus.internal.config.AmadeusTravelInnovationSandboxConfig;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.CarSearchResponse;
import org.mule.runtime.api.exception.MuleRuntimeException;
import org.mule.runtime.api.i18n.I18nMessageFactory;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

@DisplayName("Car Shopping")
public class CarShopping {

    final Logger logger = LoggerFactory.getLogger(CarShopping.class);

    private final DefaultApi api = ApiFactory.api();

    /**
     * Car Rental Airport Search - Find car rental providers and rates when you provide an airport code, as well as the pick-up and drop-off dates. Optional parameters such as currency and rental provider codes are also available and can be used to narrow down the results. This API is an ideal pairing with the flight and hotel search to provide ground transportation options at the destination.<br/>
     * With this API you can find out the price and type of car, for all car rental providers, near a specified airport. You can quickly see the locations of car providers near a given airport, and what cars are available to rent, and at what prices. This API is based on our car pricing service that gets live availability from car providers, and is used to power a variety of airline and travel agency websites. Results are validated from car providers, and thus response times may take up to 10 seconds (response times are typically about 5s), and the number of concurrent calls is throttled per user to avoid flooding our provider's systems. However, this means the final result is guaranteed to be live and accurate. The configuration of this API allows search for car rentals in the rental location where the car is picked up (at the start of the rental), is the same as the one where it will be dropped off.
     * @param location The &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the airport at which the car will be rented. (required)
     * @param pickUp Date on which the car rental will be collected from the car rental location. If no time is provided, a default value of 09:00 is used. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)
     * @param dropOff Date at which the car rental will end and the car will be returned to the rental location. If no time is provided, a default value of 17:00 is used. (required)
     * @param lang The preferred language of the content related to each car rental. Content will be returned in this language if available. (optional, default to EN)
     * @param currency The preferred &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_4217\&quot;&gt;currency&lt;/a&gt; to use when displaying prices and rates related to the car rental. (optional, default to USD)
     * @param provider 2 character car rental provider code. You may provide this parameter more than once.  (optional, default to ZI)
     * @param rateClass Allows to request specific rate types. (optional, default to ALL)
     * @param ratePlan Qualifies the rate depending on the pickup date and the rental duration. (optional, default to DAILY)
     * @param rateFilter Defines the types of rates to be returned in the output (optional, default to ESTIMATED)
     * @param vehicles Specifies the type of vehicle to be rented. If selected, the results set will include only vehicles that match these type descriptions. The enumerations above correspond to ACRISS Pseudo Codes, and you may also provide an ACRISS pseudo code directly. If specifying a vehicle-specific ACRISS code, you may provide this parameter up to 3 times. (optional)
     * @return CarSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Car Shopping - Car Rental Airport Search")
    @Alias("carRentalAirportSearch")
    @Summary("Car Rental Airport Search - Find car rental providers and rates when you provide an airport code, as well as the pick-up and drop-off dates.")
    public final CarSearchResponse carRentalAirportSearch(
        @DisplayName("Location") @Alias("location") @Summary("The IATA code of the airport at which the car will be rented.") String location,
        @DisplayName("Pick up date") @Alias("pickUp") @Summary("Date on which the car rental will be collected from the car rental location. If no time is provided, a default value of 09:00 is used.") String pickUp,
        @DisplayName("Drop off date") @Alias("dropOff") @Summary("Date at which the car rental will end and the car will be returned to the rental location. If no time is provided, a default value of 17:00 is used.") String dropOff,
        @DisplayName("Language") @Alias("lang") @Summary("he preferred language of the content related to each car rental. Content will be returned in this language if available.") @Optional(defaultValue = "EN") String lang,
        @DisplayName("Currency") @Alias("currency") @Summary("The preferred currency to use when displaying prices and rates related to the car rental.") @Optional(defaultValue = "USD") String currency,
        @DisplayName("Provider") @Alias("provider") @Summary("2 character car rental provider code. You may provide this parameter more than once.") @Optional(defaultValue = "ZI") String provider,
        @DisplayName("Rate class") @Alias("rateClass") @Summary("Allows to request specific rate types.") @Optional(defaultValue = "ALL") String rateClass,
        @DisplayName("Rate plan") @Alias("ratePlan") @Summary("Qualifies the rate depending on the pickup date and the rental duration.") @Optional(defaultValue = "DAILY") String ratePlan,
        @DisplayName("Rate filter") @Alias("rateFilter") @Summary("Defines the types of rates to be returned in the output") @Optional(defaultValue = "ESTIMATED") String rateFilter,
        @DisplayName("Vehicles") @Alias("vehicles") @Summary("Specifies the type of vehicle to be rented. The enumerations above correspond to ACRISS Pseudo Codes.") @Optional List<String> vehicles,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.carRentalAirportSearch(config
                .getApikey(), location, pickUp, dropOff, lang, currency, provider, rateClass, ratePlan, rateFilter, vehicles);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Car Rental Geosearch - Locate car rental providers and available vehicles when you define a circular area with one coordinate and radius, as well as the pick-up and drop-off dates. Optional parameters such as currency and rental provider codes are also available and can be used to narrow down the results. This API is an ideal pairing with the flight and hotel search to provide ground transportation options at the destination.<br/>
     *  With this API you can find out the price and type of car, for all car rental providers, in a specified geographical location. You can quickly see the locations of car providers near a given point, and what cars are available to rent, and at what prices. This API is based on our car pricing service that gets live availability from car providers, and is used to power a variety of airline and travel agency websites. Results are validated from car providers, and thus response times may take up to 10 seconds (response times are typically about 5s), and the number of concurrent calls is throttled per user to avoid flooding our provider's systems. However, this means the final result is guaranteed to be live and accurate. The configuration of this API allows search for car rentals in the rental location where the car is picked up (at the start of the rental), is the same as the one where it will be dropped off.
     * @param latitude Latitude of the center of the search. (required)
     * @param longitude Longitude of the center of the search. (required)
     * @param radius Radius around the center to look for hotels in kilometers (km). (required)
     * @param pickUp Date on which the car rental will be collected from the car rental location. If no time is provided, a default value of 09:00 is used. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)
     * @param dropOff Date at which the car rental will end and the car will be returned to the rental location. If no time is provided, a default value of 17:00 is used. (required)
     * @param lang The preferred language of the content related to each car rental. Content will be returned in this language if available. (optional, default to EN)
     * @param currency The preferred &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_4217\&quot;&gt;currency&lt;/a&gt; to use when displaying prices and rates related to the car rental. (optional, default to USD)
     * @param provider 2 character car rental provider code. You may provide this parameter more than once.  (optional, default to ZI)
     * @param rateClass Allows to request specific rate types. (optional, default to ALL)
     * @param ratePlan Qualifies the rate depending on the pickup date and the rental duration. (optional, default to DAILY)
     * @param rateFilter Defines the types of rates to be returned in the output (optional, default to ESTIMATED)
     * @param vehicles Specifies the type of vehicle to be rented. If selected, the results set will include only vehicles that match these type descriptions. The enumerations above correspond to ACRISS Pseudo Codes, and you may also provide an ACRISS pseudo code directly. If specifying a vehicle-specific ACRISS code, you may provide this parameter up to 3 times. (optional)
     * @return CarSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Car Shopping - Car Rental Geosearch")
    @Alias("carRentalGeosearch")
    @Summary("Car Rental Geosearch - Locate car rental providers and available vehicles when you define a circular area with one coordinate and radius, as well as the pick-up and drop-off dates.")
    public final CarSearchResponse carRentalGeosearch(
        @DisplayName("latitude") @Alias("latitude") BigDecimal latitude,
        @DisplayName("longitude") @Alias("longitude") BigDecimal longitude,
        @DisplayName("radius") @Alias("radius") Integer radius,
        @DisplayName("pickUp") @Alias("pickUp") String pickUp,
        @DisplayName("dropOff") @Alias("dropOff") String dropOff,
        @DisplayName("lang") @Alias("lang") @Optional String lang,
        @DisplayName("currency") @Alias("currency") @Optional String currency,
        @DisplayName("provider") @Alias("provider") @Optional String provider,
        @DisplayName("rateClass") @Alias("rateClass") @Optional String rateClass,
        @DisplayName("ratePlan") @Alias("ratePlan") @Optional String ratePlan,
        @DisplayName("rateFilter") @Alias("rateFilter") @Optional String rateFilter,
        @DisplayName("vehicles") @Alias("vehicles") @Optional List<String> vehicles,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.carRentalGeosearch(config
                .getApikey(), latitude, longitude, radius, pickUp, dropOff, lang, currency, provider, rateClass, ratePlan, rateFilter, vehicles);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

}