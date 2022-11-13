package com.jpedroborges.fd.togglemanager.repository.converters;

import com.jpedroborges.fd.togglemanager.BaseTypesForTest;
import com.jpedroborges.fd.togglemanager.configs.TlaConfigurationProperties;
import com.jpedroborges.fd.togglemanager.models.Tla;
import com.jpedroborges.fd.togglemanager.models.Toggle;
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
class ToTlaModelTest extends BaseTypesForTest {

    private ToTlaModel victim;
    @Mock
    private TlaConfigurationProperties tlaConfiguration;
    @Mock
    private ToToggleModel toggleConverter;

    @BeforeEach
    void setUp() {
        victim = new ToTlaModel(tlaConfiguration,toggleConverter);
    }

    @Test
    public void shouldConvert() {
        Toggle transformedToggle1 = toggleModel();

        when(tlaConfiguration.getSuffix()).thenReturn("123");
        when(tlaConfiguration.getUrlPattern()).thenReturn("x{$TLA}x{XHY}x");
        when(toggleConverter.convert(any())).thenReturn(transformedToggle1);


        Tla response = victim.convert(tlaDTO());

        assertEquals("abc", response.getName());
        assertEquals("abc123", response.getInternalName());
        assertEquals("xabc123x{XHY}x", response.getUrlPattern());
        assertEquals(newArrayList(transformedToggle1, transformedToggle1), response.getToggles());
    }

    @Test
    public void shouldConvertEmptySuffix() {
        Toggle transformedToggle1 = toggleModel();

        when(tlaConfiguration.getSuffix()).thenReturn("123");
        when(tlaConfiguration.getUrlPattern()).thenReturn("x{$TLA}x{XHY}x");
        when(toggleConverter.convert(any())).thenReturn(transformedToggle1);
        when(tlaConfiguration.getSuffix()).thenReturn(null);

        Tla response = victim.convert(tlaDTO());

        assertEquals("abc", response.getName());
        assertEquals("abc", response.getInternalName());
        assertEquals("xabcx{XHY}x", response.getUrlPattern());
        assertEquals(newArrayList(transformedToggle1, transformedToggle1), response.getToggles());
    }

    @Test
    public void shouldNotConvert() {
        assertNull(victim.convert(null));
    }

}