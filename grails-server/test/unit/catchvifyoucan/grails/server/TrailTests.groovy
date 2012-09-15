package catchvifyoucan.grails.server

import grails.test.*

class TrailTests extends GrailsUnitTestCase {
    private Date MOMENT
    private Date LATER

    void setUp() {
        super.setUp()
        mockDomain(Trail)

        Calendar calendar = Calendar.getInstance()
        MOMENT = calendar.getTime()

        calendar.add(Calendar.MINUTE, 1);
        LATER = calendar.getTime()
    }

    void testTrailCreation() {
        Trail trail = new Trail()

        assertNotNull trail
    }

    void testAdditionOfLocations() {
        Trail trail = new Trail()

        trail.addToLocations(new Location())

        assertEquals 1, trail.getLocations().size()
    }

    void testOrderednessOfLocations() {
        Trail trail = new Trail()

        trail.addToLocations(new Location(dateCreated : LATER))
        trail.addToLocations(new Location(dateCreated : MOMENT))

        assertEquals 2, trail.getLocations().size()
        assert MOMENT, trail.locations[0].dateCreated
        assert LATER, trail.locations[2].dateCreated
    }
}
