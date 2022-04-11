package local.services.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void main() {
        Assertions.assertDoesNotThrow(()->Application.main(new String[] {}));
    }
}