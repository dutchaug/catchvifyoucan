package catchvifyoucan.grails.server

class PlayerController {
    def scaffold = true

    def index = {
        redirect(action: "list")
    }
}
