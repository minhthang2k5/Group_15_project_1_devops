package com.yas.order.viewmodel;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ErrorVmTest {

    @Test
    void testErrorVm() {
        ErrorVm errorVm = new ErrorVm("400", "Bad Request", "Invalid input");
        assertEquals("400", errorVm.statusCode());
        assertEquals("Bad Request", errorVm.title());
        assertEquals("Invalid input", errorVm.detail());
        assertTrue(errorVm.fieldErrors().isEmpty());

        ErrorVm errorVm2 = new ErrorVm("500", "Server Error", "System failure", List.of("error1"));
        assertEquals(1, errorVm2.fieldErrors().size());
        assertEquals("error1", errorVm2.fieldErrors().get(0));
        
        ResponeStatusVm response = new ResponeStatusVm("OK", "Success", "200");
        assertEquals("OK", response.title());
        assertEquals("Success", response.message());
        assertEquals("200", response.statusCode());
    }
}
