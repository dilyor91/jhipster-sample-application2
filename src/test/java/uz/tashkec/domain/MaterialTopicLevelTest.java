package uz.tashkec.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import uz.tashkec.web.rest.TestUtil;

class MaterialTopicLevelTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MaterialTopicLevel.class);
        MaterialTopicLevel materialTopicLevel1 = new MaterialTopicLevel();
        materialTopicLevel1.setId(1L);
        MaterialTopicLevel materialTopicLevel2 = new MaterialTopicLevel();
        materialTopicLevel2.setId(materialTopicLevel1.getId());
        assertThat(materialTopicLevel1).isEqualTo(materialTopicLevel2);
        materialTopicLevel2.setId(2L);
        assertThat(materialTopicLevel1).isNotEqualTo(materialTopicLevel2);
        materialTopicLevel1.setId(null);
        assertThat(materialTopicLevel1).isNotEqualTo(materialTopicLevel2);
    }
}
