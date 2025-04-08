package pers.lilpen.domain.common.service.id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.lilpen.domain.common.model.valobj.IdGeneratorType;

import java.util.Map;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Component
public class IdGenerator {
    private final Map<String, IdGeneratorStrategy> idGeneratorStrategyMap;

    @Autowired
    public IdGenerator(Map<String, IdGeneratorStrategy> idGeneratorStrategyMap) {
        this.idGeneratorStrategyMap = idGeneratorStrategyMap;
    }

    public String generateId(IdGeneratorType idGeneratorType) {
        IdGeneratorStrategy idGeneratorStrategy = idGeneratorStrategyMap.get(idGeneratorType.name());
        if (idGeneratorStrategy == null) {
            throw new IllegalArgumentException("No IdGeneratorStrategy found for type: " + idGeneratorType);
        }
        return String.valueOf(idGeneratorStrategy.generateId());
    }
}
