package com.jpedroborges.fd.togglemanager.controllers.converters;

import com.jpedroborges.fd.togglemanager.controllers.dto.ToggleResponse;
import com.jpedroborges.fd.togglemanager.models.Toggle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ToToggleResponseTest {

    @Autowired
    private ToToggleResponse victim;

    @Test
    public void shouldConvert() {
        Toggle original = Toggle.builder()
                .name("toggleName")
                .status(false)
                .master(true)
                .tags(newArrayList("a", "b"))
                .build();

        ToggleResponse response = victim.convert(original);
        assertEquals("toggleName", response.getName());
        assertFalse(response.getStatus());
        assertTrue(response.isMaster());
        assertEquals(newArrayList("a", "b"), response.getTags());
    }

    @Test
    public void shouldNotConvert() {
        assertNull(victim.convert(null));
    }

}