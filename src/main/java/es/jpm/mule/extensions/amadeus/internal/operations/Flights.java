package es.jpm.mule.extensions.amadeus.internal.operations;

import es.jpm.mule.extensions.amadeus.internal.ApiFactory;
import es.jpm.mule.extensions.amadeus.internal.config.AmadeusTravelInnovationSandboxConfig;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.*;
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

@DisplayName("Flight")
public class Flights {

    final Logger logger = LoggerFactory.getLogger(Flights.class);

    private final DefaultApi api = ApiFactory.api();

    /**
     * Flight Inspiration Search - Go beyond the traditional search by origin, destination and dates to meet the needs of travelers looking for suggestions and a search experience that reflects the way they choose their trip. This can help you answer the question 'Where can I go within a given travel budget?'<br/>
     * The Inspiration Flight Search allows you to find the prices of one-way and return flights from an origin city without necessarily having a destination, or even a flight date, in mind. The search doesn't return a distinct set of price options, but rather, can tell you the price of flying from a given city to some destination, for a trip of a given duration, that falls within a given date range. The search is based on our Extreme Search platform, which continually caches a large number of flight search results from a list of origin cities to a variety of destinations. Since it's a cached search, the response time is fast, but not all origin airports are available. Here is a list of the currently supported origin-destination IATA location pairs (https://github.com/amadeus-travel-innovation-sandbox/sandbox-content/blob/master/flight-search-cache-origin-destination.csv). We try to keep this list as fresh as possible for you, but be aware that it may not always be exactly up-to-date and it can change without warning. Despite this limitation don't underestimate the power of this API. Thanks to its quick response speed you can easily pair it with other APIs to provide a low fare and inspiration for any destination. For example, you can could combine it with a event search API and suggest a total price to see go and see an concert or a game in a selection of cities.
     *
     * @param origin          &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city from which the traveler will depart. See the location and airport interfaces for more information. (required)
     * @param destination     &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city to which the traveler is going (optional, default to LAX)
     * @param departureDate   Range of dates between which the traveler could depart. Dates are specified in the &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_8601\&quot;&gt;ISO 8601&lt;/a&gt; yyyy-MM-dd date format. Ranges are inclusive and ranges of months will apply from the start to the end of the month. If just a single date is specified, only that date will be searched. By default, the date range starts today and applies up to 361 in the future is applied. Past dates are generally not supported, future dates should be in the next 361 days, although results start to become sparse after about 6 months in the future, as airlines may still be defining their schedules. The default is to search all future dates available. (optional, default to 2017-08-16--2017-08-26)
     * @param oneWay          When set to true, the query will be for a single trip from the origin to the destination. When this parameter is not provided, or is set to false, the query is for a round trip from the origin to the destination and back again. (optional, default to false)
     * @param duration        The allowed duration or range of durations of the trip, in days. This parameter must not be set if the one-way parameter is set to true. (optional, default to 1--15)
     * @param direct          Limit the search to results that do not require the passenger to change plane? (optional, default to false)
     * @param maxPrice        Maximum price of trips to find in the result set, in the currency specified for this origin and destination pair in the cache contents spreadsheet. So, for example, if the origin is NYC, and the max price is 400, this means 400 USD. If the origin is PAR, and the max price is 400, this means 400 EUR. By default, no limit is applied (optional)
     * @param aggregationMode Specifies the granularity of results to be found. DESTINATION is the default and finds one result per city. COUNTRY finds one result per country, DAY finds on result for every day in the date range, WEEK finds one result for every week in the date range. Note that specifying a small granularity but a large search scope may result in a huge output. For some very large outputs, the API may refuse to provide a result. (optional)
     * @return ExtremeSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Flight - Flight Inspiration Search")
    @Alias("flightInspirationSearch")
    @Summary("Flight Inspiration Search - Go beyond the traditional search by origin, destination and dates to meet the needs of travelers looking for suggestions and a search experience that reflects the way they choose their trip.")
    public ExtremeSearchResponse flightInspirationSearch(
        @DisplayName("Origin") @Alias("origin") @Summary("(see https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code) IATA code of the city from which the traveler will depart. See the location and airport interfaces for more information. (required)") String origin,
        @DisplayName("Destination") @Alias("destination") @Summary("(see https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code) IATA code of the city to which the traveler is going (optional, default to LAX)") String destination,
        @DisplayName("Departure date") @Alias("departureDate") @Summary("Range of dates between which the traveler could depart. Dates are specified in the ISO 8601 (see https://en.wikipedia.org/wiki/ISO_8601) yyyy-MM-dd date format. Ranges are inclusive and ranges of months will apply from the start to the end of the month. If just a single date is specified, only that date will be searched. By default, the date range starts today and applies up to 361 in the future is applied. Past dates are generally not supported, future dates should be in the next 361 days, although results start to become sparse after about 6 months in the future, as airlines may still be defining their schedules. The default is to search all future dates available. (optional, default to 2017-08-16--2017-08-26)") @Optional String departureDate,
        @DisplayName("One way") @Alias("oneWay") @Summary("When set to true, the query will be for a single trip from the origin to the destination. When this parameter is not provided, or is set to false, the query is for a round trip from the origin to the destination and back again. (optional, default to false)") boolean oneWay,
        @DisplayName("Duration") @Alias("duration") @Summary("The allowed duration or range of durations of the trip, in days. This parameter must not be set if the one-way parameter is set to true. (optional, default to 1--15)") @Optional String duration,
        @DisplayName("Direct") @Alias("direct") @Summary("Limit the search to results that do not require the passenger to change plane? (optional, default to false)") boolean direct,
        @DisplayName("Max price") @Alias("maxPrice") @Summary("Maximum price of trips to find in the result set, in the currency specified for this origin and destination pair in the cache contents spreadsheet. So, for example, if the origin is NYC, and the max price is 400, this means 400 USD. If the origin is PAR, and the max price is 400, this means 400 EUR. By default, no limit is applied (optional)") @Optional String maxPrice,
        @DisplayName("Aggregation mode") @Alias("aggregationMode") @Summary("Specifies the granularity of results to be found. DESTINATION is the default and finds one result per city. COUNTRY finds one result per country, DAY finds on result for every day in the date range, WEEK finds one result for every week in the date range. Note that specifying a small granularity but a large search scope may result in a huge output. For some very large outputs, the API may refuse to provide a result. (optional)") @Optional String aggregationMode,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.flightInspirationSearch(config
                .getApikey(), origin, destination, departureDate, oneWay, duration, direct, maxPrice, aggregationMode);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Flight Extensive Search - Build travel searches based on very flexible and open range of dates. You can use it to answer questions such as 'When is the best date to fly...'.  It's built on Amadeus' Featured Results technology, which returns thousands of results (prices, itineraries and dates) in a matter of milliseconds. Results are available over half a calendar year with a 1 to 15 day stay duration.<br/>
     * The Extensive Flight Search allows you to find the prices of one-way or return flights between two airports over a large number of dates, and for a large variety of stay durations. The search doesn't return exact itineraries, but rather tells you the best price for a flight on a given day, for a stay of a given duration. The search is based on our Extreme Search platform, which continually caches a large number of flight search results from a list of origin cities to a variety of destinations. Since it's a cached search, the response time is fast, but not all origin airports are available. Here is a list of the currently supported origin-destination IATA location pairs (https://github.com/amadeus-travel-innovation-sandbox/sandbox-content/blob/master/flight-search-cache-origin-destination.csv). We try to keep this list as fresh as possible for you, but be aware that it may not always be exactly up-to-date and it can change without warning. That said, a price graph like this provides a powerful bargin shopping tool - allowing travelers with flexible itineraries to identify days on which they can get the cheapest flights to their destinations.
     *
     * @param origin          &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city from which the traveler will depart. See the location and airport interfaces for more information. (required)
     * @param destination     &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city to which the traveler is going (required)
     * @param departureDate   Range of dates between which the traveler could depart. Dates are specified in the &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_8601\&quot;&gt;ISO 8601&lt;/a&gt; yyyy-MM-dd date format. Ranges are inclusive and ranges of months will apply from the start to the end of the month. If just a single date is specified, only that date will be searched. By default, the date range starts today and applies up to 361 in the future is applied. Past dates are generally not supported, future dates should be in the next 361 days, although results start to become sparse after about 6 months in the future, as airlines may still be defining their schedules. The default is to search all future dates available.   (optional, default to 2017-08-16--2017-08-26)
     * @param oneWay          When set to true, the query will be for a single trip from the origin to the destination. When this parameter is not provided, or is set to false, the query is for a round trip from the origin to the destination and back again. (optional, default to false)
     * @param duration        The allowed duration or range of durations of the trip, in days. This parameter must not be set if the one-way parameter is set to true. (optional, default to 1--15)
     * @param direct          Limit the search to results that do not require the passenger to change plane? (optional, default to false)
     * @param maxPrice        Maximum price of trips to find in the result set, in the currency specified for this origin and destination pair in the cache contents spreadsheet. So, for example, if the origin is NYC, and the max price is 400, this means 400 USD. If the origin is PAR, and the max price is 400, this means 400 EUR. By default, no limit is applied (optional, default to 950)
     * @param aggregationMode Specifies the granularity of results to be found. DAY is the default when one-way is true finds a result for departure date in the date range. STAY is the default otherwise and finds all round trip permutations for this route withim the given date range. DESTINATION finds one result, only the cheapest price for this route over the provided date range. WEEK finds the cheapest result for every week in the date range. Note that specifying a small granularity but a large search scope may result in a huge output. For some very large outputs, the API may refuse to provide a result. (optional, default to DAY)
     * @return ExtremeSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Flight - Flight Extensive Search")
    @Alias("flightExtensiveSearch")
    @Summary("light Extensive Search - Build travel searches based on very flexible and open range of dates.")
    public ExtremeSearchResponse flightExtensiveSearch(
        @DisplayName("Origin") @Alias("origin") @Summary("(see https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code) IATA code of the city from which the traveler will depart. See the location and airport interfaces for more information. (required)") String origin,
        @DisplayName("Destination") @Alias("destination") @Summary("(see https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code) IATA code of the city to which the traveler is going (required)") String destination,
        @DisplayName("Departure date") @Alias("departureDate") @Summary("Range of dates between which the traveler could depart. Dates are specified in the ISO 8601 yyyy-MM-dd date format. Ranges are inclusive and ranges of months will apply from the start to the end of the month. If just a single date is specified, only that date will be searched. By default, the date range starts today and applies up to 361 in the future is applied. Past dates are generally not supported, future dates should be in the next 361 days, although results start to become sparse after about 6 months in the future, as airlines may still be defining their schedules. The default is to search all future dates available.   (optional, default to 2017-08-16--2017-08-26)") @Optional String departureDate,
        @DisplayName("One way") @Alias("oneWay") @Summary("When set to true, the query will be for a single trip from the origin to the destination. When this parameter is not provided, or is set to false, the query is for a round trip from the origin to the destination and back again. (optional, default to false)") boolean oneWay,
        @DisplayName("Duration") @Alias("duration") @Summary("The allowed duration or range of durations of the trip, in days. This parameter must not be set if the one-way parameter is set to true. (optional, default to 1--15)") @Optional String duration,
        @DisplayName("Direct") @Alias("direct") @Summary("Limit the search to results that do not require the passenger to change plane? (optional, default to false)") boolean direct,
        @DisplayName("Max price") @Alias("maxPrice") @Summary("Maximum price of trips to find in the result set, in the currency specified for this origin and destination pair in the cache contents spreadsheet. So, for example, if the origin is NYC, and the max price is 400, this means 400 USD. If the origin is PAR, and the max price is 400, this means 400 EUR. By default, no limit is applied (optional)") @Optional String maxPrice,
        @DisplayName("Aggregation mode") @Alias("aggregationMode") @Summary("Specifies the granularity of results to be found. DESTINATION is the default and finds one result per city. COUNTRY finds one result per country, DAY finds on result for every day in the date range, WEEK finds one result for every week in the date range. Note that specifying a small granularity but a large search scope may result in a huge output. For some very large outputs, the API may refuse to provide a result. (optional)") @Optional String aggregationMode,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.flightExtensiveSearch(config
                .getApikey(), origin, destination, departureDate, oneWay, duration, direct, maxPrice, aggregationMode);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Flight Low-Fare Search - Find the cheapest one way or return itineraries and fares between two airports at specific dates.<br/>
     * This is the low fare search engine Amadeus uses to retrieve the best price for flights, based on our latest Master Pricer Travel Board technology. This document describes how to make a low fare search and how to handle the returned messages. A result is then composed of single or multiple itineraries. Each itinerary is composed of an outbound leg, and, if a return date was specified, an inbound leg. Each leg is composed of a list of one or more flights, that the traveller will be required to take in order to get from the origin airport to the destination airport.
     *
     * @param origin          City code from which the traveler will depart. See the location and airport interfaces for more information. (required)
     * @param destination     &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city to which the traveler is going (required)
     * @param departureDate   The date on which the traveler will depart from the origin to go to the destination. You can specify a date range of up to 2 days. For a larger date range, use the Extensive Search. Dates are specified in the &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_8601\&quot;&gt;ISO 8601&lt;/a&gt; yyyy-MM-dd date format and separated by --. (required)
     * @param returnDate      The date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, the search will find only one-way trips. If this, or the return_by parameter are specified, only return trips are found. You can specify a date range of up to 2 days. (optional, default to 2017-08-28)
     * @param arriveBy        The datetime by which the outbound flight should arrive, based on local time at the destination airport.  Date-times are specified in the &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_8601\&quot;&gt;ISO 8601&lt;/a&gt; yyyy-MM-ddTHH:mm date format (optional, default to 2017-08-25T16:00)
     * @param returnBy        The time by which the inbound flight should arrive, based on local time at the airport specified as the origin parameter (optional, default to 2017-08-28T08:00)
     * @param adults          The number of adult (age 12 and over) passengers traveling on this flight. (optional, default to 1)
     * @param children        The number of child (younger than age 12 on date of departure) passengers traveling on this flight who will each have their own separate seat (optional, default to 0)
     * @param infants         The number of infant (younger than age 2 on date of departure) passengers traveling on this flight. Infants travel in the lap of an adult passenger, and thus the number of infants must not exceed the number of adults. (optional, default to 0)
     * @param includeAirlines If specified, all results will include at least one flight where one or more of these airlines is the marketing carrier. This behaves as an OR function. Airlines are specified using &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/Airline_codes\&quot;&gt;&lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/Airline_codes\&quot;&gt;IATA airline code&lt;/a&gt;s&lt;/a&gt;. (optional)
     * @param excludeAirlines If specified, no results will include any flights where any of these airlines is the marketing carrier. Airlines are specified using &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/Airline_codes\&quot;&gt;&lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/Airline_codes\&quot;&gt;IATA airline code&lt;/a&gt;s&lt;/a&gt;. (optional)
     * @param nonstop         Setting this to true will find only flights that do not require the passenger to change from one flight to another (optional, default to false)
     * @param maxPrice        Maximum price of trips to find in the result set, in USD (US dollars) unless some other currency code is specified. By default, no limit is applied (optional, default to 980)
     * @param currency        The preferred &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_4217\&quot;&gt;currency&lt;/a&gt; for the results (optional, default to USD)
     * @param travelClass     Searches for results where the majority of the itinerary flight time should be in a the specified cabin class or higher (optional, default to ECONOMY)
     * @param numberOfResults The number of results to display. This will not be strictly interpreted but used as a guideline to display a useful number of results. By default, the number of results is dynamically determined. A maximum of 250 results will be displayed. (optional, default to 5)
     * @return LowFareSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Flight - Flight Low Fare Search")
    @Alias("flightLowFareSearch")
    @Summary("Flight Low-Fare Search - Find the cheapest one way or return itineraries and fares between two airports at specific dates.")
    public LowFareSearchResponse flightLowFareSearch(
        @DisplayName("Origin") @Alias("origin") @Summary("City code from which the traveler will depart. See the location and airport interfaces for more information. (required)") String origin,
        @DisplayName("Destination") @Alias("destination") @Summary("(see https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code) IATA code  of the city to which the traveler is going (required)") String destination,
        @DisplayName("Departure date") @Alias("departureDate") @Summary("The date on which the traveler will depart from the origin to go to the destination. You can specify a date range of up to 2 days. For a larger date range, use the Extensive Search. Dates are specified in the ISO 8601 yyyy-MM-dd date format and separated by --. (required)") String departureDate,
        @DisplayName("Return date") @Alias("returnDate") @Summary("The date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, the search will find only one-way trips. If this, or the return_by parameter are specified, only return trips are found. You can specify a date range of up to 2 days. (optional, default to 2017-08-28)") @Optional String returnDate,
        @DisplayName("Arrive by") @Alias("arriveBy") @Summary("The datetime by which the outbound flight should arrive, based on local time at the destination airport.  Date-times are specified in the ISO 8601 yyyy-MM-ddTHH:mm date format (optional, default to 2017-08-25T16:00)") @Optional String arriveBy,
        @DisplayName("Return by") @Alias("returnBy") @Summary("The time by which the inbound flight should arrive, based on local time at the airport specified as the origin parameter (optional, default to 2017-08-28T08:00)") @Optional String returnBy,
        @DisplayName("Adults") @Alias("adults") @Summary("The number of adult (age 12 and over) passengers traveling on this flight. (optional, default to 1)") @Optional Integer adults,
        @DisplayName("Children") @Alias("children") @Summary("The number of child (younger than age 12 on date of departure) passengers traveling on this flight who will each have their own separate seat (optional, default to 0)") @Optional Integer children,
        @DisplayName("Infants") @Alias("infants") @Summary("The number of infant (younger than age 2 on date of departure) passengers traveling on this flight. Infants travel in the lap of an adult passenger, and thus the number of infants must not exceed the number of adults. (optional, default to 0)") @Optional Integer infants,
        @DisplayName("Include airlines") @Alias("includeAirlines") @Summary("If specified, all results will include at least one flight where one or more of these airlines is the marketing carrier. This behaves as an OR function. Airlines are specified using (see https://en.wikipedia.org/wiki/Airline_codes) IATA airline codes. (optional)") @Optional List<String> includeAirlines,
        @DisplayName("Exclude airlines") @Alias("excludeAirlines") @Summary("If specified, no results will include any flights where any of these airlines is the marketing carrier. Airlines are specified using (see https://en.wikipedia.org/wiki/Airline_codes) IATA airline codes. (optional)") @Optional List<String> excludeAirlines,
        @DisplayName("Nonstop") @Alias("nonstop") @Summary("Setting this to true will find only flights that do not require the passenger to change from one flight to another (optional, default to false)") boolean nonstop,
        @DisplayName("Maximum price") @Alias("maxPrice") @Summary("Maximum price of trips to find in the result set, in USD (US dollars) unless some other currency code is specified. By default, no limit is applied (optional, default to 980)") @Optional Integer maxPrice,
        @DisplayName("Currency") @Alias("currency") @Summary("The preferred (see https://en.wikipedia.org/wiki/ISO_4217) currency for the results (optional, default to USD)") @Optional String currency,
        @DisplayName("Travel class") @Alias("travelClass") @Summary("Searches for results where the majority of the itinerary flight time should be in a the specified cabin class or higher (optional, default to ECONOMY)") @Optional String travelClass,
        @DisplayName("Number of results") @Alias("numberOfResults") @Summary("The number of results to display. This will not be strictly interpreted but used as a guideline to display a useful number of results. By default, the number of results is dynamically determined. A maximum of 250 results will be displayed. (optional, default to 5)") @Optional Integer numberOfResults,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.flightLowFareSearch(config
                .getApikey(), origin, destination, departureDate, returnDate, arriveBy, returnBy, adults, children, infants, includeAirlines, excludeAirlines, nonstop, maxPrice, currency, travelClass, numberOfResults);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Flight Affiliate Search - Use Travel Audience Connect's affiliate network API to search flights from our list of partners and provides deep-links to allow the user to book directly on the airline website.<br/>
     * The Flight Affiliate Search API combines Amadeus' flight search technology with Travel Audience's Connect API partners to provide a unique flight search, where all results come with deep-links to book the flight at a partner's website. The API will let you easily provide the traveler with a path to book flights from your application. Travel Audience Connect partners include (http://www.cityjet.com) CityJet, (https://www.aireuropa.com/en/flights) Air Europa and (http://www.flytap.com) TAP in Western Europe, (http://uralairlines.com/) Ural Airlines in Russia, (http://www.avianca.com.br) Avianca Brazil and (http://www.jal.com/) JAL in East Asia. Only Travel Audience Connect partner airlines are searched. For an up-to-date list of routes, see the route maps on each partners respective websites above. You can earn commission using the deep links provided in the search results if you sign up for an account at connect.travelaudience.com (http://connect.travelaudience.com/).
     *
     * @param origin           City code from which the traveler will depart. See the location and airport interfaces for more information. (required)
     * @param destination      &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city to which the traveler is going (required)
     * @param departureDate    The date on which the traveler will depart from the origin to go to the destination. The maximum scope for a date range is 2 days, for a larger scope, use the Extensive Search!  (required)
     * @param returnDate       The date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, the search will find only one-way trips. If this, or the return_by parameter are specified, only return trips are found (optional, default to 2017-08-28)
     * @param adults           The number of adult (age 12 and over) passengers traveling on this flight. (optional, default to 1)
     * @param children         The number of child (younger than age 12 on date of departure) passengers traveling on this flight who will each have their own separate seat (optional, default to 0)
     * @param infants          The number of infant (younger than age 2 on date of departure) passengers traveling on this flight. Infants travel in the lap of an adult passenger, and thus the number of infants must not exceed the number of adults. (optional, default to 0)
     * @param includeMerchants If specified, all results will include at least one flight where one or more of these airlines is the marketing carrier. Airlines are specified using &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/Airline_codes\&quot;&gt;&lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/Airline_codes\&quot;&gt;IATA airline code&lt;/a&gt;s&lt;/a&gt; (optional)
     * @param excludeMerchants If specified, no results will include any flights where any of these airlines is the marketing carrier. Airlines are specified using &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/Airline_codes\&quot;&gt;&lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/Airline_codes\&quot;&gt;IATA airline code&lt;/a&gt;s&lt;/a&gt; (optional)
     * @param maxPrice         Maximum price of trips to find in the result set, in USD (US dollars) unless some other currency code is specified. By default, no limit is applied (optional, default to 980)
     * @param currency         The preferred &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_4217\&quot;&gt;currency&lt;/a&gt; for the results (optional, default to EUR)
     * @param mobile           Setting this to true will show mobile web deeplinks  (optional, default to false)
     * @return AffiliateSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Flight - Flight Affiliate Search")
    @Alias("flightAffiliateSearch")
    @Summary("Flight Affiliate Search - Use Travel Audience Connect's affiliate network API to search flights from our list of partners and provides deep-links to allow the user to book directly on the airline website.")
    public AffiliateSearchResponse flightAffiliateSearch(
        @DisplayName("Origin") @Alias("origin") @Summary("City code from which the traveler will depart. See the location and airport interfaces for more information. (required)") String origin,
        @DisplayName("Destination") @Alias("destination") @Summary("(see https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code) IATA code  of the city to which the traveler is going (required)") String destination,
        @DisplayName("Departure date") @Alias("departureDate") @Summary("The date on which the traveler will depart from the origin to go to the destination. The maximum scope for a date range is 2 days, for a larger scope, use the Extensive Search!  (required)") String departureDate,
        @DisplayName("Return date") @Alias("returnDate") @Summary("The date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, the search will find only one-way trips. If this, or the return_by parameter are specified, only return trips are found (optional, default to 2017-08-28)") @Optional String returnDate,
        @DisplayName("Adults") @Alias("adults") @Summary("The number of adult (age 12 and over) passengers traveling on this flight. (optional, default to 1)") @Optional Integer adults,
        @DisplayName("Children") @Alias("children") @Summary("The number of child (younger than age 12 on date of departure) passengers traveling on this flight who will each have their own separate seat (optional, default to 0)") @Optional Integer children,
        @DisplayName("Infants") @Alias("infants") @Summary("The number of infant (younger than age 2 on date of departure) passengers traveling on this flight. Infants travel in the lap of an adult passenger, and thus the number of infants must not exceed the number of adults. (optional, default to 0)") @Optional Integer infants,
        @DisplayName("Include merchants") @Alias("includeMerchants") @Summary("If specified, all results will include at least one flight where one or more of these airlines is the marketing carrier. Airlines are specified using (see https://en.wikipedia.org/wiki/Airline_codes) IATA airline codes (optional)") @Optional List<String> includeMerchants,
        @DisplayName("Exclude merchants") @Alias("excludeMerchants") @Summary("If specified, no results will include any flights where any of these airlines is the marketing carrier. Airlines are specified using (see https://en.wikipedia.org/wiki/Airline_codes) IATA airline codes") List<String> excludeMerchants,
        @DisplayName("Maximum price") @Alias("maxPrice") @Summary("Maximum price of trips to find in the result set, in USD (US dollars) unless some other currency code is specified. By default, no limit is applied (optional, default to 980)") @Optional Integer maxPrice,
        @DisplayName("Currency") @Alias("currency") @Summary("The preferred (see https://en.wikipedia.org/wiki/ISO_4217) currency for the results (optional, default to EUR)") @Optional String currency,
        @DisplayName("Mobile") @Alias("mobile") @Summary("Setting this to true will show mobile web deeplinks  (optional, default to false)") boolean mobile,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.flightAffiliateSearch(config
                .getApikey(), origin, destination, departureDate, returnDate, adults, children, infants, includeMerchants, excludeMerchants, maxPrice, currency, mobile);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Airport Autocomplete - Find an IATA location code for flight search based on a city or airport name using the term parameter. By only using the country parameter, this API is also able to find all the IATA location codes associated with a country. Both term and country parameters can be used together to filter the results accordingly. The API is fully JQuery-Autocomplete compatible to enable you to quickly build a drop-down list for your users to find the right airport easily.<br/>
     * Using the term parameter and given the start of any word in an airport's official name, a city name, or the start of an IATA code(https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code), this API provides the full name and IATA location code of the city or airport, for use in flight searches. Only major cities and civilian airports with several commercial flights per week are included by default. The response provides up to 20 possible matches, sorted by importance, in a JQuery UI Autocomplete (http://jqueryui.com/autocomplete/) compatible format. This sample implementation (https://github.com/amadeus-travel-innovation-sandbox/sandbox-content/blob/master/airport-autocomplete-template.html) using JQuery UI may help. This API uses data from the OpenTravelData (https://github.com/opentraveldata/opentraveldata/blob/master/opentraveldata/optd_por_public.csv) project. By only using the country parameter, this API is also able to find all the IATA location codes associated with a country. Both term and country parameters can be used together to filter the results accordingly. The value returned is the IATA location code. The label returned is always in UTF-8 format, with the airport official name (which is often in the native language), in the format of English City Name (if not already included in the airport name).
     *
     * @param term        Search keyword that should represent the start of a word in a city or airport name. (required)
     * @param country     Identified a country based of a &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_3166-2#Current_codes\&quot;&gt;ISO 3166-1 alpha-2 code&lt;/a&gt; (optional, default to US)
     * @param allAirports Boolean to include or not all airports, no matter their traffic rank. False by default, to only display relevant airports. (optional, default to false)
     * @return List&lt;AirportAutocompleteResponse&gt;
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Flight - Airport Autocomplete")
    @Alias("airportAutocomplete")
    @Summary("Airport Autocomplete - Find an IATA location code for flight search based on a city or airport name using the term parameter.")
    public List<AirportAutocompleteResponse> airportAutocomplete(
        @DisplayName("Term") @Alias("term") @Summary("Search keyword that should represent the start of a word in a city or airport name. (required)") String term,
        @DisplayName("Country") @Alias("country") @Summary("Identified a country based of a ISO 3166-1 alpha-2 code (see https://en.wikipedia.org/wiki/ISO_3166-2#Current_codes) (optional, default to US)") @Optional String country,
        @DisplayName("All airports") @Alias("allAirports") @Summary("Include or not all airports, no matter their traffic rank. False by default, to only display relevant airports. (optional, default to false)") boolean allAirports,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.airportAutocomplete(config.getApikey(), term, country, allAirports);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Nearest Relevant Airport - Find the most useful nearby airport to a given location.<br/>
     * This service gives the most relevant airports in a radius of 500 km around the given coordinates. The relevance of an airport is computed by dividing the number of airport movements (take offs and landings) by the distance from the point. This causes the relevance of an airport to increase exponentially as you approach it. To minimize response time, all distances are computed as a great-circle distance (http://en.wikipedia.org/wiki/Great-circle_distance) from the provided coordinates to the airport coordinates, and thus do not take into account traffic conditions, international boundaries, mountains, water, or other elements that might make the a nearby airport hard to reach. Only civilian airports with at least several commercial flights per week are included in the results. The result is a list of airports sorted by decreasing relevance. It always contains the nearest airport with significant commercial traffic. You can freely download the point of reference information (https://github.com/opentraveldata/opentraveldata/blob/master/opentraveldata/optd_por_public.csv) used by this API from the Open Travel Data (https://github.com/opentraveldata/opentraveldata) project.
     *
     * @param latitude  Latitude location to be at the center of your search circle. (required)
     * @param longitude Longitude location to be at the center of your search circle. (required)
     * @return List&lt;NearestAirport&gt;
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Flight - Nearest Relevant Airport")
    @Alias("nearestRelevantAirport")
    @Summary("Nearest Relevant Airport - Find the most useful nearby airport to a given location.")
    public List<NearestAirport> nearestRelevantAirport(
        @DisplayName("Latitude") @Alias("latitude") @Summary("Latitude location to be at the center of your search circle. (required)") String latitude,
        @DisplayName("Longitude") @Alias("longitude") @Summary("Longitude location to be at the center of your search circle. (required)") String longitude,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.nearestRelevantAirport(config.getApikey(), latitude, longitude);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Location Information - Find more information about any IATA city or airport location code. With this API, you can find information such as city and airport names and locations, as well as information on timezones and airport usage.<br/>
     * This service retrieves the location information corresponding to a IATA city or airport code. When provided with an IATA code (https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code), the service determines whether this code could relate to a city code, an airport code or both. If the city could contain multiple airports, it will return all possible airports that correspond to that city code. This API is based on the Amadeus supported Geobases (http://opentraveldata.github.io/geobases) open-source project. If you wish to make your own database with all IATA location information, in order to get faster reponses, you can download the latest raw data from their github page (https://github.com/opentraveldata/opentraveldata/blob/master/opentraveldata/optd_por_public.csv)
     *
     * @param code IATA location code for which further information is required (required)
     * @return LocationResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Flight - Location Information")
    @Alias("locationInformation")
    @Summary("Location Information - Find more information about any IATA city or airport location code.")
    public LocationResponse locationInformation(
        @DisplayName("Location code") @Alias("code") @Summary("IATA location code for which further information is required (required)") String code,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.locationInformation(config.getApikey(), code);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

}