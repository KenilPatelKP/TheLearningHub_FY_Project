from azul/zulu-openjdk-alpine
EXPOSE 8080
copy ./target/Lernado-0.0.1-SNAPSHOT.war /
entrypoint java -jar ./Lernado-0.0.1-SNAPSHOT.war