package catchvifyoucan.grails.server

class GameController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }

    def allGames = {
        def games = Game.findAll()

        return [ games: games ]
    }

    def game = {
        def game = Game.findById(params.id)

        return [ players: game.players]
    }

}
