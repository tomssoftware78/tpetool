FROM openjdk:8-jdk-alpine as build
WORKDIR /workspace/app

ENV MAVEN_VERSION 3.5.4
ENV MAVEN_HOME /usr/lib/mvn
ENV PATH $MAVEN_HOME/bin:$PATH

RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz 
RUN tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz
RUN rm apache-maven-$MAVEN_VERSION-bin.tar.gz
RUN mv apache-maven-$MAVEN_VERSION /usr/lib/mvn

COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN mvn package -DskipTests

FROM openjdk:8-jre-alpine
RUN mkdir /app
RUN mkdir /logs
COPY --from=build /workspace/app/target/tpetool-0.0.1-SNAPSHOT.jar /app/tpetool-0.0.1-SNAPSHOT.jar

COPY ./start.sh .
RUN chmod +x ./*.sh
ENTRYPOINT /start.sh