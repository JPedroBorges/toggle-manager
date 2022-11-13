package com.jpedroborges.fd.togglemanager.repository.converters;

import com.jpedroborges.fd.togglemanager.BaseTypesForTest;
import com.jpedroborges.fd.togglemanager.models.Tla;
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
class ToListTlaModelTest extends BaseTypesForTest {

    private ToListTlaModel victim;
    @Mock
    private ToTlaModel converter;

    @BeforeEach
    void setUp() {
        victim = new ToListTlaModel(converter);
    }

    @Test
    public void shouldConvert() {
        Tla tla = tlaModel();
        when(converter.convert(any())).thenReturn(tla);
        assertEquals(newArrayList(tla), victim.convert(newArrayList(tlaDTO())));
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