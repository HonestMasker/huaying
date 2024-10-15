FROM registry.cn-hangzhou.aliyuncs.com/llnancy/amazoncorretto:17.0.12-alpine3.20
ADD ./target/huaying-app.jar /app.jar
CMD ["--server.port=8080"]
ENV spring.profiles.active="prod"
RUN apk add --no-cache tzdata && \
    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone && \
    apk del tzdata
LABEL maintainer=admin@lilu.org.cn
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
