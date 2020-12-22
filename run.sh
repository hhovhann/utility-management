#/bin/sh
mvn clean package && java -jar ./target/utility-management-1.0.0-SNAPSHOT.jar -DskipTests=false