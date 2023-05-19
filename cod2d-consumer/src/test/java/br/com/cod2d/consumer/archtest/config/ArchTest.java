package br.com.cod2d.consumer.archtest.config;

import br.com.cod2d.consumer.Fast;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.experimental.categories.Category;

@Category(Fast.class)
public class ArchTest {

    private static final String PACKAGE = "br.com.cod2d.consumer";

    protected JavaClasses classes = new ClassFileImporter()
            .withImportOption(new ImportOption.DoNotIncludeTests())
            .importPackages(PACKAGE);

}
