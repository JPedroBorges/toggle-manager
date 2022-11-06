package com.jpedroborges.fd.togglemanager.repository.converters;

import com.jpedroborges.fd.togglemanager.models.Toggle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ToToggleModelTest {

    @Autowired
    private ToToggleModel victim;

    @Test
    public void shouldConvert() {
        com.jpedroborges.fd.togglemanager.repository.dto.Toggle original = new com.jpedroborges.fd.togglemanager.repository.dto.Toggle();
        original.setName("toggleName");
        original.setTags(newArrayList("a", "b"));
        original.setStatus(false);

        Toggle result = victim.convert(original);
        assertEquals("toggleName", result.getName());
        assertEquals(newArrayList("a", "b"), result.getTags());
        assertFalse(result.isStatus());
    }

    @Test
    public void shouldNotConvert() {
        assertNull(victim.convert(null));
    }

}