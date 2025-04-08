package pers.lilpen.domain.common.service.id.strategy;

import org.springframework.stereotype.Component;
import pers.lilpen.app.config.IdGeneratorConfigProperties;
import pers.lilpen.domain.common.service.id.IdGeneratorStrategy;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Component(value = "SNOWFLAKE")
public class SnowflakeIdGenerator implements IdGeneratorStrategy {

    private static final long START_TIMESTAMP = 1672531200000L;
    private static final long SEQUENCE_BITS = 12;
    private static final long MACHINE_BITS = 5;
    private static final long DATACENTER_BITS = 5;
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);
    private static final long MAX_MACHINE_NUM = ~(-1L << MACHINE_BITS);
    private static final long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BITS);
    private static final long MACHINE_SHIFT = SEQUENCE_BITS;
    private static final long DATACENTER_SHIFT = SEQUENCE_BITS + MACHINE_BITS;
    private static final long TIMESTAMP_SHIFT = DATACENTER_SHIFT + DATACENTER_BITS;

    private final long datacenterId;
    private final long machineId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowflakeIdGenerator(IdGeneratorConfigProperties idGeneratorConfigProperties) {
        long datacenterId = idGeneratorConfigProperties.getDatacenterId();
        long machineId = idGeneratorConfigProperties.getMachineId();
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("Datacenter ID can't be greater than " + MAX_DATACENTER_NUM + " or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("Machine ID can't be greater than " + MAX_MACHINE_NUM + " or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    @Override
    public synchronized long generateId() {
        long currentTimestamp = getCurrentTimestamp();
        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0L) {
                currentTimestamp = getNextTimestamp();
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = currentTimestamp;

        return (currentTimestamp - START_TIMESTAMP) << TIMESTAMP_SHIFT
                | datacenterId << DATACENTER_SHIFT
                | machineId << MACHINE_SHIFT
                | sequence;
    }

    private long getNextTimestamp() {
        long timestamp = getCurrentTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = getCurrentTimestamp();
        }
        return timestamp;
    }

    private long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }
}