package catchvifyoucan.grails.server

import grails.test.*

class PlayerControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockDomain(Game, [new Game()])

        mockDomain(Player, [new Player(playerId: "0")])
        Game game = Game.findById(1)
        game.addToPlayers(Player.findById(1))
        game.save()

        mockDomain(Trail, [new Trail()])
        Player player = Player.findById(1)
        player.trail = Trail.findById(1)
        player.save()

        mockDomain(Location, [new Location(longitude: 0, latitude: 0), new Location(longitude: 0, latitude: 1), new Location(longitude: 1, latitude: 1)])
        Location.findAll().each { location ->
            player.trail.addToLocations(location)
        }
        player.save()
    }

    void testAllLocations() {
        this.controller.params.gameId = 1
        this.controller.params.playerId = "0"

        def model = this.controller.trail()

        assertEquals 3, model["trail"].size
    }

    void testSingleLocations() {
        this.controller.params.gameId = 1
        this.controller.params.playerId = 1
        this.controller.params.locationIndex = 0

        def model = this.controller.location()

        assertEquals Long.valueOf(0), model["longitude"]
        assertEquals Long.valueOf(0), model["latitude"]
    }

    void testCreationOfAPlayer() {
        this.controller.params.gameId = 1
        this.controller.params.playerId = "new"

        this.controller.createPlayer()

        assertEquals 2, Game.findById(1).players.size()
    }

    protected void tearDown() {
        super.tearDown()
    }
}
