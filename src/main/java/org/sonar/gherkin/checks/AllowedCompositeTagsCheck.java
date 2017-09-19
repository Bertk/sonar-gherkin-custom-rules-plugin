/*
 * SonarQube Cucumber Gherkin Custom Rules Plugin
 * Copyright (C) 2017-2017 Bert
 * bert.k@hotmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.gherkin.checks;

import java.util.Set;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.gherkin.api.tree.TagTree;
import org.sonar.plugins.gherkin.api.visitors.DoubleDispatchVisitorCheck;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;

@Rule(
    key = "allowed-composite-tag",
    priority = Priority.MAJOR,
    name = "list of valid tags should be used",
    tags = {Tags.TAG, Tags.CONVENTION})
  @SqaleConstantRemediation("5min")

public class AllowedCompositeTagsCheck extends DoubleDispatchVisitorCheck{

  // check specflow&specsync info http://gasparnagy.com/2016/02/integrating-specflow-with-microsoft-test-manager-mtm/
  private static final Set<String> ALLOWED_TAGS = ImmutableSet.of("smoketest", "sanitytest", "integrationtest", "systemtest",
          														  "apitest", "uitest", "unittest",
                                                                  "nonregressiontest");
  private static final Set<String> COMPOSITE_TAGS = ImmutableSet.of(
		  "tfs:(ht|f)tp(s?)\\:\\/\\/[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*(:(0-9)*)*(\\/?)([a-zA-Z0-9\\-\\.\\?\\,\\'\\/\\\\\\+&amp;%\\$#_]*)?", 
		  "tc:\\d+", "us:\\d+", "wi:\\d+", "bug:\\d+", "uid:[a-zA-Z''-'\\s]{1,40}", "owner:[a-zA-Z''-'_\\s]{1,40}");

  @Override
  public void visitTag(TagTree tree) {
    if (!ALLOWED_TAGS.contains(tree.text().toLowerCase())) {
    	String[] parts = tree.text().toLowerCase().split(":");
    	String message = "The tag \"" + tree.text() + "\" is not in the tag whitelist.";
    	boolean valid = false;
    	for (String tag:COMPOSITE_TAGS) {
    		valid = tag.startsWith(parts[0]+":");
    		if (valid) {
    			valid = tree.text().toLowerCase().matches(tag);
    			if (!valid) {
    				message = "The value \"" + parts[1] + "\" does not match reg-ex.";
    			}
    			break;
    			}
    		}
    	if (!valid) {
    		addPreciseIssue(tree, message);
    	}
    }
    // super method must be called in order to visit what is under the key node in the syntax tree
    super.visitTag(tree);
  }

}
