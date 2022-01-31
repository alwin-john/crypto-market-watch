FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
COPY build/libs/crypto-price-api-0.0.1-SNAPSHOT.jar crypto-price-api.jar
EXPOSE 8080
RUN bash -c 'touch /crypto-price-api.jar'
ENTRYPOINT ["java","-jar","/crypto-price-api.jar"]
CMD ["-start"]
