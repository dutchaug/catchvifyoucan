package catchvifyoucan.grails.server

import grails.test.*

class TrailControllerTests extends ControllerUnitTestCase {
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

    void testAdditionOfLocation() {
        this.controller.params.gameId = 1
        this.controller.params.playerId = "0"
        this.controller.params.longitude = Long.valueOf(1)
        this.controller.params.latitude = Long.valueOf(0)

        this.controller.addLocation()

        assertEquals 4, Player.findByPlayerId("0").trail.locations.size()

    }

    protected void tearDown() {
        super.tearDown()
    }
}
