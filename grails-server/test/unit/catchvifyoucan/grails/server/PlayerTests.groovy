package catchvifyoucan.grails.server

import grails.test.*

class PlayerTests extends GrailsUnitTestCase {
    private static final String COMMUNICATION_ID = "000000000000000"

    protected void setUp() {
        super.setUp()
        mockDomain(Player)
    }

    void testCommunicationIdIsNotOptional() {
        Player player = new Player()

        player.save()

        assertTrue player.hasErrors()
        assertEquals "nullable", player.errors.getFieldError("communicationId").code
    }

    void testTrailIsNotOptional() {
        Player player = new Player(communicationId: COMMUNICATION_ID, trail : null)

        player.save()

        assertTrue player.hasErrors()
        assertEquals "nullable", player.errors.getFieldError("trail").code
    }

    protected void tearDown() {
        super.tearDown()
    }
}
