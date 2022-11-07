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
class ToTlaResponseTest {

    List<ToggleResponse> transformedToggle;
    List<Toggle> originalToggle;
    @Autowired
    private ToTlaResponse victim;

    @MockBean
    private ToToggleResponse toggleConverter;

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
        originalToggle = newArrayList(originalToggle1, originalToggle2);

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
        transformedToggle = newArrayList(transformedToggle1, transformedToggle2);

        when(toggleConverter.convert(originalToggle1)).thenReturn(transformedToggle1);
        when(toggleConverter.convert(originalToggle2)).thenReturn(transformedToggle2);
    }

    @Test
    public void shouldConvert() {
        Tla original = Tla.builder()
                .internalName("abc123")
                .toggles(originalToggle)
                .name("abc")
                .urlPattern("abc123-{XHY}")
                .build();

        TlaResponse response = victim.convert(original);
        assertEquals("abc123", response.getInternalName());
        assertEquals("abc", response.getName());
        assertEquals(transformedToggle, response.getToggles());
    }

    @Test
    public void shouldNotConvert() {
        assertNull(victim.convert(null));
    }
}