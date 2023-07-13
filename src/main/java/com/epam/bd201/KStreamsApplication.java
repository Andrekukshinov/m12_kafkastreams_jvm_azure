package com.epam.bd201;

import com.epam.bd201.formatter.StayTimeDateFormatter;
import com.epam.bd201.formatter.StayTimeDateFormatterImpl;
import com.epam.bd201.mapper.HotelMapper;
import com.epam.bd201.mapper.Mapper;
import com.epam.bd201.model.Hotel;
import com.epam.bd201.model.StayType;
import com.epam.bd201.service.HotelService;
import com.epam.bd201.service.HotelServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KStreamsApplication {

    private static final Logger LOG = LogManager.getLogger(KStreamsApplication.class);

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "logging-app-1");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        StayTimeDateFormatter dateFormatter = new StayTimeDateFormatterImpl(new SimpleDateFormat("yyyy-MM-dd"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        Mapper<Hotel> hotelMapper = new HotelMapper(objectMapper);
        HotelService hotelService = new HotelServiceImpl(hotelMapper, dateFormatter);
        //If needed

        final String INPUT_TOPIC_NAME = "expedia";
        final String OUTPUT_TOPIC_NAME = "expedia_ext";


        final StreamsBuilder builder = new StreamsBuilder();

        final KStream<String, String> input_records = builder.stream(INPUT_TOPIC_NAME, Consumed.with(Serdes.String(), Serdes.String()));

        //Transform your records here
        //input_records.map();


        input_records.mapValues(hotelService::returnUpdatedHotel)
                .to(OUTPUT_TOPIC_NAME, Produced.with(Serdes.String(), Serdes.String()));

        final Topology topology = builder.build();
        LOG.info(topology.describe());

        final KafkaStreams streams = new KafkaStreams(topology, props);
        final CountDownLatch latch = new CountDownLatch(1);

        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        try {
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);
    }
}