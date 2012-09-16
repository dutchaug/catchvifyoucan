package catchvifyoucan.grails.server

import grails.test.*

class GameTests extends GrailsUnitTestCase {
    private static int playerId = 0

    protected void setUp() {
        super.setUp()
        mockDomain(Game)
    }

    void testGameCreation() {
        Game game = new Game()

        assertNotNull game
    }

    void testAdditionOfPlayers() {
        Game game = new Game()

        game.addToPlayers(new Player(playerId: nextPlayerId()))

        assert 1, game.players.size
    }

    protected void tearDown() {
        super.tearDown()
    }

    private static final synchronized nextPlayerId() {
        return playerId++
    }
}
