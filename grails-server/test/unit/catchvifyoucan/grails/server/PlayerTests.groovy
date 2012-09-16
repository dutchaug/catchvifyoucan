package catchvifyoucan.grails.server

import grails.test.*

class PlayerTests extends GrailsUnitTestCase {
    private static final String PLAYER_ID = "000000000000000"

    protected void setUp() {
        super.setUp()
        mockDomain(Player)
    }

    void testPlayerIdIsNotOptional() {
        Player player = new Player()

        player.save()

        assertTrue player.hasErrors()
        assertEquals "nullable", player.errors.getFieldError("playerId").code
    }

    void testTrailIsNotOptional() {
        Player player = new Player(playerId: PLAYER_ID, trail : null)

        player.save()

        assertTrue player.hasErrors()
        assertEquals "nullable", player.errors.getFieldError("trail").code
    }

    protected void tearDown() {
        super.tearDown()
    }
}
