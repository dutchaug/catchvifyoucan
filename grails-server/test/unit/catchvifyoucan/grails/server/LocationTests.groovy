package catchvifyoucan.grails.server

import grails.test.*

class LocationTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockDomain(Location)
    }

    void testLatitudeIsNotOptional() {
        Location location = new Location()

        location.save()

        assertTrue location.hasErrors()
        assertEquals "nullable", location.errors.getFieldError('latitude').code
    }

    void testLongitudeIsNotOptional() {
        Location location = new Location(latitude: Long.valueOf(1L))

        location.save()

        assertTrue location.hasErrors()
        assertEquals "nullable", location.errors.getFieldError('longitude').code
    }

    protected void tearDown() {
        super.tearDown()
    }
}
