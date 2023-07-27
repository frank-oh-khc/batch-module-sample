FROM openjdk:18-alpine AS builder
ENV JAR_FILE=build/libs/*.jar
COPY $JAR_FILE application.jar
RUN java -Djarmode=layertools -jar application.jar extract


FROM openjdk:18-alpine

ARG VERSION
RUN echo ${VERSION}

COPY --from=builder dependencies/ ./
RUN true
COPY --from=builder spring-boot-loader/ ./
RUN true
COPY --from=builder snapshot-dependencies/ ./
RUN true
COPY --from=builder application/ ./

ENV VERSION=${VERSION}

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
