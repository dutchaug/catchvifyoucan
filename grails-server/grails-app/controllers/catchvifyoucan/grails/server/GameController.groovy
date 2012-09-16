package catchvifyoucan.grails.server

class GameController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }

    def games = {
        def games = Game.findAll()

        return [ games: games ]
    }

    def game = {
        def game = Game.findById(params.gameId)

        return [ players: game.players]
    }

    def createGame = {
        Game game = new Game()
        game.save()
    }

}
