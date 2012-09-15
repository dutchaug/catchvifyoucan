package catchvifyoucan.grails.server

class LocationController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }
}
