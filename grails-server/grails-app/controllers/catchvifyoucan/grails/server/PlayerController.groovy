package catchvifyoucan.grails.server

class PlayerController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }

    def trail = {
        Game game = Game.findById(params.gameId)
        Player player = Player.findByPlayerId(params.playerId)

        return [ trail :  player?.trail.locations.collect {[ latitude : it.latitude, longitude : it.longitude]} ]
    }

    def location = {
        Game game = Game.findById(params.gameId)
        Player player = Player.findById(params.playerId)

        Location location = player.trail.locations[params.locationIndex]

        return [ longitude: location.longitude, latitude: location.latitude]
    }

    def createPlayer = {
        Player player = new Player(playerId: params.playerId)
        player.save()

       //if (!player.hasErrors()) {
            Game game = Game.findById(params.gameId)
            game.addToPlayers(player)
            game.save()
        //}
    }

    def addLocation = {
        Game game = Game.findById(params.gameId)
        Player player = Player.findByPlayerId(params.playerId)

        Location location = new Location(longitude: Long.valueOf(params.longitude), latitude: Long.valueOf(params.latitude))

        player.trail.addToLocations(location)
        player.save()
    }
}
