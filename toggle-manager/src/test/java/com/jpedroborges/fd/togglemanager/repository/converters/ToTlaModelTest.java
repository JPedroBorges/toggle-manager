package com.jpedroborges.fd.togglemanager.repository.converters;

import com.jpedroborges.fd.togglemanager.configs.TlaConfigurationProperties;
import com.jpedroborges.fd.togglemanager.models.Tla;
import com.jpedroborges.fd.togglemanager.models.Toggle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class ToTlaModelTest {

    List<Toggle> transformedToggle;
    List<com.jpedroborges.fd.togglemanager.repository.dto.Toggle> originalToggle;
    @Autowired
    private ToTlaModel victim;
    @MockBean
    private TlaConfigurationProperties tlaConfiguration;
    @MockBean
    private ToToggleModel toggleConverter;

    @PostConstruct
    void setUp() {
        com.jpedroborges.fd.togglemanager.repository.dto.Toggle originalToggle1 = new com.jpedroborges.fd.togglemanager.repository.dto.Toggle();
        originalToggle1.setName("toggleName1");
        originalToggle1.setTags(newArrayList("a"));
        originalToggle1.setStatus(false);
        com.jpedroborges.fd.togglemanager.repository.dto.Toggle originalToggle2 = new com.jpedroborges.fd.togglemanager.repository.dto.Toggle();
        originalToggle2.setName("toggleName2");
        originalToggle2.setTags(newArrayList("a", "b"));
        originalToggle2.setStatus(false);
        originalToggle = newArrayList(originalToggle1, originalToggle2);

        Toggle transformedToggle1 = Toggle.builder()
                .name("toggleName1")
                .status(false)
                .tags(newArrayList("a"))
                .build();
        Toggle transformedToggle2 = Toggle.builder()
                .name("toggleName2")
                .status(false)
                .tags(newArrayList("a", "b"))
                .build();
        transformedToggle = newArrayList(transformedToggle1, transformedToggle2);

        when(tlaConfiguration.getSuffix()).thenReturn("123");
        when(tlaConfiguration.getUrlPattern()).thenReturn("x{$TLA}x{XHY}x");
        when(toggleConverter.convert(originalToggle1)).thenReturn(transformedToggle1);
        when(toggleConverter.convert(originalToggle2)).thenReturn(transformedToggle2);
    }

    @Test
    public void shouldConvert() {
        com.jpedroborges.fd.togglemanager.repository.dto.Tla original = new com.jpedroborges.fd.togglemanager.repository.dto.Tla();
        original.setName("abc");
        original.setToggles(originalToggle);

        Tla response = victim.convert(original);

        assertEquals("abc", response.getName());
        assertEquals("abc123", response.getInternalName());
        assertEquals("xabc123x{XHY}x", response.getUrlPattern());
        assertEquals(transformedToggle, response.getToggles());
    }

    @Test
    public void shouldConvertEmptySuffix() {
        when(tlaConfiguration.getSuffix()).thenReturn(null);

        com.jpedroborges.fd.togglemanager.repository.dto.Tla original = new com.jpedroborges.fd.togglemanager.repository.dto.Tla();
        original.setName("abc");
        original.setToggles(originalToggle);

        Tla response = victim.convert(original);

        assertEquals("abc", response.getName());
        assertEquals("abc", response.getInternalName());
        assertEquals("xabcx{XHY}x", response.getUrlPattern());
        assertEquals(transformedToggle, response.getToggles());
    }

    @Test
    public void shouldNotConvert() {
        assertNull(victim.convert(null));
    }

}