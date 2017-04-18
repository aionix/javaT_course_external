package ru.stqa.pft.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Sergey on 13.04.2017.
 */
public class SoapHelper {
    private final ApplicationManager app;

    public SoapHelper(ApplicationManager app) {
        this.app = app;
    }


    public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "root");
        return Arrays.asList(projects).stream().map(projectData -> new Project()
                .withId(projectData.getId().intValue())
                .withName(projectData.getName())).collect(Collectors.toSet());
    }

    private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
        return new MantisConnectLocator().
                    getMantisConnectPort(new URL("http://localhost/mantisbt-1.2.19/api/soap/mantisconnect.php"));
    }

    public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        IssueData issueData = new IssueData();
        issueData.setSummary(issue.getSummary());
        issueData.setDescription(issue.getDescription());  //тут и выше создаем временный объект с необходимыми полями
        issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()),
                issue.getProject().getName()));
        BigInteger issueId = mc.mc_issue_add("administrator", "root", issueData);
        IssueData createdIssue = mc.mc_issue_get("administrator", "root", issueId);
        //преобразовываем в объект в issue
        return new Issue().withId(createdIssue.getId().intValue())
                .withSummary(createdIssue.getSummary())
                .withDescription(createdIssue.getDescription())
                .withProject(new Project()
                        .withId(createdIssue.getProject().getId().intValue())
                        .withName(createdIssue.getProject().getName()));
    }
}
