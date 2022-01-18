FROM openjdk:8u312-jre
WORKDIR /playcrud
COPY target/universal/play-rest-api-crud-1.0-SNAPSHOT.zip .
COPY entrypoint.sh .
RUN unzip play-rest-api-crud-1.0-SNAPSHOT.zip && \
       chmod +x entrypoint.sh
EXPOSE 9000
ENV PORT="5432DB_URL="localhost" " USER="postgres" PASS="admin" PLAY_SECRET="secret12345678910"
ENTRYPOINT ["./entrypoint.sh"]