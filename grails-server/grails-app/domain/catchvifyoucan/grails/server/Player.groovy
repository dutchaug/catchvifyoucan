package catchvifyoucan.grails.server

class Player {
    String playerId
    Trail trail = new Trail()

    static constraints = {
        playerId(nullabel: true)
    }

    static belongsTo = [game : Game]
}
