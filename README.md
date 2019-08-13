# connector-scripted-sql
Scripted SQL Connector

Doc: https://wiki.evolveum.com/display/midPoint/ScriptedSQL+Connector


# Configuration

## Usage

### Maven

#### Dependency
See released versions at https://bintray.com/beta/#/raisercostin/maven/connector-scripted-sql

```
<dependency>
  <groupId>com.evolveum.polygon</groupId>
  <artifactId>connector-scripted-sql</artifactId>
  <version>2.1-revomatico</version>
</dependency>
```

#### Repository
```
<repository>
  <id>raisercostin-bintray</id>
  <url>https://dl.bintray.com/raisercostin/maven</url>
  <releases><enabled>true</enabled></releases>
  <snapshots><enabled>false</enabled></snapshots>
</repository>
```

## Development

- To release `mvn release:prepare release:perform -DskipTests=true -Prelease -Darguments="-DskipTests=true -Prelease"` 