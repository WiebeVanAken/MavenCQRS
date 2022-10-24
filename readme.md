# MavenCQRS by Wiebe van Aken
An implementation of the CQRS pattern made by Wiebe van Aken, a student at the HAN University of Applied sciences.

CQRS is a pattern by Martin Fowler to segregate queries and commands in the context of software.
See [CQRS By Martin Fowler](https://martinfowler.com/bliki/CQRS.html)

## Usage
MavenCQRS requires JDK17, and is not available through the Maven Central Repository.

```xml
<dependency>
  <groupId>personal.wiebe</groupId>
  <artifactId>cqrs</artifactId>
  <version>1.1</version>
</dependency> 
```

## Example Code Usage

To create an example query / command:
```java
import personal.wiebe.cqrs.api.IQuery;
import personal.wiebe.cqrs.core.CqrsHandlerBase;

class GetTemperatureDataInCityQuery implements IQuery<Double[]> {
    private String city;

    GetTemperatureDataInCityQuery(String city) {
        this.city = city;
    }

    @Override
    public Class<? extends CqrsHandlerBase> getHandledBy() throws UnsupportedOperationException {
        return GetTemperatureDataInCityQueryHandler.class;
    }

    public String getCity() {
        return city;
    }
}
```

To create an example query/ commandhandler:
```java
import personal.wiebe.cqrs.core.QueryHandlerBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

class GetTemperatureDataInCityQueryHandler extends QueryHandlerBase<Double[], GetTemperatureDataInCityQueryHandler> {
    @Override
    protected Double[] handle(Connection connection, GetTemperatureDataInCityQueryHandler query) throws SQLException, IOException {
        if(query.getCity().equals("Arnhem")) {
            return new Double[] { 15.5, 14.3, 17.4, 12.9 };
        } else {
            return new Double[] { 16.8, 12.5, 18.6, 19.5 };
        }
    }
}
```

To execute the example query handler:
```java
import personal.wiebe.cqrs.api.CqrsMediator;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        var mediator = new CqrsMediator();
        
        var result = mediator.executeQuery(new GetTemperatureDataInCityQuery("Arnhem"));

        System.out.println(Arrays.toString(result));
    }
}
```

## Dependencies
This package uses the Jakarta EE CDI Dependency Container, it's not designed to work without Jakarta EE CDI.