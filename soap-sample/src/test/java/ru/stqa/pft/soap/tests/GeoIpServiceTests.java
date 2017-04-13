package ru.stqa.pft.soap.tests;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by Sergey on 13.04.2017.
 */
public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("178.165.64.12");
        assertEquals(geoIP.getCountryName(), "Ukraine");
    }

    @Test
    public void testMyInvalidIp() {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("122.165.64.as");
        String codeDet = geoIP.getReturnCodeDetails();
        assertEquals(geoIP.getReturnCodeDetails(), "Invalid IP address");
    }


}
