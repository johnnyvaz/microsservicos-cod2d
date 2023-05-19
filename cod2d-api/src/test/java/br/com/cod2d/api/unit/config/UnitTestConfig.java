package br.com.cod2d.api.unit.config;

import br.com.cod2d.api.Fast;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

@Category(Fast.class)
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public abstract class UnitTestConfig {
}