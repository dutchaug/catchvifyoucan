package catchvifyoucan.grails.server

class TrailController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }

    def addLocation = {
        Game game = Game.findById(params.gameId)
        Player player = Player.findByPlayerId(params.playerId)

        Location location = new Location(longitude: Long.valueOf(params.longitude), latitude: Long.valueOf(params.latitude))

        player.trail.addToLocations(location)
        player.save()
    }
}
