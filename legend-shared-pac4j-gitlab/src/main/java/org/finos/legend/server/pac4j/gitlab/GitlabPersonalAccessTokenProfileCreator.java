// Copyright 2021 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.server.pac4j.gitlab;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.creator.ProfileCreator;

public class GitlabPersonalAccessTokenProfileCreator implements ProfileCreator<GitlabPersonalAccessTokenCredentials, GitlabPersonalAccessTokenProfile>
{
    private final String gitlabHost;

    public GitlabPersonalAccessTokenProfileCreator(String gitlabHost)
    {
        this.gitlabHost = gitlabHost;
    }

    @Override
    public GitlabPersonalAccessTokenProfile create(GitlabPersonalAccessTokenCredentials credentials, WebContext webContext)
    {
        return new GitlabPersonalAccessTokenProfile(credentials.getPersonalAccessToken(), credentials.getUserId(), credentials.getUserName(), this.gitlabHost);
    }
}
