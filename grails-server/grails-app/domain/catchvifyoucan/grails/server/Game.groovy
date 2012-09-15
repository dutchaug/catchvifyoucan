package catchvifyoucan.grails.server

class Game {
    static hasMany = [ players : Player ]

    static constraints = {
    }
}
