package es.jpm.mule.extensions.amadeus.internal.operations;

import es.jpm.mule.extensions.amadeus.internal.ApiFactory;
import es.jpm.mule.extensions.amadeus.internal.config.AmadeusTravelInnovationSandboxConfig;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.PointsOfInterestResponse;
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

@DisplayName("Point of Interest")
public class Poi {

    final Logger logger = LoggerFactory.getLogger(Poi.class);

    private final DefaultApi api = ApiFactory.api();

    /**
     * YapQ City Name Search - Find landmarks and attractions in a given city.<br/>
     * Amadeus has partnered with YapQ (http://yapq.io/) to bring you point of interest APIs with the goal of offering you unbiased ratings of landmarks and tourist attractions. YapQ rates these points according to their interest on social media and provides Wikipedia content and Geonames ID in a given city. YapQ's service indexes millions of points around the world, and provides content in 12 different languages. This allows you to ensure you catch the 'must-see' sights in a YapQ supported city (http://yapq.io/cities.html). Each point of interest comes with links to content, grading information, location and directions to help make discovering your destination easy and fun. This service is still under active development, and the response format may change without warning. We'd be interested in your feedback - send us an email (mailto:sandbox@yapq.com).
     *
     * @param cityName        The name of the &lt;a href&#x3D;\&quot;http://yapq.io/cities.txt\&quot;&gt;supported city&lt;/a&gt; for which you are searching, in the selected language. (required)
     * @param lang            The preferred language of the content related to each point of interest. Content will be returned in this language if available (optional, default to EN)
     * @param category        Filters the resulting points_of_interest to include only results which have a least one category containing the given provided word. Good examples are &lt;em&gt;museum&lt;/em&gt;, &lt;em&gt;landmark&lt;/em&gt; or &lt;em&gt;church&lt;/em&gt; (optional, default to Museum)
     * @param geonames        Setting this to true includes only points of interest with a geonames ID (optional, default to false)
     * @param vibes           Includes content that doesn&#39;t correspond to an active physical place, but which gives the user some background information, or &lt;em&gt;vibe&lt;/em&gt; for the place they are visiting. An example of this may be information on an influential demolished building that used to exist at a certain location, or more information on a district of the city (optional, default to false)
     * @param socialMedia     Enabling this includes images from Instagram in the output results. This is disabled by default, since these images are often just pictures of people or food, which often have little relevance to the actual location (optional, default to false)
     * @param imageSize       The size of the images you&#39;d like to see in the response (optional, default to MEDIUM)
     * @param numberOfImages  Number of images to display (optional, default to 4)
     * @param numberOfResults The maximum number of points of interest to return in the results set. This is a range from 1 to 100 (optional, default to 20)
     * @return PointsOfInterestResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Point of Interest - YapQ City Name Search")
    @Alias("yapQCityNameSearch")
    @Summary("YapQ City Name Search - Find landmarks and attractions in a given city.")
    public PointsOfInterestResponse yapQCityNameSearch(
        @DisplayName("City name") @Alias("cityName") @Summary("The name of the (see http://yapq.io/cities.txt) supported city for which you are searching, in the selected language. (required)") String cityName,
        @DisplayName("Language") @Alias("lang") @Summary("The preferred language of the content related to each point of interest. Content will be returned in this language if available (optional, default to EN)") @Optional String lang,
        @DisplayName("Poi category") @Alias("category") @Summary("Filters the resulting points_of_interest to include only results which have a least one category containing the given provided word. Good examples are museum, landmark or church (optional, default to Museum)") @Optional String category,
        @DisplayName("Only geonames") @Alias("geonames") @Summary("Setting this to true includes only points of interest with a geonames ID (optional, default to false)") boolean geonames,
        @DisplayName("Only vibes") @Alias("vibes") @Summary("Includes content that doesn't correspond to an active physical place, but which gives the user some background information, or 'vibe' for the place they are visiting. An example of this may be information on an influential demolished building that used to exist at a certain location, or more information on a district of the city (optional, default to false)") boolean vibes,
        @DisplayName("Social media resources") @Alias("socialMedia") @Summary("Enabling this includes images from Instagram in the output results. This is disabled by default, since these images are often just pictures of people or food, which often have little relevance to the actual location (optional, default to false)") boolean socialMedia,
        @DisplayName("Image size") @Alias("imageSize") @Summary("The size of the images you'd like to see in the response (optional, default to MEDIUM)") @Optional String imageSize,
        @DisplayName("Number of images") @Alias("numberOfImages") @Summary("Number of images to display (optional, default to 4)") @Optional Integer numberOfImages,
        @DisplayName("Number of results") @Alias("numberOfResults") @Summary("The maximum number of points of interest to return in the results set. This is a range from 1 to 100 (optional, default to 20)") @Optional Integer numberOfResults,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.yapQCityNameSearch(config
                .getApikey(), cityName, lang, category, geonames, vibes, socialMedia, imageSize, numberOfImages, numberOfResults);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

    /**
     * YapQ Geosearch - Find landmarks and attractions near a given point.<br/>
     * Amadeus has partnered with YapQ (http://yapq.io/) to bring you point of interest APIs with the goal of offering you unbiased ratings of landmarks and tourist attractions. YapQ rates places according to their interest on social media and provides Wikipedia content and Geonames ID at a given location. YapQ's service indexes millions of points around the world, and provides content in 12 different languages. This allows you to ensure you catch the *must-see* sights at a specific YapQ supported location (http://yapq.io/cities.html). Each point of interest comes with links to content, grading information, location and directions to help make discovering your destination easy and fun. This service is still under active development, and the response format may change without warning. We'd be interested in your feedback - send us an email (mailto:sandbox@yapq.com).
     *
     * @param latitude        Latitude of the center of the search, in decimal degrees (required)
     * @param longitude       Longitude of the center of the search, in decimal degrees (required)
     * @param radius          Radius around the center to look for points-of-interest around the given latitude and longitude in kilometers (km) (required)
     * @param lang            The preferred language of the content related to each point of interest. Content will be returned in this language if available (optional, default to EN)
     * @param category        Filters the resulting points_of_interest to include only results which have a least one category containing the given provided word. Good examples are &lt;em&gt;museum&lt;/em&gt;, &lt;em&gt;landmark&lt;/em&gt; or &lt;em&gt;church&lt;/em&gt; (optional, default to Museum)
     * @param geonames        Setting this to true includes only points of interest with a geonames ID (optional, default to false)
     * @param vibes           Includes content that doesn&#39;t correspond to an active physical place, but which gives the user some background information, or &lt;em&gt;vibe&lt;/em&gt; for the place they are visiting. An example of this may be information on an influential demolished building that used to exist at a certain location, or more information on a district of the city (optional, default to false)
     * @param socialMedia     Enabling this includes images from Instagram in the output results. This is disabled by default, since these images are often just pictures of people or food, which often have little relevance to the actual location (optional, default to false)
     * @param imageSize       The size of the images you&#39;d like to see in the response (optional, default to MEDIUM)
     * @param numberOfImages  Number of images to display. (optional, default to 4)
     * @param numberOfResults The maximum number of points of interest to return in the results set. This is a range from 1 to 100 (optional, default to 20)
     * @return PointsOfInterestResponse
     * @throws MuleRuntimeException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    @DisplayName("Point of Interest - YapQ Geosearch")
    @Alias("yapQGeosearch")
    @Summary("YapQ Geosearch - Find landmarks and attractions near a given point.")
    public PointsOfInterestResponse yapQGeosearch(
        @DisplayName("Latitude") @Alias("latitude") @Summary("Latitude of the center of the search, in decimal degrees (required)") BigDecimal latitude,
        @DisplayName("Longitude") @Alias("longitude") @Summary("Longitude of the center of the search, in decimal degrees (required)") BigDecimal longitude,
        @DisplayName("Radius") @Alias("radius") @Summary("Radius around the center to look for points-of-interest around the given latitude and longitude in kilometers (km) (required)") Integer radius,
        @DisplayName("Language") @Alias("lang") @Summary("The preferred language of the content related to each point of interest. Content will be returned in this language if available (optional, default to EN)") @Optional String lang,
        @DisplayName("Poi category") @Alias("category") @Summary("Filters the resulting points_of_interest to include only results which have a least one category containing the given provided word. Good examples are museum, landmark or church (optional, default to Museum)") @Optional String category,
        @DisplayName("Only geonames") @Alias("geonames") @Summary("Setting this to true includes only points of interest with a geonames ID (optional, default to false)") boolean geonames,
        @DisplayName("Only vibes") @Alias("vibes") @Summary("Includes content that doesn't correspond to an active physical place, but which gives the user some background information, or 'vibe' for the place they are visiting. An example of this may be information on an influential demolished building that used to exist at a certain location, or more information on a district of the city (optional, default to false)") boolean vibes,
        @DisplayName("Social media resources") @Alias("socialMedia") @Summary("Enabling this includes images from Instagram in the output results. This is disabled by default, since these images are often just pictures of people or food, which often have little relevance to the actual location (optional, default to false)") boolean socialMedia,
        @DisplayName("Image size") @Alias("imageSize") @Summary("The size of the images you'd like to see in the response (optional, default to MEDIUM)") @Optional String imageSize,
        @DisplayName("Number of images") @Alias("numberOfImages") @Summary("Number of images to display (optional, default to 4)") @Optional Integer numberOfImages,
        @DisplayName("Number of results") @Alias("numberOfResults") @Summary("The maximum number of points of interest to return in the results set. This is a range from 1 to 100 (optional, default to 20)") @Optional Integer numberOfResults,
        @Config final AmadeusTravelInnovationSandboxConfig config) {
        try {
            return api.yapQGeosearch(config
                .getApikey(), latitude, longitude, radius, lang, category, geonames, vibes, socialMedia, imageSize, numberOfImages, numberOfResults);
        } catch (ApiException e) {
            throw new MuleRuntimeException(I18nMessageFactory.createStaticMessage(e.getMessage()), e);
        }
    }

}