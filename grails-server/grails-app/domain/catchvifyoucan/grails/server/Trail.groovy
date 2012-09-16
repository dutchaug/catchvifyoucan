package catchvifyoucan.grails.server

class Trail {
    List locations = []

    static belongsTo = Player

    static hasMany = [ locations : Location ]

    static constraints = {
    }
}
