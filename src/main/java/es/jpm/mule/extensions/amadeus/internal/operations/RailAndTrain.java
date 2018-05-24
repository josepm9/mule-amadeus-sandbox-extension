package es.jpm.mule.extensions.amadeus.internal.operations;

import es.jpm.mule.extensions.amadeus.internal.ApiFactory;
import es.jpm.mule.extensions.amadeus.internal.config.AmadeusTravelInnovationSandboxConfig;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.ExtensiveTrainSearchResponse;
import io.swagger.client.model.RailStationAutocompleteResponse;
import io.swagger.client.model.RailStationResponse;
import io.swagger.client.model.TrainScheduleSearchResponse;
import org.mule.runtime.api.exception.MuleRuntimeException;
import org.mule.runtime.api.i18n.I18nMessageFactory;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@DisplayName("Rail & Train")
public class RailAndTrain {

    final Logger logger = LoggerFactory.getLogger(RailAndTrain.class);
    final SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
    private final DefaultApi api = ApiFactory.api();

    /**
     * Train Schedule Search - Suggest destinations from your chosen departure station. Supports SNCF French Rail only.<br/>
     * This API allows you to find all the possible destinations in the Rail Instant Search cache (used by Extensive Search above) from a given origin station on a given day. You can use this to help build network maps, journey planners or provide inspiration for rail travel. This API has continuous content from SNCF (http://www.sncf.com/). All the options returned are single-leg trips - where a single train takes you directly from the origin to the destination. In general, only departure dates up to 90 days in the future are supported. Currently agglomeration stations are not supported.
     *
     * @param origin        Identifier of the rail station where you would like to depart from. (required)
     * @param departureDate The date on which you would like to depart from the origin station to go to the destination. (required)
     * @return TrainScheduleSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Rail & Train - Train Schedule Search")
    @Alias("trainScheduleSearch")
    @Summary("Train Schedule Search - Suggest destinations from your chosen departure station. Supports SNCF French Rail only.")
    public TrainScheduleSearchResponse trainScheduleSearch(
        @DisplayName("Origin") @Alias("origin") @Summary("Identifier of the rail station where you would like to depart from. (required)") String origin,
        @DisplayName("Departure date") @Alias("departureDate") @Summary("The date on which you would like to depart from the origin station to go to the destination. (required)") String departureDate,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.trainScheduleSearch(config.getApikey(), origin,
                departureDate == null ? null : LocalDate.ofEpochDay(dateFmt.parse(departureDate).getTime()));
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        } catch (ParseException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Train Extensive Search - Provides multi-day availability and a variety of schedule and pricing options to travel to your destination instantly. Supports SNCF French trains only.<br/>
     * This API allows you to search trains availability and prices for a single day or date range. It's based on our Rail Instant Search technology, providing you with immediate results from our rail search cache. This API has content from SNCF (French trains). The content is also restricted to single-leg trips - where a single train takes you directly from the origin to the destination.
     *
     * @param origin        Identifier of the rail station from which you would like to depart. (required)
     * @param destination   Identifier of the rail station to which you would like to travel. (required)
     * @param departureDate The date or range of dates on which you would like to depart from the origin station to go to the destination. (required)
     * @return ExtensiveTrainSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Rail & Train - Train Extensive Search")
    @Alias("trainExtensiveSearch")
    @Summary("Train Extensive Search - Provides multi-day availability and a variety of schedule and pricing options to travel to your destination instantly. Supports SNCF French trains only.")
    public ExtensiveTrainSearchResponse trainExtensiveSearch(
        @DisplayName("Origin") @Alias("origin") @Summary("Identifier of the rail station from which you would like to depart. (required)") String origin,
        @DisplayName("Destination") @Alias("destination") @Summary("Identifier of the rail station to which you would like to travel. (required)") String destination,
        @DisplayName("Departure date") @Alias("departureDate") @Summary("The date or range of dates on which you would like to depart from the origin station to go to the destination. (required)") String departureDate,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.trainExtensiveSearch(config.getApikey(), origin, destination, departureDate);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Rail Station Autocomplete - Transform user input into a unique rail station code. Currently only French and Italian stations are supported.<br/>
     * Given the start of any word in a rail station's official name, as a term, this API provides the full name and rail station ID of a rail station for use in searches. The response provides an array of up to 20 possible matches, sorted by passenger traffic, in a JQuery Autocomplete compatible format. The value returned is the UIC station code. The label returned is always in UTF-8 format, with the station's official name (which is often in the native language). Agglomeration station codes may also be returned. Note that only French and Italian rail stations are supported by the Rail Station Autocomplete API.
     *
     * @param term Search term that should represent some part of a station name. Not case sensitive, may be blank. (required)
     * @return List&lt;RailStationAutocompleteResponse&gt;
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Rail & Train - Rail Station Autocomplete")
    @Alias("railStationAutocomplete")
    public List<RailStationAutocompleteResponse> railStationAutocomplete(
        @DisplayName("Term") @Alias("term") @Summary("Search term that should represent some part of a station name. Not case sensitive, may be blank. (required)") @Optional(defaultValue = "") String term,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.railStationAutocomplete(config.getApikey(), term);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Rail-Station Information - Retrieve the rail station information corresponding to an Amadeus UIC rail station ID. Currently only French and Italian stations are supported.
     *
     * @param id Station ID for which further information is required. (required)
     * @return RailStationResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Rail & Train - Rail Station Information")
    @Alias("railStationInformation")
    @Summary("Rail-Station Information - Retrieve the rail station information corresponding to an Amadeus UIC rail station ID. Currently only French and Italian stations are supported.")
    public RailStationResponse railStationInformation(
        @DisplayName("Station ID") @Alias("id") @Summary("Station ID for which further information is required. (required)") String id,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.railStationInformation(config.getApikey(), id);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }
}