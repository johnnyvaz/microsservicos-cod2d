package br.com.cod2d.redirect.archtest.config;

import br.com.cod2d.redirect.Fast;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.experimental.categories.Category;

@Category(Fast.class)
public class ArchTestConfig {
    private static final String PACKAGE = "com.luizalabs.api";

    protected JavaClasses classes = new ClassFileImporter()
            .withImportOption(new ImportOption.DoNotIncludeTests())
            .importPackages(PACKAGE);
}
