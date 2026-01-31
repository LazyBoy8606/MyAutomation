FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"

CMD ["mvn", "test"]
