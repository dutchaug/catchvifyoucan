package catchvifyoucan.grails.server

class Location {
    Date dateCreated
    Long latitude
    Long longitude

    static constraints = {
        latitude(nullable : false)
        longitude(nullable :  false)
    }

    static belongsTo = [ trial : Trail ]

    static mapping = {
        sort dateCreated: "asc"
    }

}
