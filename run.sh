#/bin/sh
mvn clean package -DskipTests=true && java -jar ./target/utility-management-1.0.0-SNAPSHOT.jar