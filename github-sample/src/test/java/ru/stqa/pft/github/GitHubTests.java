package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Sergey on 19.04.2017.
 */
public class GitHubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("a7ef7186bc37c53b5d94924c15849863791476f1 ");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("aionix", "javaT_course_external")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
