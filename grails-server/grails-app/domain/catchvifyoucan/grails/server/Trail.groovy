package catchvifyoucan.grails.server

class Trail {
    static belongsTo = Player

    static hasMany = [ locations : Location ]

    static constraints = {
    }
}
