package com.fronya.plugin;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Mojo(name = "copyfile")
public class CopyFileMojo extends AbstractMojo{

    @Parameter
    private File inputFile;

    @Parameter
    private File outputFile;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            Files.copy(inputFile.toPath(), outputFile.toPath());
        } catch (IOException e) {
            getLog().error("Plugin can't copy file");
        }
    }
}
