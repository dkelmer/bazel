package com.google.devtools.build.lib.cmdline;

import com.google.common.collect.ImmutableMap;
import com.google.devtools.build.lib.skylarkinterface.StarlarkContext;

public interface BazelContext extends StarlarkContext {
  ImmutableMap<RepositoryName, RepositoryName> getRepoRemapping();
}