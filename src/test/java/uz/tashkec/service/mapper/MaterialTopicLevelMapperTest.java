package uz.tashkec.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaterialTopicLevelMapperTest {

    private MaterialTopicLevelMapper materialTopicLevelMapper;

    @BeforeEach
    public void setUp() {
        materialTopicLevelMapper = new MaterialTopicLevelMapperImpl();
    }
}