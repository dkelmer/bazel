package com.google.devtools.build.lib.skyframe;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.devtools.build.lib.cmdline.RepositoryName;
import com.google.devtools.build.lib.skyframe.serialization.autocodec.AutoCodec;
import com.google.devtools.build.skyframe.SkyKey;
import com.google.devtools.build.skyframe.SkyValue;

//TODO(dannark): DO NOT SUBMIT, change these to workspaceassignments*
public class WorkspaceMappingsValue implements SkyValue {
    @AutoCodec
    @AutoCodec.VisibleForSerialization
    static final SkyKey KEY = () -> SkyFunctions.WORKSPACE_MAPPINGS;

    private final ImmutableMap<RepositoryName, RepositoryName> workspaceMappings;

    private WorkspaceMappingsValue(ImmutableMap workspaceMappings) {
        this.workspaceMappings = workspaceMappings;
    }

    /**
     * Returns the workspace mappings.
     */
    public ImmutableMap getMappings() {
        return workspaceMappings;
    }

    /** Returns the (singleton) {@link SkyKey} for {@link WorkspaceMappingsValue}s. */
    public static SkyKey key() {
        return KEY;
    }

    /** Returns a {@link WorkspaceMappingsValue} for a workspace with the given mappings. */
    public static WorkspaceMappingsValue withMappings(ImmutableMap workspaceMappings) {
        return new WorkspaceMappingsValue(Preconditions.checkNotNull(workspaceMappings));
    }


}
