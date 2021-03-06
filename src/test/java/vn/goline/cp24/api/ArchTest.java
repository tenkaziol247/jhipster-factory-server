package vn.goline.cp24.api;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("vn.goline.cp24.api");

        noClasses()
            .that()
            .resideInAnyPackage("vn.goline.cp24.api.service..")
            .or()
            .resideInAnyPackage("vn.goline.cp24.api.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..vn.goline.cp24.api.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
