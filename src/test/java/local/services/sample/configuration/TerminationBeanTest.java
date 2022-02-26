package local.service.sample.services.sample.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TerminationBeanTest {
    TerminationBean terminationBean;

    @BeforeAll
    void beforeAll() {
        terminationBean = new TerminationBean();
    }

    @Test
    void onDestroyTest() {
        Assertions.assertDoesNotThrow(()-> terminationBean.onDestroy());
    }
}
