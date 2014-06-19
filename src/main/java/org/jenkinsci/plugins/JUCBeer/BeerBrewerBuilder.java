package org.jenkinsci.plugins.JUCBeer;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import hudson.util.ArgumentListBuilder;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;
import java.io.PrintStream;

/**
 * This class will create a simple Builder that will:
 *
 * Print to console "Hello World"
 * Print to console the list of build culprits
 * Sleep on a slave machine for 10 seconds.
 * Print to console "The builder passed! Time to celebrate with some :beer:" with size 20 font.
 *
 * User: schristou88
 * Date: 6/18/14
 * Time: 4:34 PM
 */
@Extension
public class BeerBrewerBuilder extends Builder {

    @DataBoundConstructor
    public BeerBrewerBuilder() {}

    @Override
    public boolean perform(AbstractBuild<?,?> build,
                           Launcher launcher,
                           BuildListener listener)
            throws InterruptedException, IOException {
        PrintStream logger = listener.getLogger();
        logger.println("Hello world");
        logger.println(build.getCulprits());

        ArgumentListBuilder argumentListBuilder = new ArgumentListBuilder();
        argumentListBuilder.add("sleep", "10");

        int join = launcher.launch().cmds(argumentListBuilder).join();

        if (join != 0) {
            logger.println("Issue with the build step. Exited with: " + join);
            return false;
        }

        listener.annotate(new BeerConsoleNote());


        return true;
    }

    @Extension
    public static class DescriptorImpl extends BuildStepDescriptor<Builder> {

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "Beer Brew Builder";
        }
    }
}
