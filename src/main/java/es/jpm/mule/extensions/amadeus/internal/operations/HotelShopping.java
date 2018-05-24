package es.jpm.mule.extensions.amadeus.internal.operations;

import es.jpm.mule.extensions.amadeus.internal.ApiFactory;
import es.jpm.mule.extensions.amadeus.internal.config.AmadeusTravelInnovationSandboxConfig;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.HotelPropertyResponse;
import io.swagger.client.model.HotelSearchResponse;
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

@DisplayName("Hotel Shopping")
public class HotelShopping {

    final Logger logger = LoggerFactory.getLogger(HotelShopping.class);

    private final DefaultApi api = ApiFactory.api();

    /**
     * Hotel Airport Search - Locate the cheapest available rooms near a given airport, for a given stay period. This API is ideal if you want to connect flight and hotels. Provide an IATA airport code, as well as the check-in and check-out dates, and get a list of up to 140 properties (names, codes, image, amenities) with their locations and rates. Optional parameters such as currency and maximum rates, amenities or hotel chain codes are also available and can be used to narrow down the results. More optional parameters such as show_sold_out &amp; rooms can be used to show sold out rooms and all available rooms.<br/>
     * A fast Hotel shopping API to see which hotels are available in a given area, on a given day and displays their lowest prices. With this API you can find out the price of the cheapest daily rate for all hotels near a given airport. This API allows you to quickly see the locations of hotels near a given airport, and what prices in that area look like. Note that hotel images are not available to users outside of Amadeus, as we are not licensed to redistribute them. The API is based on our high-speed hotel pricing cache, which is also used to power the Amadeus Hotel Search Engine (https://hotelsearchengine.amadeus.com/) application. Results are returned very quickly, response times are generally under 2s. Our cache has great global coverage and is constantly refreshed with the latest prices.
     * @param location &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA airport code&lt;/a&gt; for hotel availability is required requested. (required)
     * @param checkIn Date on which the guest will begin their stay in the hotel. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)
     * @param checkOut Date on which the guest will end their stay in the hotel. (required)
     * @param radius Radius around the center to look for hotels in kilometers (km). (optional, default to 42)
     * @param lang The preferred language of the content related to each hotel. Content will be returned in this language if available. (optional, default to EN)
     * @param currency The preferred &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_4217\&quot;&gt;currency&lt;/a&gt; for the results (optional, default to USD)
     * @param chain Narrows the hotel search to a given hotel provider. The hotel chain is indicated by the first two characters of the property code. (optional, default to 6C)
     * @param maxRate The maximum amount per night that any hotel in the shopping response should cost. This is calculated by dividing the total price of the stay for the given dates by the number of nights specified falling between the check_in and check_out dates. (optional, default to 500)
     * @param numberOfResults The maximum number of hotels to return in the results set. Hotels are ordered by total price, so if more than the given maximum number of hotels are available, only the cheapest options are returned. (optional, default to 20)
     * @param allRooms This option if enabled will return all hotel room rates, not just the lowest room rate. Note: This will have an impact on the response time due to the larger messages returned. (optional, default to false)
     * @param showSoldOut This option if enabled will return hotel names and addresses even if rooms are sold out (closed properties) (optional, default to false)
     * @param amenities Hotel &lt;a href&#x3D;\&quot;hotels-api-supported-amenities-filter\&quot;&gt;amenities filter&lt;/a&gt; to search narrow down hotels with certain amenities. For example&amp;colon; amenity&#x3D;POOL. (Note: multiple amenities can be used in searches: amenity&#x3D;PARKING&amp;amenity&#x3D;RESTAURANT&amp;amenity&#x3D;PETS_ALLOWED).  (optional)
     * @return HotelSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Hotel Shopping - Hotel Airport Search")
    @Alias("hotelAirportSearch")
    @Summary("Hotel Airport Search - Locate the cheapest available rooms near a given airport, for a given stay period.")
    public HotelSearchResponse hotelAirportSearch(
        @DisplayName("Location") @Alias("location") @Summary("IATA airport code (see https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code) for hotel availability is required requested. (required)") String location,
        @DisplayName("Check in date") @Alias("checkIn") @Summary("Date on which the guest will begin their stay in the hotel. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)") String checkIn,
        @DisplayName("Check out date") @Alias("checkOut") @Summary("Date on which the guest will end their stay in the hotel. (required)") String checkOut,
        @DisplayName("Radius") @Alias("radius") @Summary("Radius around the center to look for hotels in kilometers (km). (optional, default to 42)") @Optional Integer radius,
        @DisplayName("Language") @Alias("lang") @Summary("The preferred language of the content related to each hotel. Content will be returned in this language if available. (optional, default to EN)") @Optional String lang,
        @DisplayName("Currency") @Alias("currency") @Summary("The preferred currency (see https://en.wikipedia.org/wiki/ISO_4217) for the results (optional, default to USD)") @Optional String currency,
        @DisplayName("Chain") @Alias("chain") @Summary("Narrows the hotel search to a given hotel provider. The hotel chain is indicated by the first two characters of the property code. (optional, default to 6C)") @Optional String chain,
        @DisplayName("Maximum rate") @Alias("maxRate") @Summary("The maximum amount per night that any hotel in the shopping response should cost. This is calculated by dividing the total price of the stay for the given dates by the number of nights specified falling between the check_in and check_out dates. (optional, default to 500)") @Optional BigDecimal maxRate,
        @DisplayName("Number of results") @Alias("numberOfResults") @Summary("The maximum number of hotels to return in the results set. Hotels are ordered by total price, so if more than the given maximum number of hotels are available, only the cheapest options are returned. (optional, default to 20)") @Optional Integer numberOfResults,
        @DisplayName("All tooms") @Alias("allRooms") @Summary("This option if enabled will return all hotel room rates, not just the lowest room rate. Note: This will have an impact on the response time due to the larger messages returned. (optional, default to false)") boolean allRooms,
        @DisplayName("Show sold out") @Alias("showSoldOut") @Summary("This option if enabled will return hotel names and addresses even if rooms are sold out (closed properties) (optional, default to false)") boolean showSoldOut,
        @DisplayName("Amenities") @Alias("amenities") @Summary("Hotel (see hotels-api-supported-amenities-filter) amenities filter to search narrow down hotels with certain amenities. For example&amp;colon; amenity&#x3D;POOL. (Note: multiple amenities can be used in searches: amenity=PARKING&amenity=RESTAURANT&amenity=PETS_ALLOWED). (optional)") @Optional List<String> amenities,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.hotelAirportSearch(config
                .getApikey(), location, checkIn, checkOut, radius, lang, currency, chain, maxRate, numberOfResults, allRooms, showSoldOut, amenities);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Hotel Geosearch by box - Locate the cheapest available rooms within a given rectangular region for a given stay period. It's ideal for displaying results on a map.<br/>
     * A fast Hotel shopping API to see which hotels are available in a given area, on a given day and displays their lowest prices. With this API you can find out the price of the cheapest daily rate for all hotels within a specified geographical region.&lt;/p&gt;  &lt;p&gt;This API allows you to quickly see the hotel locations in a region, and what prices in that area look like,  as well as the check-in and check-out dates, and get a list of up to 140 properties (names, codes, image, amenities) with their locations and rates. Optional parameters such as currency and maximum rates, amenities or hotel chain codes are also available and can be used to narrow down the results. More optional parameters such as show_sold_out & rooms can be used to show sold out rooms and all available rooms. The API is based on our high-speed hotel pricing cache, which is also used to power the Amadeus Hotel Search Engine (https://hotelsearchengine.amadeus.com) application. Results are returned very quickly, response times are generally under 2s. Our cache has great global coverage and is constantly refreshed with the latest prices.
     * @param southWestCorner The coordinates of the south-west corner of the search box. (required)
     * @param northEastCorner The coordinates of the north-east corner of the search box. (required)
     * @param checkIn Date on which the guest will begin their stay in the hotel. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)
     * @param checkOut Date on which the guest will end their stay in the hotel. (required)
     * @param lang The preferred language of the content related to each hotel. Content will be returned in this language if available. (optional, default to EN)
     * @param currency The preferred &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_4217\&quot;&gt;currency&lt;/a&gt; for the results (optional, default to USD)
     * @param chain Narrows the hotel search to a given hotel provider. The hotel chain is indicated by the first two characters of the property code. (optional, default to 6C)
     * @param maxRate The maximum amount per night that any hotel in the shopping response should cost. This is calculated by dividing the total price of the stay for the given dates by the number of nights specified falling between the check_in and check_out dates. (optional, default to 500)
     * @param numberOfResults The maximum number of hotels to return in the results set. Hotels are ordered by total price, so if more than the given maximum number of hotels are available, only the cheapest options are returned. (optional, default to 20)
     * @param allRooms This option if enabled will return all hotel room rates, not just the lowest room rate. Note: This will have an impact on the response time due to the larger messages returned. (optional, default to false)
     * @param showSoldOut This option if enabled will return hotel names and addresses even if rooms are sold out (closed properties) (optional, default to false)
     * @param amenities Hotel &lt;a href&#x3D;\&quot;hotels-api-supported-amenities-filter\&quot;&gt;amenities filter&lt;/a&gt; to search narrow down hotels with certain amenities. For example&amp;colon; amenity&#x3D;POOL. (Note: multiple amenities can be used in searches: amenity&#x3D;PARKING&amp;amenity&#x3D;RESTAURANT&amp;amenity&#x3D;PETS_ALLOWED).  (optional)
     * @return HotelSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Hotel Shopping - Hotel Geosearch By Box")
    @Alias("hotelGeosearchByBox")
    @Summary("Hotel Geosearch by box - Locate the cheapest available rooms within a given rectangular region for a given stay period.")
    public HotelSearchResponse hotelGeosearchByBox(
        @DisplayName("South west corner") @Alias("southWestCorner") @Summary("The coordinates of the south-west corner of the search box. (required)") String southWestCorner,
        @DisplayName("North east corner") @Alias("northEastCorner") @Summary("The coordinates of the north-east corner of the search box. (required)") String northEastCorner,
        @DisplayName("Check in date") @Alias("checkIn") @Summary("Date on which the guest will begin their stay in the hotel. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)") String checkIn,
        @DisplayName("Check out date") @Alias("checkOut") @Summary("Date on which the guest will end their stay in the hotel. (required)") String checkOut,
        @DisplayName("Language") @Alias("lang") @Summary("The preferred language of the content related to each hotel. Content will be returned in this language if available. (optional, default to EN)") @Optional String lang,
        @DisplayName("Currency") @Alias("currency") @Summary("The preferred currency (see https://en.wikipedia.org/wiki/ISO_4217) for the results (optional, default to USD)") @Optional String currency,
        @DisplayName("Chain") @Alias("chain") @Summary("Narrows the hotel search to a given hotel provider. The hotel chain is indicated by the first two characters of the property code. (optional, default to 6C)") @Optional String chain,
        @DisplayName("Maximum rate") @Alias("maxRate") @Summary("The maximum amount per night that any hotel in the shopping response should cost. This is calculated by dividing the total price of the stay for the given dates by the number of nights specified falling between the check_in and check_out dates. (optional, default to 500)") @Optional BigDecimal maxRate,
        @DisplayName("Number of results") @Alias("numberOfResults") @Summary("The maximum number of hotels to return in the results set. Hotels are ordered by total price, so if more than the given maximum number of hotels are available, only the cheapest options are returned. (optional, default to 20)") @Optional Integer numberOfResults,
        @DisplayName("All tooms") @Alias("allRooms") @Summary("This option if enabled will return all hotel room rates, not just the lowest room rate. Note: This will have an impact on the response time due to the larger messages returned. (optional, default to false)") boolean allRooms,
        @DisplayName("Show sold out") @Alias("showSoldOut") @Summary("This option if enabled will return hotel names and addresses even if rooms are sold out (closed properties) (optional, default to false)") boolean showSoldOut,
        @DisplayName("Amenities") @Alias("amenities") @Summary("Hotel (see hotels-api-supported-amenities-filter) amenities filter to search narrow down hotels with certain amenities. For example&amp;colon; amenity&#x3D;POOL. (Note: multiple amenities can be used in searches: amenity=PARKING&amenity=RESTAURANT&amenity=PETS_ALLOWED). (optional)") @Optional List<String> amenities,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.hotelGeosearchByBox(config
                .getApikey(), southWestCorner, northEastCorner, checkIn, checkOut, lang, currency, chain, maxRate, numberOfResults, allRooms, showSoldOut, amenities);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Hotel Geosearch by Circle API - Locate the cheapest available rooms within a given radius of a defined point for a given stay period.<br/>
     * A fast Hotel shopping API to see which hotels are available in a given area, on a given day and displays their lowest prices. With this API you can find out the price of the cheapest daily rate for all hotels within a specified radius of a point. This API allows you to quickly see the hotel locations in a region, and what prices in that area look like,  as well as the check-in and check-out dates, and get list of up to 140 properties (names, codes, image, amenities) with their locations and rates. Optional parameters such as currency and maximum rates, amenities or hotel chain codes are also available and can be used to narrow down the results. More optional parameters such as show_sold_out &amp; rooms can be used to show sold out rooms and all available rooms. The API is based on our high-speed hotel pricing cache, which is also used to power the Amadeus Hotel Search Engine (https://hotelsearchengine.amadeus.com/) application. Results are returned very quickly, response times are generally under 2s. Our cache has great global coverage and is constantly refreshed with the latest prices.
     * @param latitude Latitude of the center of the search. (required)
     * @param longitude Longitude of the center of the search. (required)
     * @param radius Radius around the center to look for hotels in kilometers (km). (required)
     * @param checkIn Date on which the guest will begin their stay in the hotel. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)
     * @param checkOut Date on which the guest will end their stay in the hotel. (required)
     * @param lang The preferred language of the content related to each hotel. Content will be returned in this language if available. (optional, default to EN)
     * @param currency The preferred &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_4217\&quot;&gt;currency&lt;/a&gt; for the results (optional, default to USD)
     * @param chain Narrows the hotel search to a given hotel provider. The hotel chain is indicated by the first two characters of the property code. (optional, default to 6C)
     * @param maxRate The maximum amount per night that any hotel in the shopping response should cost. This is calculated by dividing the total price of the stay for the given dates by the number of nights specified falling between the check_in and check_out dates. (optional, default to 500)
     * @param numberOfResults The maximum number of hotels to return in the results set. Hotels are ordered by total price, so if more than the given maximum number of hotels are available, only the cheapest options are returned. (optional, default to 20)
     * @param allRooms This option if enabled will return all hotel room rates, not just the lowest room rate. Note: This will have an impact on the response time due to the larger messages returned. (optional, default to false)
     * @param showSoldOut This option if enabled will return hotel names and addresses even if rooms are sold out (closed properties) (optional, default to false)
     * @param amenities Hotel &lt;a href&#x3D;\&quot;hotels-api-supported-amenities-filter\&quot;&gt;amenities filter&lt;/a&gt; to search narrow down hotels with certain amenities. For example&amp;colon; amenity&#x3D;POOL. (Note: multiple amenities can be used in searches: amenity&#x3D;PARKING&amp;amenity&#x3D;RESTAURANT&amp;amenity&#x3D;PETS_ALLOWED).  (optional)
     * @return HotelSearchResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Hotel Shopping - Hotel Geosearch By Circle")
    @Alias("hotelGeosearchByCircle")
    @Summary("Hotel Geosearch by Circle API - Locate the cheapest available rooms within a given radius of a defined point for a given stay period.")
    public HotelSearchResponse hotelGeosearchByCircle(
        @DisplayName("Latitude") @Alias("latitude") @Summary("Latitude of the center of the search. (required)") BigDecimal latitude,
        @DisplayName("Longitude") @Alias("longitude") @Summary("Longitude of the center of the search. (required)") BigDecimal longitude,
        @DisplayName("Radius") @Alias("radius") @Summary("Radius around the center to look for hotels in kilometers (km). (required)") Integer radius,
        @DisplayName("Check in date") @Alias("checkIn") @Summary("Date on which the guest will begin their stay in the hotel. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)") String checkIn,
        @DisplayName("Check out date") @Alias("checkOut") @Summary("Date on which the guest will end their stay in the hotel. (required)") String checkOut,
        @DisplayName("Language") @Alias("lang") @Summary("The preferred language of the content related to each hotel. Content will be returned in this language if available. (optional, default to EN)") @Optional String lang,
        @DisplayName("Currency") @Alias("currency") @Summary("The preferred currency (see https://en.wikipedia.org/wiki/ISO_4217) for the results (optional, default to USD)") @Optional String currency,
        @DisplayName("Chain") @Alias("chain") @Summary("Narrows the hotel search to a given hotel provider. The hotel chain is indicated by the first two characters of the property code. (optional, default to 6C)") @Optional String chain,
        @DisplayName("Maximum rate") @Alias("maxRate") @Summary("The maximum amount per night that any hotel in the shopping response should cost. This is calculated by dividing the total price of the stay for the given dates by the number of nights specified falling between the check_in and check_out dates. (optional, default to 500)") @Optional BigDecimal maxRate,
        @DisplayName("Number of results") @Alias("numberOfResults") @Summary("The maximum number of hotels to return in the results set. Hotels are ordered by total price, so if more than the given maximum number of hotels are available, only the cheapest options are returned. (optional, default to 20)") @Optional Integer numberOfResults,
        @DisplayName("All tooms") @Alias("allRooms") @Summary("This option if enabled will return all hotel room rates, not just the lowest room rate. Note: This will have an impact on the response time due to the larger messages returned. (optional, default to false)") boolean allRooms,
        @DisplayName("Show sold out") @Alias("showSoldOut") @Summary("This option if enabled will return hotel names and addresses even if rooms are sold out (closed properties) (optional, default to false)") boolean showSoldOut,
        @DisplayName("Amenities") @Alias("amenities") @Summary("Hotel (see hotels-api-supported-amenities-filter) amenities filter to search narrow down hotels with certain amenities. For example&amp;colon; amenity&#x3D;POOL. (Note: multiple amenities can be used in searches: amenity=PARKING&amenity=RESTAURANT&amenity=PETS_ALLOWED). (optional)") @Optional List<String> amenities,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.hotelGeosearchByCircle(config
                .getApikey(), latitude, longitude, radius, checkIn, checkOut, lang, currency, chain, maxRate, numberOfResults, allRooms, showSoldOut, amenities);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * Hotel Property Code Search - Find out more room and rate information once you have found your preferred hotel.<br/>
     * This API allows you to quickly see the detailed information of a single hotel, including descriptions, address, GPS location, amenities, awards, lowest priced room and all room prices and booking information. This API gives you more information on a specific property. Optional parameters such as show_sold_out &amp; rooms can be used to show sold out rooms and all available rooms. The API is based on our high-speed hotel pricing cache, which is also used to power the Amadeus Hotel Search Engine (https://hotelsearchengine.amadeus.com/) application. Results are returned very quickly, response times are generally under 2s. Our cache has great global coverage and is constantly refreshed with the latest prices.
     * @param propertyCode A Hotel property code based on 2 letter chain code + 3 letter &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code\&quot;&gt;IATA code&lt;/a&gt; of the city + 3 char property unique id. (required)
     * @param checkIn Date on which the guest will begin their stay in the hotel. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)
     * @param checkOut Date on which the guest will end their stay in the hotel. (required)
     * @param lang The preferred language of the content related to each hotel. Content will be returned in this language if available. (optional, default to EN)
     * @param currency The preferred &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_4217\&quot;&gt;currency&lt;/a&gt; for the results (optional, default to USD)
     * @param allRooms This option if enabled will return all hotel room rates, not just the lowest room rate. Note: This will have an impact on the response time due to the larger messages returned. (optional, default to true)
     * @param showSoldOut This option if enabled will return hotel names and addresses even if rooms are sold out (closed properties) (optional, default to false)
     * @return HotelPropertyResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Hotel Shopping - Hotel Property Code Search")
    @Alias("hotelPropertyCodeSearch")
    @Summary("Hotel Property Code Search - Find out more room and rate information once you have found your preferred hotel.")
    public HotelPropertyResponse hotelPropertyCodeSearch(
        @DisplayName("Hotel property code") @Alias("propertyCode") @Summary("A Hotel property code based on 2 letter chain code + 3 letter (see IATA code: https://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code) of the city + 3 char property unique id. (required)") String propertyCode,
        @DisplayName("Check in date") @Alias("checkIn") @Summary("Date on which the guest will begin their stay in the hotel. Past availability is not displayed, future availability becomes less useful from about 6 months from the current date. (required)") String checkIn,
        @DisplayName("Check out date") @Alias("checkOut") @Summary("Date on which the guest will end their stay in the hotel. (required)") String checkOut,
        @DisplayName("Language") @Alias("lang") @Summary("The preferred language of the content related to each hotel. Content will be returned in this language if available. (optional, default to EN)") @Optional String lang,
        @DisplayName("Currency") @Alias("currency") @Summary("The preferred currency (see https://en.wikipedia.org/wiki/ISO_4217) for the results (optional, default to USD)") @Optional String currency,
        @DisplayName("All tooms") @Alias("allRooms") @Summary("This option if enabled will return all hotel room rates, not just the lowest room rate. Note: This will have an impact on the response time due to the larger messages returned. (optional, default to false)") boolean allRooms,
        @DisplayName("Show sold out") @Alias("showSoldOut") @Summary("This option if enabled will return hotel names and addresses even if rooms are sold out (closed properties) (optional, default to false)") boolean showSoldOut,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.hotelPropertyCodeSearch(config
                .getApikey(), propertyCode, checkIn, checkOut, lang, currency, allRooms, showSoldOut);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

}