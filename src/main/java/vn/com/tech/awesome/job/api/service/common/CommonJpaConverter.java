package vn.com.tech.awesome.job.api.service.common;

import com.fasterxml.jackson.core.type.TypeReference;
import vn.com.tech.awesome.job.api.util.JsonMapper;

import javax.persistence.AttributeConverter;

/**
 * @author Admin
 * @created 18/01/2024 - 11:33 AM
 * @project awesome-job-api
 */
public class CommonJpaConverter<E> implements AttributeConverter<E, String> {

    private final TypeReference<E> typeReference;

    public CommonJpaConverter(TypeReference<E> typeReference) {
        this.typeReference = typeReference;
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        return attribute == null ? null : JsonMapper.write(attribute);
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        return dbData == null ? null : JsonMapper.read(dbData, typeReference);
    }
}
