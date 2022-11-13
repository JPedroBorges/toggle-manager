package com.jpedroborges.fd.togglemanager.controllers.converters;

import com.jpedroborges.fd.togglemanager.BaseTypesForTest;
import com.jpedroborges.fd.togglemanager.controllers.dto.ToggleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ToToggleResponseTest extends BaseTypesForTest {

    private ToToggleResponse victim;

    @BeforeEach
    void setUp() {
        victim = new ToToggleResponse();
    }

    @Test
    public void shouldConvert() {
        ToggleResponse response = victim.convert(toggleModel());

        assertEquals("toggleName0", response.getName());
        assertFalse(response.getStatus());
        assertTrue(response.isMaster());
        assertEquals(newArrayList("a"), response.getTags());
    }

    @Test
    public void shouldNotConvert() {
        assertNull(victim.convert(null));
    }

}