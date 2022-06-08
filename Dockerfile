FROM hseeberger/scala-sbt:17.0.2_1.6.2_3.1.1
ENV UI_CONFIG=tui
WORKDIR /caro
ADD . /caro
RUN sbt compile
RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean
CMD sbt run