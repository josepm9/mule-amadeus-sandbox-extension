package es.jpm.mule.extensions.amadeus.internal.operations;

import es.jpm.mule.extensions.amadeus.internal.ApiFactory;
import es.jpm.mule.extensions.amadeus.internal.config.AmadeusTravelInnovationSandboxConfig;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.TravelRecordResponse;
import org.mule.runtime.api.exception.MuleRuntimeException;
import org.mule.runtime.api.i18n.I18nMessageFactory;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Travel Record")
public class TravelRecord {

    final Logger logger = LoggerFactory.getLogger(TravelRecord.class);

    private final DefaultApi api = ApiFactory.api();

    /**
     * Travel Record Retrieve - Enable travelers to explore the details of their journeys stored in the Amadeus system using our Retrieve Travel Record API.<br/>
     * Note: This API requires the use of HTTPS. This service retrieves a travel record (also sometimes referred to as a PNR) for a given journey when provided with Record Locator to identify a travel record, along with the last name of any traveler who is marked as a passenger on this record. The API provides detailed information on a given record, including any air, car, hotel or rail reservations, as well as passenger details, and contact frequent traveler information for each passenger when available. You can use this to provide a wide variety of pre-trip or in-trip services. Note that this API transmits sensitive personal data about a traveler's journey. We work hard to ensure that we comply with all the legal requirements this entails, and as an application owner, you need to do so too - we don't want you to get in trouble! This paragraph, or anything else in our documentation, does not constitute legal advice, it's just to give you an idea of some of the potential issues that you may encounter. Please check your legal obligations regarding the use of this data before implementing this API. In most countries, the data in the returned travel record is considered to be the property of the traveler. In order to ensure that you are acting on behalf of the traveler, we require you to provide the traveler's last name in addition to the record locator when you make a call to this API. You should ensure that you have consent from the traveler before retrieving this record, in some countries this is a legal requirement - please respect this appropriately. Our data center is based in Europe, so there is a legal requirement that you to access this API over a secure connection. If you plan to store the information returned by this API, ensure you comply with storage requirements for European data, in addition to those of your local country. For example, there are strict requirements on the caching of retrieved travel records, so please ensure the cache control HTTP headers in the response are respected.
     *
     * @param recordLocator The Amadeus identifier of the given travel record. Usually printed at the top of an itinerary or boarding pass. (required)
     * @param lastName      The last name of any traveler in this record, as written on their identification used for travel. This is required to ensure that applications retrieving the record are acting on behalf of the customer. (required)
     * @param env           Indicates the Amadeus system from which this record should be retrieved. (optional, default to TEST)
     * @return TravelRecordResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Travel Record - Travel Record Retrieve")
    @Alias("travelRecordRetrieve")
    @Summary("Travel Record Retrieve - Enable travelers to explore the details of their journeys stored in the Amadeus system using our Retrieve Travel Record API.")
    public TravelRecordResponse travelRecordRetrieve(
        @DisplayName("Record locator") @Alias("recordLocator") @Summary("The Amadeus identifier of the given travel record. Usually printed at the top of an itinerary or boarding pass. (required)") String recordLocator,
        @DisplayName("Last name") @Alias("lastName") @Summary("The last name of any traveler in this record, as written on their identification used for travel. This is required to ensure that applications retrieving the record are acting on behalf of the customer. (required)") String lastName,
        @DisplayName("Environment") @Alias("env") @Summary("Indicates the Amadeus system from which this record should be retrieved. (optional, default to TEST)") @Optional() String env,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.travelRecordRetrieve(config.getApikey(), recordLocator, lastName, env);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

}