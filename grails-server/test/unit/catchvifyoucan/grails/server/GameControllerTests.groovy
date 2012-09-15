package catchvifyoucan.grails.server

import grails.test.*

class GameControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockDomain(Player)

        mockDomain(Game, [new Game(), new Game()])
    }

    void testAllGame() {
        def model = this.controller.games()

        assertEquals 2, model["games"].size
        assertEquals 1, model["games"][0].id
    }

    void testPlayersInGame() {
        addPlayersTo(1, [new Player(communicationId: "0"), new Player(communicationId: "1")])

        this.controller.params.id = 1
        def model = this.controller.game()

        assertEquals 2, model["players"].size()
    }

    private void addPlayersTo(gameId, players) {
        def game = Game.findById(gameId)
        players.each { player ->
            game.addToPlayers(player)
        }
        game.save()
    }

    void testCreateAGame() {
        this.controller.createGame()

        def games = Game.findAll()

        assertEquals 3, games.size()
    }

    protected void tearDown() {
        super.tearDown()
    }
}
