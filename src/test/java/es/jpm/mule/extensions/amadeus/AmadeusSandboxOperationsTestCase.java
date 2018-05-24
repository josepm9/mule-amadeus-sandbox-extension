package es.jpm.mule.extensions.amadeus;

import io.swagger.client.model.AirportAutocompleteResponse;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.StringEndsWith;
import org.hamcrest.core.StringStartsWith;
import org.junit.Test;
import org.mockito.internal.matchers.EndsWith;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;

import java.util.List;

public class AmadeusSandboxOperationsTestCase extends MuleArtifactFunctionalTestCase {

    /**
     * Specifies the mule config xml with the flows that are going to be
     * executed in the tests, this file lives in the test resources.
     */
    @Override
    protected String getConfigFile() {
        return "Flights-test-flows.xml";
    }

    @Test
    public void airportAutocompleteOperation() throws Exception {
        final List<AirportAutocompleteResponse> payloadValue = ((List<AirportAutocompleteResponse>) this.flowRunner("airport-autocomplete-flow").run()
            .getMessage()
            .getPayload()
            .getValue());
        MatcherAssert.assertThat(payloadValue.size(), Is.is(1));
        final AirportAutocompleteResponse r = payloadValue.get(0);
        MatcherAssert.assertThat(r.getValue(), Is.is("MAD"));
        MatcherAssert.assertThat(r.getLabel(), StringEndsWith.endsWith("Barajas Airport [MAD]"));
    }

}
