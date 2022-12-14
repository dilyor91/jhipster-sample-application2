package uz.tashkec.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import uz.tashkec.web.rest.TestUtil;

class WorkPlanTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(WorkPlan.class);
        WorkPlan workPlan1 = new WorkPlan();
        workPlan1.setId(1L);
        WorkPlan workPlan2 = new WorkPlan();
        workPlan2.setId(workPlan1.getId());
        assertThat(workPlan1).isEqualTo(workPlan2);
        workPlan2.setId(2L);
        assertThat(workPlan1).isNotEqualTo(workPlan2);
        workPlan1.setId(null);
        assertThat(workPlan1).isNotEqualTo(workPlan2);
    }
}
