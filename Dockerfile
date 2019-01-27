FROM openjdk:8-jre
MAINTAINER Divyanshu kumar

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/demo.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib           /usr/share/myservice/lib
# Add the service itself
ARG JAR_FILE=demo-0.0.1-SNAPSHOT.jar

ADD target/${JAR_FILE} /usr/share/myservice/demo.jar

EXPOSE 8080