package org.jenkinsci.plugins.JUCBeer;

import hudson.MarkupText;
import hudson.console.ConsoleAnnotator;
import hudson.console.ConsoleNote;

/**
 * User: schristou88
 * Date: 6/18/14
 * Time: 5:12 PM
 */
public class BeerConsoleNote extends ConsoleNote {
    @Override
    public ConsoleAnnotator annotate(Object context, MarkupText text, int charPos) {
        StringBuilder stringBuilder = new StringBuilder("<p style=\"font-size:20px\">");
        stringBuilder.append("The builder passed! Time to celebrate with some ");
        stringBuilder.append("&#127866;");
        stringBuilder.append("</p>");
        text.addMarkup(charPos, stringBuilder.toString());
        return null;
    }
}
