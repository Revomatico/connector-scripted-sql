import org.forgerock.openicf.misc.scriptedcommon.ScriptedConfiguration
import org.identityconnectors.framework.spi.ConfigurationClass
import org.identityconnectors.framework.spi.ConfigurationProperty

/**
 * Created by Viliam Repan (lazyman).
 */
@ConfigurationClass(skipUnsupported = true)
class MyexampleConfiguration extends ScriptedConfiguration {

    private String customExampleProperty = "defaultValue"

    @ConfigurationProperty(displayMessageKey = "someKey")
    String getCustomExampleProperty() {
        return customExampleProperty
    }

    void setCustomExampleProperty(String customExampleProperty) {
        this.customExampleProperty = customExampleProperty
    }
}