FROM alpine:latest

#RUN echo "nameserver 1.1.1.1" > /etc/resolv.conf  && echo "search mkkk.hu" >> /etc/resolv.conf
RUN apk update \
  && apk add --no-cache \
    openjdk25-jre \
    curl \
  && echo "config-server:x:1099:1099:,,,:/home/config-server:/bin/sh" >>/etc/passwd \
  && echo "config-server:x:1099:" >>/etc/group \
  && mkdir -p /home/config-server \
  && chown 1099:1099 /home/config-server \
  && rm -rf /tmp/* /var/cache/* \
  && mkdir -p /var/cache/apk


HEALTHCHECK \
  --interval=3m \
  --retries=2 \
  --timeout=2s \
  CMD if [ "ok" == $(curl --silent --show-error --max-time 3 "http://127.0.0.1:9090/utility/health_check") ]; then exit 0; else exit 1; fi;

LABEL maintainer="AstrA <gecsevar@gmail.com>"
WORKDIR /app/
COPY ./build/install/gecsevar-hu /app/
USER config-server
# Run the app
ENTRYPOINT ["/bin/sh","/app/bin/event-promoter-backend"]

#RUN mkdir /app
#WORKDIR /app
