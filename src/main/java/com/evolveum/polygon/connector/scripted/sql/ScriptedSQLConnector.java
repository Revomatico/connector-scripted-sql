package com.evolveum.polygon.connector.scripted.sql;

import groovy.lang.Binding;
import org.forgerock.openicf.misc.scriptedcommon.OperationType;
import org.identityconnectors.common.StringUtil;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.Uid;
import org.identityconnectors.framework.spi.ConnectorClass;

import java.util.Set;

/**
 * Created by Viliam Repan (lazyman).
 */
@ConnectorClass(
		displayNameKey = "groovy.sql.connector.display",
		configurationClass = ScriptedSQLConfiguration.class,
		messageCatalogPaths = {"org/forgerock/openicf/connectors/groovy/Messages", "org/forgerock/openicf/connectors/scriptedsql/Messages"}
)
public class ScriptedSQLConnector extends org.forgerock.openicf.connectors.scriptedsql.ScriptedSQLConnector {

	@Override
	protected Binding createBinding(Binding arguments, OperationType action, ObjectClass objectClass,
									Uid uid, Set<Attribute> attributes, OperationOptions options) {
		Binding binding = super.createBinding(arguments, action, objectClass, uid, attributes, options);
		if (!OperationType.SCHEMA.equals(action)
				&& StringUtil.isNotBlank(getScriptedConfiguration().getSchemaScriptFileName())) {
			arguments.setVariable(SCHEMA, schema());
		}
		return binding;
	}
}
