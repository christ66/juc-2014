package org.jenkinsci.plugins.JUCBeer;

import hudson.Extension;
import hudson.model.RootAction;

@Extension
public class JenkinsRootAction implements RootAction {
    public String getIconFileName() {
        return "/images/jenkins.png";
    }

    public String getDisplayName() {
        return "Jenkins home page";
    }

    public String getUrlName() {
        return "http://jenkins-ci.org";
    }
}
