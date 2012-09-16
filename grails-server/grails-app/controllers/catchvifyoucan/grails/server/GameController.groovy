package catchvifyoucan.grails.server

import grails.converters.JSON

class GameController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }

    def games = {
        def games = Game.findAll()

        def result = [ games: games ]
        withFormat {
            html {
                return result
            }
            json {
                render result as JSON
            }
        }

    }

    def game = {
        def game = Game.findById(params.gameId)

        def result = [ players: game.players]
        withFormat {
            html {
                return result
            }
            json {
                render result as JSON
            }
        }
    }

    def createGame = {
        Game game = new Game()
        game.save()
    }

}
