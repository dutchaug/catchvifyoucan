package catchvifyoucan.grails.server

class TrailController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }
}
