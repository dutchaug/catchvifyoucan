package catchvifyoucan.grails.server

class Player {
    String communicationId
    Trail trail = new Trail()

    static constraints = {
        communicationId(nullabel: true)
    }

    static belongsTo = [game : Game]
}
