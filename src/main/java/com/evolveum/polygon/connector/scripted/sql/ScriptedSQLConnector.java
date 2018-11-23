package com.evolveum.polygon.connector.scripted.sql;

import org.identityconnectors.framework.spi.ConnectorClass;

/**
 * Created by Viliam Repan (lazyman).
 */
@ConnectorClass(
		displayNameKey = "groovy.sql.connector.display",
		configurationClass = ScriptedSQLConfiguration.class,
		messageCatalogPaths = {"org/forgerock/openicf/connectors/groovy/Messages", "org/forgerock/openicf/connectors/scriptedsql/Messages"}
)
public class ScriptedSQLConnector extends org.forgerock.openicf.connectors.scriptedsql.ScriptedSQLConnector {
}
