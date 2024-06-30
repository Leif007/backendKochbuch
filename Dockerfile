FROM gradle:8-jdk21 as builder
WORKDIR /
COPY src/main/java/htw_berlin/kochbuch_backend ./
RUN gradle build

FROM openjdk:21-slim
LABEL authors="Leif Stöhr, Alexander von Allwörden"
COPY --from=builder build/libs .
ENTRYPOINT ["java","-jar","/backendKochbuch-0.0.1-SNAPSHOT.jar"]