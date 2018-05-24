package es.jpm.mule.extensions.amadeus.internal.operations;

import es.jpm.mule.extensions.amadeus.internal.ApiFactory;
import es.jpm.mule.extensions.amadeus.internal.config.AmadeusTravelInnovationSandboxConfig;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.FlightTrafficSearchResult;
import io.swagger.client.model.TopDestinationsSearchResponse;
import io.swagger.client.model.TopSearchesSearchResponse;
import org.mule.runtime.api.exception.MuleRuntimeException;
import org.mule.runtime.api.i18n.I18nMessageFactory;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DisplayName("Travel Intelligence")
public class TravelIntelligence {

    final Logger logger = LoggerFactory.getLogger(TravelIntelligence.class);

    private final DefaultApi api = ApiFactory.api();

    /**
     * Top Flight Destinations - Find the most popular flight destinations from an origin during a period. This can help you answer questions like 'Where are most people going to from Paris during the month of September?'.<br/>
     * The Top Flight Destinations API lets you find the most popular flight destinations from an origin during a period. This can help you answer questions like 'Where are most people from Paris going to during the month of September?' The API is based on estimated flight traffic summary data from two journey points over a specific period. It returns up to 50 results, ordered by popularity, showing number of travelers as well as number of flights. This estimated search is based on Amadeus' Travel Intelligence Engine, a high performance scalable cloud-based platform, born in the age of Big Data and purposely built for the industry bringing total flexibility and speed to business intelligence for travel. Please see amadeus.com/travelintelligence (http://www.amadeus.com/travelintelligence) for more information.
     *
     * @param period          Period, in month of the year (YYYY-MM), when consumers are traveling. Only periods from 2011-01 up to previous month of the current year are valid. Future dates are not supported. (required)
     * @param origin          &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city from which the traveler will depart. (required)
     * @param numberOfResults The maximum number of destinations to return in the results set. Destinations are ordered by number of travelers. The maximum number of destinations returned is 50 (optional, default to 10)
     * @return TopDestinationsSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Travel Intelligence - Top Flight Destinations")
    @Alias("topFlightDestinations")
    @Summary("Top Flight Destinations - Find the most popular flight destinations from an origin during a period.")
    public TopDestinationsSearchResponse topFlightDestinations(
        @DisplayName("Period") @Alias("period") @Summary("Period, in month of the year (YYYY-MM), when consumers are traveling. Only periods from 2011-01 up to previous month of the current year are valid. Future dates are not supported. (required)") String period,
        @DisplayName("Origin") @Alias("origin") @Summary("IATA code of the city from which the traveler will depart. (required)") String origin,
        @DisplayName("Number Of results") @Alias("numberOfResults") @Summary("The maximum number of destinations to return in the results set. Destinations are ordered by number of travelers. The maximum number of destinations returned is 50 (optional, default to 10)") @Optional Integer numberOfResults,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.topFlightDestinations(config.getApikey(), period, origin, numberOfResults);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Flight Traffic API - Find the true origin and destination traffic summary between two journey points over a specified period. This can help you answer questions like 'What cities are people coming from to visit Los Angeles between January through April of 2015'.<br/>
     * The Flight Traffic API lets you find the origin and destination traffic summary between two journey points over a specified period. The search returns number of flights &amp; travelers for each origin and destination, ordered by popularity, for each month specified within the search period. This search can help you answer questions like 'Where are people from Los Angeles traveling to between January and April of 2015?' or 'Which is the most popular month for New Yorkers to travel last year?'. This search is based on Amadeus' Travel Intelligence Engine, a high performance scalable cloud-based platform, born in the age of Big Data and purposely built for the industry bringing total flexibility and speed to business intelligence for travel. Please see amadeus.com/travelintelligence (http://www.amadeus.com/travelintelligence) for more information.
     *
     * @param period                   Range of periods for which flight traffic information is required. Ranges are inclusive and ranges of months will apply from the start to the end of the month. If just a single period is specified, only that period will be displayed. Only periods from 2011-01 up to previous month of the current year are valid. Future periods are not supported. (required)
     * @param origin                   &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city from which the traveler will depart. (required)
     * @param destination              &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city to which the traveler is going. (optional, default to LAX)
     * @param numberOfResultsPerPeriod The maximum number of destinations to return for each period. Destinations are ordered by dates and number of travelers. The maximum number of destinations per period returned is 50 (optional, default to 5)
     * @return List&lt;FlightTrafficSearchResult&gt;
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Travel Intelligence - Flight Traffic")
    @Alias("flightTrafficAPI")
    @Summary("Flight Traffic API - Find the true origin and destination traffic summary between two journey points over a specified period.")
    public List<FlightTrafficSearchResult> flightTraffic(
        @DisplayName("Period") @Alias("period") @Summary("Range of periods for which flight traffic information is required. Ranges are inclusive and ranges of months will apply from the start to the end of the month. If just a single period is specified, only that period will be displayed. Only periods from 2011-01 up to previous month of the current year are valid. Future periods are not supported. (required)") String period,
        @DisplayName("Origin") @Alias("origin") @Summary("IATA code of the city from which the traveler will depart. (required)") String origin,
        @DisplayName("Destination") @Alias("destination") @Summary("IATA code of the city to which the traveler is going. (optional, default to LAX)") @Optional String destination,
        @DisplayName("Number of results per period") @Alias("numberOfResultsPerPeriod") @Summary("The maximum number of destinations to return for each period. Destinations are ordered by dates and number of travelers. The maximum number of destinations per period returned is 50 (optional, default to 5)") @Optional Integer numberOfResultsPerPeriod,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.flightTrafficAPI(config.getApikey(), period, origin, destination, numberOfResultsPerPeriod);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Top Flight Searches - Find the most popular flight searches from an origin in a during given search period. This can help you answer questions like 'Where are people looking to travel from Paris during the month of September?'.<br/>
     * The Top Flight Search allows you to find number of estimated searches from an origin, optionally a destination, within a time period when travelers are performing the searches. The search is based on queries performed from within a country (also refers to as market) and returns up to 50 results, ordered by popularity, showing number of searches for most searched destination with its previous year comparison. This search also shows patterns on how travelers are searching for flights, revealing where, when and for how long they’re planning to travel. See Trip Durations(How long are the trips planned for?) and Advance Search Period (How long before departures do travelers start searching for their trips?). This estimated search is based on Amadeus' Travel Intelligence Engine, a high performance scalable cloud-based platform, born in the age of Big Data and purposely built for the industry bringing total flexibility and speed to business intelligence for travel. Please see amadeus.com/travelintelligence (http://www.amadeus.com/travelintelligence) for more information.
     *
     * @param period          Period of date (month or year) when consumers are searching to travel. Use YYYY-MM for month or YYYY for year. Only periods from year 2011-01 up to current year, previous month are valid. Future dates are not supported. (required)
     * @param origin          &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city from which the traveler will depart. (required)
     * @param country         2-letter IATA country code of the country where the search queries originates from. (required)
     * @param destination     &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city to which the traveler is going (optional, default to LON)
     * @param numberOfResults The maximum number of destinations to return in the results set. Destinations are ordered by number of searches. The maximum number of destinations returned is 50 (optional, default to 10)
     * @return TopSearchesSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Travel Intelligence - Top Flight Searches")
    @Alias("topFlightSearches")
    @Summary("Top Flight Searches - Find the most popular flight searches from an origin in a during given search period.")
    public TopSearchesSearchResponse topFlightSearches(
        @DisplayName("Period") @Alias("period") @Summary("Period of date (month or year) when consumers are searching to travel. Use YYYY-MM for month or YYYY for year. Only periods from year 2011-01 up to current year, previous month are valid. Future dates are not supported. (required)") String period,
        @DisplayName("Origin") @Alias("origin") @Summary("IATA code of the city from which the traveler will depart. (required)") String origin,
        @DisplayName("Country") @Alias("country") @Summary("2-letter IATA country code of the country where the search queries originates from. (required)") String country,
        @DisplayName("Destination") @Alias("destination") @Summary("IATA code of the city to which the traveler is going (optional, default to LON)") @Optional String destination,
        @DisplayName("Number of results") @Alias("numberOfResults") @Summary("The maximum number of destinations to return in the results set. Destinations are ordered by number of searches. The maximum number of destinations returned is 50 (optional, default to 10)") @Optional Integer numberOfResults,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.topFlightSearches(config.getApikey(), period, origin, country, destination, numberOfResults);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }
}