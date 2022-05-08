FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1

ENV UI_CONFIG=tui
EXPOSE 8081 8082
WORKDIR /caro
ADD . /caro
RUN sbt compile
CMD sbt run
