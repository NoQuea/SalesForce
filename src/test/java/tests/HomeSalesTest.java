package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeSalesTest extends BaseTest {

    @Test(description = "View Profile icon should be opened", retryAnalyzer = Retry.class)
    public void viewProfileShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        loginPage.isPageOpen();
        homeSalesPage.clickViewProfile();

        assertTrue(viewProfileModalPage.isPageOpen(), "View Profile modal page doesn't open");
    }

    @Test(description = "Enter user settings", retryAnalyzer = Retry.class)
    public void enterUserSettings() {
        loginPage.open();
        loginPage.login(email, password);

        homeSalesPage.isPageOpen();
        homeSalesPage.clickViewProfile();
        viewProfileModalPage.clickSettings();

        assertTrue(settingsPage.isPageOpen(), "Settings page doesn't open");
    }

    @Test(description = "Log out of your account")
    public void logOut() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickViewProfile();
        viewProfileModalPage.clickLogOutLink();

        assertTrue(loginPage.isPageOpen(), "Login page doesn't open");
    }

    @Test(description = "Notifications icon should be opened", retryAnalyzer = Retry.class)
    public void notificationsShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickNotifications();
        assertTrue(notificationsModalPage.isPageOpen(), "Notifications modal page doesn't open");
    }

    @Test(description = "Setup icon should be opened", retryAnalyzer = Retry.class)
    public void setupShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickSetup();
        assertTrue(setupModalPage.isPageOpen(), "Setup modal page doesn't open");
    }

    @Test(description = "Salesforce Help icon should be opened", retryAnalyzer = Retry.class)
    public void salesforceHelpShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickSalesforceHelp();
        assertTrue(salesforceHelpModalPage.isPageOpen(), "Salesforce Help modal page doesn't open");
    }

    @Test(description = "Learning Paths icon should be opened", retryAnalyzer = Retry.class)
    public void learningPathsShouldBeOpened() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickLearningPaths();
        assertEquals(learningPathsModalPage.getText(), "Learning Paths", "Learning Paths modal page doesn't open");
    }

    @Test(description = "Click on the Calendar link", retryAnalyzer = Retry.class)
    public void clickOnCalendarLink() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickLink("Calendar");
        assertTrue(calendarModalPage.isPageOpen(), "Calendar modal page doesn't open");
    }

    @Test(description = "Click on the Dashboards, Notes, Groups links", retryAnalyzer = Retry.class)
    public void clickOnDashboardsNotesReportsGroupsLinks() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickLink("Dashboards");
        assertTrue(dashboardsModalPage.isPageOpen(), "Calendar modal page doesn't open");
        homeSalesPage.clickLink("Notes");
        assertTrue(notesModalPage.isPageOpen(), "Notes modal page doesn't open");
        homeSalesPage.clickLink("Groups");
        assertTrue(groupsModalPage.isPageOpen(), "Groups modal page doesn't open");
    }

    @Test(description = "Click on the Reports link", retryAnalyzer = Retry.class)
    public void clickOnReportsLink() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickLink("Reports");
        assertTrue(reportsModalPage.isPageOpen(), "Reports modal page doesn't open");
    }

    @Test(description = "Click on the Opportunities link", retryAnalyzer = Retry.class)
    public void clickOnOpportunitiesLink() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickLink("Opportunities");
        assertTrue(opportunitiesModalPage.isPageOpen(), "Opportunities modal page doesn't open");
    }

    @Test(description = "Click on the Tasks link", retryAnalyzer = Retry.class)
    public void clickOnTasksLink() {
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.isPageOpen();

        homeSalesPage.clickLink("Tasks");
        assertTrue(tasksModalPage.isPageOpen(), "Tasks modal page doesn't open");
    }

}
