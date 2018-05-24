package es.jpm.mule.extensions.amadeus.internal;

import es.jpm.mule.extensions.amadeus.internal.config.AmadeusTravelInnovationSandboxConfig;
import org.mule.runtime.api.meta.Category;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Export;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

@Xml(prefix = "amadeusSandbox")
@Extension(name = "Amadeus Travel Innovation Sandbox", vendor = "JPM", category = Category.COMMUNITY)
@Configurations(AmadeusTravelInnovationSandboxConfig.class)
public class AmadeusTravelInnovationSandboxMuleExtension {

}
