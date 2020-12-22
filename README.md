# utility-management
Gas &amp; Water Usage Monitoring Application Demo Application

#Endpoints

* POST      /measurements                          - Insert measurements for given user
###### ```URL: http://localhost:8080/measurements```asciidoc

* Request Body
```asciidoc
{
   "userId":1,
   "gasMeter":12345,
   "coldWaterMeter":12345,
   "hotWaterMeter":12345
}
```

* Success Response Body
```asciidoc
{
    "userId": 1,
    "gasMeter": 12345,
    "coldWaterMeter": 12345,
    "hotWaterMeter": 12345,
    "error": "no errors"
}
```

* Error Response Body
```asciidoc
{
    "userId": null,
    "gasMeter": null,
    "coldWaterMeter": null,
    "hotWaterMeter": null,
    "error": "Something happened when trying to retrieve previously measurement."
}
```

* GET       /measurements/{user_id}                           - Get measurements for given user
###### ```URL: http://localhost:8080/measurements/1```asciidoc
* Success Response Body

```asciidoc
{
   "userId":1,
   "gasMeter":12345,
   "coldWaterMeter":12345,
   "hotWaterMeter":12345
}
```
* Error Response Body
```asciidoc
{
    "userId": null,
    "gasMeter": null,
    "coldWaterMeter": null,
    "hotWaterMeter": null,
    "error": "Something happened when trying to retrieve previously measurement."
}
```

# Build and Run application
From project folder execute ```./run.sh``` script

# Run from Terminal
* ```mvn clean package && java -jar ./target/utility-management-1.0.0-SNAPSHOT.jar```

# Stack
* Java 11
* Maven 3.6.1
* Spring Boot 2.4.1

# Build Project
mvn clean package

# Run Tests
mvn clean test

# Nice to have TODO's
* More unit and integration tests with different scenarios
* Validation custom logic with custom exceptions and handling responses with errors
* Application measurement and cross logging with AOP

# Estimation time
* Time 6h