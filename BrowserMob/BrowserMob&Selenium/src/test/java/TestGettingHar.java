import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import net.lightbody.bmp.core.har.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

/**
 * Created by GaBi on 02.06.2016.
 *
 */
public class TestGettingHar {

    private static final String BASE_URL = "https://basegroup.ru/";
    private static final String HAR_FILE_PATH = "results\\basegroup.har";
    private static final String HAR_LABEL = "basegroup.har";
    private static final String XPATH_OF_SEARCH_BUTTON = "//div[@class='bg-userbox']/a[1]";
    private static final String CLASS_NAME_OF_SEARCH_FIELD = "form-text";
    private static final String EXCEL_FILE_PATH = "results\\timingTable.xls";
    private static final String SHEET_NAME = "Timing data";
    private static final String FIRST_COLUMN_NAME = "Time";
    private static final String SECOND_COLUMN_NAME = "Url";
    private WebDriver driver;
    private BrowserMobProxy proxy;
    private Har har;


    @BeforeClass
    public void setUp() throws Exception {

        // start the proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);
    }

    @BeforeMethod
    public void startDriver(){

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // start the browser up
        driver = new FirefoxDriver(capabilities);

        // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        // create a new HAR with the label "basegroup.har"
        proxy.newHar(HAR_LABEL);
    }

    @Test
    public void pagesSurfing() throws Exception {

        // open basegroup.ru
        driver.get(BASE_URL);

        // find search button and click
        driver.findElement(By.xpath(XPATH_OF_SEARCH_BUTTON)).click();

        // check if search field is enabled
        assertTrue(driver.findElement(By.className(CLASS_NAME_OF_SEARCH_FIELD)).isEnabled());
    }

    @AfterMethod
    public void writeHar() throws Exception{

        // get the HAR data
        har = proxy.getHar();
        // save request and time from har to excel
        printHarLogToExcel();
        // handling har-data, save har file
        try {
            File file = new File(HAR_FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                har.writeTo(fileOutputStream);
            } finally {
                fileOutputStream.close();
            }
        } catch (IOException e) {
            // handling exception
            e.printStackTrace();
        } finally {
            // stop the browser
            driver.quit();
        }
    }

    @AfterClass
    public void tearDown() {

        // stop the proxy
        proxy.stop();
    }

    /**
     * Prints the information about request and time from har to excel file
     *
     */
    public void printHarLogToExcel(){
        Map<String, Long> unsortedMap = new HashMap<String, Long>();

        for (HarEntry entry : har.getLog().getEntries()) {
            HarRequest request = entry.getRequest();

            //creating unsorted map of url as a key and time as a value
            unsortedMap.put(request.getUrl(), entry.getTime());
        }

        // Forcing the descending order by creating our own comparator then passing it to the sorted map at creation time
        Map<String, Long> sortedMap = sortByComparator(unsortedMap);

        // Write sortedMap to excel file
        writeExcel(sortedMap);
    }

    /**
     * Sorts the map by comparator from the highest time to the lowest
     * @param unsortedMap the map
     * @return sortedMap
     */
    private static Map<String, Long> sortByComparator(Map<String, Long> unsortedMap) {

        // Convert Map to List
        List<Map.Entry<String, Long>> list =
                new LinkedList<Map.Entry<String, Long>>(unsortedMap.entrySet());

        // Sort list with comparator, to compare the Map values
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o1,
                               Map.Entry<String, Long> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // Convert sorted map back to a Map
        Map<String, Long> sortedMap = new LinkedHashMap<String, Long>();
        for (Iterator<Map.Entry<String, Long>> it = list.iterator(); it.hasNext();) {
            Map.Entry<String, Long> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    /**
     * Prints the map
     * @param map the map
     */
    public static void printMap(Map<String, Long> map) {
        for (Entry<String, Long> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }

    /**
     * Writes the map to excel file
     * @param sortedMap the map
     */
    public void writeExcel(Map<String, Long> sortedMap) {

        // Create a new Workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a blank sheet
        XSSFSheet sheet = workbook.createSheet(SHEET_NAME);

        // Create first row and write headers of columns
        Row firstRow = sheet.createRow(0);
        Cell headerCellOfFirstColumn = firstRow.createCell(0);
        headerCellOfFirstColumn.setCellValue(FIRST_COLUMN_NAME);
        Cell headerCellOfSecondColumn = firstRow.createCell(1);
        headerCellOfSecondColumn.setCellValue(SECOND_COLUMN_NAME);

        // Iterate over data and write it to the sheet
        int rowNum = 1;
        for (Entry entry : sortedMap.entrySet()) {
            Row row = sheet.createRow(rowNum++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue((Long)entry.getValue());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue((String)entry.getKey());
        }

        //Save the excel sheet
        try{
            FileOutputStream out = new FileOutputStream(new File(EXCEL_FILE_PATH));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
