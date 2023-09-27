package jpcloudstream;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@Log4j2
public class JpCloudStreamApplication {

    // toUppercase-in-0
    // toUppercase-out-0
    @Bean
    public Function<String, String> toUppercase() {
        return String::toUpperCase;
    }

    // producer-out-0
    @Bean
    public Supplier<Flux<Long>> producer() {
        return () -> Flux.interval(Duration.ofSeconds(3)).log();
    }

    // processor-in-0
    // processor-out-0
     @Bean
    public Function<Flux<Long>, Flux<Long>> processor() {
        return flx -> flx.map(nbr -> nbr * nbr);
    }

    // consumer-in-0
    @Bean
    public Consumer<Long> consumer() {
        return number -> log.info("Value info [{}]", number);
    }

    public static void main(String[] args) {
        SpringApplication.run(JpCloudStreamApplication.class, args);
    }

}
