# connector-scripted-sql
Scripted SQL Connector

Doc: https://wiki.evolveum.com/display/midPoint/ScriptedSQL+Connector

# Configuration

## Usage

### Maven

#### Dependency

```
<dependency>
  <groupId>org.raisercostin</groupId>
  <artifactId>jedio</artifactId>
  <version>0.1</version>
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