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

import java.io.File;

import org.junit.Test;
import org.sonar.gherkin.checks.AllowedCompositeTagsCheck;
import org.sonar.gherkin.checks.verifier.GherkinCheckVerifier;

public class AllowedCompositeTagsCheckTest {

  @Test
  public void test_default_white_list() {
    GherkinCheckVerifier.verify(new AllowedCompositeTagsCheck(), getTestFile("allowed-tags/allowed-tags-default.feature"));
  }

  @Test
  public void test_composite_tags() {
    GherkinCheckVerifier.verify(new AllowedCompositeTagsCheck(), getTestFile("allowed-tags/allowed-tags-composite.feature"));
  }

  @Test
  public void test_composite_tfs_tag() {
    GherkinCheckVerifier.verify(new AllowedCompositeTagsCheck(), getTestFile("allowed-tags/allowed-tfs-composite.feature"));
  }

  public static File getTestFile(String relativePath) {
	    return new File("src/test/resources/checks/" + relativePath);
	  }
}