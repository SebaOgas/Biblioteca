package com.utn.biblioteca.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.utn.biblioteca.controllers.ControladorBase;
import com.utn.biblioteca.repositories.RepositorioBase;
import com.utn.biblioteca.services.ServicioBase;
import jakarta.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.utn.biblioteca", importOptions = {ImportOption.DoNotIncludeTests.class})
public class ArchUnitTest {
    @ArchTest
    public static final ArchRule layerRule =
            layeredArchitecture().consideringAllDependencies()
            .layer("Controller").definedBy("com.utn.biblioteca.controllers")
            .layer("Service").definedBy("com.utn.biblioteca.services")
            .layer("Persistence").definedBy("com.utn.biblioteca.repositories")

            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

    @ArchTest
    public static final ArchRule controllerNameRule =
            classes().that().haveSimpleNameEndingWith("Controlador").should().resideInAPackage("com.utn.biblioteca.controllers");

    @ArchTest
    public static final ArchRule controllerBaseRule =
            classes().that().haveSimpleNameEndingWith("Controlador").should().implement(ControladorBase.class);

    @ArchTest
    public static final ArchRule serviceNameRule =
            classes().that().haveSimpleNameEndingWith("ServicioImpl").should().resideInAPackage("com.utn.biblioteca.services");

    @ArchTest
    public static final ArchRule serviceBaseRule =
            classes().that().haveSimpleNameEndingWith("ServicioImpl").should().implement(ServicioBase.class);

    @ArchTest
    public static final ArchRule repositoryNameRule =
            classes().that().haveSimpleNameEndingWith("Repositorio").should().resideInAPackage("com.utn.biblioteca.repositories");

    @ArchTest
    public static final ArchRule repositoryBaseRule =
            classes().that().haveSimpleNameEndingWith("Repositorio").should().beAssignableTo(RepositorioBase.class);

    @ArchTest
    public static final ArchRule entitiesAnotationRule =
            classes().that().resideInAPackage("com.utn.biblioteca.entities").should().beAnnotatedWith(Entity.class)
                    .orShould().haveSimpleName("EntidadBase");

}
