package org.jenkinsci.plugins.JUCBeer;

import hudson.Extension;
import hudson.cli.CLICommand;
import hudson.model.AbstractProject;
import hudson.model.Item;
import org.kohsuke.args4j.Option;

/**
 * Commented second is the "inefficient" way of writing the plugin.
 *
 * User: schristou88
 * Date: 6/18/14
 * Time: 5:23 PM
 */
@Extension
public class ExecuteTwoJobs extends CLICommand {

    @Option(name="--first", required = true, usage = "Name of the first job to build")
//    public String first
    public AbstractProject first;

    @Option(name="--second", required = true, usage = "Name of the second job to build")
//    public String second
    public AbstractProject second;

    @Override
    public String getShortDescription() {
        return "Execute two jobs.";
    }

    @Override
    protected int run() throws Exception {
//        AbstractProject firstProject = Jenkins.getInstance().getItemByFullName(first, AbstractProject.class);
//        AbstractProject secondProject = Jenkins.getInstance().getItemByFullName(second, AbstractProject.class);
//
//        // Check if the project exists. getItemByFullName may return null.
//        if (firstProject == null) {
//            throw new CmdLineException(null, "The project: " + first + " does not exist.");
//        }
//        if (secondProject == null) {
//            throw new CmdLineException(null, "The project: " + second + " does not exist.");
//        }
//
//        firstProject.scheduleBuild2(0);
//        secondProject.scheduleBuild2(0);



        first.checkPermission(Item.BUILD);
        second.checkPermission(Item.BUILD);
        first.scheduleBuild2(0);
        second.scheduleBuild2(0);
        return 0;
    }
}
