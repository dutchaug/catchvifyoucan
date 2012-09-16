package catchvifyoucan.grails.server

import grails.converters.JSON

class PlayerController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }

    def trail = {
        Game game = Game.findById(params.gameId)
        Player player = Player.findByPlayerId(params.playerId)

        def result = [ trail :  player?.trail.locations.collect {[ latitude : it.latitude, longitude : it.longitude]} ]
        withFormat {
            html {
                return result
            }
            json {
                render result as JSON
            }
        }

    }

    def location = {
        Game game = Game.findById(params.gameId)
        Player player = Player.findById(params.playerId)

        Location location = player.trail.locations[params.locationIndex]

        def result = [ longitude: location.longitude, latitude: location.latitude]
        withFormat {
            html {
                return result
            }
            json {
                render result as JSON
            }
        }
    }

    def createPlayer = {
        Player player = new Player(playerId: params.playerId)
        player.save()

       //if (!player.hasErrors()) {
            Game game = Game.findById(params.gameId)
            game.addToPlayers(player)
            game.save()
        //}

        def result = [ status : "ok" ]
        withFormat {
            html {
                return result
            }
            json {
                render result as JSON
            }
        }
    }

    def addLocation = {
        Game game = Game.findById(params.gameId)
        Player player = Player.findByPlayerId(params.playerId)

        Long latitude = Long.valueOf(params.latitude)
        Long longitude = Long.valueOf(params.longitude)
        Location location = new Location(longitude: longitude, latitude: latitude)
        location.save()

        player.trail.addToLocations(location)
        player.save()

        def result = [ status: "ok" ]
        withFormat {
            html {
                return result
            }
            json {
                render result as JSON
            }
        }
    }
}
