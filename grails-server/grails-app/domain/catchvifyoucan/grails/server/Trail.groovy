package catchvifyoucan.grails.server

class Trail {
    static hasMany = [ locations : Location ]

    static constraints = {
    }
}
