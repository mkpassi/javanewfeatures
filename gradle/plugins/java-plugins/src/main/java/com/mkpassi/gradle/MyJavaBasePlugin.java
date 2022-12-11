package com.mkpassi.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.api.tasks.testing.Test;
import org.gradle.jvm.toolchain.JavaLanguageVersion;

public abstract class MyJavaBasePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project){
        project.getPlugins().apply("java");
        project.getPlugins().apply("com.diffplug.spotless");

        SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
        sourceSets.create("integrationTests");
        project.getTasks().register("integrationTests", Test.class,t -> {
            t.setTestClassesDirs(sourceSets.getByName("integrationTests").getOutput().getClassesDirs());
            t.setClasspath(sourceSets.getByName("integrationTests").getRuntimeClasspath());
            t.useJUnitPlatform();
        });

        project.getDependencies().getComponents().withModule("org.slf4j:slf4j-simple", Slf4jSimpleRule.class);

        JavaPluginExtension java = project.getExtensions().getByType(JavaPluginExtension.class);
        java.getToolchain().getLanguageVersion().set(JavaLanguageVersion.of(11));

        project.getTasks().withType(JavaCompile.class).configureEach(t -> {
            t.getOptions().setEncoding("UTF-8");
        });

        project.getTasks().named("test" , Test.class,t -> {
            t.useJUnitPlatform(junit -> junit.excludeTags("slow"));
            t.setMaxParallelForks(4);
            t.setMaxHeapSize("1g");
        });

        project.getTasks().register("testSlow", Test.class,t -> {
            t.setTestClassesDirs(sourceSets.getByName("test").getOutput().getClassesDirs());
            t.setClasspath(sourceSets.getByName("test").getRuntimeClasspath());
            t.useJUnitPlatform(junit -> junit.includeTags("slow"));
        });

        project.getTasks().named("check", t-> {
            t.dependsOn(project.getTasks().named("testSlow"));
        });
    }
}
