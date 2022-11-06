package com.jpedroborges.fd.togglemanager.repository.converters;

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
class ToListTlaModelTest {

    List<Tla> transformedList;
    List<com.jpedroborges.fd.togglemanager.repository.dto.Tla> originalList;
    @Autowired
    private ToListTlaModel victim;
    @MockBean
    private ToTlaModel converter;

    @PostConstruct
    void setUp() {
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
        Tla transformed = Tla.builder()
                .internalName("abc123")
                .toggles(newArrayList(transformedToggle1, transformedToggle2))
                .name("abc")
                .urlPattern("abc123-{XHY}")
                .build();
        transformedList = newArrayList(transformed);

        com.jpedroborges.fd.togglemanager.repository.dto.Toggle originalToggle1 = new com.jpedroborges.fd.togglemanager.repository.dto.Toggle();
        originalToggle1.setName("toggleName1");
        originalToggle1.setTags(newArrayList("a"));
        originalToggle1.setStatus(false);
        com.jpedroborges.fd.togglemanager.repository.dto.Toggle originalToggle2 = new com.jpedroborges.fd.togglemanager.repository.dto.Toggle();
        originalToggle2.setName("toggleName2");
        originalToggle2.setTags(newArrayList("a", "b"));
        originalToggle2.setStatus(false);
        com.jpedroborges.fd.togglemanager.repository.dto.Tla original = new com.jpedroborges.fd.togglemanager.repository.dto.Tla();
        original.setName("abc");
        original.setToggles(newArrayList(originalToggle1, originalToggle2));
        originalList = newArrayList(original);

        when(converter.convert(original)).thenReturn(transformed);
    }

    @Test
    public void shouldConvert() {
        assertEquals(transformedList, victim.convert(originalList));
    }

    @Test
    public void shouldConvertEmpty() {
        assertEquals(victim.convert(newArrayList()).size(), 0);
    }

    @Test
    public void shouldNotConvert() {
        assertNull(victim.convert(null));
    }


}