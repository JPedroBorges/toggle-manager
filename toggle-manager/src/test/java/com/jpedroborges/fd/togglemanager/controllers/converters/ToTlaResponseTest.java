package com.jpedroborges.fd.togglemanager.controllers.converters;

import com.jpedroborges.fd.togglemanager.BaseTypesForTest;
import com.jpedroborges.fd.togglemanager.controllers.dto.TlaResponse;
import com.jpedroborges.fd.togglemanager.controllers.dto.ToggleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToTlaResponseTest extends BaseTypesForTest {
    private ToTlaResponse victim;

    @Mock
    private ToToggleResponse toggleConverter;

    @BeforeEach
    void setUp() {
        victim = new ToTlaResponse(toggleConverter);
    }

    @Test
    public void shouldConvert() {
        ToggleResponse transformedToggle1 = toggleResponse();

        when(toggleConverter.convert(any())).thenReturn(transformedToggle1);

        TlaResponse response = victim.convert(tlaModel());
        assertEquals("abc0", response.getInternalName());
        assertEquals("abc", response.getName());
        assertEquals(newArrayList(transformedToggle1,transformedToggle1), response.getToggles());
    }

    @Test
    public void shouldNotConvert() {
        assertNull(victim.convert(null));
    }
}