package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeSalesTest extends BaseTest {

    @Test
    public void viewProfileShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        loginPage.isPageOpen();
        homeSalesPage.clickViewProfile();

        assertTrue(viewProfileModalPage.isPageOpen(), "View Profile modal page doesn't open");
    }

    @Test
    public void enterUserSettings() {
        loginPage.open();
        loginPage.login(email, password);

        homeSalesPage.isPageOpen();
        homeSalesPage.clickViewProfile();
        viewProfileModalPage.clickSettings();

        assertTrue(settingsPage.isPageOpen(), "Settings page doesn't open");
    }

    @Test
    public void logOut() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickViewProfile();
        viewProfileModalPage.clickLogOutLink();

        assertTrue(loginPage.isPageOpen(), "Login page doesn't open");
    }

    @Test
    public void notificationsShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.closeSubscribeButton();
        homeSalesPage.clickNotifications();
        assertTrue(notificationsModalPage.isPageOpen(), "Notifications modal page doesn't open");
    }

    @Test
    public void setupShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.closeSubscribeButton();
        homeSalesPage.clickSetup();
        assertTrue(setupModalPage.isPageOpen(), "Setup modal page doesn't open");
    }

    @Test
    public void salesforceHelpShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();
        homeSalesPage.closeSubscribeButton();

        homeSalesPage.clickSalesforceHelp();
        assertTrue(salesforceHelpModalPage.isPageOpen(), "Salesforce Help modal page doesn't open");
    }

    @Test
    public void learningPathsShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();
        homeSalesPage.closeSubscribeButton();

        homeSalesPage.clickLearningPaths();
        assertEquals(learningPathsModalPage.getText(), "Learning Paths", "Learning Paths modal page doesn't open");
    }

    @Test
    public void clickOnCalendarOpportunitiesTasksLinks() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickLink("Calendar");
        assertTrue(calendarModalPage.isPageOpen(), "Calendar modal page doesn't open");
        homeSalesPage.clickLink("Opportunities");
        assertTrue(opportunitiesModalPage.isPageOpen(), "Opportunities modal page doesn't open");
        homeSalesPage.clickLink("Tasks");
        assertTrue(tasksModalPage.isPageOpen(), "Tasks modal page doesn't open");

    }

    @Test
    public void clickOnDashboardsNotesReportsGroupsLinks() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();
        homeSalesPage.closeSubscribeButton();

        homeSalesPage.clickLink("Dashboards");
        assertTrue(dashboardsModalPage.isPageOpen(), "Calendar modal page doesn't open");
        homeSalesPage.clickLink("Notes");
        assertTrue(reportsModalPage.isPageOpen(), "Reports modal page doesn't open");
        homeSalesPage.clickLink("Groups");
        assertTrue(groupsModalPage.isPageOpen(), "Groups modal page doesn't open");
    }

    @Test
    public void clickOnReportsLinks() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickLink("Reports");
        assertTrue(reportsModalPage.isPageOpen(), "Reports modal page doesn't open");


    }

}
