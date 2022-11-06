package com.jpedroborges.fd.togglemanager.controllers.converters;

import com.jpedroborges.fd.togglemanager.controllers.dto.TlaResponse;
import com.jpedroborges.fd.togglemanager.controllers.dto.ToggleResponse;
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
class ToListTlaResponseTest {

    List<TlaResponse> transformedList;
    List<Tla> originalList;
    @Autowired
    private ToListTlaResponse victim;
    @MockBean
    private ToTlaResponse converter;

    @PostConstruct
    void setUp() {
        Toggle originalToggle1 = Toggle.builder()
                .name("toggleName1")
                .status(false)
                .tags(newArrayList("a"))
                .build();
        Toggle originalToggle2 = Toggle.builder()
                .name("toggleName2")
                .status(false)
                .tags(newArrayList("a", "b"))
                .build();
        Tla original = Tla.builder()
                .internalName("abc123")
                .toggles(newArrayList(originalToggle1, originalToggle2))
                .name("abc")
                .urlPattern("abc123-{XHY}")
                .build();
        originalList = newArrayList(original);

        ToggleResponse transformedToggle1 = ToggleResponse.builder()
                .name("toggleName1")
                .status(false)
                .tags(newArrayList("a"))
                .build();
        ToggleResponse transformedToggle2 = ToggleResponse.builder()
                .name("toggleName2")
                .status(false)
                .tags(newArrayList("a", "b"))
                .build();
        TlaResponse transformed = TlaResponse.builder()
                .numberOfInstances(0)
                .internalName("abc123")
                .name("abc")
                .toggles(newArrayList(transformedToggle1, transformedToggle2))
                .build();
        transformedList = newArrayList(transformed);

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