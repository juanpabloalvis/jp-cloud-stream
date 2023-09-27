# Kafka stream
After defined a function and anotate with @Bean, It will auto-expose, we can see the auto-created topics 
checking in intellij tool or inside the container:
> kafka-topics.sh --bootstrap-server 127.0.0.1:9092 --list

We can see something like:


toUppercase-in-0

toUppercase-out-0

Functions table:
https://docs.spring.io/spring-cloud-stream/docs/4.1.x/reference/html/spring-cloud-stream-binder-kafka.html#_summary_of_function_based_programming_styles_for_kafka_streams



# Metrics
After enable metrics, we can se the list of the metrics for cloudstream that we have for example kafka:
>http://localhost:8089/actuator/metrics

Now, if we check the metric in detail:
> http://localhost:8089/actuator/metrics/kafka.producer.record.send.total