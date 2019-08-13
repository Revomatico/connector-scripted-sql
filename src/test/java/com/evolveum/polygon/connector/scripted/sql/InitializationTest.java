package com.evolveum.polygon.connector.scripted.sql;

import org.h2.Driver;
import org.identityconnectors.framework.api.APIConfiguration;
import org.identityconnectors.framework.api.ConnectorFacade;
import org.identityconnectors.framework.api.ConnectorFacadeFactory;
import org.identityconnectors.test.common.TestHelpers;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Viliam Repan (lazyman).
 */
public class InitializationTest {

	static {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Test
	@org.junit.jupiter.api.Test
	public void initializationTest() {
		ConnectorFacade con = setupConnector();
		AssertJUnit.assertNotNull(con);

		con.validate();

		con.schema();
		con.test();
	}

	private ScriptedSQLConfiguration createConfiguration() {
		ScriptedSQLConfiguration config = new ScriptedSQLConfiguration();

		config.setJdbcUrlTemplate("jdbc:h2:mem:testdb");
		config.setUser("sa");
		config.setJdbcDriver("org.h2.Driver");

		File scripts = new File("./src/test/resources/scripts");
		config.setScriptRoots(new String[]{scripts.getAbsolutePath()});

		config.setRecompileGroovySource(true);

		config.setCreateScriptFileName("CreateScript.groovy");
		config.setUpdateScriptFileName("UpdateScript.groovy");
		config.setDeleteScriptFileName("DeleteScript.groovy");
		config.setSearchScriptFileName("SearchScript.groovy");
		config.setTestScriptFileName("TestScript.groovy");
		config.setSyncScriptFileName("SyncScript.groovy");
		config.setSchemaScriptFileName("SchemaScript.groovy");

		config.setClasspath(new String[]{"."});

		config.setCustomConfiguration("MyexampleConfiguration");
		config.setScriptBaseClass("BaseScript");

		return config;
	}

	private ConnectorFacade setupConnector() {
		return setupConnector(createConfiguration());
	}

	private ConnectorFacade setupConnector(ScriptedSQLConfiguration config) {
		config.validate();

		ConnectorFacadeFactory factory = ConnectorFacadeFactory.getInstance();

		APIConfiguration impl = TestHelpers.createTestConfiguration(ScriptedSQLConnector.class, config);
		return factory.newInstance(impl);
	}
}
