package br.com.cod2d.consumer.unit.config;

import br.com.cod2d.consumer.Fast;
import org.junit.experimental.categories.Category;
import org.springframework.test.context.ActiveProfiles;

@Category(Fast.class)
@ActiveProfiles("test")
public abstract class UnitTestConfig {
}