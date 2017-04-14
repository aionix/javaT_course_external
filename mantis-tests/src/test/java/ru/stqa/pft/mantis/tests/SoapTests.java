package ru.stqa.pft.mantis.tests;
import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import biz.futureware.mantis.rpc.soap.client.ProjectData;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Set;

/**
 * Created by Sergey on 13.04.2017.
 */
public class SoapTests extends TestBase {

    @Test
    public void getProj() throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soapHelper().getProjects();
        for (Project project : projects) {
            System.out.println("name is: " + project.getName());
        }}

    @Test
    public void getProj2() throws RemoteException, ServiceException, MalformedURLException {
        MantisConnectPortType mc = new MantisConnectLocator().
                getMantisConnectPort(new URL("http://localhost/mantisbt-1.2.19/api/soap/mantisconnect.php"));
        ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "root");
        for (ProjectData project : projects) {
            System.out.println("name is: " + project.getName());
        }}

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soapHelper().getProjects();
        Issue issue = new Issue().withSummary("Bug number1")
                .withDescription("issue description")
                .withProject(projects.iterator().next());
        Issue issueCreated = app.soapHelper().addIssue(issue);
    }
}
