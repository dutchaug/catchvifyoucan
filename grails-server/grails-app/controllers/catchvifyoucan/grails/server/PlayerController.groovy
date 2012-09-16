package catchvifyoucan.grails.server

class PlayerController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }

    def trail = {
        Game game = Game.findById(params.gameId)
        Player player = Player.findByCommunicationId(params.communicationId)

        return [ trail :  player?.trail.locations.collect {[ latitude : it.latitude, longitude : it.longitude]} ]
    }

    def location = {
        Game game = Game.findById(params.gameId)
        Player player = Player.findById(params.communicationId)

        Location location = player.trail.locations[params.locationIndex]

        return [ longitude: location.longitude, latitude: location.latitude]
    }

    def createPlayer = {
        Player player = new Player(communicationId: params.communicationId)
        player.save()

       //if (!player.hasErrors()) {
            Game game = Game.findById(params.gameId)
            game.addToPlayers(player)
            game.save()
        //}
    }
}
