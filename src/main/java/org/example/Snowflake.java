package org.example;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Snowflake {
    private static LocalDateTime epoch = LocalDateTime.of(
            2020,
            1,
            1,
            0, 0,
            0
    );
    private static final long epochMilli = epoch.toInstant(ZoneOffset.UTC).toEpochMilli();
    private static long lastTimeStamp = -1L;
    private static final int SEQUENCE_BITS = 12;
    private static final long SEQUENCE_MASK = ~(-1L << 12);
    private static long sequence = 0L;
    private static long machineId = 7L;

    public static String format(long i) {
        StringBuilder result = new StringBuilder();
        String binaryString = Long.toBinaryString(i);
        String paddedBinaryString = "0".repeat(64 - binaryString.length()) + binaryString;

        for (int j = 0; j < 64; j++) {
            result.append(paddedBinaryString.charAt(j));
            if((j + 1) % 8 == 0 && j != 63){
                result.append("_");
            }
        }

        return result.toString();
    }

    public static synchronized long generate(long timestamp){

        if(timestamp == lastTimeStamp){
            sequence = (sequence + 1L) & SEQUENCE_MASK;
            System.out.println("sequence:"  + sequence);
            if(sequence == 0){
                while(timestamp <= lastTimeStamp){
                    timestamp = System.currentTimeMillis();
                }
            }
        } else {
            sequence = 0L;
        }

        lastTimeStamp = timestamp;

        long id = 0L;
        id = id | ( (timestamp - epochMilli) << 22) | (machineId << SEQUENCE_BITS) | sequence;

        return id;
    }
}
