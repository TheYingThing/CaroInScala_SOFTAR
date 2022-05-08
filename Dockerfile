FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1
ENV UI_CONFIG=tui
EXPOSE 8081 8082
WORKDIR /caro
ADD . /caro
RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*
CMD sbt run