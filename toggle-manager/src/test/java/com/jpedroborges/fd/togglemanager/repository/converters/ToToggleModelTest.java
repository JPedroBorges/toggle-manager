package com.jpedroborges.fd.togglemanager.repository.converters;

import com.jpedroborges.fd.togglemanager.BaseTypesForTest;
import com.jpedroborges.fd.togglemanager.models.Toggle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ToToggleModelTest  extends BaseTypesForTest  {

    private ToToggleModel victim;

    @BeforeEach
    void setUp() {
        victim = new ToToggleModel();
    }

    @Test
    public void shouldConvert() {
        Toggle result = victim.convert(toggleDTO());

        assertEquals("toggleName0", result.getName());
        assertEquals(newArrayList("a"), result.getTags());
        assertFalse(result.getStatus());
        assertTrue(result.isMaster());
    }

    @Test
    public void shouldNotConvert() {
        assertNull(victim.convert(null));
    }

}