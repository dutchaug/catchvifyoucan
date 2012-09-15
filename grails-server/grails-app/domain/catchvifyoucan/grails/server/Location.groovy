package catchvifyoucan.grails.server

class Location {
    Date dateCreated

    static constraints = {
    }

    static belongsTo = [ trial : Trail ]

    static mapping = {
        sort dateCreated: "asc"
    }

}
